package ${params.javaPackage}.repository.${params.packageName};

import ${params.javaPackage}.entity.${params.packageName}.${params.entityName}Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**   
 * @Description: ${table.chinaName} ${table.comment!}
 * @author Lemur
 * @date ${createTime}
 * @version V1.0   
 */
@Repository("${params.entityName?uncap_first}Repository")
public interface ${params.entityName}Repository extends CrudRepository<${params.entityName}Entity, <#if params.idType.value == 'auto'>Long<<#else>String</#if>> {

}