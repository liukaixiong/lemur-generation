/**
 * 管理初始化
 */
var TableField = {};

TableField.trTemplate = "<tr id=\"replaceId\" class=\"fieldTr\">\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \">\n"
                        + "            <div class=\"th-inner \"><span style='cursor:pointer;' class=\"glyphicon glyphicon-minus fieldTrRemove\"></span>\n"
                        + "            </div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"fieldName\">\n"
                        + "            <div class=\"td-inner \"><input type=\"text\" class=\"form-control\"\n"
                        + "                                          placeholder=\"数据库字段名称\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \" data-field=\"name\">\n"
                        + "            <div class=\"td-inner \"><input type=\"text\" class=\"form-control\"\n"
                        + "                                          placeholder=\"代码字段名称\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"content\">\n"
                        + "            <div class=\"td-inner \"><input type=\"text\" class=\"form-control\"\n"
                        + "                                          placeholder=\"功能\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \" data-field=\"type\">\n"
                        + "            <div class=\"td-inner \"><select class=\"form-control\">\n"
                        + "                <option value=\"String\">String</option>\n"
                        + "            </select></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \" data-field=\"isKey\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isShowList\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isNull\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isShowAdd\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isShowEdit\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isShowDetail\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isImport\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isExport\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"isQuery\">\n"
                        + "            <div class=\"td-inner \"><input type=\"checkbox\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"queryMode\">\n"
                        + "            <div class=\"td-inner \"><select class=\"form-control\">\n"
                        + "                <option value=\"1\">=</option>\n"
                        + "                <option value=\"2\">!=</option>\n"
                        + "                <option value=\"3\">&gt;</option>\n"
                        + "                <option value=\"4\">&gt;=</option>\n"
                        + "                <option value=\"5\">&lt;</option>\n"
                        + "                <option value=\"6\">&lt;=</option>\n"
                        + "                <option value=\"7\">like</option>\n"
                        + "                <option value=\"8\">lift like</option>\n"
                        + "                <option value=\"9\">right like</option>\n"
                        + "                <option value=\"10\">between</option>\n"
                        + "            </select></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"showType\">\n"
                        + "            <div class=\"td-inner \"><select class=\"form-control\">\n"
                        + "                <option value=\"1\">文本</option>\n"
                        + "                <option value=\"2\">下拉</option>\n"
                        + "                <option value=\"3\">多行文本</option>\n"
                        + "                <option value=\"4\">单选</option>\n"
                        + "                <option value=\"5\">多选</option>\n"
                        + "                <option value=\"6\">日期</option>\n"
                        + "                <option value=\"7\">文件</option>\n"
                        + "            </select></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"orderNum\">\n"
                        + "            <div class=\"td-inner \"><input type=\"text\" class=\"form-control\"\n"
                        + "                                          placeholder=\"排序\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"dictName\">\n"
                        + "            <div class=\"td-inner \"><input type=\"text\" class=\"form-control\"\n"
                        + "                                          placeholder=\"字典名称\"></div>\n"
                        + "        </td>\n"
                        + "        <td style=\"text-align: center; vertical-align: middle; \"\n"
                        + "            data-field=\"dictType\">\n"
                        + "            <div class=\"td-inner \"><select class=\"form-control\">\n"
                        + "                <option value=\"1\">枚举</option>\n"
                        + "                <option value=\"2\">字典</option>\n"
                        + "                <option value=\"3\">显示列表</option>\n"
                        + "            </select></div>\n"
                        + "        </td>\n"
                        + "    </tr>";

TableField.trClink = function () {
}

TableField.fieldAdd = function () {
    var maxId = $(
        $("#tableField").find('tbody').find('tr')[$("#tableField").find('tbody').find('tr').length
                                                  - 1]).attr("id");
    if (maxId) {
        maxId = maxId.replace('fieldTr', '')
        maxId = parseInt(maxId) + 1;
    } else {
        maxId = 1;
    }
    $("#tableField").find('tbody')
        .append(TableField.trTemplate.replace("replaceId", 'fieldTr' + maxId));
}

TableField.fieldTrRemove = function () {
    $(this).parent().parent().parent().remove();
}

$(function () {
    $(document).on('click',".fieldTr",TableField.trClink);
    $(document).on('click',".fieldAdd",TableField.fieldAdd);
    $(document).on('click',".fieldTrRemove",TableField.fieldTrRemove);
});
