<%if (t.isProtocol == 1) {%>
${g.copyright!}
<%}%>
package ${g.codePackage}.model;

import cn.afterturn.boot.bussiness.model.IdTenantBaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;
import lombok.Data;
<%if (t.api == 1) {%>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<%}%>
<%if (t.isImport == 1 || t.isExport == 1) {%>
import cn.afterturn.easypoi.excel.annotation.Excel
<%}%>

/**
 * ${g.name}
 *
 * @author ${g.author}
 * @Date ${g.date}
 */
@Data
<%if (t.api == 1) {%>
@ApiModel("${g.name}")
<%}%>
@TableName("${g.tableName}")
public class ${g.entityName}Model extends IdTenantBaseModel<${g.entityName}Model> {

    private static final long serialVersionUID = 1L;

<%for(field in t.fields){%>

     /* ${field.chinaName}  - ${field.comment} */
    <%if (t.isImport == 1 || t.isExport == 1) {%>
    @Excel(name = "${field.chinaName}")
    <%}%>
    <%if (field.name == g.idName) {%>
    @TableId(value = "g.idName",type = IdType.AUTO)
    <%}else{%>
    @TableField(value="${field.fieldName}")
    <%}%>
    <%if (t.api == 1) {%>
    @ApiModelProperty("${field.chinaName}")
    <%}%>
    private ${field.type} ${field.name};
<%}%>
}
