package net.tfedu.productUpdate.entity;

import java.io.Serializable;

/**
 * 版本文件信息类
 * @author WeiCuicui
 *
 */
public class VersionFiles implements Serializable{
	
	private static final long serialVersionUID = 8160030266758656476L;
  
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * 升级文件名称
     */
    private String filename;

    /**
     * 升级服务器地址
     */
    private String address;

    /**
     * 相对路径
     */
    private String location;

    /**
     * filetype：1：程序2：数据3：脚本
     */
    private Integer filetype;

    /**
     * 文件大小
     */
    private Long filesize;

    /**
     * 是否需要注册
     */
    private Integer isreg;

    /**
     * 是否压缩文件
     */
    private Integer deccompressfile;


    public VersionFiles(String filename, String address, String location, Integer filetype, Long filesize, Integer isreg, Integer deccompressfile) {
        
        this.filename = filename;
        this.address = address;
        this.location = location;
        this.filetype = filetype;
        this.filesize = filesize;
        this.isreg = isreg;
        this.deccompressfile = deccompressfile;
       
    }

    public VersionFiles() {
        super();
    }


    /**
     * 获取升级文件名称
     *
     * @return filename - 升级文件名称
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置升级文件名称
     *
     * @param filename 升级文件名称
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * 获取升级服务器地址
     *
     * @return address - 升级服务器地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置升级服务器地址
     *
     * @param address 升级服务器地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取相对路径
     *
     * @return location - 相对路径
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置相对路径
     *
     * @param location 相对路径
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取filetype：1：程序2：数据3：脚本
     *
     * @return filetype - filetype：1：程序2：数据3：脚本
     */
    public Integer getFiletype() {
        return filetype;
    }

    /**
     * 设置filetype：1：程序2：数据3：脚本
     *
     * @param filetype filetype：1：程序2：数据3：脚本
     */
    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    /**
     * 获取文件大小
     *
     * @return filesize - 文件大小
     */
    public Long getFilesize() {
        return filesize;
    }

    /**
     * 设置文件大小
     *
     * @param filesize 文件大小
     */
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    /**
     * 获取是否需要注册
     *
     * @return isreg - 是否需要注册
     */
    public Integer getIsreg() {
        return isreg;
    }

    /**
     * 设置是否需要注册
     *
     * @param isreg 是否需要注册
     */
    public void setIsreg(Integer isreg) {
        this.isreg = isreg;
    }

    /**
     * 获取是否压缩文件
     *
     * @return deccompressfile - 是否压缩文件
     */
    public Integer getDeccompressfile() {
        return deccompressfile;
    }

    /**
     * 设置是否压缩文件
     *
     * @param deccompressfile 是否压缩文件
     */
    public void setDeccompressfile(Integer deccompressfile) {
        this.deccompressfile = deccompressfile;
    }
}