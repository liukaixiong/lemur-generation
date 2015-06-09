package cn.afterturn.generation.parse;

import cn.afterturn.generation.base.GenBeanEntity;
import cn.afterturn.generation.db.entity.generation.GenerationEntity;

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
