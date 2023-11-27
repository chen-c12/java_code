package com.chen.poject;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {

    @Test
    public void test1() throws Exception{
//        创建一个SaxReader输入流，去读取xml配置文件，生成document对象
        SAXReader saxReader = new SAXReader();
    try {
        Document document = saxReader.read("src/book.xml");

        System.out.println(document);
    }catch (Exception e){
        e.printStackTrace();
        }
    }

    /**
     * 读取books.xml文件生成Book类
     * */
    @Test
    public void test2() throws Exception{
//        1.读取Book.xml文件
        SAXReader reader = new SAXReader();
//        在Junit调试中，相对路径是从模块名开始算
        Document document = reader.read("src/book.xml");
//        2.通过Document对象获取根元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
//        3.通过根元素获取book标签对象
//        element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
//        4.遍历，处理每个book标签转换为Book类
        for (Element book:books){
//            asXML()把标签对象，转换为标签字符串
            Element nameElement = book.element("name");
            String nameText = nameElement.getText();
            String priceText = book.elementText("price");
            BigDecimal price = new BigDecimal(priceText);
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText, BigDecimal.valueOf(Double.parseDouble(priceText)),authorText));


        }
    }
}
