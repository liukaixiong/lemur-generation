package ${params.javaPackage}.entity.${params.packageName};

<#if isNeedDate>
import java.util.Date;
</#if>

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
 * @Description: ${table.chinaName} ${table.comment!}
 * @author Lemur
 * @date ${createTime}
 * @version V1.0   
 */
@Entity
@Table(name = "${table.tableName}")
public class ${params.entityName}Entity implements java.io.Serializable {

	private static final long         serialVersionUID = 1L;
	<#list table.fields as v>
	/**
	 * ${v.chinaName} ${v.comment!}
	 **/
	private ${v.type}			 ${v.name};
	</#list>
	
	<#list table.fields as v>
	/**
	 *方法: 取得${v.chinaName}
	 *@return: ${v.type}  ${v.comment!}
	 */
	<#if v.name == params.idName>
	
	<#if params.idType.value == 'auto'>
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "uuid-string")
	</#if>
	<#if params.idType.value == 'identity'>
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	</#if>
	<#if params.idType.value == 'sequence'>
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sequence")
	</#if>
	</#if>
	@Column(name ="${v.fieldName}" , nullable=<#if v.nullable == 'Y'>true<#else>false</#if><#if v.precision?exists && v.precision != ''>,precision=${v.precision}</#if><#if v.scale?exists &&  v.scale != ''>,scale=${v.scale}</#if><#if v.charmaxLength?exists && v.charmaxLength != ''>,length=${v.charmaxLength}</#if>)
	public ${v.type} get${v.name?cap_first}(){
		return this.${v.name};
	}

	/**
	 *方法: 设置${v.chinaName}
	 *@param: ${v.name}  ${v.comment!}
	 */
	public void set${v.name?cap_first}(${v.type} ${v.name}){
		this.${v.name} = ${v.name};
	}
	</#list>
}
