package cn.afterturn.gen.modular.code.service.impl.convert;

import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.core.model.GenFieldEntity;
import cn.afterturn.gen.modular.code.model.TableFieldDbinfoModel;
import cn.afterturn.gen.modular.code.model.TableFieldModel;
import cn.afterturn.gen.modular.code.model.TableFieldVerifyModel;
import cn.afterturn.gen.modular.code.model.TableInfoModel;
import cn.afterturn.gen.modular.code.model.TableServiceConfigModel;
import cn.afterturn.gen.modular.code.service.ITableConvertServer;
import cn.afterturn.gen.modular.code.service.ITableInfoService;

/**
 * 导入的数据库版本实现
 *
 * @author JueYue on 2017/10/25.
 */
@Service("dbTableConvertServer")
public class TableConvertServiceOfDbImpl implements ITableConvertServer {

    @Autowired
    private ITableInfoService tableInfoService;

    @Override
    public void importBean(String json, int userId) {
        GenBeanEntity bean = JSON.parseObject(json, GenBeanEntity.class);
        TableInfoModel entity = new TableInfoModel();
        entity.setClassName(bean.getName());
        if (StringUtils.isEmpty(bean.getChinaName())) {
            entity.setContent(bean.getTableName());
        } else {
            entity.setContent(bean.getChinaName());
        }
        entity.setTableName(bean.getTableName());
        entity.setUserId(userId);
        entity.setServiceConfig(getDefaultServceConfig());
        entity.setTableFields(getTableFields(bean.getFields()));
        tableInfoService.insert(entity);
    }

    private List<TableFieldModel> getTableFields(List<GenFieldEntity> fields) {
        List<TableFieldModel> list = new ArrayList<TableFieldModel>();
        TableFieldModel fieldModel;
        GenFieldEntity tableFiedl;
        TableFieldVerifyModel verifyModel;
        TableFieldDbinfoModel dbinfoModel;
        for (int i = 0; i < fields.size(); i++) {
            fieldModel = new TableFieldModel();
            tableFiedl = fields.get(i);
            fieldModel.setFieldName(tableFiedl.getFieldName());
            fieldModel.setName(tableFiedl.getName());
            fieldModel.setContent(tableFiedl.getChinaName());
            fieldModel.setType(tableFiedl.getType());
            fieldModel.setIsKey(tableFiedl.getKey());
            verifyModel = new TableFieldVerifyModel();
            verifyModel.setNotNull(tableFiedl.getNotNull());
            fieldModel.setVerifyModel(verifyModel);
            dbinfoModel = new TableFieldDbinfoModel();
            dbinfoModel.setFieldName(tableFiedl.getFieldName());
            dbinfoModel.setFieldContent(tableFiedl.getComment());
            dbinfoModel.setFieldLength(tableFiedl.getFieldLength());
            dbinfoModel.setFieldPointLength(tableFiedl.getFieldPointLength());
            dbinfoModel.setFieldType(tableFiedl.getFieldType());
            fieldModel.setDbinfoModel(dbinfoModel);
            list.add(fieldModel);
        }
        return list;
    }

    private List<TableServiceConfigModel> getDefaultServceConfig() {
        List<TableServiceConfigModel> list = new ArrayList<TableServiceConfigModel>();
        list.add(new TableServiceConfigModel("list", 1, 1, 2, "02"));
        list.add(new TableServiceConfigModel("add", 1, 1, 1, "01"));
        list.add(new TableServiceConfigModel("edit", 1, 1, 1, "01"));
        list.add(new TableServiceConfigModel("delete", 1, 1, 1, "01"));
        list.add(new TableServiceConfigModel("detail", 1, 1, 2, "02"));
        return list;
    }
}
