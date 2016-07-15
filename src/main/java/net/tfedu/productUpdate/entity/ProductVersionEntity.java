package net.tfedu.productUpdate.entity;

import java.io.Serializable;

public class ProductVersionEntity implements Serializable{

	private static final long serialVersionUID = 8160030266758656476L;
	  
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    private String productcode;

    private String code;

    private String name;

    private String description;
    
    private String versionid;
    
    private String createtime;

    
    

	public ProductVersionEntity(String productcode,String versioncode, String versionname, String description,String versionid,String createtime) {
      
        this.code = versioncode;
        this.name = versionname;
        this.description = description;
        this.productcode = productcode;
        this.versionid = versionid;
        this.createtime = createtime;
    }

    public ProductVersionEntity() {
        super();
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    
    public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getVersionid() {
		return versionid;
	}

	public void setVersionid(String versionid) {
		this.versionid = versionid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
