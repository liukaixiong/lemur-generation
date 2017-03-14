requirejs(['jquery', 'jquery-ui', 'navInit', 'knockout', 'http-client', 'app-storage', 'validate', 'popup', 'dialog'],
    function ($, ui, navInit, ko, httpclient, appStorage, validate, popup, dialog) {
        navInit.init();
        var ModifyViewModel = function () {
            var self = this;
            //登录密码修改参数
            this.logincrrPsw = ko.observable();
            this.loginnewPsw = ko.observable();
            this.loginsurePsw = ko.observable();
            this.errMsg = ko.observable();

            this.showBox = ko.observable(true);

            this.loginPsw = function (a,m) {
                $(m.target).css({
                    'borderBottom': '2px solid #5cbffa',
                    'color': '#5cbffa'
                }).siblings().css({'borderBottom': 'none', 'color': '#000'});
                self.showBox(true);
            };
            this.updatePsw = function(){
                var logincrrPsw = self.logincrrPsw();
                if(!logincrrPsw){
                    self.errMsg('*请先输入旧密码');
                    return;
                }
                var loginnewPsw = self.loginnewPsw();
                if(!loginnewPsw){
                    self.errMsg('*请先输入新密码');
                    return;
                }
                var loginsurePsw = self.loginsurePsw();
                if(!loginsurePsw){
                    self.errMsg('*请先输入确认密码');
                    return;
                }
                if(loginsurePsw!==loginnewPsw){
                    self.errMsg('*两次输入的密码不一致');
                    return;
                }
                var url = '/aut/login/modifyPwd';
                var param = {
                    originalPwd:logincrrPsw,
                    newPwd:loginsurePsw
                };
                httpclient.postJSON(param,url,null,function(data){
                    dialog.alert('密码修改成功');
                });

            }
            //初始化
            this.init = function () {

            }
        }
        var modifyViewModel = new ModifyViewModel();
        ko.applyBindings(modifyViewModel, document.getElementById('content_wrapper'));
        modifyViewModel.init();
    });