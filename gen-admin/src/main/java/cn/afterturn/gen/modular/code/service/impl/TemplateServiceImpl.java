package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.afterturn.gen.modular.code.dao.TemplateDao;
import cn.afterturn.gen.modular.code.dao.TemplateFileDao;
import cn.afterturn.gen.modular.code.model.TemplateFileModel;
import cn.afterturn.gen.modular.code.model.TemplateModel;
import cn.afterturn.gen.modular.code.service.ITemplateService;

/**
 * 模板管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:22
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private TemplateDao templateDao;
    @Autowired
    private TemplateFileDao templateFileDao;

    @Override
    public Integer insert(TemplateModel entity, TemplateFileModel fileModel) {
        templateDao.insert(entity);
        fileModel.setTemplateId(entity.getId());
        return templateFileDao.insert(fileModel);
    }

    @Override
    public Integer deleteById(Integer id) {
        templateFileDao.deleteByTemplateId(id);
        return templateDao.deleteById(id);
    }

    @Override
    public Integer updateById(TemplateModel entity, TemplateFileModel fileModel) {
        fileModel.setTemplateId(entity.getId());
        int  nums = templateFileDao.updateTemplateId(fileModel);
        if(nums == 0){
            templateFileDao.insert(fileModel);
        }
        return templateDao.updateById(entity);
    }

    @Override
    public TemplateModel selectById(Integer id) {
        return templateDao.selectById(id);
    }

    @Override
    public TemplateModel selectOne(TemplateModel entity) {
        return templateDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(TemplateModel model) {
        return templateDao.selectCount(model);
    }

    @Override
    public List<TemplateModel> selectList(TemplateModel model) {
        return templateDao.selectList(model);
    }

    @Override
    public List<TemplateModel> selectPage(Pagination pagination, TemplateModel model, Wrapper<TemplateModel> wrapper) {
        return templateDao.selectPage(pagination, model, wrapper);
    }

}
