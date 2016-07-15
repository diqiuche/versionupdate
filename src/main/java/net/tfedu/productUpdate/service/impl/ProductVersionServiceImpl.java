package net.tfedu.productUpdate.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import net.tfedu.core.utils.datatype.JsonUtil;
import net.tfedu.productUpdate.dao.ProductVersionMapper;
import net.tfedu.productUpdate.entity.ProductVersion;
import net.tfedu.productUpdate.entity.ProductVersionEntity;
import net.tfedu.productUpdate.service.ProductVersionService;


@Service("productVersionService")
public class ProductVersionServiceImpl implements ProductVersionService{

	@Resource ProductVersionMapper productVersionMapper;
	
	/**
	 * 查询一个产品的所有版本
	 * @param productCode
	 * @return
	 */
	@Override
	public List<ProductVersionEntity> getAllVersions(String productCode){
		return productVersionMapper.getAllVersions(productCode);
	}
	
	/**
	 * 版本检索结果
	 * @param productCode 产品编码
	 * @param keyWord  检索关键字
	 * @return
	 */
	@Override
	public List<ProductVersionEntity> searchVersions(String productCode,String keyWord){
		return productVersionMapper.searchVersions(productCode, keyWord);
	}
	
	/**
	 * 删除一个版本
	 * @param productCode
	 * @param versionCode
	 */
	@Override
	public void deleteOneVersion(String productCode,String versionCode){
		
		productVersionMapper.deleteOneVersion(productCode, versionCode);
	}
	
	/**
	 * 查询一个版本的信息
	 * @param productCode
	 * @param versionCode
	 * @return
	 */
	public ProductVersion getOneVersion(String productCode,String versionCode){
		return productVersionMapper.getOneVersion(productCode, versionCode);
	}
	
	/**
	 * 编辑一个版本
	 * @param productCode
	 * @param versionCode
	 * @param versionName
	 * @param description
	 */
	public void editOneVersion(String productCode,String version){
		
		ProductVersion pVersion = new ProductVersion();
		//将json字符串中的" 替换为 '
		version = version.replace('"', '\'');	
		pVersion = JsonUtil.getInstance().fromJson(version,ProductVersion.class);
		
		productVersionMapper.editOneVersion(productCode, pVersion);
	}
	
	/**
	 * 新建一个版本
	 * @param productCode
	 * @param versionCode
	 * @param versionId
	 * @param versionName
	 * @param description
	 */
	public String addOneVersion(String productCode,String version){
		
		ProductVersion pVersion = new ProductVersion();
		//将json字符串中的" 替换为 '
		version = version.replace('"', '\'');	
		pVersion = JsonUtil.getInstance().fromJson(version,ProductVersion.class);
		String versionId = productCode + pVersion.getCode();
		
		//判断是否已经存在相同的版本信息
		if(productVersionMapper.getOneVersion(productCode, pVersion.getCode()) != null){
			return "error";
		} else {
			productVersionMapper.addOneVersion(productCode, pVersion, versionId);
			return "success";
		}
	}
}
