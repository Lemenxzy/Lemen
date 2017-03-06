package been;

import java.util.Date;

public class Content implements java.io.Serializable{
	/**
	 *文章javabeen
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	//id
	private Integer channelId;
	//所属分类ID
	private Date creaTime;
	//建立时间
	private Date updataTime;
	//更新时间
	private String content;
	//正文
	private String title;
	//音乐路劲
	private String music;
	//标题
	private String description;
	//简介
	private String img;
	//图片地址
	private String author;
	//作者
	private String keywords;
	//关键字
	private Integer hits;
	//点击数
	private Integer commentHits;
	//评论数
	private Integer loves;
	//点赞数
	private Integer isDelete;
	//0代表删除1代表未删除
	private Integer statuss;
	//1代表发布，0代表为发布
	private String channelName;
	
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Date getCreaTime() {
		return creaTime;
	}

	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}

	public Date getUpdataTime() {
		return updataTime;
	}

	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getCommentHits() {
		return commentHits;
	}

	public void setCommentHits(Integer commentHits) {
		this.commentHits = commentHits;
	}

	public Integer getLoves() {
		return loves;
	}

	public void setLoves(Integer loves) {
		this.loves = loves;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getStatuss() {
		return statuss;
	}

	public void setStatuss(Integer statuss) {
		this.statuss = statuss;
	}
	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}
	

}
