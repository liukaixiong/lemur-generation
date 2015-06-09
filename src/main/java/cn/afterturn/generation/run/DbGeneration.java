package cn.afterturn.generation.run;

import cn.afterturn.generation.base.GenBeanEntity;
import cn.afterturn.generation.base.TypeEnmu;
import cn.afterturn.generation.db.entity.generation.GenerationEntity;
import cn.afterturn.generation.db.read.ReadTableFactory;
import cn.afterturn.generation.parse.IParse;
import cn.afterturn.generation.parse.impl.FreemakParseImpl;

/**
 * 生成类
 * 
 * @author JueYue
 * @date 2014年12月23日
 */
public final class DbGeneration {

    private static TypeEnmu[] types        = new TypeEnmu[] { TypeEnmu.Repository, TypeEnmu.Entity,
            TypeEnmu.MybatisXml           };

    private static String     JAVA_PACKAGE = "cn.linkea.qdcrm.common.dal.crmapp";

    public static void generation(GenerationEntity entity) {

        GenBeanEntity tableEntity = ReadTableFactory.getReadTable().read(entity.getTableName());
        IParse parseImpl = new FreemakParseImpl();
        parseImpl.parse(entity, tableEntity);
    }

    public static void main(String[] args) {
        GenerationEntity entiy = new GenerationEntity();
        entiy.setJavaPackage(JAVA_PACKAGE);
        entiy.setEntityName("ShopGoodsCategory");
        entiy.setPackageName("goodscategory");
        entiy.setTableName("t_shop_goods_category");
        entiy.setTypes(types);
        DbGeneration.generation(entiy);
    }

}
