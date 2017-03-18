package cn.afterturn.gen.repository.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
/**
 * 处理用户和时间的拦截器
 * 修改绑定修改用户和时间
 * @author JueYue
 * 2017年3月15日
 */
@Intercepts(@Signature(type = Executor.class, method = "insert", args = { MappedStatement.class,
                                                                          Object.class,
                                                                          RowBounds.class,
                                                                          ResultHandler.class }))
public class UpdateInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        
        return null;
    }

    @Override
    public Object plugin(Object target) {
        
        return null;
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
