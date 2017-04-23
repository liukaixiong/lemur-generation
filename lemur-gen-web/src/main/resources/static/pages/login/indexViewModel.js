requirejs(['jquery','jquery-ui', 'knockout', 'http-client', 'app-storage', 'validate','popup', 'dialog'],
    function ($,ui, ko, httpclient, appStorage, validate,popup, dialog) {
        var LoginViewModel = function () {
            var self = this;
            this.params={};
            this.show=false;
            this.errData=ko.observable('');//验证提示信息
            this.phoneNumber=ko.observable('13112345678');
            this.password=ko.observable('123456');
            this.pswMemory=function(a,m){
                if(!self.show){
                    $(m.target).attr('src','../../images/login/checked.png');
                    self.show=true;
                    self.params.rememberMe='on';
                }
                else if(self.show){
                    $(m.target).attr('src','../../images/login/check.png');
                    self.show=false;
                }
            }

            this.showErr=ko.observable(false);

            //忘记密码
            this.forgetPsw=function(){
                window.location.href='forgetPsw.html';
            }

            this.login=function(){
                var url='/login';
                var phone=/^1(3|4|5|7|8)\d{9}$/;
                var phoneNumber=self.phoneNumber();
                var password=self.password();
                if(!phone.test(phoneNumber)){
                    self.errData('*请输入正确的手机号码！');
                    self.showErr(true);
                    return;
                }
                self.params.userName=phoneNumber;
                if(!password){
                    self.errData('*密码不能为空！');
                    self.showErr(true)
                    return;
                }
                self.showErr(false);
                self.params.password = password;
                location.href = '/pages/dbinfo/index.html';
               /* httpclient.postJSON(self.params,url,null,function(data){
                    var ext = data.ext;
                    ext = JSON.parse(ext);
                    appStorage.setUserInfo(ext);
                })*/
            }

            //初始化
            this.init=function(){

            }
        }
        var loginViewModel = new LoginViewModel();
        ko.applyBindings(loginViewModel, document.getElementById('login'));
        loginViewModel.init();
    }
)