package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.dao.TableFieldDao;
import cn.afterturn.gen.modular.code.model.TableFieldModel;
import cn.afterturn.gen.modular.code.service.ITableFieldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:22
 */
@Service
public class TableFieldServiceImpl implements ITableFieldService {

    @Autowired
    private TableFieldDao tableFieldDao;

    @Override
    @Transactional()
    public Integer insert(TableFieldModel entity) {
        return tableFieldDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return tableFieldDao.deleteById(id);
    }

    @Override
    public Integer updateById(TableFieldModel entity) {
        return tableFieldDao.updateById(entity);
    }

    @Override
    public TableFieldModel selectById(Integer id) {
        return tableFieldDao.selectById(id);
    }

    @Override
    public TableFieldModel selectOne(TableFieldModel entity) {
        return tableFieldDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(TableFieldModel model) {
        return tableFieldDao.selectCount(model);
    }

    @Override
    public List<TableFieldModel> selectList(TableFieldModel model) {
        return tableFieldDao.selectList(model);
    }

    @Override
    public List<TableFieldModel> selectPage(Pagination pagination, TableFieldModel model, Wrapper<TableFieldModel> wrapper) {
        return tableFieldDao.selectPage(pagination,model,wrapper);
    }

}
