/**
 * 参数校验模块
 */
;(function(){
    //解析JSON
    var parseJson = function(val){
        if(JSON && typeof JSON.parse == 'function'){
            return JSON.parse(val);
        }else{
            return eval('('+val+');');
        }
    };
    //定义属性访问器
    var dot = {};
    dot.set = function (obj, path, val) {
        var segs = path.split('.');
        var attr = segs.pop();

        for (var i = 0; i < segs.length; i++) {
            var seg = segs[i];
            obj[seg] = obj[seg] || {};
            obj = obj[seg];
        }

        obj[attr] = val;
    };
    dot.get = function (obj, path) {
        var segs = path.split('.');
        var attr = segs.pop();

        for (var i = 0; i < segs.length; i++) {
            var seg = segs[i];
            if (!obj[seg]) return;
            obj = obj[seg];
        }

        return obj[attr];
    };
    //判断目标的类型
    var typeOf =  function(val){
        switch (Object.prototype.toString.call(val)) {
            case '[object Function]': return 'function';
            case '[object Date]': return 'date';
            case '[object RegExp]': return 'regexp';
            case '[object Arguments]': return 'arguments';
            case '[object Array]': return 'array';
            case '[object String]': return 'string';
        }
        if (val === null) return 'null';
        if (val === undefined) return 'undefined';
        if (val && val.nodeType === 1) return 'element';
        if (val === Object(val)) return 'object';

        return typeof val;
    };

    //类型转换器
    var typecast = function (val, type) {
        var fn = typecast[type];
        if (typeof fn != 'function') throw new Error('cannot cast to ' + type);
        return fn(val);
    };

    //字符串转换象类型
    typecast.json = typecast.object = typecast.array = function (val) {
        if(typeof val === 'string'){
            try{
                return parseJson(val);
            }catch(e){
                return null;
            }
        }
        return null;
    };

    //转换为字符串
    typecast.string = function (val) {
        return val != null ? val.toString() : null;
    };

    //转换为数字
    typecast.number = function (val) {
        var num = parseFloat(val);
        return isNaN(num)
            ? null
            : num;
    };

    //转换为日期
    typecast.date = function (val) {
        var date = new Date(val);
        return isNaN(date.valueOf())
            ? null
            : date;
    };

    //转换为布尔值
    typecast.boolean = function (val) {
        return !!val && val.toString().toLowerCase() !== 'false';
    };

    /**
     * 描述一个对象的属性,包含若干个规则
     * @param name
     * @param schema
     * @constructor
     */
    function Property (name, schema) {
        this.fns = [];
        this.name = name;
        this.schema = schema;
        this._type = undefined;
        this._msg = '校验出错: ' + name;
    }

    function message(msg) {
        return this._msg = msg;
    }

    Property.prototype = {

        /**
         * 添加验证函数
         *
         * @param {Function} fn
         * @param {String} [msg]
         * @return {Property}
         * @api public
         */

        use: function (fn, msg) {
            this.fns.push([fn, msg]);
            return this;
        },

        /**
         * 配置 required 规则
         *
         * @param {Boolean} [bool]
         * @param {String} [msg]
         * @return {Property}
         * @api public
         */

        required: function (bool, msg) {
            if ('string' == typeof bool) msg = bool;
            return this.use(function (value) {
                return value != null && value != undefined && value != '';
            }, msg);
        },

        /**
         * 配置 type 规则
         *
         * @param {String} name
         * @param {String} [msg]
         * @return {Property}
         * @api public
         */

        type: function (name, msg) {
            this._type = name;
            return this.use(function (value) {
                return value == null || typeOf(value) == name;
            }, msg);
        },

        /**
         * 获得新的path对象
         *
         * @param {String} path
         * @param {Object} [rules]
         * @return {Path}
         * @api public
         */

        path: function (path, rules) {
            return this.schema.path(path, rules);
        },

        /**
         * 设置默认的消息
         *
         * @param {String} msg
         * @return {Property}
         * @api public
         */
        message:message,
        msg:message,

        /**
         * 根据属性设置的类型转换数据
         *
         * @param {Mixed} val
         * @return {Mixed}
         * @api public
         */
        typecast: function (val) {
            if(this._type != null){
                return typecast(val, this._type);
            }else{
                return val;
            }
        },

        /**
         * 校验给定的值
         *
         * @param {Mixed} value
         * @param {Object} [ctx]
         * @return {String|Boolean}
         * @api public
         */
        validate: function (value, ctx) {
            var fns = this.fns;

            for (var i = 0; i < fns.length; i++) {
                var fn = fns[i];
                var valid = fn[0].call(ctx, value);
                if (!valid) return fn[1] || this._msg;
            }

            return false;
        }
    };

    /**
     * 向属性定义新的规则
     * @param name
     * @param fn
     */
    Property.define = function(name,fn){
        if(typeof fn !== 'function'){
            throw new Error('fn must be function');
        }
        if(name == 'use'){
            throw new Error('name not be "use" ');
        }
        var orgFn = Property.prototype[name];
        if(orgFn == null){
            Property.prototype[name] = function(){
                var args = Array.prototype.slice.call(arguments,0);
                var retFn = fn.apply(this,args);
                if(typeof retFn !== 'function'){
                    throw new Error('fn return value must be function');
                }
                var msg = (args.length > 1 && typeof args[args.length-1] == 'string')
                    ? args[args.length-1] : null;
                this.use(retFn,msg);
            };
        }else{
            throw new Error('['+name+'] rule already exists ');
        }
    };


    /**
     * 描述一个规则对象,包含若干个属性
     * ,每个属性有若干个检验规则
     *
     * @param {Object} [obj]
     * @param {Object} [opts]
     * @api public
     */
    function Schema (obj, opts) {
        if (!(this instanceof Schema)) return new Schema(obj, opts);
        obj = obj || {};
        this.props = {};
        this.opts = opts || {};
        for (var key in obj) {
            if (!obj.hasOwnProperty(key)) continue;
            this.path(key, obj[key]);
        }
    }

    /**
     * 根据路径添加验证规则
     *
     * @param {String} path
     * @param {Object} [rules]
     * @return {Property}
     * @api public
     */

    Schema.prototype.path = function (path, rules) {
        var nested = false;
        var prop = this.props[path] || new Property(path, this);
        this.props[path] = prop;

        if (!rules) return prop;

        for (var key in rules) {
            if (!rules.hasOwnProperty(key)) continue;
            var rule = rules[key];
            if (!Array.isArray(rule)) rule = [rule];
            var ruleFn = prop[key];
            if(typeof ruleFn !== 'function'){
                throw new Error('['+key+'] rule is not a function , act is : '+ruleFn);
            }
            ruleFn.apply(prop, rule);
        }

        return prop;
    };

    /**
     * 根据配置的校验规则,数据转换给定的对象
     *
     * @param {Object} obj
     * @api public
     */
    Schema.prototype.typecast = function (obj) {
        for (var key in this.props) {
            var prop = this.props[key];
            var value = dot.get(obj, key);
            if (value == null) continue;
            dot.set(obj, key, prop.typecast(value));
        }
    };


    /**
     * 校验一个给定的对象
     *
     * @param {Object} obj
     * @param {Object} [opts]
     * @return {Array}
     * @api public
     */

    Schema.prototype.validate = function (obj, opts) {
        var errors = [];
        opts = opts || this.opts;

        if (opts.typecast) this.typecast(obj);

        for (var key in this.props) {
            var prop = this.props[key];
            var value = dot.get(obj, key);
            var err = prop.validate(value, obj);
            if (err) errors.push(err);
        }

        return errors;
    };

    /**
     * 定义 正则匹配
     * @param regexp
     * @returns {Property}
     */
    Property.define('match', function (regexp) {
        return function (value) {
            return value == null || regexp.test(value);
        }
    });

    /**
     * 定义 最大长度校验规则
     * @param maxLen
     * @returns {Property}
     */
    Property.define('maxLength',function (maxLen) {
        return function(value){
            return value == null || value.toString().length <= maxLen;
        };
    });
    /**
     * 定义 最小长度校验规则
     * @param minLen
     * @returns {Property}
     */
    Property.define('minLength',function (minLen) {
        return function(value){
            return value == null || value.toString().length >= minLen;
        };
    });

    /**
     * 定义 指定长度校验规则
     * @param equalLen
     * @returns {Property}
     */
    Property.define('equalLength',function (equalLen) {
        return function(value){
            return value == null || value.toString().length == equalLen;
        };
    });

    /**
     * 定义 最大值校验规则
     * @param maxLen
     * @param msg
     * @returns {Property}
     */
    Property.define('max',function (max) {
        return function(value){
            return value == null || value <= max;
        };
    });

    /**
     * 定义 最小值校验规则
     * @param maxLen
     * @param msg
     * @returns {Property}
     */
    Property.define('min',function (min) {
        return function(value){
            return value == null || value >= min;
        };
    });

    /**
     * 定义 在包含范围校验规则
     * @param maxLen
     * @param msg
     * @returns {Property}
     */
    Property.define('included',function(arr){
        return function(value){
            return value==null || arr.indexOf(value) !== -1;
        };
    });

    //暴露校验工厂
    var validateFactory = this.validateFactory = {};
    //暴露构造函数
    validateFactory.Property = Property;
    validateFactory.Schema=Schema;
    //定义新的规则
    validateFactory.define=function(name,fn){
        Property.define(name,fn);
    };
    //创建一个规则
    validateFactory.createValidate = function createValidate(rules,options){
        return new Schema(rules,options || { typecast: true });
    };
    //根据规则校验参数
    validateFactory.validate = function validate(rules,paramObj){
        return validateFactory.createValidate(rules).validate(paramObj);
    };

})();