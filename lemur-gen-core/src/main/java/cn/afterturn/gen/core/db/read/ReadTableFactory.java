package cn.afterturn.gen.core.db.read;

import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;
import cn.afterturn.gen.core.db.read.impl.mysql.ReadTableForMysqlImpl;
import cn.afterturn.gen.core.util.PropertiesUtil;

/**
 * 读取库的工厂
 * @author JueYue
 * @date 2014年12月25日
 */
public class ReadTableFactory {

    private static final String MYSQL      = "mysql";

    private static final String ORACLE     = "oracle";

    private static final String SQLSERVER  = "sqlserver";

    private static final String POSTGRESQL = "postgresql";

    public static IReadTable getReadTable() {
        String dbType = PropertiesUtil.getString(PropertiesUtil.DB_TYPE).trim();
        if (MYSQL.equalsIgnoreCase(dbType)) {
            return new ReadTableForMysqlImpl();
        }
        throw new GenerationRunTimeException("数据库不支持");
    }
}
