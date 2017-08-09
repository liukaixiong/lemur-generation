requirejs(['jquery','jquery-ui', 'navInit', 'knockout', 'http-client', 'app-storage', 'validate','datepicker', 'popup', 'dialog','pager','bootstrap'],
    function ($,ui,navInit, ko, httpclient, appStorage, validate,datepicker, popup, dialog, pager,bootstrap) {
        navInit.init();
        var DbInfoViewModel = function () {
            var self = this;
			this.databases = ko.observableArray();
			this.dbconnects = ko.observableArray();
			this.tables = ko.observableArray();
			this.templates = ko.observableArray();
            
            this.author = ko.observable();
            this.javapackage = ko.observable();
            this.jsppackage = ko.observable();
            this.className = ko.observable();
            this.name = ko.observable();
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
            	self.curInfo.tableName = null;
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
            			self.curInfo.templates.push(d.id);
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
            
            this.genCode=function(){
                self.curInfo.author = self.author();
                self.curInfo.javaPackage = self.javapackage();
                self.curInfo.jspPackage = self.jsppackage();
                self.curInfo.entityName = self.className();
                self.curInfo.name = self.name();
            	if(self.curInfo && self.curInfo.dbName && self.curInfo.tableName && self.curInfo.templates && self.curInfo.templates.length > 0){
            		window.location.href='/gen/genCode?'+$.param(self.curInfo);
            	}else{
            		 dialog.alert('缺少必要参数');
            	}
            }
           
            // 页面初始化
            this.init=function(){
                self.getData('/dbinfo/queryAll','dbconnects');
                self.param().pageSize = 20;
                self.getData('/template/list','templates');
                self.param().pageSize = 10;
            }
        }
        var genViewModel = new DbInfoViewModel();
        ko.applyBindings(genViewModel, document.getElementById('content_wrapper'));
        genViewModel.init();
    });