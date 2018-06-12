package cn.afterturn.gen.core.db.convert.sql;

import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.core.model.enmus.DBType;

/**
 * @author JueYue on 2017/10/25.
 */
public interface ISqlConvert {

    /**
     * 解析SQL
     */
    public GenBeanEntity parseSql(String sql);

    public DBType getDbType();

    default String handlerDBName(String name) {
        if (name.indexOf(".") != -1) {
            return name.substring(name.indexOf(".") + 1);
        }
        name = name.trim();
        if (name.startsWith("\"")) {
            name = name.substring(1);
        }
        if (name.endsWith("\"")) {
            name = name.substring(0, name.length() - 1);
        }
        return name;
    }
}
