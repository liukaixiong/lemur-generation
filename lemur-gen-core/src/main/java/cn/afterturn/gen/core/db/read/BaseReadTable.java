package cn.afterturn.gen.core.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.afterturn.gen.core.db.exception.GenerationRunTimeException;
import cn.afterturn.common.util.ConnectionUtil;
import cn.afterturn.gen.core.util.NameUtil;
import cn.afterturn.gen.model.base.GenBeanEntity;
import cn.afterturn.gen.model.base.GenFieldEntity;

/**
 * 读表基础类
 * @author JueYue
 * @date 2014年12月25日
 */
public abstract class BaseReadTable {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseReadTable.class);

    protected List<GenFieldEntity> getTableFields(String dbName, String tableName, String sql) throws Exception {
        List<GenFieldEntity> list = new ArrayList<GenFieldEntity>();
        Statement statement = null;
        try {
            ResultSet rs = ConnectionUtil.createStatement()
                .executeQuery(String.format(sql, tableName, dbName));
            GenFieldEntity field;
            while (rs.next()) {
                field = new GenFieldEntity();
                field.setCharmaxLength(rs.getString("charmaxLength"));
                field.setComment(rs.getString("column_comment"));
                field.setFieldName(rs.getString("fieldName"));
                field.setNullable(rs.getString("nullable"));
                field.setFieldType(rs.getString("fieldType"));
                field.setPrecision(rs.getString("numeric_precision"));
                field.setScale(rs.getString("scale"));
                list.add(field);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return list;
    }

    protected GenBeanEntity getTableEntiy(String dbName, String tableName, String sql) throws Exception {
        Statement statement = null;
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(String.format(sql, tableName, dbName));
            String dbTableName = null;
            String comment = null;
            while (rs.next()) {
                dbTableName = rs.getString(1);
                comment = rs.getString(2);
            }
            if (StringUtils.isEmpty(dbTableName)) {
                throw new GenerationRunTimeException("表不存在");
            } else {
                GenBeanEntity entity = new GenBeanEntity();
                if (StringUtils.isNotEmpty(comment)) {
                    entity.setChinaName(handlerTableComment(comment));
                }
                entity.setTableName(dbTableName);
                return entity;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }

    public List<String> getAllDB(String sql) throws SQLException {
        Statement statement = null;
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(String.format(sql));
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return list;
    }

    protected abstract String handlerTableComment(String comment);

    protected List<GenBeanEntity> getAllTableEntiy(String dbName, String sql) throws Exception {
        Statement statement = null;
        List<GenBeanEntity> list = new ArrayList<>();
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(String.format(sql, dbName));
            String dbTableName = null;
            String comment = null;
            while (rs.next()) {
                dbTableName = rs.getString(1);
                comment = rs.getString(2);
                if (StringUtils.isEmpty(dbTableName)) {
                    throw new GenerationRunTimeException("表不存在");
                } else {
                    GenBeanEntity entity = new GenBeanEntity();
                    if (StringUtils.isNotEmpty(comment)) {
                        entity.setChinaName(handlerTableComment(comment));
                    }
                    entity.setTableName(dbTableName);
                    list.add(entity);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new GenerationRunTimeException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return list;
    }

    protected String getFieldName(String fieldName, String comment) {
        if (StringUtils.isNotEmpty(comment)) {
            String[] nameAndComment = comment.split(",");
            return nameAndComment[0];
        }
        return NameUtil.getEntityHumpName(fieldName);
    }

    protected String convertType(String dataType, String precision, String scale) {
        if (dataType.contains("char") || dataType.contains("text")) {
            dataType = "String";
        } else if (dataType.contains("int")) {
            dataType = "Integer";
        } else if (dataType.contains("float")) {
            dataType = "Float";
        } else if (dataType.contains("double")) {
            dataType = "Double";
        } else if (dataType.contains("number")) {
            if (StringUtils.isNotEmpty(scale) && Integer.parseInt(scale) > 0) {
                dataType = "Double";
            } else if (StringUtils.isNotEmpty(precision) && Integer.parseInt(precision) > 10) {
                dataType = "Long";
            } else {
                dataType = "Integer";
            }
        } else if (dataType.contains("decimal")) {
            dataType = "BigDecimal";
        } else if (dataType.contains("date")) {
            dataType = "Date";
        } else if (dataType.contains("time")) {
            dataType = "Date";
        } else if (dataType.contains("blob")) {
            dataType = "byte[]";
        } else if (dataType.contains("clob")) {
            dataType = "java.sql.Clob";
        } else if (dataType.contains("numeric")) {
            dataType = "BigDecimal";
        } else {
            dataType = "Object";
        }
        return dataType;
    }
}
