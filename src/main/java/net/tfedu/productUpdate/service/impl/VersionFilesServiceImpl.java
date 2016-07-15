package net.tfedu.productUpdate.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import net.tfedu.core.utils.datatype.JsonUtil;
import net.tfedu.productUpdate.dao.VersionFilesMapper;
import net.tfedu.productUpdate.entity.VersionFiles;
import net.tfedu.productUpdate.entity.VersionFilesEntity;
import net.tfedu.productUpdate.service.VersionFilesService;

/**
 * 一个版本下升级文件的service
 * @author WeiCuicui
 *
 */
@Service("versionFilesService")
public class VersionFilesServiceImpl implements VersionFilesService{

	@Resource VersionFilesMapper versionFilesMapper;
	
	/**
	 * 查询指定版本下的所有升级文件
	 * @param versionId
	 * @return
	 */
	@Override
	public List<VersionFilesEntity> getAllFiles(String versionId){
		
		List<VersionFilesEntity> list = versionFilesMapper.getAllFiles(versionId);
		
		return list;
	}
	
	/**
	 * 根据关键字，查询特定文件
	 * @param versionId
	 * @param keyWord
	 * @return
	 */
	@Override
	public List<VersionFilesEntity> searchFiles(String versionId,String keyWord){
		List<VersionFilesEntity> list = versionFilesMapper.searchFiles(versionId,keyWord);
		
		return list;
	}
	
	/**
	 * 新增升级文件
	 * @param fileInfo
	 */
	@Override
	public void addOneFile(String versionId,String fileInfo,String host,String flag){
		VersionFiles file = new VersionFiles();
		//将json字符串中的双引号 替换为 单引号
		fileInfo = fileInfo.replace('"', '\'');	
		file = JsonUtil.getInstance().fromJson(fileInfo,VersionFiles.class);
		
		if(flag.equals("local")){
			//拼接出最终的文件路径
			file.setAddress(host + file.getAddress());
			//将相对路径中的  / 替换为 \
			String location = file.getLocation().replace('/', '\\');
			file.setLocation(location);
		} else {
			//将相对路径中的  / 替换为 \
			String location = file.getLocation().replace('/', '\\');
			file.setLocation(location);
		}
		//没有该路径时，插入；
		//若已存在相同路径，则不再插入
		if(versionFilesMapper.getOneFile(versionId, file.getFilename(), file.getLocation()) == null){
			versionFilesMapper.addOneFile(versionId,file);
		} 
		
	}

	
	/**
	 * 删除一个文件
	 * @param versionId
	 * @param fileName
	 */
	@Override
	public void deleteOneFile(String versionId,String fileName){
		versionFilesMapper.deleteOneFile(versionId, fileName);
	}
	
	
	/**
	 * 查询所有的存储路径
	 * @return
	 */
	public List<String> getAllPaths(String versionId){
		return versionFilesMapper.getAllPaths(versionId);
	}
}
