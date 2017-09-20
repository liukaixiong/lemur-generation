package cn.afterturn.gen.modular.code.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.afterturn.gen.modular.code.model.TableBaseFieldModel;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TableBaseFieldDao
 *
 * @author JueYue
 * @Date 2017-09-18 13:40
 */
@Repository
public interface TableBaseFieldDao extends BaseMapper<TableBaseFieldModel>{

    /**
     * 统计数量
     * @param model
     * @return
     */
    Integer selectCount(@Param("e")TableBaseFieldModel model);

    /**
     * 查询列表
     * @param model
     * @return
     */
    List<TableBaseFieldModel> selectList(@Param("e")TableBaseFieldModel model);

    /**
     * 分页查询信息
     * @param pagination
     * @param model
     * @param wrapper
     * @return
     */
    List<TableBaseFieldModel> selectPage(@Param("p")Pagination pagination,@Param("e") TableBaseFieldModel model,@Param("w") Wrapper<TableBaseFieldModel> wrapper);

}
