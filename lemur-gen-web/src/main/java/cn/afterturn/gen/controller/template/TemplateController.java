package cn.afterturn.gen.controller.template;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.afterturn.common.model.RequestModel;
import cn.afterturn.common.model.ResponseModel;
import cn.afterturn.common.util.LemurLogger;
import cn.afterturn.gen.model.template.TemplateEntity;
import cn.afterturn.gen.service.template.ITemplateService;

/**
 * 模板管理服务
 * @author JueYue
 * @date 2016-11-18 14:54
 * @version V1.0  
 */
@RestController
@RequestMapping("template.htm")
public class TemplateController {

    private static final Logger LOGGER        = LemurLogger.getLogger();

    private static final String TEMPLATE_VIEW = "template/templateList";

    @Autowired
    private ITemplateService    templateService;

    @RequestMapping
    public String home(TemplateEntity entity, ModelMap modelMap, RequestModel form) {
        modelMap.addAttribute("entity", entity);
        modelMap.addAttribute("form", form);
        return TEMPLATE_VIEW;
    }

    @RequestMapping(params = "ACTION=TEMPLATE_LIST")
    public ResponseModel TemplateList(TemplateEntity entity, RequestModel form) {
        ResponseModel rm;
        try {
            PageInfo<TemplateEntity> list = templateService.getTemplatePage(entity, form.getPage(),
                form.getPageSize());
            rm = ResponseModel.ins(list);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            rm = new ResponseModel(ResponseModel.SYSTEM_ERROR);
        }
        return rm;
    }
}
