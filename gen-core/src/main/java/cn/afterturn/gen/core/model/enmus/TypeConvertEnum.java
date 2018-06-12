package cn.afterturn.gen.core.model.enmus;

/**
 * 数据类型转换
 *
 * @author by jueyue on 18-6-12.
 */
public enum TypeConvertEnum {


    ORACLE_BLOB(DBType.ORACLE, "BLOB", GenFileType.BYTE_ARR),
    ORACLE_CHAR(DBType.ORACLE, "CHAR", GenFileType.STRING),
    ORACLE_CLOB(DBType.ORACLE, "CLOB", GenFileType.STRING),
    ORACLE_DATE(DBType.ORACLE, "DATE", GenFileType.DATE),
    ORACLE_NUMBER(DBType.ORACLE, "NUMBER", GenFileType.BIG_DECIMAL),
    ORACLE_LONG(DBType.ORACLE, "LONG", GenFileType.STRING),
    ORACLE_SMALLINT(DBType.ORACLE, "SMALLINT", GenFileType.INTEGER),
    ORACLE_TIMESTAMP(DBType.ORACLE, "TIMESTAMP", GenFileType.DATE),
    ORACLE_RAW(DBType.ORACLE, "RAW", GenFileType.BYTE_ARR),
    ORACLE_VARCHAR2(DBType.ORACLE, "VARCHAR2", GenFileType.STRING),


    //----------------------------------------------------------------------
    SQLSERVER_TIMESTAMP(DBType.SQLSERVER, "TIMESTAMP", GenFileType.DATE),
    SQLSERVER_BIT(DBType.SQLSERVER, "BIT", GenFileType.BOOLEAN),
    SQLSERVER_CHAR(DBType.SQLSERVER, "CHAR", GenFileType.STRING),
    SQLSERVER_NCHAR(DBType.SQLSERVER, "NCHAR", GenFileType.STRING),
    SQLSERVER_DATETIME(DBType.SQLSERVER, "DATETIME", GenFileType.DATE),
    SQLSERVER_MONEY(DBType.SQLSERVER, "MONEY", GenFileType.BIG_DECIMAL),
    SQLSERVER_SMALLMONEY(DBType.SQLSERVER, "SMALLMONEY", GenFileType.BIG_DECIMAL),
    SQLSERVER_DECIMAL(DBType.SQLSERVER, "DECIMAL", GenFileType.BIG_DECIMAL),
    SQLSERVER_FLOAT(DBType.SQLSERVER, "FLOAT", GenFileType.DOUBLE),
    SQLSERVER_INT(DBType.SQLSERVER, "INT", GenFileType.INTEGER),
    SQLSERVER_IMAGE(DBType.SQLSERVER, "IMAGE", GenFileType.BYTE_ARR),
    SQLSERVER_TEXT(DBType.SQLSERVER, "TEXT", GenFileType.BYTE_ARR),
    SQLSERVER_BTEXT(DBType.SQLSERVER, "NTEXT", GenFileType.BYTE_ARR),
    SQLSERVER_XML(DBType.SQLSERVER, "XML", GenFileType.BYTE_ARR),
    SQLSERVER_NUMERIC(DBType.SQLSERVER, "NUMERIC", GenFileType.BIG_DECIMAL),
    SQLSERVER_REAL(DBType.SQLSERVER, "REAL", GenFileType.FLOAT),
    SQLSERVER_SMALLINT(DBType.SQLSERVER, "SMALLINT", GenFileType.SHORT),
    SQLSERVER_SMALL_DATETIME(DBType.SQLSERVER, "SMALLDATETIME", GenFileType.DATE),
    SQLSERVER_TINYINT(DBType.SQLSERVER, "TINYINT", GenFileType.BYTE),
    SQLSERVER_NVARCHAR(DBType.SQLSERVER, "NVARCHAR", GenFileType.STRING),
    SQLSERVER_VARBINARY(DBType.SQLSERVER, "VARBINARY", GenFileType.BYTE_ARR),
    SQLSERVER_VARCHAR(DBType.SQLSERVER, "VARCHAR", GenFileType.STRING),

