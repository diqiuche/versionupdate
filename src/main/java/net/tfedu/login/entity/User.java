package net.tfedu.login.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class User implements Serializable {
	
	private static final long serialVersionUID = 8160030266758656476L;
	  
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String pwd;

    @Column(name = "createDate")
    private Date createdate;

    public User(Long id, String username, String pwd, Date createdate) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.createdate = createdate;
    }

    public User() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * @return createDate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}