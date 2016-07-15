package versionUpdate;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import net.tfedu.core.helper.ResultJSON;
import net.tfedu.core.helper.tests.BaseControllerTestCase;
import net.tfedu.core.utils.datatype.JsonUtil;
import net.tfedu.productUpdate.controller.FilesController;

/**
 * 升级文件相关controller单元测试
 * @author WeiCuicui
 *
 */
public class FileControllerTest extends BaseControllerTestCase{

	@Resource FilesController filesController;
	
	/**
	 * 获取版本下的所有文件
	 * @throws Exception
	 */
	@Test
	public void getAllFiles()throws Exception{
		String versionId = "HDKT300";
		ResultJSON json = filesController.getAllFiles(versionId);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 查找文件
	 * @throws Exception
	 */
	@Test
	public void searchFiles()throws Exception{
		String versionId = "HDKT300";
		String keyWord = "H";
		ResultJSON json = filesController.searchFiles(versionId, keyWord);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 查询所有的路径
	 * @throws Exception
	 */
	@Test
	public void getAllPaths()throws Exception{
		String versionId = "HDKT300";
		ResultJSON json = filesController.getAllPaths(versionId);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 删除一个文件
	 * @throws Exception
	 *//*
	@Test
	public void deleteOneFile()throws Exception{
		String versionId = "HDKT300";
		String fileName = "git常用命令.txt";
		ResultJSON json = filesController.deleteOneFile(versionId, fileName);
		
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
		
	}*/
	
	
}
