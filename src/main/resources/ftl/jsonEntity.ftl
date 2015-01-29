package ${params.javaPackage};

<#if isNeedDate>
import java.util.Date;
</#if>
<#if isNeedList>
import java.util.List;
</#if>
<#if isNeedBigDecimal>
import java.math.BigDecimal;
</#if>
<#if isNeedBigInteger>
import java.math.BigInteger;
</#if>

/**   
 * @Description: ${table.chinaName!} ${table.comment!}
 * @author Lemur
 * @date ${createTime}
 * @version V1.0   
 */
public class ${table.name} implements java.io.Serializable {

	private static final long         serialVersionUID = 1L;
	<#list table.fields as v>
	/**
	 * ${v.chinaName!} ${v.comment!}
	 **/
	<#if v.fieldName?exists>
	@JsonProperty("${v.fieldName}")
	</#if>
	private ${v.type}			 ${v.name};
	</#list>
	<#list table.fields as v>
	/**
	 *方法: 取得${v.chinaName!}
	 *@return: ${v.type}  ${v.comment!}
	 */
	public ${v.type} get${v.name?cap_first}(){
		return this.${v.name};
	}

	/**
	 *方法: 设置${v.chinaName!}
	 *@param: ${v.name}  ${v.comment!}
	 */
	public void set${v.name?cap_first}(${v.type} ${v.name}){
		this.${v.name} = ${v.name};
	}
	</#list>
}
