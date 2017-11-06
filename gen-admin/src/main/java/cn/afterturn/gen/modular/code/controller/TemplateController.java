package cn.afterturn.gen.modular.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import cn.afterturn.gen.common.annotion.BussinessLog;
import cn.afterturn.gen.common.annotion.Permission;
import cn.afterturn.gen.common.constant.factory.PageFactory;
import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.core.base.controller.BaseController;
import cn.afterturn.gen.core.shiro.ShiroKit;
import cn.afterturn.gen.core.util.ToolUtil;
import cn.afterturn.gen.modular.code.model.TemplateFileModel;
import cn.afterturn.gen.modular.code.model.TemplateGroupModel;
import cn.afterturn.gen.modular.code.model.TemplateModel;
import cn.afterturn.gen.modular.code.service.ITemplateFileService;
import cn.afterturn.gen.modular.code.service.ITemplateGroupService;
import cn.afterturn.gen.modular.code.service.ITemplateService;
import cn.afterturn.gen.modular.system.warpper.BeanKeyConvert;

/**
 * 模板管理控制器
 *
 * @author JueYue
 * @Date 2017-09-11 11:22
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    private String PREFIX = "/code/template/";

    @Autowired
    private ITemplateService templateService;
    @Autowired
    private ITemplateFileService templateFileService;
    @Autowired
    private ITemplateGroupService templateGroupService;


    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        return PREFIX + "template.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String TemplateAdd(Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        return PREFIX + "template_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String TemplateUpdate(@PathVariable Integer id, Model modelMap) {
        TemplateGroupModel model = new TemplateGroupModel();
        model.setUserId(ShiroKit.getUser().getId());
        modelMap.addAttribute("groups", templateGroupService.selectList(model));
        modelMap.addAttribute("template", templateService.selectById(id));
        modelMap.addAttribute("file", templateFileService.selectOne(new TemplateFileModel(id)));
        return PREFIX + "template_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(TemplateModel model) {
        Page<TemplateModel> page = new PageFactory<TemplateModel>().defaultPage();
        model.setUserId(ShiroKit.getUser().getId());
        page.setRecords(templateService.selectPage(page, model, new EntityWrapper<TemplateModel>()));
        BeanKeyConvert.systemUserNameConvert(page.getRecords());
        return super.packForBT(page);
    }


    @BussinessLog(value = "模板管理新增", key = "companyid")
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(TemplateModel model, TemplateFileModel fileModel) throws UnsupportedEncodingException {
        fileModel.setFile(hanlderFileEncode(fileModel.getFile()));
        templateService.insert(model, fileModel);
        return SUCCESS_TIP;
    }

    @BussinessLog(value = "模板管理删除", key = "id")
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(Integer id) {
        templateService.deleteById(id);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "模板管理修改", key = "id")
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(TemplateModel model, TemplateFileModel fileModel) throws UnsupportedEncodingException {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        fileModel.setFile(hanlderFileEncode(fileModel.getFile()));
        templateService.updateById(model, fileModel);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(TemplateModel model) {
        return templateService.selectOne(model);
    }

    private String hanlderFileEncode(String file) {
        return file.replaceAll("& #40;","(")
                .replaceAll("& #41;",")")
                .replaceAll("& lt;","<")
                .replaceAll("& gt;",">")
                .replaceAll("& #39;","'");
    }
}
