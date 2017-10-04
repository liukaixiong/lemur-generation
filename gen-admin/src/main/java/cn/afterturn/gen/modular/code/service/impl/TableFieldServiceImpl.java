package cn.afterturn.gen.modular.code.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import cn.afterturn.gen.core.support.CollectionKit;
import cn.afterturn.gen.modular.code.dao.TableFieldDao;
import cn.afterturn.gen.modular.code.model.TableFieldDbinfoModel;
import cn.afterturn.gen.modular.code.model.TableFieldModel;
import cn.afterturn.gen.modular.code.model.TableFieldVerifyModel;
import cn.afterturn.gen.modular.code.service.ITableFieldDbinfoService;
import cn.afterturn.gen.modular.code.service.ITableFieldService;
import cn.afterturn.gen.modular.code.service.ITableFieldVerifyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private ITableFieldVerifyService tableFieldVerifyService;
    @Autowired
    private ITableFieldDbinfoService tableFieldDbinfoService;

    @Override
    @Transactional
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

    @Override
    public void batchSaveOrUpdate(List<TableFieldModel> tableFields) {
        // 删除旧数据
        Map<String,Object> temp = new HashMap<String, Object>();
        temp.put("table_id",tableFields.get(0).getTableId());
        List<TableFieldModel> list = tableFieldDao.selectByMap(temp);
        if(CollectionKit.isNotEmpty(list)){
            List<Integer> ids = getIds(list);
            tableFieldDao.deleteBatchIds(ids);
            tableFieldVerifyService.deleteByFieldIds(ids);
            tableFieldDbinfoService.deleteByFieldIds(ids);
        }
        tableFieldDao.batchInsert(tableFields);

        List<TableFieldVerifyModel> verifyModelList = new ArrayList<TableFieldVerifyModel>(tableFields.size());
        List<TableFieldDbinfoModel> dbInfoModelList = new ArrayList<TableFieldDbinfoModel>(tableFields.size());
        for (int i = 0; i < tableFields.size(); i++) {
            list.get(i).getVerifyModel().setFieldId(list.get(i).getId());
            verifyModelList.add(list.get(i).getVerifyModel());
            list.get(i).getDbinfoModel().setFieldId(list.get(i).getId());
            dbInfoModelList.add(list.get(i).getDbinfoModel());
        }
        tableFieldVerifyService.batchInsert(verifyModelList);
        tableFieldDbinfoService.batchInsert(dbInfoModelList);

    }

    /**
     *
     * @param list
     * @return
     */
    private List<Integer> getIds(List<TableFieldModel> list) {
        List<Integer> ids = new ArrayList<Integer>(list.size());
        for (int i = 0; i < list.size(); i++) {
            ids.add(list.get(i).getId());
        }
        return ids;
    }

}
