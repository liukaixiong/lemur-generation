package io.lemur.generation.run;

import io.lemur.generation.base.GenBeanEntity;
import io.lemur.generation.base.TypeEnmu;
import io.lemur.generation.db.entity.generation.GenerationEntity;
import io.lemur.generation.db.read.ReadTableFactory;
import io.lemur.generation.parse.IParse;
import io.lemur.generation.parse.impl.FreemakParseImpl;

/**
 * 生成类
 * 
 * @author JueYue
 * @date 2014年12月23日
 */
public final class DbGeneration {

    private static TypeEnmu[] types        = new TypeEnmu[] { TypeEnmu.IService,
            TypeEnmu.ServiceImpl, TypeEnmu.Controller, TypeEnmu.ListJsp };

    private static String     JAVA_PACKAGE = "com.postaop.bus.map";

    public static void generation(GenerationEntity entity) {

        GenBeanEntity tableEntity = ReadTableFactory.getReadTable().read(entity.getTableName());
        IParse parseImpl = new FreemakParseImpl();
        parseImpl.parse(entity, tableEntity);
    }

    public static void main(String[] args) {
        GenerationEntity entiy = new GenerationEntity();
        entiy.setJavaPackage(JAVA_PACKAGE);
        entiy.setEntityName("BusStation");
        entiy.setPackageName("busstation");
        entiy.setTableName("bus_station");
        entiy.setTypes(types);
        DbGeneration.generation(entiy);
    }

}
