package been;

import java.util.Date;

public class Indexmusic implements java.io.Serializable{
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	private Integer	id;
	private Date crearTime;
	private Date updataTime;
	private String musicSrc;
	private Integer musicID;
	private Integer isDelete;
	public Integer getMusicID() {
		return musicID;
	}
	public void setMusicID(Integer musicID) {
		this.musicID = musicID;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCrearTime() {
		return crearTime;
	}
	public void setCrearTime(Date crearTime) {
		this.crearTime = crearTime;
	}
	public Date getUpdataTime() {
		return updataTime;
	}
	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}
	public String getMusicSrc() {
		return musicSrc;
	}
	public void setMusicSrc(String musicSrc) {
		this.musicSrc = musicSrc;
	}


}
