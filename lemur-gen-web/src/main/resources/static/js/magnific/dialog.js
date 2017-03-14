define(['jquery','knockout', 'popup'], function($, ko, popup) {
    var DialogPopup = function(){
        var self = this;
        this.isAlert = ko.observable(false);
        this.msgTitle = ko.observable('温馨提示');
        this.msg = ko.observable('');
        this.yesCallBack = function(){

        };
        this.noCallBack = function(){

        };
        this.showMsg = function(title,msg,yesCallBack){
            self.isAlert(true);
            self.msg(msg);
            if(title){
                self.msgTitle(title);
            };
            var callBack = function(){
                if(yesCallBack){
                    yesCallBack();
                }
                $.magnificPopup.close();
            };
            self.yesCallBack=callBack;
            showDialog(callBack);
        };
        this.alert = function(msg,yesCallBack){
            self.isAlert(true);
            self.msg(msg);
            var callBack = function(){
                if(yesCallBack){
                    yesCallBack();
                }
                $.magnificPopup.close();
            };
            self.yesCallBack=callBack;
            showDialog(callBack);
        };
        this.confirm = function(msg,yesCallBack,noCallBack){
            self.isAlert(false);
            self.msg(msg);
            self.yesCallBack = function(){
                if(yesCallBack){
                    yesCallBack();
                }
                $.magnificPopup.close();
            };
            self.noCallBack = function(){
                if(noCallBack){
                    noCallBack();
                }
                $.magnificPopup.close();
            };
            showDialog(noCallBack);
        };
        function showDialog(callBack){
            $.magnificPopup.open({
                items: {
                    src: '#dialogPopup'
                },
                callbacks: {
                    beforeOpen: function(e) {
                        this.st.mainClass = 'mfp-zoomIn';
                    },
                    afterClose: function(e) {
                        if(callBack){
                            callBack();
                        }
                    }
                },

                midClick: true
            });
        };
        this.init = function(){
            var dialogHtml = '<div id="dialogPopup"class="popup-basic mfp-with-anim mfp-hide">'+
                '<div class="panel">'+
                '<div class="panel-heading" style="color: #ffffff;background-color: #2384c6;border: none;border-radius: 0px;">'+
                '<span class="panel-title">'+
                '<i class="fa fa-rocket"></i>'+
                '<span data-bind="text:msgTitle"></span>'+
                '</span>'+
                '</div>'+
                '<div class="panel-body p25 admin-form">'+
                '<div class="col-md-12 mb5"data-bind="html:msg"></div>'+
                '</div>'+
                '<div class="panel-footer text-center">'+
                '<button class="btn btn-primary mr20"data-bind="click:yesCallBack">确定</button>'+
                '<button class="btn btn btn-dark"data-bind="click:noCallBack,css:{hide:isAlert}">关闭</button>'+
                '</div>'+
                '</div>'+
                '</div>';
            $('body').append(dialogHtml);
        };
    };
    var Dialog = function(){
        var dialogPopup = new DialogPopup();
        dialogPopup.init();
        this.alert = function(msg,yesCallBack){
            dialogPopup.alert(msg,yesCallBack);
        };
        this.confirm = function(msg,yesCallBack,noCallBack){
            dialogPopup.confirm(msg,yesCallBack,noCallBack);
        };
        this.showMsg = function (title,msg,yesCallBack) {
            dialogPopup.showMsg(title,msg,yesCallBack);
        };
        //时间格式化
        this.dateFormat = function (datetime, format) {
            var date = {
                "M+" : datetime.getMonth() + 1,
                "d+" : datetime.getDate(),
                "h+" : datetime.getHours(),
                "m+" : datetime.getMinutes(),
                "s+" : datetime.getSeconds(),
                "q+" : Math.floor((datetime.getMonth() + 3) / 3),
                "S" : datetime.getMilliseconds()
            };
            if (/(y+)/.test(format)) {
                format = format.replace(RegExp.$1, (datetime.getFullYear() + '').substr(4 - RegExp.$1.length));
            }
            for (var k in date) {
                if (new RegExp("(" + k + ")").test(format)) {
                    format = format.replace(RegExp.$1, (RegExp.$1.length === 1) ? (date[k]) : (('00' + date[k]).substr(('' + date[k]).length)));
                }
            }
            return format;
        };
        ko.applyBindings(dialogPopup,document.getElementById('dialogPopup'));
    };
    return new Dialog();
});