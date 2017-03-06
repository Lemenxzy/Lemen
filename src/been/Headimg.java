package been;

import java.util.Date;

public class Headimg implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer	Id;
	private String	url;
	private Date creatTime;
	private Date updataTime;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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

	
	
	
}
