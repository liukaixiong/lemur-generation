package cn.afterturn.gen.core.db.convert.sql;

import cn.afterturn.gen.core.db.convert.sql.impl.SqlConvertOfMysql;
import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;
import cn.afterturn.gen.core.db.read.impl.ReadTableForMysqlImpl;

import static cn.afterturn.gen.core.GenCoreConstant.*;

/**
 * @author JueYue on 2017/10/25.
 */
public class SqlConvertFactory {

    public static ISqlConvert getReadTable(String dbType) {
        if (MYSQL.equalsIgnoreCase(dbType)) {
            return new SqlConvertOfMysql();
        }
        throw new GenerationRunTimeException("数据库不支持");
    }
}
