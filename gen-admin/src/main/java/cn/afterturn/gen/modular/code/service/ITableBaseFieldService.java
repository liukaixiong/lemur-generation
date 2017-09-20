package cn.afterturn.gen.modular.code.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.model.TableBaseFieldModel;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.util.List;
import java.util.Map;


/**
 * Service
 *
 * @author JueYue
 * @Date 2017-09-18 13:40
 */
public interface ITableBaseFieldService {

     /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer insert(TableBaseFieldModel entity);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return int
     */
    Integer deleteById(Integer id);

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     * @return int
     */
    Integer updateById(TableBaseFieldModel entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return TableBaseFieldModel
     */
    TableBaseFieldModel selectById(Integer id);

    /**
     * <p>
     * 根据 entity 条件，查询一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return TableBaseFieldModel
     */
    TableBaseFieldModel selectOne(TableBaseFieldModel entity);

    /**
     * <p>
     * 根据 model 条件，查询总记录数
     * </p>
     *
     * @param model 实体对象
     * @return int
     */
    Integer selectCount(TableBaseFieldModel model);

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param model 实体对象封装操作类（可以为 null）
     * @return List<TableBaseFieldModel>
     */
    List<TableBaseFieldModel> selectList(TableBaseFieldModel model);


    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param pagination 分页查询条件
     * @param model   实体对象封装操作可以为 null）
     * @param wrapper   SQL包装
     * @return List<TableBaseFieldModel>
     */
    List<TableBaseFieldModel> selectPage(Pagination pagination, TableBaseFieldModel model,Wrapper<TableBaseFieldModel> wrapper);

}
