package com.postaop.bus.map.controller.${params.packageName};

import io.lemur.common.util.logger.MyLogger;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.linkea.common.util.PageList;

import com.postaop.bus.map.controller.util.PageForm;
import com.postaop.bus.map.controller.util.PermissionEnum;
import com.postaop.bus.map.controller.util.PermissionUtil;
import ${params.javaPackage}.entity.${params.packageName}.${params.entityName}Entity;
import ${params.javaPackage}.service.${params.packageName}.I${params.entityName}Service;

/**
 * ${table.chinaName!} ${table.comment!}服务
 * @author JueYue
 * @date ${createTime}
 * @version V1.0  
 */
@Controller
@RequestMapping("${params.packageName}.htm")
public class ${params.entityName}Controller {

    private static final Logger LOGGER             = MyLogger.getLogger();

    private static final String ${params.entityName?html?upper_case}_VIEW = "${params.packageName}/${params.entityName?html?uncap_first}List";

    @Autowired
    private I${params.entityName}Service ${params.entityName?html?uncap_first}Service;

    @RequestMapping
    public String home(${params.entityName}Entity entity, ModelMap modelMap, PageForm pageForm) {
        modelMap.addAttribute("entity", entity);
        modelMap.addAttribute("pageForm", pageForm);
        return ${params.entityName?html?upper_case}_VIEW;
    }

    @RequestMapping(params = "ACTION=${params.entityName?html?upper_case}_LIST")
    public String ${params.entityName}List(${params.entityName}Entity entity, ModelMap modelMap, PageForm pageForm) {
        try {
            PageList<${params.entityName}Entity> list = ${params.entityName?html?uncap_first}Service.get${params.entityName}Page(entity,pageForm.getPage(),pageForm.getPageSize());
            modelMap.addAttribute("list", list);
            modelMap.addAttribute("paginator", list.getPaginator());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            modelMap.addAttribute(PageForm.resultMsg, "系统异常");
            modelMap.addAttribute(PageForm.success, false);
        }
        return home(entity, modelMap, pageForm);
    }
}
