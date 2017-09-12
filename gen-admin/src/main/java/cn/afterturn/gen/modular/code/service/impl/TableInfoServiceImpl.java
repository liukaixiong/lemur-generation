package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.afterturn.gen.modular.code.dao.TableInfoDao;
import cn.afterturn.gen.modular.code.model.TableInfoModel;
import cn.afterturn.gen.modular.code.service.ITableInfoService;

/**
 * 表信息管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:32
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {

    @Autowired
    private TableInfoDao tableInfoDao;

    @Override
    public Integer insert(TableInfoModel entity) {
        return tableInfoDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return tableInfoDao.deleteById(id);
    }

    @Override
    public Integer updateById(TableInfoModel entity) {
        return tableInfoDao.updateById(entity);
    }

    @Override
    public TableInfoModel selectById(Integer id) {
        return tableInfoDao.selectById(id);
    }

    @Override
    public TableInfoModel selectOne(TableInfoModel entity) {
        return tableInfoDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(TableInfoModel model) {
        return tableInfoDao.selectCount(model);
    }

    @Override
    public List<TableInfoModel> selectList(TableInfoModel model) {
        return tableInfoDao.selectList(model);
    }

    @Override
    public List<TableInfoModel> selectPage(Pagination pagination, TableInfoModel model, Wrapper<TableInfoModel> wrapper) {
        return tableInfoDao.selectPage(pagination, model, wrapper);
    }

}
