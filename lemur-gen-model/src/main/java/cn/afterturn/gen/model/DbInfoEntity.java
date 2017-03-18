/**
 * 代码归 Green Dragon Team 所有,任何公司和个人不得擅自使用, 我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package cn.afterturn.gen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**   
 * @Description: InnoDB free: 97280 kB kB
 * @author JueYue
 * @date 2017-03-14 19:52
 * @version V1.0   
 */
@Entity
@Table(name = "t_system_dbinfo")
public class DbInfoEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id 
     **/
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "ID", nullable = false, length = 32)
    private String            id;
    /**
     * 数据库驱动 
     **/
    @Column(name = "DB_DRIVER", nullable = false, length = 100)
    private String            dbDriver;
    /**
     * 数据库地址 
     **/
    @Column(name = "DB_URL", nullable = false, length = 200)
    private String            dbUrl;
    /**
     * 数据库账户 
     **/
    @Column(name = "DB_USER_NAME", nullable = false, length = 100)
    private String            dbUserName;
    /**
     * 连接密码 
     **/
    @Column(name = "DB_PASSWORD", nullable = false, length = 100)
    private String            dbPassword;
    /**
     * UserId 
     **/
    @Column(name = "USER_ID", nullable = false, length = 32)
    private String            userId;
    /**
     * 数据库类型 
     **/
    @Column(name = "DB_TYPE", nullable = false, length = 10)
    private String            dbType;
    /**
     * 创建人 
     **/
    @Column(name = "CRT_USER_ID", nullable = false, length = 16)
    private String            crtUserId;
    /**
     * 创建时间 
     **/
    @Column(name = "CRT_TIME", nullable = false)
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date              crtTime;
    /**
     * 修改人 
     **/
    @Column(name = "MDF_USER_ID", nullable = false, length = 16)
    private String            mdfUserId;
    /**
     * 修改时间 
     **/
    @Column(name = "MDF_TIME", nullable = false)
    private Date              mdfTime;

    /**
     *方法: 取得Id
     *@return: String  
     */
    public String getId() {
        return this.id;
    }

    /**
     *方法: 设置Id
     *@param: id  
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *方法: 取得数据库驱动
     *@return: String  
     */
    public String getDbDriver() {
        return this.dbDriver;
    }

    /**
     *方法: 设置数据库驱动
     *@param: dbDriver  
     */
    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    /**
     *方法: 取得数据库地址
     *@return: String  
     */
    public String getDbUrl() {
        return this.dbUrl;
    }

    /**
     *方法: 设置数据库地址
     *@param: dbUrl  
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /**
     *方法: 取得数据库账户
     *@return: String  
     */
    public String getDbUserName() {
        return this.dbUserName;
    }

    /**
     *方法: 设置数据库账户
     *@param: dbUserName  
     */
    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    /**
     *方法: 取得连接密码
     *@return: String  
     */
    public String getDbPassword() {
        return this.dbPassword;
    }

    /**
     *方法: 设置连接密码
     *@param: dbPassword  
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    /**
     *方法: 取得UserId
     *@return: String  
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     *方法: 设置UserId
     *@param: userId  
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *方法: 取得数据库类型
     *@return: String  
     */
    public String getDbType() {
        return this.dbType;
    }

    /**
     *方法: 设置数据库类型
     *@param: dbType  
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     *方法: 取得创建人
     *@return: String  
     */
    public String getCrtUserId() {
        return this.crtUserId;
    }

    /**
     *方法: 设置创建人
     *@param: crtUserId  
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /**
     *方法: 取得创建时间
     *@return: Date  
     */
    public Date getCrtTime() {
        return this.crtTime;
    }

    /**
     *方法: 设置创建时间
     *@param: crtTime  
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     *方法: 取得修改人
     *@return: String  
     */
    public String getMdfUserId() {
        return this.mdfUserId;
    }

    /**
     *方法: 设置修改人
     *@param: mdfUserId  
     */
    public void setMdfUserId(String mdfUserId) {
        this.mdfUserId = mdfUserId;
    }

    /**
     *方法: 取得修改时间
     *@return: Date  
     */
    public Date getMdfTime() {
        return this.mdfTime;
    }

    /**
     *方法: 设置修改时间
     *@param: mdfTime  
     */
    public void setMdfTime(Date mdfTime) {
        this.mdfTime = mdfTime;
    }
}
