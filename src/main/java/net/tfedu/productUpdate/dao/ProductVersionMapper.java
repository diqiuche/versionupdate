package net.tfedu.productUpdate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.core.helper.CoreMapper;
import net.tfedu.productUpdate.entity.ProductVersion;
import net.tfedu.productUpdate.entity.ProductVersionEntity;

public interface ProductVersionMapper extends CoreMapper<ProductVersion>{
	
	/**
	 * 根据产品code，版本code，产品类型，查询最新版本信息
	 * @param productCode  产品code
	 * @param versionCode  版本code
	 * @param productType  产品类型
	 * @return
	 */
	public ProductVersion latestVersionInfoByCode(@Param("productCode")String productCode,@Param("versionCode")String versionCode,@Param("productType")int productType);
	
	/**
	 * 根据产品编码，版本名称，产品类型，查询最新版本信息
	 * @param productName  产品名称
	 * @param versionCode  版本code
	 * @param productType  产品类型
	 * @return
	 */
	public ProductVersion latestVersionInfoByName(@Param("productCode")String productCode,@Param("versionName")String versionName,@Param("productType")int productType);


	/**
	 * 查询一个产品的所有版本
	 * @param productCode
	 * @return
	 */
	public List<ProductVersionEntity> getAllVersions(@Param("productCode")String productCode);
	
	/**
	 * 版本检索结果
	 * @param productCode
	 * @param keyWord
	 * @return
	 */
	public List<ProductVersionEntity> searchVersions(@Param("productCode")String productCode,@Param("keyWord")String keyWord);
	
	/**
	 * 根据版本code，删除一个版本
	 * @param productCode
	 * @param versionCode
	 */
	public void deleteOneVersion(@Param("productCode")String productCode,@Param("versionCode")String versionCode);
	
	/**
	 * 查询一个版本的详细信息
	 * @param productCode
	 * @param versionCode
	 * @return
	 */
	public ProductVersion getOneVersion(@Param("productCode")String productCode,@Param("versionCode")String versionCode);
	
	/**
	 * 编辑一个版本信息
	 */
	public void editOneVersion(@Param("productCode")String productCode,@Param("pVersion")ProductVersion pVersion);
	
	
	/**
	 * 增加一个版本信息
	 */
	public void addOneVersion(@Param("productCode")String productCode,@Param("pVersion")ProductVersion pVersion,@Param("versionId")String versionId);
	
}