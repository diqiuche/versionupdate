package net.tfedu.productUpdate.entity;

import java.io.Serializable;

/**
 * 产品、版本关联的类文件
 * @author WeiCuicui
 *
 */
public class ProductVersion implements Serializable{
	
	private static final long serialVersionUID = 8160030266758656476L;
	  
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

    private String code;

    
	private String name;

    private String description;

    public ProductVersion(String versioncode, String versionname, String description) {
      
        this.code = versioncode;
        this.name = versionname;
        this.description = description;
    }

    public ProductVersion() {
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
}