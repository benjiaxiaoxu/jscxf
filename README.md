jscxf
=====
<h1>囧事服务</h1><br/>
<h3>主要依赖于cxf实现了根据参数返回或插入json等一系列的功能</h3>
    主要用于安卓ios客户端访问得到一些数据，数据库和openfire同步，仿照微博的方式给客户端提供信息服务支持
    
服务启动后
访问http://localhost:9000/js/jaxrs/
/**
	 * 根据用户名查询
	 * @param username
	 * @return
	 */
	
	@GET  
    @Path(value = "/{username}/search")  
	public JiongShiList findUserByName(@PathParam("username")String username);
	
	/**
	 * 通过get方式发布囧事
	 * @param text
	 * @param source
	 * @param username
	 * @param longitude
	 * @param latitude
	 */
	@GET  
    @Path(value = "/add")  
	public void addJiongShiget(@QueryParam("text")String text,@QueryParam("source")String source,
			@QueryParam("username")String username,@QueryParam("longitude")String longitude,@QueryParam("latitude")String latitude);
	
	/**
	 * 通过post方式发布囧事
	 * @param text
	 * @param source
	 * @param username
	 * @param longitude
	 * @param latitude
	 */
	@POST 
    @Path(value = "/add")  
	public void addJiongShipost(@QueryParam("text")String text,@QueryParam("source")String source,
			@QueryParam("username")String username,@QueryParam("longitude")String longitude,@QueryParam("latitude")String latitude);
	
	/**
	 * 得到所有的囧事
	 * @return
	 */
	@GET  
    @Path(value = "/search")  
	public JiongShiList findALLJiongShi();
	
	/**
	 * 得到最近的囧事
	 * @return
	 */
	@GET  
    @Path(value = "/searchByCount")  
	public JiongShiList findALLJiongShiByCount(@QueryParam("count")int count);
	
	/**
	 * 得到从start到stop的囧事
	 * @return
	 */
	@GET  
    @Path(value = "/searchByStartStop")  
	public JiongShiList findALLJiongShiByStartStop(@QueryParam("start")int start,@QueryParam("stop")int stop);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@GET  
    @Path(value = "/addRepostsCountG")  
	public void addRepostsCountGet(@QueryParam("id")int id,@QueryParam("username")String username);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@POST 
    @Path(value = "/addRepostsCountP")  
	public void addRepostsCountPost(@QueryParam("id")int id,@QueryParam("username")String username);
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@GET  
    @Path(value = "/addAttitudesCounG")  
	public void addAttitudesCountGet(@QueryParam("id")int id,@QueryParam("username")String username);
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	@POST 
    @Path(value = "/addAttitudesCounP")  
	public void addAttitudesCountPost(@QueryParam("id")int id,@QueryParam("username")String username);


@GET  
    @Path(value = "/searchbyNameId")  
	public List<Comments> findCommentByName(@QueryParam("name")String name,@QueryParam("jiongshiid")int jiongshiid);
	@GET  
    @Path(value = "/add")  
	public void inseartCommentget(@QueryParam("text")String text,@QueryParam("source")String source,@QueryParam("username")String username,@QueryParam("jiongshiid")int jiongshiid,@QueryParam("reply_comment")String reply_comment);
	
	@POST  
    @Path(value = "/add")  
	public void inseartCommentpost(@QueryParam("text")String text,@QueryParam("source")String source,@QueryParam("username")String username,@QueryParam("jiongshiid")int jiongshiid,@QueryParam("reply_comment")String reply_comment);

@QueryParam后跟的是所需要的参数
