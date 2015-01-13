#lemur-generation
	java 的代码生成器 根据模板生成相应的代码,免去重复写代码的烦恼,自主定制模板,格式化代码
	
#模板参数说明
	isNeedDate 是否含有date类型
	createTime 创建时间 yyyy-MM-dd HH:mm格式
```java
params 参数
	/** Java包名*/
    private String            javaPackage      = "io.lemur";
    /**JSP包名,如果为空,使用javaPackage*/
    private String            jspPackage;
    /**需要生成的对象*/
    private TypeEnmu[]        types            = TypeEnmu.values();
    /**功能名称*/
    private String            name;
    /**数据库表明*/
    private String            tableName;
    /**主键名称*/
    private String            idName           = "id";
    /**主键类型*/
    private GenerationType    idType           = GenerationType.IDENTITY;
    /**类名,不填使用表名*/
    private String            entityName;
    /**包名,不填使用表名,小写*/
    private String            packageName;
```

```java
table 参数
	/**表名*/
    private String                    tableName;
    /**Java 表名*/
    private String                    name;
    /**中文名称*/
    private String                    chinaName;
    /**注释*/
    private String                    comment;
    /**表字段*/
    private List<DataBaseFieldEntity> fields;
DataBaseFieldEntity详情
    /**数据库字段名称*/
    private String            fieldName;
    /**字段名称*/
    private String            name;
    /** 字段中文名称*/
    private String            chinaName;
    /**数据库字段注释*/
    private String            comment;
    /** 数据库字段类型*/
    private String            fieldType;
    /**字段类型*/
    private String            type;
    /**字符串允许输入最大长度*/
    private String            charmaxLength;
    /**精度**/
    private String            precision;
    /**小数点**/
    private String            scale;
    /**是否允许为空 Y/N **/
    private String            nullable;
```
	