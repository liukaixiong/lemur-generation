package cn.afterturn.gen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
 * @Description:模板管理; InnoDB free: 7168 kB kB
 * @author JueYue
 * @date 2016-11-18 14:43
 * @version V1.0   
 */
@Entity
@Table(name = "t_system_template")
public class TemplateEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id 
     **/
    private String            id;
    /**
     * 模板名称 
     **/
    private String            templateName;
    /**
     * 模板地址 
     **/
    private String            templatePath;
    /**
     * UserId 
     **/
    private String            userId;
    /**
     * TemplateDesc 
     **/
    private String            templateDesc;
    /**
     * 文件名称 
     **/
    private String            fileName;
    /**
     * 模板类型
     **/
    private String            templateType;

    /**
     *方法: 取得Id
     *@return: String  
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 32)
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
     *方法: 取得模板名称
     *@return: String  
     */
    @Column(name = "Template_NAME", nullable = false, length = 50)
    public String getTemplateName() {
        return this.templateName;
    }

    /**
     *方法: 设置模板名称
     *@param: templateName  
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     *方法: 取得模板地址
     *@return: String  
     */
    @Column(name = "Template_path", nullable = false, length = 1000)
    public String getTemplatePath() {
        return this.templatePath;
    }

    /**
     *方法: 设置模板地址
     *@param: templatePath  
     */
    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    /**
     *方法: 取得UserId
     *@return: String  
     */
    @Column(name = "USER_ID", nullable = false, length = 32)
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
     *方法: 取得TemplateDesc
     *@return: String  
     */
    @Column(name = "Template_DESC", nullable = false, length = 1000)
    public String getTemplateDesc() {
        return this.templateDesc;
    }

    /**
     *方法: 设置TemplateDesc
     *@param: templateDesc  
     */
    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    /**
     *方法: 取得文件名称
     *@return: String  
     */
    @Column(name = "FILE_NAME", nullable = false, length = 100)
    public String getFileName() {
        return this.fileName;
    }

    /**
     *方法: 设置文件名称
     *@param: fileName  
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "TEMPLATE_TYPE", nullable = false, length = 20)
    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
}
