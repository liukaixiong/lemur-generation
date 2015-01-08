package io.lemur.generation;

import org.apache.commons.lang.StringUtils;

import io.lemur.generation.entity.enmu.GenerationType;
import io.lemur.generation.entity.enmu.TypeEnmu;
import io.lemur.generation.entity.generation.GenerationEntity;
import io.lemur.generation.entity.table.DataBaseTableEntity;
import io.lemur.generation.parse.IParse;
import io.lemur.generation.parse.impl.freemark.FreemakParseImpl;
import io.lemur.generation.read.ReadTableFactory;

/**
 * 生成类
 * 
 * @author JueYue
 * @date 2014年12月23日
 */
public final class Generation {

    private static TypeEnmu[] types        = new TypeEnmu[] { TypeEnmu.Entity, TypeEnmu.Repository };

    private static String     JAVA_PACKAGE = "io.lemur.users";
    private static String     JSP_PACKAGE  = "users";

    public static void generation(GenerationEntity entity) {

        DataBaseTableEntity tableEntity = ReadTableFactory.getReadTable().read(
            entity.getTableName());
        IParse parseImpl = new FreemakParseImpl();
        parseImpl.parse(entity, tableEntity);
    }

    public static void main(String[] args) {
        GenerationEntity entiy = new GenerationEntity();
        entiy.setJavaPackage(JAVA_PACKAGE);
        entiy.setEntityName("BaseUser");
        entiy.setPackageName("baseuser");
        entiy.setTableName("t_s_base_user");
        entiy.setTypes(types);
        Generation.generation(entiy);
    }

}
