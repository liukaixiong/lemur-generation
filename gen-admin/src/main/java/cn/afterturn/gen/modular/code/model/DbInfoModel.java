package cn.afterturn.gen.modular.code.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库管理
 *
 * @author JueYue
 * @Date 2017-09-11 11:15
 */
@TableName("t_code_dbinfo")
public class DbInfoModel extends Model<DbInfoModel> {

    private static final long serialVersionUID = 1L;
    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 别名
     */
    @TableField(value = "ALIAS")
    private String alias;

    /**
     * 数据库驱动
     */
    @TableField(value = "DB_DRIVER")
    private String dbDriver;

    /**
     * 数据库地址
     */
    @TableField(value = "DB_URL")
    private String dbUrl;

    /**
     * 数据库账户
     */
    @TableField(value = "DB_USER_NAME")
    private String dbUserName;

    /**
     * 连接密码
     */
    @TableField(value = "DB_PASSWORD")
    private String dbPassword;

    /**
     * UserId
     */
    @TableField(value = "USER_ID")
    private String userId;

    /**
     * 数据库类型
     */
    @TableField(value = "DB_TYPE")
    private String dbType;

    /**
     * 创建人
     */
    @TableField(value = "CRT_USER_ID")
    private String crtUserId;

    /**
     * 创建时间
     */
    @TableField(value = "CRT_TIME")
    private Date crtTime;

    /**
     * 修改人
     */
    @TableField(value = "MDF_USER_ID")
    private String mdfUserId;

    /**
     * 修改时间
     */
    @TableField(value = "MDF_TIME")
    private Date mdfTime;


    /**
     * 获取: Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置: Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取: 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置: 别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取: 数据库驱动
     */
    public String getDbDriver() {
        return dbDriver;
    }

    /**
     * 设置: 数据库驱动
     */
    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    /**
     * 获取: 数据库地址
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * 设置: 数据库地址
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /**
     * 获取: 数据库账户
     */
    public String getDbUserName() {
        return dbUserName;
    }

    /**
     * 设置: 数据库账户
     */
    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    /**
     * 获取: 连接密码
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * 设置: 连接密码
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    /**
     * 获取: UserId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置: UserId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取: 数据库类型
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * 设置: 数据库类型
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * 获取: 创建人
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /**
     * 设置: 创建人
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /**
     * 获取: 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置: 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取: 修改人
     */
    public String getMdfUserId() {
        return mdfUserId;
    }

    /**
     * 设置: 修改人
     */
    public void setMdfUserId(String mdfUserId) {
        this.mdfUserId = mdfUserId;
    }

    /**
     * 获取: 修改时间
     */
    public Date getMdfTime() {
        return mdfTime;
    }

    /**
     * 设置: 修改时间
     */
    public void setMdfTime(Date mdfTime) {
        this.mdfTime = mdfTime;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
