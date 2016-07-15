package net.tfedu.productUpdate.service;

import java.util.List;
import net.tfedu.productUpdate.entity.ProductVersion;
import net.tfedu.productUpdate.entity.ProductVersionEntity;

public interface ProductVersionService {

	/**
	 * 查询一个产品的所有版本
	 * @param productCode
	 * @return
	 */
	public List<ProductVersionEntity> getAllVersions(String productCode);
	
	/**
	 * 版本检索结果
	 * @param productCode
	 * @param keyWord
	 * @return
	 */
	public List<ProductVersionEntity> searchVersions(String productCode,String keyWord);
	
	/**
	 * 删除一个版本
	 * @param productCode
	 * @param versionCode
	 */
	public void deleteOneVersion(String productCode,String versionCode);
	
	/**
	 * 查询一个版本的信息
	 * @param productCode
	 * @param versionCode
	 * @return
	 */
	public ProductVersion getOneVersion(String productCode,String versionCode);
	
	/**
	 * 编辑一个版本
	 * @param productCode
	 * @param versionCode
	 * @param versionName
	 * @param description
	 */
	public void editOneVersion(String productCode,String version);
	
	/**
	 * 新建一个版本
	 * @param productCode
	 * @param versionCode
	 * @param versionId
	 * @param versionName
	 * @param description
	 */
	public String addOneVersion(String productCode,String version);
}
