package cn.afterturn.generation.run;

import java.util.Map;

import cn.afterturn.generation.base.GenBeanEntity;
import cn.afterturn.generation.base.TypeEnmu;
import cn.afterturn.generation.db.entity.generation.GenerationEntity;
import cn.afterturn.generation.json.parse.JsonParse;
import cn.afterturn.generation.parse.IParse;
import cn.afterturn.generation.parse.impl.FreemakParseJsonImpl;
import io.lemur.common.util.ucode.ParseCode;

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
