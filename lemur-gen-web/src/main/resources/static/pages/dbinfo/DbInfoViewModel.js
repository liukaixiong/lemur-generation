requirejs(['jquery','jquery-ui', 'navInit', 'knockout', 'http-client', 'app-storage', 'validate','datepicker', 'popup', 'dialog','pager'],
    function ($,ui,navInit, ko, httpclient, appStorage, validate,datepicker, popup, dialog, pager) {
        navInit.init();
        var DbInfoViewModel = function () {
            var self = this;
			this.dbinfoList = ko.observableArray();
            this.errMsg = ko.observable();// 错误提示
            this.id = ko.observable();//Id
			this.dbDriver = ko.observable();//数据库驱动
			this.dbUrl = ko.observable();//数据库地址
			this.dbUserName = ko.observable();//数据库账户
			this.dbPassword = ko.observable();//连接密码
			this.userId = ko.observable();//UserId
			this.dbType = ko.observable();//数据库类型
			this.crtUserId = ko.observable();//创建人
			this.crtTime = ko.observable();//创建时间
			this.mdfUserId = ko.observable();//修改人
			this.mdfTime = ko.observable();//修改时间
			// 属性列表
            var fields = ["id","dbDriver","dbUrl","dbUserName","dbPassword","userId","dbType","crtUserId","crtTime","mdfUserId","mdfTime"];
            var requireFields = ["notNeed","dbDriver","dbUrl","dbUserName","dbPassword","notNeed","dbType","notNeed","notNeed","notNeed","notNeed"];
            var fieldName = ["ID","数据库驱动","数据库地址","数据库名称","数据库密码","用户","数据库类型","创建用户","创建时间","修改用户","修改时间"];
            
            this.curDbInfo = ko.observable({});// 当前选中
            
            // 查询
            this.param = ko.observable({});// 查询参数
            // 查询按钮
            this.getData = function () {
                var param = self.param();
                param.dbUserName = self.dbUserName();
                param.pageNum = pager.curPage();
                param.pageSize = pager.curNumber()[0];
                var url = '/dbinfo/list';
                var success = function(data){
                    if(data.key != '0000'){
                        dialog.alert(data.msg);
                        return;
                    }
                    var ext = data.result;
                    self.dbinfoList(ext.list);
                    pager.pages(ext.pages);
                    pager.total(ext.total);
                };
                // 模拟数据end
                httpclient.getJSON(url,param,success);
            };
            this.queryData=function(){
                pager.curPage(1);
                self.getData();
            };
            // 重置按钮
            this.resetData=function(){
            	$(fields).each(function(){
                 	self[this]('');
                 });
            };
            
            this.addOrUpdateDbInfo = function(){
            	var isOk = true;
            	var param = self.curDbInfo();
            	$(requireFields).each(function(i,val){
            		if(val != 'notNeed'){
            			var v = self.curDbInfo()[fields[i]];
                    	if(!v){
                            self.errMsg('*'+fieldName[i]);
                            isOk = false;
                            return isOk;
                        }
            		}
                });
            	if(!isOk){
            		return;
            	}
                self.errMsg('');
                var url = '/dbinfo/addOrUpdate';
                var success = function(data){
                    if(data.key!=='0000'){
                        self.errMsg(data.msg);
                        return;
                    }
                    if(self.curDbInfo().id){
                    	dialog.alert('更新成功');
                    }else{
                    	dialog.alert('添加成功');
                    }
                    pager.curPage(1);
                    self.getData();
                };
                httpclient.postJSON(param,url,null,success);
            };
            
            
            this.addDbInfo = function(data){
            	self.editDbInfo(new Object());
            }
            
            this.editDbInfo = function(data){
                self.errMsg('');
                self.curDbInfo(data);
                $.magnificPopup.open({
                    items: {
                        src: '#addOrUpdatePopup'
                    },
                    callbacks: {
                        beforeOpen: function (e) {
                            this.st.mainClass = 'mfp-zoomIn';
                        }
                    },
                    midClick: true
                });
            };
            // 删除操作
            this.deleteDbInfo=function(data){
                self.curDbInfo(data);
                dialog.confirm('确定删除该数据库连接？',function(){
                    var curDbInfo = self.curDbInfo();
                    var url = '/dbinfo/delete';
                    var param = {
                        id : curDbInfo.id
                    };
                    httpclient.getJSON(url,param, function (json) {
                        if(json.key!=='0000'){
                            dialog.alert(json.msg);
                            return;
                        }
                        dialog.alert('删除成功');
                        pager.curPage(1);
                        self.getData();
                    });
                });
            }
            // 弹窗关闭
            this.close = function(){
                $.magnificPopup.close();
            };
            // 页面初始化
            this.init=function(){
                self.getData();
            }
        }
        
        ko.components.register('footer', {
            viewModel: function(){return pager},
            template: { fromUrl: 'pages/common/footer.html' }
        });

        
        var dbinfoViewModel = new DbInfoViewModel();
        ko.applyBindings(dbinfoViewModel, document.getElementById('content_wrapper'));
        dbinfoViewModel.init();
    });