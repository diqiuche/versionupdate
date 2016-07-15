package net.tfedu.productUpdate.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.core.helper.ResultJSON;
import net.tfedu.productUpdate.entity.ProductVersion;
import net.tfedu.productUpdate.entity.ProductVersionEntity;
import net.tfedu.productUpdate.service.ProductVersionService;

/**
 * 产品下的版本相关controller
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/update")
public class ProductVersionController {

	@Resource ProductVersionService versionService;
	
	/**
	 * 查询一个产品下的所有版本信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/versions", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllVersions(HttpServletRequest request,String productCode)throws Exception{
		
		List<ProductVersionEntity> list = versionService.getAllVersions(productCode);
		return ResultJSON.getSuccess(list);
	}
	
	/**
	 * 根据版本编码的关键字，查看相关版本
	 * @param productCode  产品编码
	 * @param keyWord  搜索关键字
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "v1.0/versionsSearch",method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON searchVersions(String productCode,String keyWord)throws Exception{
		
		List<ProductVersionEntity> list = versionService.searchVersions(productCode, keyWord);
		return ResultJSON.getSuccess(list);
	}
	
	/**
	 * 查看一个版本的具体信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/versionInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getOneVersion(String productCode,String versionCode)throws Exception{
		ProductVersion version = versionService.getOneVersion(productCode, versionCode);
		return ResultJSON.getSuccess(version);
	}
	

	/**
	 * 新增一个版本
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/versions", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON addVersion(HttpServletRequest request,String productCode,String version)throws Exception{
		String result = versionService.addOneVersion(productCode, version);
		return ResultJSON.getSuccess(result);
	}
	
	/**
	 * 编辑一个版本
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/versionsEdit", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON editVersions(HttpServletRequest request,String productCode,String version)throws Exception{
		versionService.editOneVersion(productCode, version);
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 删除一个版本
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/versionsDelete", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteVersions(String productCode,String versionCode)throws Exception{
		versionService.deleteOneVersion(productCode, versionCode);
		return ResultJSON.getSuccess(null);
	}
	
	
}
