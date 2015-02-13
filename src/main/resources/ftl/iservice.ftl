package ${params.javaPackage}.service.${params.packageName};

import cn.linkea.common.util.PageList;

import ${params.javaPackage}.entity.${params.packageName}.${params.entityName}Entity;

/**
 * ${table.chinaName!} ${table.comment!}服务
 * @author JueYue
 * @date ${createTime}
 * @version V1.0  
 */
public interface I${params.entityName}Service {
    /**
     * 分页查询${table.chinaName!} ${table.comment!}
     * @param entity
     * @param page
     * @param pageSize
     * @return
     */
    public PageList<${params.entityName}Entity> get${params.entityName}Page(${params.entityName}Entity entity,int page, int pageSize);

    /**
     * 新增${table.chinaName!} ${table.comment!}
     * @param entity
     * @return
     */
    public boolean add${params.entityName}(${params.entityName}Entity entity);

    /**
     * 修改${table.chinaName!} ${table.comment!}
     * @param entity
     * @return
     */
    public boolean update${params.entityName}(${params.entityName}Entity entity);

    /**
     * 删除${table.chinaName!} ${table.comment!}
     * @param entity
     * @return
     */
    public boolean detele${params.entityName}(${params.entityName}Entity entity);

}
