/**
 * HttpClient
 * Created by young on 11/05/15.
 */
define(['jquery', 'app-storage','dialog'], function($, appStorage,dialog) {
    var HttpClient = function() {
        var self = this;
        this.getJSON = function(url, params, success, fail) {
            var paramsObj = (params == undefined)? {}:params;
            var reqUrl = self.genReqUrl(url, paramsObj);
            var deferred = $.ajax({
                headers: self.getHeaders(),
                url: reqUrl,
                cache:false,
                type: 'GET',
                dataType: 'JSON'
            });
            self.doCallback(deferred, success, fail);
        };
        this.upload = function (url, params) {
            var paramsObj = (params == undefined)? {}:params;
            var reqUrl = self.genReqUrl(url, paramsObj);
            var form = $("<form>");   //定义一个form表单
            form.attr('style', 'display:none');   //在form表单中添加查询参数
            form.attr('target', '');
            form.attr('method', 'get');
            form.attr('action', reqUrl);
            $('body').append(form);  //将表单放置在web中
            form.submit();
            return;


            var deferred = $.ajax({
                headers: self.getHeaders(),
                url: reqUrl,
                type: 'GET'
            });
        };
        this.postJSON = function(data, url, params, success, fail) {
            var paramsObj = (params == undefined)? {}:params;
            var reqUrl = self.genReqUrl(url, paramsObj);
            var deferred = $.ajax({
                headers: self.getHeaders(),
                url: reqUrl,
                type: 'POST',
                data: data,
                dataType: 'JSON'
            });
            self.doCallback(deferred, success, fail);
        }
        this.postFile = function(data, url, params, success, fail) {
            var paramsObj = (params == undefined)? {}:params;
            var reqUrl = self.genReqUrl(url, paramsObj);
            var settings = {
                "async": true,
                "crossDomain": true,
                "url": reqUrl,
                "method": "POST",
                "headers": self.getHeaders(),
                "processData": false,
                "contentType": false,
                "mimeType": "multipart/form-data",
                "data": data,
                "dataType": 'JSON'
            };
            var deferred = $.ajax(settings);
            self.doCallback(deferred, success, fail);
        }
        this.putJSON = function(data, url, params, success, fail) {
            var paramsObj = (params == undefined)? {}:params;
            var reqUrl = self.genReqUrl(url, paramsObj);
            var deferred = $.ajax({
                headers: self.getHeaders(),
                url: reqUrl,
                type: 'PUT',
                data: data,
                dataType: 'JSON'
            });
            self.doCallback(deferred, success, fail);
        }
        this.delete = function(url, params, success, fail) {
            var paramsObj = (params == undefined)? {}:params;
            var reqUrl = self.genReqUrl(url, paramsObj);
            var deferred = $.ajax({
                headers: self.getHeaders(),
                url: reqUrl,
                type: 'DELETE',
                dataType: 'JSON'
            });
            self.doCallback(deferred, success, fail);
        }
        this.getHeaders = function() {
            var headObject = new Object();
            var session = appStorage.getUserSession();
            if(session) {
                headObject['AID'] = session.aid;
                headObject['TOKEN'] = session.token;
            }
            return headObject;
        }
        this.genReqUrl = function(url, params) {
            var paramsObj = (params == undefined)? {}:params;
            return Opc.SERVER_NAME + '' + url + '?' + $.param(paramsObj);
            //return location.origin + '/api' + url + '?' + $.param(paramsObj);
        }
        this.doCallback = function(deferred, success, fail) {
            $.when(deferred)
                .done(function (data, textStatus, jqXHR) {
                    //未登录判断
                    var key = data.key;
                    if(key&&key==='-9910'){
                        dialog.alert('请先登录',function () {
                            window.location.href = '../login/index.html';
                        });
                        throw ('未登录');
                    }
                    if(key&&key==='-9920'){
                        dialog.alert('服务未找到');
                        return;
                    }
                    if(data != undefined) {
                        if(success && success.constructor == Function) success(data);
                    } else {
                        if(fail && fail.constructor == Function) fail('server_busy', '服务器繁忙,请稍后重试');
                    }
                })
                .fail(function (errResp) {
                    var errKey = 'server_busy';
                    var errMsg = '服务器繁忙,请稍后重试';
                    var ext = { };
                    if (errResp != undefined) {
                        var statusCode = errResp.status;
                        if(errResp.responseJSON != undefined) {
                            var respJSON = errResp.responseJSON;
                            if(respJSON.key != undefined && respJSON.key.constructor == String) {
                                errKey = respJSON.key;
                            }
                            if(respJSON.msg != undefined && respJSON.msg.constructor == String) {
                                errMsg = respJSON.msg;
                            }
                            ext = errResp.ext;
                        }
                        if(401 == statusCode) {
                            dialog.alert('请先登录',function () {
                                window.location.href = '../login';
                            });
                            throw ('未登录');
                        }
                        if(403 == statusCode) {
                            dialog.alert(errMsg);
                            return;
                        }
                    }
                    if(fail && fail.constructor == Function) {
                        fail(errKey, errMsg, ext);
                    }else{//无错误回调，默认弹出错误信息
                        dialog.alert(errMsg)
                    }
                });
        }
    }
    return new HttpClient();
});