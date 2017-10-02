package cn.afterturn.gen.modular.code.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.model.TableFieldDbinfoModel;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TableFieldDbinfoDao
 *
 * @author JueYue
 * @Date 2017-09-27 20:46
 */
@Repository
public interface TableFieldDbinfoDao extends BaseMapper<TableFieldDbinfoModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")TableFieldDbinfoModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableFieldDbinfoModel> selectList(@Param("e")TableFieldDbinfoModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableFieldDbinfoModel> selectPage(@Param("p")Pagination pagination,@Param("e") TableFieldDbinfoModel model,@Param("w") Wrapper<TableFieldDbinfoModel> wrapper);

}
