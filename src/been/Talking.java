package been;

import java.util.Date;

public class Talking implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	//主键
	private Integer	id;
	//内容
	private String	content;
	//建立时间
	private Date creatTime;
	//更新时间
	private Date updataTime;
	//是否删除，0代表未删除1代表删除
	private Integer	isDelete;
	//谁评论的
	private Integer	userId;
	//评论谁
	private Integer contentID;
	
	private String username;
	private String header;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getContentID() {
		return contentID;
	}
	public void setContentID(Integer contentID) {
		this.contentID = contentID;
	}

}
