package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ����
 * @title: MyServletContextLstenerImpl
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/2511:42
 */
public class MyServletContextLstenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext���󱻴�����");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext����������");
    }
}
