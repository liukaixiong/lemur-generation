package ${params.javaPackage}.service.${params.packageName};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linkea.common.lang.Paginator;
import cn.linkea.common.util.PageList;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ${params.javaPackage}.entity.${params.packageName}.${params.entityName}Entity;
import ${params.javaPackage}.repository.${params.packageName}.${params.entityName}Repository;

/**
 * ${table.chinaName!} ${table.comment!}服务
 * @author JueYue
 * @date ${createTime}
 * @version V1.0  
 **/
@Service("${params.entityName?html?uncap_first}Service")
public class ${params.entityName}ServiceImpl implements I${params.entityName}Service {

    @Autowired
    private ${params.entityName}Repository ${params.entityName?html?uncap_first}Repository;

    @Override
    public PageList<${params.entityName}Entity> get${params.entityName}Page(${params.entityName}Entity ${params.entityName}, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<${params.entityName}Entity> pageInfo = ${params.entityName?html?uncap_first}Repository.select(${params.entityName});
        Paginator paginator = new Paginator(pageSize);
        paginator.setPage(page);
        paginator.setItems((int) ((Page<${params.entityName}Entity>)pageInfo).getTotal());
        PageList<${params.entityName}Entity> resultList = new PageList<${params.entityName}Entity>(pageInfo);
        resultList.setPaginator(paginator);
        return resultList;
    }

    @Override
    public boolean add${params.entityName}(${params.entityName}Entity entity) {
        return ${params.entityName?html?uncap_first}Repository.insertSelective(entity) > 0;
    }

    @Override
    public boolean update${params.entityName}(${params.entityName}Entity entity) {
        return ${params.entityName?html?uncap_first}Repository.updateByPrimaryKeySelective(entity) > 0;
    }

    @Override
    public boolean detele${params.entityName}(${params.entityName}Entity entity) {
        return ${params.entityName?html?uncap_first}Repository.deleteByPrimaryKey(entity.getId()) > 0;
    }

}
