requirejs(['jquery','jquery-ui', 'navInit', 'knockout', 'http-client', 'app-storage', 'validate','datepicker', 'popup', 'dialog','pager','bootstrap'],
    function ($,ui,navInit, ko, httpclient, appStorage, validate,datepicker, popup, dialog, pager,bootstrap) {
        navInit.init();
        var DbInfoViewModel = function () {
            var self = this;
			this.databases = ko.observableArray();
			this.dbconnects = ko.observableArray().extend({ deferred: true });
			this.tables = ko.observableArray();
			this.templates = ko.observableArray();
            
            this.curInfo = ko.observable({});// 当前选中
            
            // 查询
            this.param = ko.observable({});// 查询参数
            // 查询按钮
            this.getData = function (url,p) {
                var param = self.param();
                var success = function(data){
                    if(data.key != '0000'){
                        dialog.alert(data.msg);
                        return;
                    }
                    var ext = data.result;
                    self[p](ext.list);
                };
                // 模拟数据end
                httpclient.postJSON(param,url,success);
            };
            this.queryData=function(){
                self.getData();
            };
            
            this.getDataBases=function(data){
            	self.param(data);
            	self.selectChange(data,'id','dbconnects');
            	self.curInfo = data;
            	self.databases([]);
            	self.tables([]);
            	self.getData('/gen/queryDatabses','databases');
            }
            
            this.getTables=function(data){
            	self.curInfo.dbName = data.name;
            	self.selectChange(data,'name','databases');
            	self.param(self.curInfo);
            	self.tables([]);
            	self.getData('/gen/queryTables','tables');
            }
            
            this.selectTables=function(data){
            	self.curInfo.tableName = data.tableName;
            	self.selectChange(data,'tableName','tables');
            }
            this.selectTemplates=function(data){
            	self.curInfo.templates = [];
            	
            	$(self.templates()).each(function(i,d){
            		if(d.id == data.id){
            			d.isSelected = !data.isSelected;
            		}
            		if(d.isSelected){
            			self.curInfo.templates.push(data.id);
            		}
            	});
            	var temp = $.extend(true, [], self.templates());
            	self.templates(temp);
            }
            
            this.selectChange=function(data,paramsName,arrName){
            	$(self[arrName]()).each(function(i,d){
            		d.isSelected = (d[paramsName] == data[paramsName]);
            	});
            	var temp = $.extend(true, [], self[arrName]());
            	self[arrName](temp);
            }
           
            // 页面初始化
            this.init=function(){
                self.getData('/dbinfo/queryAll','dbconnects');
                self.getData('/template/list','templates');
            }
        }
        var genViewModel = new DbInfoViewModel();
        ko.applyBindings(genViewModel, document.getElementById('content_wrapper'));
        genViewModel.init();
    });