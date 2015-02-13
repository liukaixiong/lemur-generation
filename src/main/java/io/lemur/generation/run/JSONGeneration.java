package io.lemur.generation.run;

import java.util.Map;

import io.lemur.common.util.ucode.ParseCode;
import io.lemur.generation.base.GenBeanEntity;
import io.lemur.generation.base.TypeEnmu;
import io.lemur.generation.db.entity.generation.GenerationEntity;
import io.lemur.generation.json.parse.JsonParse;
import io.lemur.generation.parse.IParse;
import io.lemur.generation.parse.impl.FreemakParseJsonImpl;

/**
 * 生成类
 * 
 * @author JueYue
 * @date 2014年12月23日
 */
public final class JSONGeneration {

    private static TypeEnmu[] types        = new TypeEnmu[] { TypeEnmu.JSONEntity };

    private static String     JAVA_PACKAGE = "io.lemur.map.model.amap.place";

    public static void generation(GenerationEntity entity) {
        JsonParse parse = new JsonParse();
        parse.setNameModifier("AmapPlace%sModel");
        Map<String, Object> map = new JsonParse().parseFile("D:/高德的url.txt", ParseCode.UTF8);
        if(map == null){
            return;
        }
        GenBeanEntity bean = parse.iteratorMap(map, "");
        IParse parseImpl = new FreemakParseJsonImpl();
        parseImpl.parse(entity, bean);
    }

    public static void main(String[] args) {
        GenerationEntity entiy = new GenerationEntity();
        entiy.setJavaPackage(JAVA_PACKAGE);
        entiy.setTypes(types);
        JSONGeneration.generation(entiy);
    }

}
