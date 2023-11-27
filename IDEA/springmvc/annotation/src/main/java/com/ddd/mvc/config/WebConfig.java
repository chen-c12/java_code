package com.ddd.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * @author ����
 * @title: WebConfig
 * @projectName chen
 * @description: TODO
 * @date 2022/1/2014:21
 */

/**
 * ����springmvc�������ļ���
 * 1.ɨ�����   2.��ͼ������    3.view-controller    4.default-servlet-handler
 * 5.mvcע������    6.�ļ��ϴ�������   7.�쳣����  8.������
 */

//����ǰ���ʶΪһ��������
@Configuration

//ɨ�����
@ComponentScan("com.ddd.mvc.controller")

//����mvcע������
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer {

    //ʹ��Ĭ�ϵ�servlet����̬��Դ
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //�����ļ��ϴ�������
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    //����������

//    public void addInterceptors(InterceptorRegistry registry) {
//        FirstInterceptor firstInterceptor = new FirstInterceptor();
//        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
//    }

    //������ͼ����

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }*/

    //�����쳣ӳ��
    /*@Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        //�����쳣ӳ��
        exceptionResolver.setExceptionMappings(prop);
        //���ù����쳣��Ϣ�ļ�
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }*/

    //��������ģ�������

    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver��Ҫһ��ServletContext��Ϊ�����������ͨ��WebApplicationContext �ķ������
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //����ģ�����沢Ϊģ������ע��ģ�������
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //������ͼ��������δ������ע��ģ������
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

}
