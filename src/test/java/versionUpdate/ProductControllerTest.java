package versionUpdate;


import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.util.Assert;
import net.tfedu.core.helper.ResultJSON;
import net.tfedu.core.helper.tests.BaseControllerTestCase;
import net.tfedu.core.utils.datatype.JsonUtil;

import net.tfedu.productUpdate.controller.ProductController;
import net.tfedu.productUpdate.controller.ProductUpdateController;



public class ProductControllerTest extends BaseControllerTestCase{
	
	@Resource ProductUpdateController productUpdateController;
	
	@Resource ProductController productController;

	
	/**
	 * 根据versionname查找版本升级文件
	 * @throws Exception
	 */
	@Test
	public void testVersionByName()throws Exception{

		request.setParameter("productCode", "HDKT");
		
		request.setParameter("versionName", "2.0.0");
		
		request.setParameter("productType", "1");

		ResultJSON json = productUpdateController.selectVersionsByName(request, response);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 根据versioncode查找版本升级文件
	 * @throws Exception
	 */
	@Test
	public void testVersionByCode()throws Exception{

		request.setParameter("productCode", "HDKT");
		
		request.setParameter("versionCode", "200");
		
		request.setParameter("productType", "1");

		ResultJSON json = productUpdateController.selectVersionsByCode(request, response);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 查询所有的产品信息
	 * @return
	 */
	@Test
	public void getAllProductions()throws Exception{
		ResultJSON json = productController.getAllProducts();
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 产品检索
	 * @throws Exception
	 */
	@Test
	public void searchProductions()throws Exception{
		String keyWord = "H";
		ResultJSON json = productController.searchProducts(keyWord);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 查看一个产品的具体信息
	 * @throws Exception
	 */
	@Test
	public void getOneProduct()throws Exception{
		String productCode = "HDKT";
		ResultJSON json = productController.getOneProduct(productCode);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 增加新产品
	 * @throws Exception
	 *//*
	@Test
	public void insertProduction()throws Exception{
		String productCode = "HDKThaha";
		String productName = "HDKThahahahah";
		int productType = 1;
		ResultJSON json = productController.addProduct(productCode, productName, productType);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	*//**
	 * 编辑一个产品
	 * @throws Exception
	 *//*
	@Test
	public void editProduction()throws Exception{
		String productCode = "HDKThaha";
		String productName = "HDKThahah_update";
		ResultJSON json = productController.editProduct(productCode, productName);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	*//**
	 * 删除一个产品
	 * @throws Exception
	 *//*
	@Test
	public void deleteProduction()throws Exception{
		String productCode = "HDKThaha";
		ResultJSON json = productController.deleteProduct(productCode);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}*/
}
