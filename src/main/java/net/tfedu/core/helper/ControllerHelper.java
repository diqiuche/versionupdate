package net.tfedu.core.helper;

import javax.servlet.http.HttpServletRequest;

import net.tfedu.core.exception.ParamsException;
import net.tfedu.core.utils.datatype.StringUtils;

/**
 * Controller助手类
 * 
 * @author bruce
 *
 */
public class ControllerHelper {
	
	 
	/**
	 * 检测空
	 * @param str
	 * @return
	 * @throws Exception
	 */
    public static String checkEmpty(String str) throws Exception{
    	if(StringUtils.isEmpty(str)){
    		throw new  ParamsException();
    	}
    	return str.trim();
    }

    /**
     * 获取单个参数值
     * 
     * @param request
     * @param paramName
     * @return 字符串
     * @throws ParamsException
     */
    public static String getParameter(HttpServletRequest request, String paramName) throws ParamsException {
        String param;
        if (StringUtils.isNotEmpty(request.getParameter(paramName))) {
            param = request.getParameter(paramName).toString().trim();
        } else {
            throw new ParamsException();
        }
        return param;
    }
    
    
    /**
     * 获取可选的参数
     * @param request
     * @param paramName
     * @return
     * @throws ParamsException
     */
    public static String getOptionalParameter(HttpServletRequest request, String paramName) throws ParamsException {
        String param = request.getParameter(paramName);
        return StringUtils.isNotEmpty(param)?param.toString().trim():"";
    }
    /**
     * 获取可选的int参数
     * @param request
     * @param paramName
     * @return
     * @throws ParamsException
     */
    public static int getOptionalIntegerParameter(HttpServletRequest request, String paramName) throws ParamsException {
        String param = request.getParameter(paramName);
        return StringUtils.isNotEmpty(param)?Integer.parseInt(param.toString().trim()):0;
    }
    /**
     * 获取可选的long参数
     * @param request
     * @param paramName
     * @return
     * @throws ParamsException
     */
    public static long getOptionalLongParameter(HttpServletRequest request, String paramName) throws ParamsException {
        String param = request.getParameter(paramName);
        return StringUtils.isNotEmpty(param)?Long.parseLong(param.toString().trim()):0;
    }
    
    /**
     * 获取单个参数值
     * 
     * @param request
     * @param paramName
     * @return 字符串
     * @throws ParamsException
     */
    public static String getHeaderParameter(HttpServletRequest request, String paramName) throws ParamsException {
        String param;
        if (StringUtils.isNotEmpty(request.getHeader(paramName))) {
            param = request.getHeader(paramName).toString().trim();
        } else {
            throw new ParamsException();
        }
        return param;
    }

    /**
     * 获取单个参数值
     * 
     * @param request
     * @param paramName
     * @return 整数
     * @throws ParamsException
     */
    public static int getIntParameter(HttpServletRequest request, String paramName) throws ParamsException {
        int param;
        if (StringUtils.isNotEmpty(request.getParameter(paramName))) {
            param = Integer.parseInt(request.getParameter(paramName).toString().trim());
        } else {
            throw new ParamsException();
        }
        return param;
    }

    /**
     * 获取单个参数值，如果获取失败，则赋值0
     * 
     * @param request
     * @param paramName
     * @return 整数
     * @throws ParamsException
     */
    public static int getIntWithDefault(HttpServletRequest request, String paramName) throws ParamsException {
        int param;
        if (StringUtils.isNotEmpty(request.getParameter(paramName))) {
            param = Integer.parseInt(request.getParameter(paramName).toString().trim());
        } else {
            param = 0;
        }
        return param;
    }

    /**
     * 获取单个参数值
     * 
     * @param request
     * @param paramName
     * @return 长整形
     * @throws ParamsException
     */
    public static long getLongParameter(HttpServletRequest request, String paramName) throws ParamsException {
        long param;
        if (StringUtils.isNotEmpty(request.getParameter(paramName))) {
            param = Long.parseLong(request.getParameter(paramName).toString().trim());
        } else {
            throw new ParamsException();
        }
        return param;
    }

    /**
     * 获取页码
     * 
     * @param request
     * @return
     * @throws ParamsException
     */
    public static int getPage(HttpServletRequest request) throws ParamsException {
        String strPageNum = request.getParameter("page");
        return StringUtils.isNotEmpty(strPageNum) ? Integer.parseInt(strPageNum) : 1;
    }

    /**
     * 获取页大小
     * 
     * @param request
     * @return
     * @throws ParamsException
     */
    public static int getPageSize(HttpServletRequest request) throws ParamsException {
        String strPageSize = request.getParameter("perPage");
        return StringUtils.isNotEmpty(strPageSize) ? Integer.parseInt(strPageSize) : 10;
    }
    
    
    /**
     * 不同的子系统，使用不同的model参数
     * @param request
     * @return
     */
    public static String getModel(HttpServletRequest request){
    	 return request.getParameter("model") == null ? " " : request
				.getParameter("model");
    }
    
    
}
