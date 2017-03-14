package cn.afterturn.gen.service;

import com.github.pagehelper.PageInfo;

import cn.afterturn.gen.model.TemplateEntity;

/**
 * 模板管理; InnoDB free: 7168 kB kB服务
 * @author JueYue
 * @date 2016-11-18 14:54
 * @version V1.0  
 */
public interface ITemplateService {
    /**
     * 分页查询模板管理
     * @param entity
     * @param page
     * @param pageSize
     * @return
     */
    public PageInfo<TemplateEntity> getTemplatePage(TemplateEntity entity, int page, int pageSize);

    /**
     * 新增模板管理
     * @param entity
     * @return
     */
    public boolean addTemplate(TemplateEntity entity);

    /**
     * 修改模板管理
     * @param entity
     * @return
     */
    public boolean updateTemplate(TemplateEntity entity);

    /**
     * 删除模板管理
     * @param entity
     * @return
     */
    public boolean deteleTemplate(TemplateEntity entity);

}
