package cn.afterturn.gen.service.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.afterturn.gen.model.template.TemplateEntity;
import cn.afterturn.gen.repository.template.TemplateRepository;

/**
 * 模板管理; InnoDB free: 7168 kB kB服务
 * @author JueYue
 * @date 2016-11-18 14:54
 * @version V1.0  
 **/
@Service("templateService")
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public PageInfo<TemplateEntity> getTemplatePage(TemplateEntity Template, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<TemplateEntity>(templateRepository.select(Template));
    }

    @Override
    public boolean addTemplate(TemplateEntity entity) {
        return templateRepository.insertSelective(entity) > 0;
    }

    @Override
    public boolean updateTemplate(TemplateEntity entity) {
        return templateRepository.updateByPrimaryKeySelective(entity) > 0;
    }

    @Override
    public boolean deteleTemplate(TemplateEntity entity) {
        return templateRepository.deleteByPrimaryKey(entity.getId()) > 0;
    }

}