    //---------------------------------------------------------------------
    DB2_BIGINT(DBType.DB2, "BIGINT", GenFileType.LONG),
    DB2_BLOB(DBType.DB2, "BLOB", GenFileType.BYTE_ARR),
    DB2_CHARACTER(DBType.DB2, "CHARACTER", GenFileType.STRING),
    DB2_GRAPHIC(DBType.DB2, "GRAPHIC", GenFileType.STRING),
    DB2_CLOB(DBType.DB2, "CLOB", GenFileType.STRING),
    DB2_DATE(DBType.DB2, "DATE", GenFileType.DATE),
    DB2_DECIMAL(DBType.DB2, "DECIMAL", GenFileType.BIG_DECIMAL),
    DB2_DOUBLE(DBType.DB2, "DOUBLE", GenFileType.DOUBLE),
    DB2_INTEGER(DBType.DB2, "INTEGER", GenFileType.INTEGER),
    DB2_LONGVARGRAPHIC(DBType.DB2, "LONGVARGRAPHIC", GenFileType.BYTE_ARR),
    DB2_LONGVARCHAR(DBType.DB2, "LONGVARCHAR", GenFileType.BYTE_ARR),
    DB2_REAL(DBType.DB2, "REAL", GenFileType.LONG),
    DB2_SMALLINT(DBType.DB2, "SMALLINT", GenFileType.SHORT),
    DB2_TIME(DBType.DB2, "TIME", GenFileType.DATE),
    DB2_TIMESTAMP(DBType.DB2, "TIMESTAMP", GenFileType.DATE),
    DB2_VARGRAPHIC(DBType.DB2, "VARGRAPHIC", GenFileType.STRING),
    DB2_VARCHAR(DBType.DB2, "VARCHAR", GenFileType.STRING),

    //------------------------------------------------------------
    MYSQL_BIGINT(DBType.MYSQL, "BIGINT", GenFileType.LONG),
    MYSQL_TINYBLOB(DBType.MYSQL, "TINYBLOB", GenFileType.BYTE_ARR),
    MYSQL_BIT(DBType.MYSQL, "BIT", GenFileType.BOOLEAN),
    MYSQL_ENUM(DBType.MYSQL, "ENUM", GenFileType.STRING),
    MYSQL_SET(DBType.MYSQL, "SET", GenFileType.STRING),
    MYSQL_CHAR(DBType.MYSQL, "CHAR", GenFileType.STRING),
    MYSQL_DATE(DBType.MYSQL, "DATE", GenFileType.DATE),
    MYSQL_YEAR(DBType.MYSQL, "YEAR", GenFileType.DATE),
    MYSQL_DECIMAL(DBType.MYSQL, "DECIMAL", GenFileType.BIG_DECIMAL),
    MYSQL_NUMERIC(DBType.MYSQL, "NUMERIC", GenFileType.BIG_DECIMAL),
    MYSQL_DOUBLE(DBType.MYSQL, "DOUBLE", GenFileType.DOUBLE),
    MYSQL_REAL(DBType.MYSQL, "REAL", GenFileType.DOUBLE),
    MYSQL_MEDIUMINT(DBType.MYSQL, "MEDIUMINT", GenFileType.INTEGER),
    MYSQL_BLOB(DBType.MYSQL, "BLOB", GenFileType.BYTE_ARR),
    MYSQL_MEDIUMBLOB(DBType.MYSQL, "MEDIUMBLOB", GenFileType.BYTE_ARR),
    MYSQL_LONGBLOB(DBType.MYSQL, "LONGBLOB", GenFileType.BYTE_ARR),
    MYSQL_FLOAT(DBType.MYSQL, "FLOAT", GenFileType.FLOAT),
    MYSQL_INT(DBType.MYSQL, "INT", GenFileType.INTEGER),
    MYSQL_SMALLINT(DBType.MYSQL, "SMALLINT", GenFileType.SHORT),
    MYSQL_TIME(DBType.MYSQL, "TIME", GenFileType.DATE),
    MYSQL_TIMESTAMP(DBType.MYSQL, "TIMESTAMP", GenFileType.DATE),
    MYSQL_DATETIME(DBType.MYSQL, "DATETIME", GenFileType.DATE),
    MYSQL_TINYINT(DBType.MYSQL, "TINYINT", GenFileType.BYTE),
    MYSQL_VARBINARY(DBType.MYSQL, "VARBINARY", GenFileType.BYTE_ARR),
    MYSQL_BINARY(DBType.MYSQL, "BINARY", GenFileType.BYTE_ARR),
    MYSQL_VARCHAR(DBType.MYSQL, "VARCHAR", GenFileType.STRING),
    MYSQL_TINYTEXT(DBType.MYSQL, "TINYTEXT", GenFileType.STRING),
    MYSQL_TEXT(DBType.MYSQL, "TEXT", GenFileType.STRING);


    private DBType db;
    private String dbType;
    private GenFileType type;

    TypeConvertEnum(DBType db, String dbType, GenFileType type) {
        this.db = db;
        this.dbType = dbType;
        this.type = type;
    }

    public static String getTypeByDb(DBType db, String dbType) {
        TypeConvertEnum[] types = TypeConvertEnum.values();
        for (int i = 0; i < types.length; i++) {
            if (types[i].db.equals(db) && types[i].dbType.equalsIgnoreCase(dbType)) {
                return types[i].type.getType();
            }
        }
        return null;
    }

    public DBType getDb() {
        return db;
    }

    public String getDbType() {
        return dbType;
    }

    public GenFileType getType() {
        return type;
    }

}
