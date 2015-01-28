package io.lemur.generation.json.parse;

import io.lemur.common.util.file.FileUtil;
import io.lemur.common.util.json.JSONUtil;
import io.lemur.common.util.ucode.ParseCode;

import java.util.Map;

/**
 * 解析json为Map对象
 * @author JueYue
 * @date 2015年1月28日
 */
public class JsonParse {

    public Map<String, Object> parseFile(String fileName) {
        String jsonContent = FileUtil.readToString(fileName, ParseCode.UTF8);
        return JSONUtil.parseJson(jsonContent, Map.class);
    }

}
