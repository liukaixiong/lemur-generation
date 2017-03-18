requirejs(['jquery','jquery-ui', 'navInit', 'knockout', 'http-client', 'app-storage', 'validate','datepicker', 'popup', 'dialog'],
    function ($,ui,navInit, ko, httpclient, appStorage, validate,datepicker, popup, dialog) {
        navInit.init();
        var ProductViewModel = function () {
            var self = this;
            //分页
            this.curPage = ko.observable(1);
            this.pages = ko.observable(0);
            this.total = ko.observable(0);
            this.lineNumber = [20,40, 60, 80];//显示行数
            this.curNumber = ko.observableArray([20]);//显示行数选择监听
            this.curNumber = ko.observableArray([1]);//显示行数选择监听
            this.turnNumber = ko.observable();//跳转页数
            /******************底部分页栏***********************/
                //每页显示的条数选项，发生改变时，重新请求数据
            this.computedNum =function(){
                $('#content-footer select[name="lineNumber"]').change(function(){
                    self.curPage(1);
                    self.getData();
                })
            }
            //上一页
            this.prePage = function(){
                var curPage = self.curPage();
                if(curPage<=1){
                    return;
                }
                self.curPage(curPage - 1);
                self.getData();
            };
            //下一页
            this.nextPage = function(){
                var curPage = self.curPage();
                var pages = self.pages();
                if(curPage>=pages){
                    return;
                }
                self.curPage(curPage + 1);
                self.getData();
            };
            //跳页操作
            this.turnTo = function(){
                var num = self.turnNumber();
                var total = self.total();
                if(num<=0||num>total){
                    dialog.alert('请输入正确的页码')
                }else {
                    self.curPage(num);
                    self.getData();
                }
            }
            /*****************底部分页栏end***********************/
            this.dataList = ko.observableArray();
            //查询参数
            this.productName = ko.observable();//产品名称
            this.param = ko.observable({});
            //获取数据
            this.getData = function(){
            };

            //查询
            this.queryData=function(){
            	var url = 'template/list';
            	 var success = function(json){
                     self.dataList(json.list);
                     self.pages(json.pages);
                     self.total(json.total);
                 };
            	httpclient.postJSON(url,param,success);
            }
            //重置
            this.resetData=function(){
                self.templateName('');
            }
            this.addClick = function(){
                self.openBox();
            }
            //查看详细操作
            this.viewDetails=function(){

            }
            //弹框显示
            this.openBox=function(){
                $.magnificPopup.open({
                    items: {
                        src: '#addPopup',
                        width : '800px'  
                    },
                    callbacks: {
                        beforeOpen: function (e) {
                            this.st.mainClass = 'mfp-zoomIn';
                        }
                    },
                    midClick: true
                });
            }
            //弹窗关闭
            this.close = function(){
                $.magnificPopup.close();
            };

            //初始化
            this.init=function(){
                self.getData();
            }
        }
        var productViewModel = new ProductViewModel();
        ko.applyBindings(productViewModel, document.getElementById('content_wrapper'));
        productViewModel.init();
    });