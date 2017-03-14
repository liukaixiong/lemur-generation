var Opc = {
    SERVER_NAME: ''
}

var StorageKey = {
    USER_SESSION: 'USER_SESSION',
    USER_INFO: 'USER_INFO',
    REMEMBER_ACCOUNT: 'REMEMBER_ACCOUNT',
    OID: 'OID',
    USER_MENU: 'USER_MENU'
}

requirejs.config({
    baseUrl: Opc.SERVER_NAME + '/js/',
    paths: {
        'knockout': 'shared/knockout-3.4.0',
        'jquery': 'shared/jquery-1.11.1.min',
        'validate': 'shared/validate',
        'navInit':'shared/navInit',
        'http-client': 'core/http-client',
        'app-storage': 'core/storage',
        'jquery-ui' : 'date/jquery-ui.min',
        'datepicker' : 'date/jquery-ui-datepicker.min',
        'datech':'date/jquery.ui.datepicker-zh-CN',
        'compute':'shared/compute',
        'popup':'magnific/jquery.magnific-popup',
        'dialog':'magnific/dialog',

        'highCharts':'chart/highCharts',
        'highChart':'chart/highChart',
        'main':'chart/main',
        'c3':'chart/c3.min',
        'd3':'chart/d3',
        'minD3':'chart/d3.min'

    },
    shim: {
        'scripts': ['jquery']
    }
});