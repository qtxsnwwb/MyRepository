<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="com.application.login.action.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user = (User) session.getAttribute("user");
	if(user == null){
		response.sendRedirect("login.jsp");
	}
	session.setAttribute("userName", user.getUserName());
	request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- ===== Site Title===== -->
	<title>首页</title>
	
	<!-- ===== Google Fonts ===== -->
	
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,400italic|Raleway:500,600,700">
	
	<!-- ===== Favicon Icon ===== -->
	<link rel="icon" href="images/favicon.ico">
	
	<!-- ===== Bootstrap ===== -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	<!-- ===== Font Icons ===== -->
	<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
	
	<!-- ===== Corousel and Lightbox ===== -->
	<link rel="stylesheet" href="css/owl.theme.css">
	<link rel="stylesheet" href="css/owl.carousel.css">
	<link rel="stylesheet" href="css/nivo-lightbox.css">
	<link rel="stylesheet" href="css/themes/default/default.css">
	
	<!-- ===== Colors ===== -->
	<link rel="stylesheet" href="css/colors/color.css"> 
	
	
	<!-- ===== Preloader ===== -->
	<link rel="stylesheet" href="css/preloader.css">
	
	<!-- ===== style.css ===== -->
	<link rel="stylesheet" href="css/style3.css">
	
	<!-- ===== Responsive CSS ===== -->
	<link rel="stylesheet" href="css/responsive.css">
	
	<!--[===== if lt IE 9]>
				<script src="js/html5shiv.js"></script>
				<script src="js/respond.min.js"></script>
	<![endif]===== -->
     
</head>

<body>
<!-- ===== preloader ===== -->
<!-- é¢å è½½é¡µé¢ -->
<div class="preloaders">
  <div class="preloaders-gif">&nbsp;</div>
</div>


<!-- ===== Header ===== -->
<header id="home">

<!-- ===== Over color Image ===== -->
<div class="background-overlay1">
	
	<div class="container-header">
		
		<!-- ===== Sticky Navigation ===== -->
		<!-- è¿éæ¯logo -->
		<div class="navbar navbar-inverse bs-docs-nav navbar-fixed-top sticky-navigation bgc-two">
			<div class="container">
				<div class="logodiv">			
					<img src="images/images/logo.png" class="logo">
					
				</div>
				
				<!-- ===== Navigation Menu ===== -->
				<div class="navbar-collapse collapse" id="onepage-navigation">
					<ul class="nav navbar-nav navbar-right main-navigation">
						<li><a href="#home">首页</a></li>
						<li><a href="#section-about">关于我们</a></li>
						<li><a href="#section-pricing">人才需求</a></li>
						<li><a href="#section-portfolio">加入我们</a></li>
						<li><a href="#section-contact">联系我们</a></li>
						<li><a href="appInfo.jsp" style="color:#FF44AA;">招聘信息</a></li>
						<li><a href="declare.jsp" style="color:#FF44AA;">投递简历</a></li>
						<li><a href="">
							${sessionScope.userName}
						</a></li>
						<li><a href="logout.jsp">注销</a></li>
					</ul>
				</div>
				
			</div>
			
		</div>
		
		<!-- ===== End Sticky Navigation ===== -->
		
	</div>
	
	<!-- ===== Welcome ===== -->
	<div class="containerhome">
		
		<div class="row">
			
			<div class="col-md-10 col-md-offset-1 distance-header">
				
				
				<img src="images/images/first.png" class="imgfirst">
				
			</div>

		</div>
		
	</div>
	<!-- ===== End Welcome ===== -->
	
</div>

</header>


