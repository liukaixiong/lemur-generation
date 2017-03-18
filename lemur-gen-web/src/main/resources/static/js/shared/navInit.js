define(['jquery','knockout','app-storage','http-client','dialog'], function($,ko,appStorage,httpclient,dialog) {
    var tmplHtml = '<header class="navbar navbar-fixed-top navbar-shadow" id="topHeader">'+
        '<div class="navbar-branding ">'+
        '<img src="../../images/common/LOGO.png" style="width: 60px;float:left;">'+
        '<span class="navbar-brand" style="padding-left: 0px;"><b>代码生成平台</b></span>'+
        '</div>'+
        '<div class="nav navbar-nav navbar-right" style="line-height: 60px;">'+
        '<span data-bind="text:userName"></span>'+
        '<a href="../pswModify/"  class="ml20">修改密码</a>'+
        '<a href="javascript:void(0)"  class="ml20" data-bind="click:loginOut">退出</a>'+
        '</div>'+
        '</header>'+
        '<aside id="sidebar_left" class="nano nano-light affix sidebar-default">'+
        '<div class="sidebar-left-content nano-content">'+
        '<ul class="nav sidebar-menu" data-bind="foreach:moduleArr" id="navUl">'+
        '<li data-bind="css:{active: $parent.setCurPageActive($data.id,$data.url)}">'+
        '<a href="javascript:void(0)" data-bind="css:{accordionToggle:menuList,menuOpen:$parent.setActive(menuList)},click:$parent.menuClick">'+
        '<span class="glyphicon" data-bind="attr:{class: $root.getClassName($data.className)}"></span>'+
        '<span class="sidebar-title" data-bind="text:module"></span>'+
        '<span data-bind="css:{caret: menuList.length}"></span>'+
        '</a>'+
        '<ul class="nav sub-nav" data-bind="foreach:menuList">'+
        '<li data-bind="css:{active: $root.setCurPageActive($data.id,$data.url)}">'+
        '<a href="javascript:void(0)" data-bind="click:$root.menuClick">'+
        '<span class="glyphicon" data-bind="attr:{class: $root.getClassName($data.className)}"></span>'+
        '<span data-bind="text:module"></span>'+
        '</a>'+
        '</li>'+
        '</ul>'+
        '</li>'+
        '</ul>'+
        '</div>'+
        '</aside>';
    var  footer= '<footer id="content-footer" class="affix">'+
        '<div class="row">'+
        '<div class="col-md-12">'+
        '<span class="footer-legal">© 2014-2016 <a href="http://www.miibeian.gov.cn" target="view_window">[沪ICP备15021088号]</a> 卡友支付服务有限公司版权所有</span>'+
        '</div>'+
        '</div>'+
        '</footer>';
    var NavViewModal = function (){
        var self = this;
        //this.moduleArr = appStorage.getUserMenu();
        this.moduleArr = [{
            "module" : "系统管理",
            "className" : "but6",
            "menuList" : [{
                "module" : "用户管理",
                "url" : "",
                "className" : "but10",
            }, {
                "module" : "数据库管理",
                "url" : "/dbinfo",
                "className" : "but9",
                "menuList" : []
            }, {
                "module" : "模板管理",
                "url" : "/template",
                "className" : "but8",
                "menuList" : []
            },{
                "module" : "系统日志",
                "url" : "/SysJournal",
                "className" : "but8",
                "menuList" : []
            }, {
                "module" : "密码修改",
                "url" : "/SysPassword",
                "className" : "but8",
                "menuList" : []
            }
            ]
        }
        ];
        this.curPage = ko.observable();
        this.setCurPage = function(){
            var pathname = location.pathname;
            pathname = pathname.replace('/static/pages/','../');
            var index = pathname.indexOf('/index.html')
            if(index!==-1){
                pathname = pathname.slice(0,index+1)
            }
            self.curPage(pathname);
        };
        this.getClassName = function(className){
            return 'glyphicon ' + className;
        };
        //当前页对应导航按钮
        this.setCurPageActive = function(id,url){
            var funcList = self.userFuncList();
            var curPage = self.curPage();
            if(!url||curPage.indexOf(url) == -1){
                return false;
            }
            if(id&&funcList.indexOf(id)===-1){//无权限
                alert('您没有权限使用当前功能。');
                location.href = '../common/';
                return;
            }
            return true;
        };
        //获取当前用户权限
        this.userFuncList = ko.observableArray();
        this.getUserFunc = function(){
            var userInfo = appStorage.getUserInfo();
            if(userInfo&&userInfo.funcList){
                self.userFuncList(userInfo.funcList.split(","));
            }
        };
        this.setActive = function(menuList){
            if(!menuList){
                return false;
            }
            var curPage = self.curPage();
            for(var i=0;i<menuList.length;i++){
                if(menuList[i].url&&curPage.indexOf(menuList[i].url) !== -1){
                    return true;
                }
            }
        };

        this.menuClick = function(menuData){
            if(menuData.menuList&&menuData.menuList.length){
                return false;
            }
            //var id = menuData.id;
            //var userFuncList = self.userFuncList();
            //if(id&&userFuncList.indexOf(id) === -1){
            //    alert('您没有权限使用当前功能。');
            //    return false;
            //}
            if(!menuData.url){
                return;
            }
            var url = '..' + menuData.url + '/';
            if(url&&url!=='#'){
                location.href = url+'index.html';
                return false;
            }
            return false;
        };
        this.init = function(){
            self.setCurPage();
            self.getUserFunc();
            $(document).on('click','.sidebar-menu li a.accordionToggle',function(e){
                //$('.sidebar-menu li a.accordion-toggle').on('click', function (e) {
                e.preventDefault();
                if ($('body').hasClass('sb-l-m') && !$(this).parents('ul.sub-nav').length) {
                    return;
                }
                if (!$(this).parents('ul.sub-nav').length) {
                    $('a.accordionToggle.menuOpen').next('ul').slideUp('fast', 'swing', function () {
                        $(this).attr('style', '').prev().removeClass('menuOpen');
                    });
                } else {
                    var activeMenu = $(this).next('ul.sub-nav');
                    var siblingMenu = $(this).parent().siblings('li').children('a.accordionToggle.menuOpen').next('ul.sub-nav')
                    activeMenu.slideUp('fast', 'swing', function () {
                        $(this).attr('style', '').prev().removeClass('menuOpen');
                    });
                    siblingMenu.slideUp('fast', 'swing', function () {
                        $(this).attr('style', '').prev().removeClass('menuOpen');
                    });
                }
                if (!$(this).hasClass('menuOpen')) {
                    $(this).next('ul').slideToggle('fast', 'swing', function () {
                        $(this).attr('style', '').prev().toggleClass('menuOpen');
                    });
                }
            });
            $('.dropdown-toggle').on('click', function () {
                $(this).next().show();
            });
        }
    };
    var UserViewModal = function (){
        var self = this;
        //操作员信息
        this.userName = ko.observable();
        this.curUserInfo = ko.observable();
        this.getUserInfo = function(){
        //    var userInfo = appStorage.getUserInfo();
        //    var userSession = appStorage.getUserSession();
        //    if(!userSession){
        //        dialog.alert('请先登录',function () {
        //            location.href = '../login';
        //        });
        //        throw ('未登录');
        //    }
        //    self.userName(userSession.account);
        };
        this.loginOut = function(){
            appStorage.removeUserSession();
            location.href = '../login';
            return;
            httpclient.delete('/api/session',{},function(data){
                appStorage.removeUserInfo();
                location.href = '../login';
            });
        };
        this.tabs=function(){
            $('.panel-heading li').click(function(){
                $(this).attr('class','loong').siblings().attr('class','');
                var num=$(this).children().attr('href');
                $('#'+num.substr(1)).attr('class','tab-pane active').siblings().attr('class','tab-pane');
            })
        }
        this.init = function(){
            self.getUserInfo();
            self.tabs();
        };
    };
    var navInit = function(){
        this.init = function(info){
            $('body').prepend(tmplHtml);
            var navViewModal = new NavViewModal();
            navViewModal.init();
            ko.applyBindings(navViewModal,document.getElementById('navUl'));
            //$('#content_wrapper').append(footer);
            $('body').removeClass('hide');
            var userViewModal = new UserViewModal();
            userViewModal.init();
            ko.applyBindings(userViewModal,document.getElementById('topHeader'));
            $('head').append('<link rel="shortcut icon" href="../../images/common/favicon.ico" type="image/x-icon" />');
      
      		// --------------使用组件化,模板开发项目
        	//第一步：重写loadTemplate方法
			var templateFromUrlLoader = {
			    loadTemplate: function(name, templateConfig, callback) {
			        if (templateConfig.fromUrl) {
			            var fullUrl = '/' + templateConfig.fromUrl
			            
			            //ajax动态获取外部的file内容
			            $.get(fullUrl, function(markupString) {
			                ko.components.defaultLoader.loadTemplate(name, markupString, callback);
			            });
			        } else {
			            callback(null);
			        }
			    }
			};
			
			//替换原来的defaultLoader，实现新的templateFromUrlLoader
			ko.components.loaders.unshift(templateFromUrlLoader);
        };
    };
    return new navInit();
});