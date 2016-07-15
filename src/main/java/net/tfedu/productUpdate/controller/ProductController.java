package net.tfedu.productUpdate.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.core.helper.ResultJSON;
import net.tfedu.productUpdate.entity.Production;
import net.tfedu.productUpdate.service.ProductionService;

/**
 * 产品controller
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/update")
public class ProductController {
	
	@Resource ProductionService productionService;
	
	/**
	 * 查询所有产品信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/product", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllProducts()throws Exception{
		
		List<Production> list = productionService.getAllProductions();
		return ResultJSON.getSuccess(list);
	}

	/**
	 * 新增一个产品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/product", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON addProduct(String productCode,String productName,int productType)throws Exception{
		String result = productionService.addOneProduct(productCode, productName, productType);
		return ResultJSON.getSuccess(result);
	}
	
	/**
	 * 编辑一个产品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/productEdit", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON editProduct(String productCode,String productName)throws Exception{
		productionService.editOneProduct(productCode, productName);
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 删除一个产品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/productDelete", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteProduct(String productCode)throws Exception{
		productionService.deleteOneProduct(productCode);
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 查询一个产品的具体信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/productInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getOneProduct(String productCode)throws Exception{
		Production production = productionService.getOneProduction(productCode);
		return ResultJSON.getSuccess(production);
	}
	
	/**
	 * 根据关键字，查询产品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/productSearch", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON searchProducts(String keyWord)throws Exception{
		
		List<Production> list = productionService.searchProducts(keyWord);
		return ResultJSON.getSuccess(list);
	}

}
