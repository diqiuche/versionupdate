package versionUpdate;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import net.tfedu.core.helper.ResultJSON;
import net.tfedu.core.helper.tests.BaseControllerTestCase;
import net.tfedu.core.utils.datatype.JsonUtil;
import net.tfedu.productUpdate.controller.ProductVersionController;

/**
 * 版本相关controller单元测试
 * @author WeiCuicui
 *
 */
public class VersionControllerTest extends BaseControllerTestCase{

	
	@Resource ProductVersionController productVersionController;
	
	/**
	 * 查询所有的版本信息
	 * @throws Exception
	 */
	@Test
	public void getAllVersions()throws Exception{
		String productCode = "HDKT";
		
        ResultJSON json = productVersionController.getAllVersions(request, productCode);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 版本检索
	 * @throws Exception
	 */
	@Test
	public void searchVersions()throws Exception{
		
		String productCode = "HDKT";
		
		String keyWord = "3";
		
        ResultJSON json = productVersionController.searchVersions(productCode, keyWord);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}

	/**
	 * 增加一个版本
	 * @throws Exception
	 *//*
	@Test
	public void addVersion()throws Exception{
		String productCode = "HDKT";
		String version = "{'code':'001','name':'version001','description':'first version'}";
        ResultJSON json = productVersionController.addVersion(request, productCode, version);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	
	*//**
	 * 查询一个版本的详细信息
	 * @throws Exception
	 *//*
	@Test
	public void getOneVersion()throws Exception{
		String productCode = "HDKT";
		String versionCode = "001";
		
		ResultJSON json = productVersionController.getOneVersion(productCode, versionCode);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	*//**
	 * 编辑一个版本信息
	 * @throws Exception
	 *//*
	@Test
	public void editOneVersion()throws Exception{
		String productCode = "HDKT";
		String version = "{'code':'001','name':'version001_update','description':'first version update'}";
        ResultJSON json = productVersionController.editVersions(request, productCode, version);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	*//**
	 * 删除一个版本
	 * @throws Exception
	 *//*
	@Test
	public void deleteOneVersion()throws Exception{
		String productCode = "HDKT";
		String versionCode = "001";
		ResultJSON json = productVersionController.deleteVersions(productCode, versionCode);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	*/

}
