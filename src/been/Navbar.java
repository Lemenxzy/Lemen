package been;

import java.util.Date;

public class Navbar implements java.io.Serializable{


	
	private static final long serialVersionUID = 1L;
	//id
	private Integer	id;
	//分类名
	private String	name;
	//是否删除0未删除，1删除
	private Integer	isDelete;
	//建立时间
	private Date creatTime;
	//分类英文名
	private String ename;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getShunxu() {
		return shunxu;
	}
	public void setShunxu(Integer shunxu) {
		this.shunxu = shunxu;
	}
	private Integer	shunxu;

	
	
}
