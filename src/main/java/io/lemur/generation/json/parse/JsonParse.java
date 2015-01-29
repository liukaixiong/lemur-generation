package io.lemur.generation.json.parse;

import io.lemur.common.util.file.FileUtil;
import io.lemur.common.util.json.JSONUtil;
import io.lemur.common.util.logger.MyLogger;
import io.lemur.common.util.ucode.ParseCode;
import io.lemur.generation.base.GenBeanEntity;
import io.lemur.generation.base.GenFieldEntity;
import io.lemur.generation.util.NameUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

/**
 * 解析json为Map对象
 * @author JueYue
 * @date 2015年1月28日
 */
@SuppressWarnings("unchecked")
public class JsonParse {

    private static final Logger LOGGER       = MyLogger.getLogger();

    private String              nameModifier = "%s";

    public Map<String, Object> parseFile(String fileName) {
        return parseFile(fileName, ParseCode.UTF8);
    }

    public Map<String, Object> parseFile(String fileName, String encode) {
        String jsonContent = FileUtil.readToString(fileName, encode);
        return JSONUtil.parseJson(jsonContent, Map.class);
    }

    public GenBeanEntity iteratorMap(Map<String, Object> map, String name) {
        GenBeanEntity bean = new GenBeanEntity();
        bean.setName(String.format(nameModifier, NameUtil.getEntityHumpName(name)));
        List<GenFieldEntity> fields = new ArrayList<GenFieldEntity>();
        bean.setFields(fields);
        Iterator<String> its = map.keySet().iterator();
        while (its.hasNext()) {
            String key = its.next();
            Object obj = map.get(key);
            GenFieldEntity field = new GenFieldEntity();
            judgeField(obj, key, field);
            fields.add(field);
        }
        bean.setFields(fields);
        return bean;
    }

    private void judgeField(Object obj, String key, GenFieldEntity field) {
        if (key.contains("_")) {
            field.setFieldName(key);
        }
        field.setName(NameUtil.getFieldHumpName(key));

        if (obj instanceof Map) {
            GenBeanEntity bean = iteratorMap((Map<String, Object>) obj, key);
            field.setBean(bean);
            field.setType(bean.getName());
        } else if (obj.getClass().isArray()) {
            Object[] arr = (Object[]) obj;
            if (arr.length == 0) {
                LOGGER.error(key + "---------------无法判断类型及其属性");
            }else{
                hanlderArrayType(arr[0], key, field);
            }
        } else if (obj instanceof List) {
            List<Object> list = (List<Object>) obj;
            if (list.size() == 0) {
                field.setType("未知");
                LOGGER.error(key + "---------------无法判断类型及其属性");
            } else {
                String type = getPrivateName(list.get(0));
                if (type == null) {
                    GenBeanEntity bean = iteratorMap((Map<String, Object>) list.get(0), key);
                    field.setBean(bean);
                    field.setType("List<" + bean.getName() + ">");
                } else {
                    field.setType("List<" + type + ">");
                }
            }
        } else {
            field.setType(obj.getClass().getSimpleName());
        }

    }

    /**
     * 处理数组类型
     * 内部可能是数组,map,常见类型
     * @param object
     * @param key
     * @param field
     */
    private void hanlderArrayType(Object obj, String key, GenFieldEntity field) {
        if (obj instanceof Map) {
            GenBeanEntity bean = iteratorMap((Map<String, Object>) obj, key);
            field.setBean(bean);
            field.setType(bean.getName() + "[]");
        } else if (obj.getClass().isArray()) {
            Object[] arr = (Object[]) obj;
            if (arr.length == 0) {
                LOGGER.error(key + "---------------无法判断类型及其属性");
            }
            hanlderArrayType(arr[0], key, field);
            field.setType(field.getType() + "[]");
        } else {
            field.setType(obj.getClass().getSimpleName() + "[]");
        }

    }

    private String getPrivateName(Object obj) {
        if (obj instanceof Map || obj.getClass().isArray() || obj instanceof List) {
            return null;
        }
        return obj.getClass().getSimpleName();
    }

    public void setNameModifier(String nameModifier) {
        this.nameModifier = nameModifier;
    }

}
