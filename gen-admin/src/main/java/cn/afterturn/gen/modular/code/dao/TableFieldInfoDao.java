package cn.afterturn.gen.modular.code.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import cn.afterturn.gen.modular.code.model.TableFieldInfoModel;

/**
 * TableFieldInfoDao
 *
 * @author JueYue
 * @Date 2017-09-11 11:36
 */
@Repository
public interface TableFieldInfoDao extends BaseMapper<TableFieldInfoModel> {

    /**
     * 统计数量
     */
    Integer selectCount(@Param("e") TableFieldInfoModel model);

    /**
     * 查询列表
     */
    List<TableFieldInfoModel> selectList(@Param("e") TableFieldInfoModel model);

    /**
     * 分页查询信息
     */
    List<TableFieldInfoModel> selectPage(@Param("p") Pagination pagination, @Param("e") TableFieldInfoModel model, @Param("w") Wrapper<TableFieldInfoModel> wrapper);

}
