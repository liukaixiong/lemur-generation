requirejs(['jquery','jquery-ui', 'navInit', 'knockout', 'http-client', 'app-storage', 'validate','datepicker', 'popup', 'dialog','pager'],
          function ($,ui,navInit, ko, httpclient, appStorage, validate,datepicker, popup, dialog, pager) {
              navInit.init();
              var TemplateInfoViewModel = function () {
                  var self = this;
                  this.templateList = ko.observableArray();
                  this.errMsg = ko.observable();// 错误提示
                  this.id = ko.observable();//Id
                  this.templateName = ko.observable();//模板名称
                  this.templatePath = ko.observable();//模板地址
                  this.templateDesc = ko.observable();//模板描述
                  this.fileName = ko.observable();//文件名称
                  this.userId = ko.observable();//UserId
                  this.templateType = ko.observable();//模板类型
                  this.crtUserId = ko.observable();//创建人
                  this.crtTime = ko.observable();//创建时间
                  this.mdfUserId = ko.observable();//修改人
                  this.mdfTime = ko.observable();//修改时间
                  // 属性列表
                  var fields = ["id","templateName","templatePath","templateDesc","fileName","userId","templateType","crtUserId","crtTime","mdfUserId","mdfTime"];
                  var requireFields = ["notNeed","templateName","templatePath","templateDesc","fileName","notNeed","templateType","notNeed","notNeed","notNeed","notNeed"];
                  var fieldName = ["ID","模板名称","模板地址","模板描述","文件名称","用户","模板类型","创建用户","创建时间","修改用户","修改时间"];

                  this.curtemplateInfo = ko.observable({});// 当前选中

                  // 查询
                  this.param = ko.observable({});// 查询参数
                  // 查询按钮
                  this.getData = function () {
                      var param = self.param();
                      param.templateName = self.templateName();
                      param.pageNum = pager.curPage();
                      param.pageSize = pager.curNumber()[0];
                      var url = '/template/list';
                      var success = function(data){
                          if(data.key != '0000'){
                              dialog.alert(data.msg);
                              return;
                          }
                          var ext = data.result;
                          self.templateList(ext.list);
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

                  this.addOrUpdatetemplateInfo = function(){
                      var isOk = true;
                      var param = self.curtemplateInfo();
                      $(requireFields).each(function(i,val){
                          if(val != 'notNeed'){
                              var v = self.curtemplateInfo()[fields[i]];
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
                      var url = '/templateInfo/addOrUpdate';
                      var success = function(data){
                          if(data.key!=='0000'){
                              self.errMsg(data.msg);
                              return;
                          }
                          if(self.curtemplateInfo().id){
                              dialog.alert('更新成功');
                          }else{
                              dialog.alert('添加成功');
                          }
                          pager.curPage(1);
                          self.getData();
                      };
                      httpclient.postJSON(param,url,null,success);
                  };


                  this.addtemplateInfo = function(data){
                      self.edittemplateInfo(new Object());
                  }

                  this.edittemplateInfo = function(data){
                      self.errMsg('');
                      self.curtemplateInfo(data);
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
                  this.deletetemplateInfo=function(data){
                      self.curtemplateInfo(data);
                      dialog.confirm('确定删除该数据库连接？',function(){
                          var curtemplateInfo = self.curtemplateInfo();
                          var url = '/templateInfo/delete';
                          var param = {
                              id : curtemplateInfo.id
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


              var templateInfoViewModel = new TemplateInfoViewModel();
              ko.applyBindings(templateInfoViewModel, document.getElementById('content_wrapper'));
              templateInfoViewModel.init();
          });