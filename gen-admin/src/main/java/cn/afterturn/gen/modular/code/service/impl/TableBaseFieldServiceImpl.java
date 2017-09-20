package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.dao.TableBaseFieldDao;
import cn.afterturn.gen.modular.code.model.TableBaseFieldModel;
import cn.afterturn.gen.modular.code.service.ITableBaseFieldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-18 13:40
 */
@Service
public class TableBaseFieldServiceImpl implements ITableBaseFieldService {

    @Autowired
    private TableBaseFieldDao tableBaseFieldDao;

    @Override
    public Integer insert(TableBaseFieldModel entity) {
        return tableBaseFieldDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return tableBaseFieldDao.deleteById(id);
    }

    @Override
    public Integer updateById(TableBaseFieldModel entity) {
        return tableBaseFieldDao.updateById(entity);
    }

    @Override
    public TableBaseFieldModel selectById(Integer id) {
        return tableBaseFieldDao.selectById(id);
    }

    @Override
    public TableBaseFieldModel selectOne(TableBaseFieldModel entity) {
        return tableBaseFieldDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(TableBaseFieldModel model) {
        return tableBaseFieldDao.selectCount(model);
    }

    @Override
    public List<TableBaseFieldModel> selectList(TableBaseFieldModel model) {
        return tableBaseFieldDao.selectList(model);
    }

    @Override
    public List<TableBaseFieldModel> selectPage(Pagination pagination, TableBaseFieldModel model, Wrapper<TableBaseFieldModel> wrapper) {
        return tableBaseFieldDao.selectPage(pagination,model,wrapper);
    }

}
