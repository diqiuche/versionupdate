package net.tfedu.productUpdate.service;

import java.util.List;
import net.tfedu.productUpdate.entity.VersionFilesEntity;

public interface VersionFilesService {

	/**
	 * 查询指定版本下的所有升级文件
	 * @param versionId
	 * @return
	 */
	public List<VersionFilesEntity> getAllFiles(String versionId);
	
	/**
	 * 根据版本关键字，查询该版本下的所有升级文件
	 * @param keyWord
	 * @return
	 */
	public List<VersionFilesEntity> searchFiles(String versionId,String keyWord);
	
	/**
	 * 新增升级文件
	 * @param fileInfo
	 */
	public void addOneFile(String versionId,String fileInfo,String host,String flag);

	
	/**
	 * 删除一个文件
	 * @param versionId
	 * @param fileName
	 */
	public void deleteOneFile(String versionId,String fileName);
	
	/**
	 * 查询所有的存储路径
	 * @return
	 */
	public List<String> getAllPaths(String versionId);
	
}
