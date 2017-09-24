package cn.afterturn.gen.modular.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import cn.afterturn.gen.common.annotion.BussinessLog;
import cn.afterturn.gen.common.annotion.Permission;
import cn.afterturn.gen.common.constant.factory.PageFactory;
import cn.afterturn.gen.common.exception.BizExceptionEnum;
import cn.afterturn.gen.common.exception.BussinessException;
import cn.afterturn.gen.core.base.controller.BaseController;
import cn.afterturn.gen.core.util.ToolUtil;
import cn.afterturn.gen.modular.code.model.TableInfoModel;
import cn.afterturn.gen.modular.code.service.ITableInfoService;
import cn.afterturn.gen.modular.system.warpper.BeanKeyConvert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author JueYue
 * @Date 2017-09-20 09:18
 */
@Controller
@RequestMapping("/tableinfo")
public class TableInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableInfoController.class);

    private String PREFIX = "/code/tableinfo/";

    @Autowired
    private ITableInfoService tableInfoService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tableinfo.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/goto_add")
    public String TableInfoAdd() {
        return PREFIX + "tableinfo_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/goto_update/{id}")
    public String TableInfoUpdate(@PathVariable Integer id, Model model) {
	model.addAttribute("tableinfo", tableInfoService.selectById(id));
        return PREFIX + "tableinfo_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(TableInfoModel model) {
        Page<TableInfoModel> page = new PageFactory<TableInfoModel>().defaultPage();
        page.setRecords(tableInfoService.selectPage(page,model,new EntityWrapper<TableInfoModel>()));
        BeanKeyConvert.systemUserNameConvert(page.getRecords());
        return super.packForBT(page);
    }


    @BussinessLog(value = "新增", key = "tableName" )
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public Object add(@RequestBody TableInfoModel model) {
        tableInfoService.insert(model);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "删除", key = "id" )
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public Object delete(Integer id) {
        tableInfoService.deleteById(id);
        return SUCCESS_TIP;
    }


    @BussinessLog(value = "修改", key = "id" )
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public Object update(TableInfoModel model) {
        if (ToolUtil.isOneEmpty(model.getId())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        tableInfoService.updateById(model);
        return super.SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail(TableInfoModel model) {
        return tableInfoService.selectOne(model);
    }
}
