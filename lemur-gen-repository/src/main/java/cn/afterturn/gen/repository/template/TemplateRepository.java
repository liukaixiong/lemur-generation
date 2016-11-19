package cn.afterturn.gen.repository.template;

import org.springframework.stereotype.Repository;

import cn.afterturn.gen.model.template.TemplateEntity;
import tk.mybatis.mapper.common.Mapper;

/**   
 * @Description:模板管理; InnoDB free: 7168 kB kB
 * @author JueYue
 * @date 2016-11-18 14:43
 * @version V1.0   
 */
@Repository("templateRepository")
public interface TemplateRepository extends Mapper<TemplateEntity> {

}