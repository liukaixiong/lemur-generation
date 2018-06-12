INSERT INTO t_system_menu(code, pcode, pcodes, name, icon, url, num, levels, ismenu, tips, status, isopen)
VALUES ('tablebasefield_list', 'EASYCODE', '[0],[easycode],', '基础字段管理', '', '/tablebasefield', 6, 2, 1, NULL, 1, NULL);
INSERT INTO t_system_menu(code, pcode, pcodes, name, icon, url, num, levels, ismenu, tips, status, isopen)
VALUES ('tablebasefield_add', 'tablebasefield_list', '[0],[EASYCODE],[tablebasefield_list],', '新增', '', '/tablebasefield/add', 1, 3, 0, NULL, 1, NULL);
INSERT INTO t_system_menu(code, pcode, pcodes, name, icon, url, num, levels, ismenu, tips, status, isopen)
VALUES ('tablebasefield_update', 'tablebasefield_list', '[0],[EASYCODE],[tablebasefield_list],', '编辑', '', '/tablebasefield/update', 2, 3, 0, NULL, 1, NULL);
INSERT INTO t_system_menu(code, pcode, pcodes, name, icon, url, num, levels, ismenu, tips, status, isopen)
VALUES ('tablebasefield_detail', 'tablebasefield_list', '[0],[EASYCODE],[tablebasefield_list],', '详情', '', '/tablebasefield/update', 2, 3, 0, NULL, 1, NULL);
INSERT INTO t_system_menu(code, pcode, pcodes, name, icon, url, num, levels, ismenu, tips, status, isopen)
VALUES ('tablebasefield_delete', 'tablebasefield_list', '[0],[EASYCODE],[tablebasefield_list],', '删除', '', '/tablebasefield/delete', 3, 3, 0, NULL, 1, NULL);
