package utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Н№гу
 * @title: WebUtils
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/10/3016:32
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try{
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String stInt,int defaultValue){

        try {
            return Integer.parseInt(stInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
