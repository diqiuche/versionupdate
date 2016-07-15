package net.tfedu.productUpdate.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import net.tfedu.productUpdate.dao.ProductionMapper;
import net.tfedu.productUpdate.entity.Production;
import net.tfedu.productUpdate.service.ProductionService;

/**
 * 产品serviceImpl
 * @author WeiCuicui
 *
 */
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Resource ProductionMapper mapper;
	
	/**
	 * 查询所有的产品信息
	 * @return
	 */
	@Override
	public List<Production> getAllProductions(){
		
		List<Production> list = mapper.getAllProducts();
		
		//将typeid转换为typename
		for(int i = 0,len = list.size(); i < len; ++i){
			Production item = list.get(i);
			int typeId = item.getProducttype();
			String typeName = Production.getProductType(typeId);
			item.setTypename(typeName);
		}
		return list;
	}
	
	/**
	 * 查询一个产品信息
	 * @param productCode
	 * @return
	 */
	public Production getOneProduction(String productCode){
		
		Production item = mapper.getOneProduct(productCode);
		int typeId = item.getProducttype();
		String typeName = Production.getProductType(typeId);
		item.setTypename(typeName);
		return item;
	}
	
	/**
	 * 新增一个产品
	 */
	public String addOneProduct(String productCode,String productName,int productType){
		
		//已经存在相同的产品了
		if(mapper.getOneProduct(productCode) != null){
			return "error";
		} else {
			
			mapper.addOneProduct(productCode, productName, productType);
			return "success";
		}
		
	}


	/**
	 * 编辑一个产品
	 * @param productCode
	 * @param productName
	 */
	public void editOneProduct(String productCode,String productName){
		mapper.editOneProduct(productCode, productName);
	}

	/**
	 * 删除一个产品
	 * @param productCode
	 */
	public void deleteOneProduct(String productCode){
		mapper.deleteOneProduct(productCode);
	}
	
	/**
	 * 根据关键字查询产品,匹配产品编码
	 * @param keyword
	 * @return
	 */
	public List<Production> searchProducts(String keyword){
		
		List<Production> list = mapper.searchProducts(keyword);
		//将typeid转换为typename
		for(int i = 0,len = list.size(); i < len; ++i){
			Production item = list.get(i);
			int typeId = item.getProducttype();
			String typeName = Production.getProductType(typeId);
			item.setTypename(typeName);
		}
		
		return list;
	}
}
