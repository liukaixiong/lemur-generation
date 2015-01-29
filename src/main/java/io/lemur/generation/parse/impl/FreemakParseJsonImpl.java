package io.lemur.generation.parse.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import io.lemur.generation.base.GenFieldEntity;
import io.lemur.generation.base.GenBeanEntity;
import io.lemur.generation.db.entity.enmu.TypeEnmu;
import io.lemur.generation.db.entity.generation.GenerationEntity;
import io.lemur.generation.parse.IParse;
import io.lemur.generation.util.CodeFromatter;
import io.lemur.generation.util.PropertiesUtil;

/**
 * FREEMARK 解析 JOSN
 * @author JueYue
 * @date 2014年12月25日
 */
public class FreemakParseJsonImpl implements IParse {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public Configuration getConfiguration() throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File(FreemakParseJsonImpl.class.getResource("/")
            .getFile() + "/ftl"));
        cfg.setLocale(Locale.CHINA);
        cfg.setDefaultEncoding("UTF-8");
        return cfg;
    }

    @Override
    public void parse(GenerationEntity generationEntity, GenBeanEntity tableEntity) {

        Map<String, Object> rootMap = new HashMap<String, Object>();
        rootMap.put("params", generationEntity);
        rootMap.put("table", tableEntity);
        rootMap.put("isNeedDate", judgeNeedAdd(tableEntity.getFields(),"Date"));
        rootMap.put("isNeedList", judgeNeedAdd(tableEntity.getFields(),"List"));
        rootMap.put("isNeedBigInteger", judgeNeedAdd(tableEntity.getFields(),"BigInteger"));
        rootMap.put("isNeedBigDecimal", judgeNeedAdd(tableEntity.getFields(),"BigDecimal"));
        rootMap.put("createTime", format.format(new Date()));
        if (StringUtils.isEmpty(generationEntity.getEntityName())) {
            generationEntity.setEntityName(tableEntity.getName());
        }
        if (StringUtils.isEmpty(generationEntity.getPackageName())) {
            generationEntity.setPackageName(tableEntity.getName());
        }
        for (int i = 0; i < tableEntity.getFields().size(); i++) {
            if (tableEntity.getFields().get(i).getBean() != null) {
                parse(generationEntity, tableEntity.getFields().get(i).getBean());
            }
        }
        for (int i = 0; i < generationEntity.getTypes().length; i++) {
            try {
                //创建文件目录
                String pathOfSrc = getSrcPath(generationEntity, tableEntity,
                    generationEntity.getTypes()[i]);
                File file = new File(pathOfSrc);
                if (!file.exists()) {
                    file.mkdirs();
                }
                // 模板解析
                Template template = getConfiguration().getTemplate(
                    generationEntity.getTypes()[i].getValue());
                Writer outWriter = new OutputStreamWriter(new FileOutputStream(
                    pathOfSrc + "/" + tableEntity.getName() + ".java"), "UTF-8");
                Writer out = new StringWriter();
                template.process(rootMap, out);
                String sourceCode = out.toString();
                //格式化文件
                if (PropertiesUtil.getBoolean(PropertiesUtil.IS_FORMAT)
                    && generationEntity.getTypes()[i].getSuffix().endsWith(".java")) {
                    sourceCode = CodeFromatter.format(sourceCode);
                }
                //输出
                outWriter.write(sourceCode);
                outWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getSrcPath(GenerationEntity generationEntity, GenBeanEntity tableEntity,
                              TypeEnmu type) {
        return PropertiesUtil.getString(PropertiesUtil.GENERATION_PATH)
               + generationEntity.getJavaPackage().replace(".", "/");
    }

    /**
     * 判断是否存在type类型
     * @param fields
     * @return
     */
    private boolean judgeNeedAdd(List<GenFieldEntity> fields, String type) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getType() != null && fields.get(i).getType().contains(type)) {
                return true;
            }
        }
        return false;
    }

}
