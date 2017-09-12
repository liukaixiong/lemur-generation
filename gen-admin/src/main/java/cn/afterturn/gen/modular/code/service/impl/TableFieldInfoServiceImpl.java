package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.afterturn.gen.modular.code.dao.TableFieldInfoDao;
import cn.afterturn.gen.modular.code.model.TableFieldInfoModel;
import cn.afterturn.gen.modular.code.service.ITableFieldInfoService;

/**
 * 表字段信息Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:36
 */
@Service
public class TableFieldInfoServiceImpl implements ITableFieldInfoService {

    @Autowired
    private TableFieldInfoDao tableFieldInfoDao;

    @Override
    public Integer insert(TableFieldInfoModel entity) {
        return tableFieldInfoDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return tableFieldInfoDao.deleteById(id);
    }

    @Override
    public Integer updateById(TableFieldInfoModel entity) {
        return tableFieldInfoDao.updateById(entity);
    }

    @Override
    public TableFieldInfoModel selectById(Integer id) {
        return tableFieldInfoDao.selectById(id);
    }

    @Override
    public TableFieldInfoModel selectOne(TableFieldInfoModel entity) {
        return tableFieldInfoDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(TableFieldInfoModel model) {
        return tableFieldInfoDao.selectCount(model);
    }

    @Override
    public List<TableFieldInfoModel> selectList(TableFieldInfoModel model) {
        return tableFieldInfoDao.selectList(model);
    }

    @Override
    public List<TableFieldInfoModel> selectPage(Pagination pagination, TableFieldInfoModel model, Wrapper<TableFieldInfoModel> wrapper) {
        return tableFieldInfoDao.selectPage(pagination, model, wrapper);
    }

}