<!-- ===== Section About ===== -->
<section class="section-about bgc-one" id="section-about">
<div class="container">
    
	<img src="images/images/title1.png"> 
	
	<div class="row">
		<div class="col-md-6">
			<!-- ===== Images ===== -->
			<div class="side-images pull-left">
				<img src="images/images/pic0.png" alt="Feature" class="img-responsive">
			</div>
		</div>
		<div class="col-md-6">
			
			<div class="about text-left">
				
				<!-- ===== Features List ===== -->
				<ul class="feature-list">
					
					<li>
					<!-- ===== Icons ===== -->
					<div class="icon-custom pull-left">
						<i class="fa fa-laptop"></i>
					</div>
					<!-- ===== Detailt Post===== -->
					<div class="details pull-left">
						<h6>公司背景</h6>
						<p>
							苹果公司(Apple Inc.)是美国的一家高科技公司，2007年由苹果电脑公司(Apple Computer, Inc.)更名而来，核心业务为电子科技产品，总部位于加利福尼亚州的库比蒂诺。苹果公司由史蒂夫·乔布斯、斯蒂夫·沃兹尼亚克和Ron Wayne在1976年4月1日创立，在高科技企业中以创新而闻名，知名的产品有Apple II、Macintosh电脑、Macbook笔记本电脑、iPod音乐播放器、iTunes商店、iMac一体机、iPhone手机和iPad平板电脑等。它在高科技企业中以创新而闻名。
						</p>
					</div>
					</li>
					
					<li>
					<!-- ===== Icons ===== -->
					<div class="icon-custom pull-left">
						<i class="fa fa-cog"></i>
					</div>
					<!-- ===== Details Post ===== -->
					<div class="details pull-left">
						<h6>文化理念</h6>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eveniet error cum, aut beatae officiis doloribus vel odit a quia veritatis illum ad minima vitae unde, mollitia sapiente placeat id fuga苹果崇尚“精英主义”和“精简主义”。“精英主义”是苹果的人才文化。一群想“改变世界”的精英聚集在苹果旗下，组成一流的A团队。苹果所招募的人都是顶级大腕，这才使得苹果产品“有范儿”。“精简主义”可以导致“精专主义”，聚焦在少量产品或一个产品的少数指标上，并由“精细”达到“精湛”，最后做到极致便是“精美”。苹果的战略思路，很符合吉姆· 柯林斯的三环模式或刺猬理论：做自己最擅长的、最有激情的、能赚钱的。
						</p>
					</div>
					</li>
					
					<li>
					<!-- ===== Icons ===== -->
					<div class="icon-custom pull-left">
						<i class="fa fa-photo"></i>
					</div>
					<!-- ===== Detail Post ===== -->
					<div class="details pull-left">
						<h6>发展过程</h6>
						<p>
						    苹果公司创立之初，主要开发和销售的个人电脑，截至2014年致力于设计、开发和销售消费电子、计算机软件、在线服务和个人计算机。苹果的Apple II于1970年代助长了个人电脑革命，其后的Macintosh接力于1980年代持续发展。该公司硬件产品主要是Mac电脑系列、iPod媒体播放器、iPhone智能手机和iPad平板电脑；在线服务包括iCloud、iTunes Store和App Store；消费软件包括OS X和iOS操作系统、iTunes多媒体浏览器、Safari网络浏览器，还有iLife和iWork创意和生产力套件。苹果公司在高科技企业中以创新而闻名世界。
						</p>
					</div>
					</li>
				</ul>
			</div>
		</div>
		
	</div>
	
</div> 

</section>

<!-- ===== Section Pricing ===== -->
<section id="section-pricing" class="section-pricing bgc-two">
<div class="container">
	
	<img src="images/images/title2.png"> 
	
	<div class="pricing-table">
		
		<!-- ===== Pricing Table ===== -->
		<div class="row">
			
			<!-- ===== Pricing one ===== -->
			<div class="col-md-4">
				<div class="package background-color-white">
					<div class="header-dark">
						<h3>人力资源经理</h3>
						<div class="sub-sub">
							$10000 / Year
						</div> 
					</div>
					
					<!-- ===== Package Details ===== -->
					<div class="package-features">
						<ul>
							<li>
							    本科以上学历
							</li>
							<li>
							   两年以上工作经验
							</li>
							<li>
							    年终奖
							</li>
							<li>
							    五险一金
							</li>
							<li>
							    国内旅游
							</li>
							<li>
							    岗位培训
							</li>
						</ul>
						<div class="bottom-row">
							<div class="column-button">
								<div id="call_to_action-1">
									<a href="#" class="btn secondary-button">SIGN UP</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> <!-- ===== End Pricing One ===== -->
			
			<!-- ===== Pricing Two ===== -->
			<div class="col-md-4">
				<div class="package-center background-color-white">
					<div class="header">
						<h3>产品经理</h3>
						<div class="sub-sub">
							$16000 / Year
						</div>
					</div>
					
					<!-- ===== Package Details ===== -->
					<div class="package-features">
						<ul>
							<li>
							   本科以上学历
							</li>
							<li>
							    两年以上工作经验
							</li>
							<li>
							    年终奖
							</li>
							<li>
							   项目奖金
							</li>
							<li>
							    五险一金
							</li>
							<li>
							   国内旅游
							</li>
						</ul>
						<div class="bottom-row">
							<div class="column-3p">
								<div id="call_to_action-2">
									<a href="#" class="btn standard-button">SIGN UP</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> <!-- ===== End Pricing Two ===== -->
			
			<!-- ===== Pricing three ===== -->
			<div class="col-md-4">
				<div class="package background-color-white">
					<div class="header-dark">
						<h3>销售经理</h3>
						<div class="sub-sub">
							$10700 / Year
						</div>
					</div>
					
					<!-- ===== Package Details ===== -->
					<div class="package-features">
						<ul>
							<li>
                               	 本科以上学历
							</li>
							<li>
                                	两年以上工作经验
							</li>
							<li>
                                	年终奖
							</li>
							<li>
                              	绩效奖金
							</li>
							<li>
                                	五险一金
							</li>
							<li>
                                	国内旅游
							</li>
						</ul>
						<div class="bottom-row">
							<div class="column-3p">
								<div id="call_to_action-3">
									<a href="" class="btn secondary-button">SIGN UP</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> <!-- ===== End Pricing Three ===== -->
			
			
		</div> 
	</div>
	
