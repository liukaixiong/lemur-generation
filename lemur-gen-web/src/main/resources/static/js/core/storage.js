define(['jquery'], function($) {
    var Storage = function() {
        var self = this;

        this.setRememberAccount = function(account) {
            if (!window.localStorage) return;
            if(!account || account.constructor != String || '' == account.trim()) return;
            window.localStorage.removeItem(StorageKey.REMEMBER_ACCOUNT);
            window.localStorage.setItem(StorageKey.REMEMBER_ACCOUNT, account);
        }

        this.getRememberAccount = function() {
            if (!window.localStorage) return null;
            return window.localStorage.getItem(StorageKey.REMEMBER_ACCOUNT);
        }

        this.setUserSession = function(session) {
            if (!window.localStorage) return;
            if(!session || session.constructor != Object) return;
            if(!session.aid || !session.token) return;
            window.localStorage.removeItem(StorageKey.USER_SESSION);
            window.localStorage.setItem(StorageKey.USER_SESSION, JSON.stringify(session));
        }
        this.getUserSession = function() {
            if (!window.localStorage) return null;
            var session = window.localStorage.getItem(StorageKey.USER_SESSION);
            if(!session) return null;
            return JSON.parse(session);
        }
        this.removeUserSession = function(){
            window.localStorage.removeItem(StorageKey.USER_SESSION);
        }
        this.setUserInfo = function(info) {
            if (!window.localStorage) return;
            if (!info || info.constructor != Object) return;
            if (!info.id || !info.operatorId || !info.operatorName
                || !info.name || !info.shortName || !info.state) return;
            window.localStorage.removeItem(StorageKey.USER_INFO);
            window.localStorage.setItem(StorageKey.USER_INFO, JSON.stringify(info));
        }

        this.getUserInfo = function() {
            if (!window.localStorage) return null;
            var info = window.localStorage.getItem(StorageKey.USER_INFO);
            if (!info) return null;
            return JSON.parse(info);
        }

        this.removeUserInfo = function(){
            window.localStorage.removeItem(StorageKey.USER_INFO);
        }

        this.removeRememberAccount = function () {
            window.localStorage.removeItem(StorageKey.REMEMBER_ACCOUNT);
        }

        this.setOID = function(operatorId) {
            if (!window.localStorage) return;
            if(!operatorId || operatorId.constructor != String || '' == operatorId.trim()) return;
            window.localStorage.removeItem(StorageKey.OID);
            window.localStorage.setItem(StorageKey.OID, JSON.stringify(operatorId));
        }

        this.getOID = function() {
            if (!window.localStorage) return null;
            var session = window.localStorage.getItem(StorageKey.OID);
            if(!session) return null;
            return JSON.parse(session);
        }

        this.removeOID = function () {
            window.localStorage.removeItem(StorageKey.OID);
        }

        this.setUserMenu = function(info) {
            if (!window.localStorage) return;
            if (!info || info.constructor != Array) return;
            window.localStorage.removeItem(StorageKey.USER_MENU);
            window.localStorage.setItem(StorageKey.USER_MENU, JSON.stringify(info));
        }

        this.getUserMenu = function() {
            if (!window.localStorage) return null;
            var info = window.localStorage.getItem(StorageKey.USER_MENU);
            if (!info) return null;
            return JSON.parse(info);
        }

        this.removeUserMenu = function(){
            window.localStorage.removeItem(StorageKey.USER_MENU);
        }

    }
    return new Storage();
});