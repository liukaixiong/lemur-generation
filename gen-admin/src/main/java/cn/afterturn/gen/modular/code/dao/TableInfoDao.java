package cn.afterturn.gen.modular.code.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import cn.afterturn.gen.modular.code.model.TableInfoModel;

/**
 * TableInfoDao
 *
 * @author JueYue
 * @Date 2017-09-11 11:32
 */
@Repository
public interface TableInfoDao extends BaseMapper<TableInfoModel> {

    /**
     * 统计数量
     */
    Integer selectCount(@Param("e") TableInfoModel model);

    /**
     * 查询列表
     */
    List<TableInfoModel> selectList(@Param("e") TableInfoModel model);

    /**
     * 分页查询信息
     */
    List<TableInfoModel> selectPage(@Param("p") Pagination pagination, @Param("e") TableInfoModel model, @Param("w") Wrapper<TableInfoModel> wrapper);

}
