<%if (t.isProtocol == 1) {%>
        ${g.copyright!}
<%}%>
package ${g.codePackage}.controller;

import cn.afterturn.boot.bussiness.base.controller.BaseController;
import ${g.codePackage}.model.${g.entityName}Model;
import ${g.codePackage}.service.I${g.entityName}Service;

<%if (t.api == 1) {%>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
<%}%>
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ${g.name}控制器
 *
 * @author ${g.author}
 * @Date ${g.date}
 */
<%if (t.api == 1) {%>
@Api("${g.name}")
<%}%>
@RestController
@RequestMapping("/${strutil.toLowerCase(g.entityName)}")
public class ${g.entityName}Controller extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(${g.entityName}Controller.class);

    @Autowired
    private I${g.entityName}Service ${g.lowerEntityName}Service;

}