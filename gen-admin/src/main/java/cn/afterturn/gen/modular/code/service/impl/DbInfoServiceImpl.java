package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.afterturn.gen.modular.code.dao.DbInfoDao;
import cn.afterturn.gen.modular.code.model.DbInfoModel;
import cn.afterturn.gen.modular.code.service.IDbInfoService;

/**
 * 数据库管理Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:15
 */
@Service
public class DbInfoServiceImpl implements IDbInfoService {

    @Autowired
    private DbInfoDao dbInfoDao;

    @Override
    public Integer insert(DbInfoModel entity) {

        return dbInfoDao.insert(entity);
    }

    @Override
    public Integer deleteById(Integer id) {
        return dbInfoDao.deleteById(id);
    }

    @Override
    public Integer updateById(DbInfoModel entity) {
        return dbInfoDao.updateById(entity);
    }

    @Override
    public DbInfoModel selectById(Integer id) {
        return dbInfoDao.selectById(id);
    }

    @Override
    public DbInfoModel selectOne(DbInfoModel entity) {
        return dbInfoDao.selectOne(entity);
    }

    @Override
    public Integer selectCount(DbInfoModel model) {
        return dbInfoDao.selectCount(model);
    }

    @Override
    public List<DbInfoModel> selectList(DbInfoModel model) {
        return dbInfoDao.selectList(model);
    }

    @Override
    public List<DbInfoModel> selectPage(Pagination pagination, DbInfoModel model, Wrapper<DbInfoModel> wrapper) {
        return dbInfoDao.selectPage(pagination, model, wrapper);
    }

}
