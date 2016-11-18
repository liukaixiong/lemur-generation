package cn.afterturn.gen.core.parse;

import cn.afterturn.gen.core.base.GenBeanEntity;
import cn.afterturn.gen.model.GenerationEntity;

/**
 * 模板解析接口
 * @author JueYue
 * @date 2014年12月23日
 */
public interface IParse {
    /**
     * 解析FLT 生成文件
     * @param javaPackage
     * @param jspPackage
     * @param types
     * @param tableEntity
     */
    public void parse(GenerationEntity generationEntity, GenBeanEntity tableEntity);

}
