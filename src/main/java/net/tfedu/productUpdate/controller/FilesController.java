package net.tfedu.productUpdate.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.tfedu.core.config.CommonWebConfig;
import net.tfedu.core.helper.FileUtil;
import net.tfedu.core.helper.ResultJSON;
import net.tfedu.productUpdate.entity.VersionFiles;
import net.tfedu.productUpdate.entity.VersionFilesEntity;
import net.tfedu.productUpdate.service.VersionFilesService;

/**
 * 升级文件信息
 * @author WeiCuicui
 */
@Controller
@RequestMapping("/update")
public class FilesController {

	@Resource VersionFilesService versionFilesService;
	
	@Resource
	CommonWebConfig config;
	
	//写入日志
    Logger logger = LoggerFactory.getLogger(FilesController.class);
	
	
	/**
	 * 查询一个版本下的所有升级文件
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/files", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllFiles(String versionId)throws Exception{

		List<VersionFilesEntity> list = versionFilesService.getAllFiles(versionId);
		return ResultJSON.getSuccess(list);
	}
	
    /**
     * 根据关键字检索文件
     * @param keyWord
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/v1.0/filesSearch", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON searchFiles(String versionId,String keyWord)throws Exception{
	
		List<VersionFilesEntity> list = versionFilesService.searchFiles(versionId,keyWord);
		return ResultJSON.getSuccess(list);
	}

	
	/**
	 * 在版本下增加升级文件信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/files", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON addOneFile(String versionId,String fileInfo,String flag)throws Exception{
		//获取当前上下文路径
		String host = config.getHost();
		versionFilesService.addOneFile(versionId,fileInfo,host,flag);
		return ResultJSON.getSuccess(null);
	}

	
	/**
	 * 删除文件
	 * @param versionId 版本id
	 * @param fileName  文件名（唯一的）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/filesDelete", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteOneFile(String versionId,String fileName)throws Exception{
		versionFilesService.deleteOneFile(versionId, fileName);
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 查询所有的路径
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/allPaths", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllPaths(String versionId)throws Exception{
		List<String> list = versionFilesService.getAllPaths(versionId);
		return ResultJSON.getSuccess(list);
	}
	
	
	/**
	 * 多文件上传，接收文件
	 * @param pic 文件
	 * @param req
	 * @param response
	 * @param savePath 文件存储路径
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/v1.0/uploadFile",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String uploadFile(@RequestParam("pic")CommonsMultipartFile pic,HttpServletRequest req,HttpServletResponse response,String savePath) throws IOException{  
		
		//将路径中的 \ 替换为 /
		savePath = savePath.replace('\\', '/');
		
		if(savePath.charAt(savePath.length() - 1) != '/'){
			savePath = savePath + "/";
		}
		
		//设置文件保存的本地路径  
		String filePath = req.getSession().getServletContext().getRealPath(savePath);  
		
		//文件名
		String fileName = pic.getOriginalFilename();  
		 
		logger.debug("文件存储路径： " + savePath + "； 文件名： " + fileName);
		  
		/*String fileType = fileName.split("[.]")[1];   
		//为了避免文件名重复，在文件名前加UUID  
		String uuid = UUID.randomUUID().toString().replace("-","");  
		String uuidFileName = uuid + fileName;  
		File f = new File(filePath+"/"+uuid+"."+fileType);*/  
		  
		//将文件保存到服务器  
		FileUtil.upFile(pic.getInputStream(), fileName, filePath);  
		return savePath;  
	}  
}