</div> 

</section>

<!-- ===== Section Portfolio ===== -->
<section id="section-portfolio" class="section-portfolio bgc-one">
<div class="container">
	
	<h2>加入我们</h2>
	<div class="underline">
	</div>
	
	<div class="sub-sub">
		<p style="font-size: 30px;font-weight: bold;">Will you be the one?<br>                    
		            Come to join us.</p>
	</div>
	
	<!-- ===== Portfolio ===== -->
	<div class="row portfolio">
		
		<div id="portfolio" class="owl-carousel owl-theme">
			
			<div class="portfolio-images">
				<a href="images/images/pic1.png" data-lightbox-gallery="portfolio-gallery"><img src="images/images/pic1.png" alt="portfolio"></a>
			</div>
			
			<div class="portfolio-images">
				<a href="images/images/pic2.png" data-lightbox-gallery="portfolio-gallery"><img src="images/images/pic2.png" alt="portfolio"></a>
			</div>
			
			<div class="portfolio-images">
				<a href="images/images/pic3.png" data-lightbox-gallery="portfolio-gallery"><img src="images/images/pic3.png" alt="portfolio"></a>
			</div>
			
			<div class="portfolio-images">
				<a href="images/images/pic1.png" data-lightbox-gallery="portfolio-gallery"><img src="images/images/pic1.png" alt="portfolio"></a>
			</div>
		</div>
		
	</div> <!-- ===== End Portfolio ===== -->
	
</div>

</section>


<!-- ===== Contact Us ===== -->
<section id="section-contact" class="section-contact bgc-one">
<div class="container">
	
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			
			<h2>Contact</h2>
			<div class="underline"></div>
			<div class="sub-sub">
			</div>
			
            <!-- ===== Form ===== -->
            <form class="contact-form" id="contact" role="form">

                <!-- ===== Succes Send Email ===== -->
                <h6 class="success">
                <span class="olored-text icon_check"></span> Your message successfully. </h6>

                <!-- ===== Error Send Email ===== -->
                <h6 class="error">
                <span class="colored-text icon_error-circle_alt"></span> your message sent pending. </h6>

                <div class="field-wrapper col-md-6">
                    <input class="form-control input-box" id="contact-form-name" type="text" name="contact-form-name" placeholder="Your Name">
                </div>

                <div class="field-wrapper col-md-6">
                    <input class="form-control input-box" id="contact-form-email" type="email" name="contact-form-email" placeholder="Email">
                </div>

                <div class="field-wrapper col-md-12">
                    <input class="form-control input-box" id="contact-form-subject" type="text" name="contact-form-subject" placeholder="Subject">
                </div>

                <div class="field-wrapper col-md-12">
                    <textarea class="form-control textarea-box" id="contact-form-message" rows="7" name="contact-form-message" placeholder="Your Message"></textarea>
                </div>

                <button class="btn standard-button" type="submit" id="contact-form-submit" name="submit" data-style="expand-left">Send Message</button>
            </form>
            <!-- ===== End Form ===== -->
		
		</div>
	</div>
	
</div>

</section>
<img src="images/images/foot.png">



<!-- ===== Script Javascript ===== -->
<script src="js/jquery.min.js"></script>
<script src="js/preloader.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/retina.js"></script>
<script src="js/SmoothScroll.js"></script>
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.localScroll.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/nivo-lightbox.min.js"></script>
<script src="js/jquery.nav.js"></script>
<script src="js/jquery.fitvids.js"></script>
<script src="js/custom.js"></script>

</body>
</html>