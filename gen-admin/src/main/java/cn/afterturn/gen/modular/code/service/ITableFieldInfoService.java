package cn.afterturn.gen.modular.code.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.List;

import cn.afterturn.gen.modular.code.model.TableFieldInfoModel;


/**
 * 表字段信息Service
 *
 * @author JueYue
 * @Date 2017-09-11 11:36
 */
public interface ITableFieldInfoService {

    /**
     * <p> 插入一条记录 </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer insert(TableFieldInfoModel entity);

    /**
     * <p> 根据 ID 删除 </p>
     *
     * @param id 主键ID
     * @return int
     */
    Integer deleteById(Integer id);

    /**
     * <p> 根据 ID 修改 </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer updateById(TableFieldInfoModel entity);

    /**
     * <p> 根据 ID 查询 </p>
     *
     * @param id 主键ID
     * @return TableFieldInfoModel
     */
    TableFieldInfoModel selectById(Integer id);

    /**
     * <p> 根据 entity 条件，查询一条记录 </p>
     *
     * @param entity 实体对象
     * @return TableFieldInfoModel
     */
    TableFieldInfoModel selectOne(TableFieldInfoModel entity);

    /**
     * <p> 根据 model 条件，查询总记录数 </p>
     *
     * @param model 实体对象
     * @return int
     */
    Integer selectCount(TableFieldInfoModel model);

    /**
     * <p> 根据 entity 条件，查询全部记录 </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<TableFieldInfoModel>
     */
    List<TableFieldInfoModel> selectList(TableFieldInfoModel model);


    /**
     * <p> 根据 entity 条件，查询全部记录（并翻页） </p>
     *
     * @param pagination 分页查询条件
     * @param model      实体对象封装操作��以为 null）
     * @param wrapper    SQL包装
     * @return List<TableFieldInfoModel>
     */
    List<TableFieldInfoModel> selectPage(Pagination pagination, TableFieldInfoModel model, Wrapper<TableFieldInfoModel> wrapper);

}
