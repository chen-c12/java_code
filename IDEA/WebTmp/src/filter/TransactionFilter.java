package filter;

import utils.Jdbcutils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 金鱼
 * @title: TransactionFilter
 * @projectName WebTmp
 * @description: 对所有service进行事物管理
 * @date 2021/11/1715:36
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);

            //提交事务
            Jdbcutils.commitAndClose();

        } catch (Exception e) {
            //回滚事务
            Jdbcutils.rollbackAndClose();
            e.printStackTrace();
            //把异常抛给tomcat
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
