package been;

import java.util.Date;

public class UserBeen implements java.io.Serializable {

	/**
	 * lemenJAVAben
	 * @since 1.0.0
	 */	
	private static final long serialVersionUID = 1L;
	//ID
	private Integer id;
	//账号
	private String username;
	//密码
	private String password;
	//建立时间
	private Date creatTime;
	//更新时间
	private Date updataTime;
	//邮箱
	private String email;
	//删除0代表未删除，1删除
	private Integer isDelete;
	//用户ID
	private Integer userId;
	
	private String userhead;

	public String getUserhead() {
		return userhead;
	}

	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdataTime() {
		return updataTime;
	}

	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
