package net.tfedu.productUpdate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.core.helper.CoreMapper;
import net.tfedu.productUpdate.entity.VersionFiles;
import net.tfedu.productUpdate.entity.VersionFilesEntity;

public interface VersionFilesMapper extends CoreMapper<VersionFiles> {
	
	/**
	 * 根据产品code，版本code，产品类型，查询当前版本后的所有升级文件
	 * @param productCode
	 * @param versionCode
	 * @param productType
	 * @return
	 */
	public List<VersionFiles> allUpdatedFilesByCode(@Param("productCode")String productCode,@Param("versionCode")String versionCode,@Param("productType")int productType);
	
	/**
	 * 根据产品code，版本name，产品类型，查询当前版本后的所有升级文件
	 * @param productCode
	 * @param versionName
	 * @param productType
	 * @return
	 */
	public List<VersionFiles> allUpdatedFilesByName(@Param("productCode")String productCode,@Param("versionName")String versionName,@Param("productType")int productType);
	
	/**
	 * 查询指定版本下的文件
	 * @param versionId 版本id
	 * @return
	 */
	public List<VersionFilesEntity> getAllFiles(@Param("versionId")String versionId);
	
	/**
	 * 根据关键字查询文件信息
	 * @param versionId
	 * @param keyWord
	 * @return
	 */
	public List<VersionFilesEntity> searchFiles(@Param("versionId")String versionId,@Param("keyWord")String keyWord);

	
	/**
	 * 增加一个文件
	 * @param fileInfo
	 * @return
	 */
	public void addOneFile(@Param("versionId")String versionId,@Param("vFile")VersionFiles fileInfo);

	
	/**
	 * 删除文件
	 * @param versionId
	 * @param fileName
	 */
	public void deleteOneFile(@Param("versionId")String versionId,@Param("fileName")String fileName);
	
	/**
	 * 查询所有的路径
	 * @return
	 */
	public List<String> getAllPaths(@Param("versionId")String versionId);
	
	/**
	 * 查询该版本下、该路径下，是否存在同名文件
	 * @param versionId
	 * @param fileName
	 * @param location
	 * @return
	 */
	public VersionFiles getOneFile(@Param("versionId")String versionId,@Param("fileName")String fileName,@Param("location")String location);
}
