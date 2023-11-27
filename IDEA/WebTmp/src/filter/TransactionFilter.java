package filter;

import utils.Jdbcutils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ����
 * @title: TransactionFilter
 * @projectName WebTmp
 * @description: ������service�����������
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

            //�ύ����
            Jdbcutils.commitAndClose();

        } catch (Exception e) {
            //�ع�����
            Jdbcutils.rollbackAndClose();
            e.printStackTrace();
            //���쳣�׸�tomcat
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
