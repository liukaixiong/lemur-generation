package io.lemur.generation.util;

import io.lemur.generation.exception.GenerationRunTimeException;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置文件读取工具
 * 
 * @author JueYue
 * @date 2014年12月21日
 */
public class PropertiesUtil {

    public static String DB_DRIVER       = "db.driver";
    public static String DB_URL          = "db.url";
    public static String DB_USER_NAME    = "db.username";
    public static String DB_NAME         = "db.name";
    public static String DB_PASSWORD     = "db.password";
    public static String DB_TYPE         = "db.type";
    public static String GENERATION_PATH = "generation.path";
    public static String IS_FORMAT       = "is.format";

    private PropertiesUtil() {

    }

    private static Logger         LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    private static ResourceBundle resourceBundle;

    static {
        try {
            resourceBundle = ResourceBundle.getBundle("generation");
        } catch (Exception e) {
            LOGGER.error("generation 配置没有找到,检查配置文件");
            throw new GenerationRunTimeException("未找到配置文件", e);
        }
    }

    public static String getString(String key) {
        if (!resourceBundle.containsKey(key)) {
            LOGGER.error("{}没有找到,请和核对配置文件", key);
            throw new GenerationRunTimeException("未找到需要的参数");
        }
        return resourceBundle.getString(key);
    }

    public static boolean getBoolean(String key) {
        if (!resourceBundle.containsKey(key)) {
            LOGGER.error("{}没有找到,请和核对配置文件", key);
            throw new GenerationRunTimeException("未找到需要的参数");
        }
        return Boolean.valueOf(resourceBundle.getString(key));
    }

    public static String getCommentSplit() {
        if (!resourceBundle.containsKey("comment.split")) {
            LOGGER.error("{}没有找到,请和核对配置文件", "comment.split");
            throw new GenerationRunTimeException("未找到需要的参数");
        }
        String splitKey = resourceBundle.getString("comment.split");
        if ("空格".equals(splitKey)) {
            return " ";
        }
        if ("逗号".equals(splitKey)) {
            return ",";
        }
        return splitKey;
    }

}
