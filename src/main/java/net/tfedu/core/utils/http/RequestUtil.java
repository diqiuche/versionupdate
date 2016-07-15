package net.tfedu.core.utils.http;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tfedu.core.utils.datatype.DateConverter;


/**
 * Convenience class for setting and retrieving cookies.
 */
public final class RequestUtil {

    protected static final Logger log = LoggerFactory.getLogger(RequestUtil.class);

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private RequestUtil() {
    }

    /**
     * 投票等复合对象处理时，手工组装entity
     * 
     * @param request
     * @param entity
     */
    public static <T> void getParameterMap(HttpServletRequest request, T entity) {
        Map<String, String[]> properties = request.getParameterMap();
        Class<?> entityClass = entity.getClass();
        Set<String> keySet = properties.keySet();
        Field[] fields = entityClass.getDeclaredFields();
        String value = null;
        // 免得出现Date解析错误
        DateConverter dateConverter = new DateConverter();// 实现一个日期转换类
        ConvertUtils.register(dateConverter, java.sql.Timestamp.class);// 注册一个时间戳
        ConvertUtils.register(dateConverter, java.util.Date.class);// 注册一个日期类
        for (Field field : fields) {
            String name = field.getName();
            if (keySet.contains(name)) {
                String[] mapValue = properties.get(name);
                if (null == mapValue) {
                    value = "";
                } else if (mapValue.length > 1) {
                    // 跳过数组，数组单独处理了。
                    continue;
                } else {
                    value = mapValue[0];
                }

                try {
                    // 参数类型与变量类型要一致，下面是错误的写法，反射将调用失败
                    // Character status;
                    // public void setStatus(char status) {
                    // this.status = status;
                    // }
                    BeanUtils.setProperty(entity, name, value);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.debug("copyProperty error: " + e.getMessage());
                }
            }
        }
    }
}
