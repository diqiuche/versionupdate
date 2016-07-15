package net.tfedu.productUpdate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 产品信息类
 * @author WeiCuicui
 *
 */
public class Production implements Serializable{
	
	private static final long serialVersionUID = 8160030266758656476L;
	  
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productcode;

    private String productname;

    /**
     * ProductType：1：pc   2：android     3：ios
     */
    private Integer producttype;
    
    /**
     * 创建时间
     */
    private String createtime;
    
    /**
     * 产品类型名
     */
    private String typename;
    
    public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Production(String productcode, String productname, Integer producttype, String createtime,String typename) {
        this.productcode = productcode;
        this.productname = productname;
        this.producttype = producttype;
        this.createtime = createtime;
        this.typename = typename;
    }

    public Production() {
        super();
    }

    /**
     * @return productcode
     */
    public String getProductcode() {
        return productcode;
    }

    /**
     * @param productcode
     */
    public void setProductcode(String productcode) {
        this.productcode = productcode == null ? null : productcode.trim();
    }

    /**
     * @return productname
     */
    public String getProductname() {
        return productname;
    }

    /**
     * @param productname
     */
    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    /**
     * 获取ProductType：1：pc   2：android     3：ios
     *
     * @return producttype - ProductType：1：pc   2：android     3：ios
     */
    public Integer getProducttype() {
        return producttype;
    }

    /**
     * 设置ProductType：1：pc   2：android     3：ios
     *
     * @param producttype ProductType：1：pc   2：android     3：ios
     */
    public void setProducttype(Integer producttype) {
        this.producttype = producttype;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
    
    /**
     * 根据产品类型号，返回产品具体类型
     * @param type
     * @return
     */
    public static String getProductType(int type){
    	if(type == 1)
    		return "pc";
    	else if(type == 2)
    		return "android";
    	else if(type == 3)
    		return "ios";
    	else {
			return "error type";
		}
    }
}