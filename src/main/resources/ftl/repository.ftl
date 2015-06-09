package ${params.javaPackage}.repository.${params.packageName};

import ${params.javaPackage}.entity.${params.packageName}.${params.entityName}Entity;

import com.github.abel533.mapper.QueryRepository;
import org.springframework.stereotype.Repository;
/**   
 * @Description: ${table.chinaName!} ${table.comment!}
 * @author JueYue
 * @date ${createTime}
 * @version V1.0   
 */
@Repository("${params.entityName?uncap_first}Repository")
public interface ${params.entityName}Repository extends QueryRepository<${params.entityName}Entity> {

}