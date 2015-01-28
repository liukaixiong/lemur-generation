package io.lemur.generation;


import org.apache.commons.lang.StringUtils;

import io.lemur.generation.db.entity.enmu.GenerationType;
import io.lemur.generation.db.entity.enmu.TypeEnmu;
import io.lemur.generation.db.entity.generation.GenerationEntity;
import io.lemur.generation.db.entity.table.DataBaseTableEntity;
import io.lemur.generation.db.parse.IParse;
import io.lemur.generation.db.parse.impl.freemark.FreemakParseImpl;
import io.lemur.generation.db.read.ReadTableFactory;

/**
 * 生成类
 * 
 * @author JueYue
 * @date 2014年12月23日
 */
public final class DbGeneration {

    private static TypeEnmu[] types        = new TypeEnmu[] { TypeEnmu.Entity };

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
        entiy.setEntityName("MsmngRole");
        entiy.setPackageName("baseuser");
        entiy.setTableName("msmng_role");
        entiy.setTypes(types);
        DbGeneration.generation(entiy);
    }

}
