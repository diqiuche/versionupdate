package net.tfedu.productUpdate.service;

import java.util.List;
import net.tfedu.productUpdate.entity.Production;

/**
 * 产品的service接口
 * @author WeiCuicui
 *
 */
public interface ProductionService {

	/**
	 * 查询所有的产品信息
	 * @return
	 */
	public List<Production> getAllProductions();
	
	/**
	 * 查询一个产品信息
	 * @param productCode
	 * @return
	 */
	public Production getOneProduction(String productCode);
	
	/**
	 * 新增一个产品
	 */
	public String addOneProduct(String productCode,String productName,int productType);


	/**
	 * 编辑一个产品
	 * @param productCode
	 * @param productName
	 */
	public void editOneProduct(String productCode,String productName);

	/**
	 * 删除一个产品
	 * @param productCode
	 */
	public void deleteOneProduct(String productCode);
	
	/**
	 * 根据关键字查询产品,匹配产品编码
	 * @param keyword
	 * @return
	 */
	public List<Production> searchProducts(String keyword);
}
