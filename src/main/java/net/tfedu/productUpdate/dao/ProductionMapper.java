package net.tfedu.productUpdate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.core.helper.CoreMapper;
import net.tfedu.productUpdate.entity.Production;

public interface ProductionMapper extends CoreMapper<Production> {
	/**
	 * 查询所有的产品
	 * @return
	 */
	public List<Production> getAllProducts();
	
	/**
	 * 根据产品编码，查询一个产品
	 * @param productCode
	 * @return
	 */
	public Production getOneProduct(@Param("productCode")String productCode);
	
	/**
	 * 新增一个产品
	 * @param productCode
	 * @return
	 */
	public void addOneProduct(@Param("productCode")String productCode,@Param("productName")String productName,@Param("productType")int productType);


	/**
	 * 编辑一个产品
	 * @param productCode
	 * @param productName
	 */
	public void editOneProduct(@Param("productCode")String productCode,@Param("productName")String productName);

	/**
	 * 删除一个产品
	 * @param productCode
	 */
	public void deleteOneProduct(@Param("productCode")String productCode);
	
	/**
	 * 根据关键字查询产品
	 * @param keyword
	 * @return
	 */
	public List<Production> searchProducts(@Param("keyword")String keyword);
}