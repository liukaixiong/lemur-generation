package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.dao.TableInfoDao;
import cn.afterturn.gen.modular.code.model.TableInfoModel;
import cn.afterturn.gen.modular.code.service.ITableInfoService;
import cn.afterturn.gen.modular.code.service.ITableServiceConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {

    @Autowired
    private TableInfoDao tableInfoDao;
    @Autowired
    private ITableServiceConfigService tableServiceConfigService;

    @Override
    @Transactional
    public Integer insert(TableInfoModel entity) {
        tableInfoDao.insert(entity);
        for (int i = 0; i < entity.getServiceConfig().size(); i++) {
            entity.getServiceConfig().get(i).setTableId(entity.getId());
        }
        tableServiceConfigService.batchSaveOrUpdateServiceConfig(entity.getServiceConfig());
        return 1;
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
        return tableInfoDao.selectPage(pagination,model,wrapper);
    }

}
