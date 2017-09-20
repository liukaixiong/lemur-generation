package cn.afterturn.gen.modular.code.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.model.TableFieldVerifyModel;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TableFieldVerifyDao
 *
 * @author JueYue
 * @Date 2017-09-20 09:24
 */
@Repository
public interface TableFieldVerifyDao extends BaseMapper<TableFieldVerifyModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")TableFieldVerifyModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableFieldVerifyModel> selectList(@Param("e")TableFieldVerifyModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableFieldVerifyModel> selectPage(@Param("p")Pagination pagination,@Param("e") TableFieldVerifyModel model,@Param("w") Wrapper<TableFieldVerifyModel> wrapper);

}
