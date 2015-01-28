package io.lemur.generation.db;

import io.lemur.generation.entity.field.DataBaseFieldEntity;
import io.lemur.generation.entity.table.DataBaseTableEntity;
import io.lemur.generation.exception.GenerationRunTimeException;
import io.lemur.generation.util.ConnectionUtil;
import io.lemur.generation.util.NameUtil;
import io.lemur.generation.util.PropertiesUtil;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读表基础类
 * @author JueYue
 * @date 2014年12月25日
 */
public abstract class BaseReadTable {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseReadTable.class);

    protected List<DataBaseFieldEntity> getTableFields(String tableName, String sql)
                                                                                    throws Exception {
        List<DataBaseFieldEntity> list = new ArrayList<DataBaseFieldEntity>();
        Statement statement = null;
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(
                String.format(sql, tableName, PropertiesUtil.getString(PropertiesUtil.DB_NAME)));
            DataBaseFieldEntity field;
            while (rs.next()) {
                field = new DataBaseFieldEntity();
                field.setCharmaxLength(rs.getString("charmaxLength"));
                field.setComment(rs.getString("_comment"));
                field.setFieldName(rs.getString("fieldName"));
                field.setNullable(rs.getString("nullable"));
                field.setFieldType(rs.getString("fieldType"));
                field.setPrecision(rs.getString("_precision"));
                field.setScale(rs.getString("scale"));
                list.add(field);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e.fillInStackTrace());
            throw new GenerationRunTimeException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return list;
    }

    protected DataBaseTableEntity getTableEntiy(String tableName, String sql) throws Exception {
        Statement statement = null;
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(
                String.format(sql, tableName, PropertiesUtil.getString(PropertiesUtil.DB_NAME)));
            String dbTableName = null;
            String comment = null;
            while (rs.next()) {
                dbTableName = rs.getString(1);
                comment = rs.getString(2);
            }
            if (StringUtils.isEmpty(dbTableName)) {
                throw new GenerationRunTimeException("表不存在");
            } else {
                DataBaseTableEntity entity = new DataBaseTableEntity();
                if (StringUtils.isNotEmpty(comment)) {
                    String[] nameAndComment = comment.split(PropertiesUtil.getCommentSplit());
                    entity.setChinaName(comment);
                    if (nameAndComment.length > 1) {
                        entity.setComment(nameAndComment[nameAndComment.length - 1]);
                    }
                }
                entity.setTableName(dbTableName);
                return entity;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e.fillInStackTrace());
            throw new GenerationRunTimeException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }

    protected String getFieldName(String fieldName, String comment) {
        if (StringUtils.isNotEmpty(comment)) {
            String[] nameAndComment = comment.split(PropertiesUtil.getCommentSplit());
            return nameAndComment[0];
        }
        return NameUtil.getEntityHumpName(fieldName);
    }

    protected String convertType(String dataType, String precision, String scale) {
        if (dataType.contains("char")) {
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
