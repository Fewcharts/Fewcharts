<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="question" scope="request" class="com.qapro.entity.Question"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta property="og:title" content="Fewcharts - chart everything now!"/>
<meta property="og:type" content="company" />
<meta property="og:url" content="http://www.fewcharts.com/"/>
<meta property="og:image" content="http://www.fewcharts.com/assets/img/bannerfb1200x630.png"/>
<meta property="og:description" content= "Fewcharts is a ranking system focused mainly on music that allows you to find out who is the best. Through Fewcharts you can add your own preferences in 50 characters and create topic by voting with your friends. It's 100% free and will always be."/>

<meta property="og:site_name" content="http://www.fewcharts.com" />

<link rel="shortcut icon" type="image/x-icon" href="assets/img/fewchartsfavicon.ico">

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Fewcharts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">
<link href="css/custom" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
  <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Fewcharts.com</a> 
         <!-- potremmo aggiungere un logo  -->
        </div>
        
        <div class="navbar-collapse collapse">
     
          <ul class="nav navbar-nav">
        
     
            <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Charts <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a  href="SelectAllQuestion">All Charts</a>
                            </li>
                            <li>
                                <a href="SelectAllQuestionByDate">Latest Charts</a>
                            </li>
                            
                
              </ul>
            </li>
    
       	
                   <li>
          <!-- discorso di far appare il logout quando uno è loggato -->
                   
                   <c:choose>
  <c:when test="${not empty sessionScope.memberInfo.userName }">
 <ul class="nav navbar-nav navbar-right">
                    <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="DisplayAllQuestions" style="color: #F0FFFF">  Logged in as ${sessionScope.memberInfo.userName} </a>
                    </li>
                    </ul>
                    <li>
                        <a href="Logout">Logout</a>
                    </li>
                     </ul>
                    
</c:when>
  <c:otherwise>
   <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="login.jsp">Login</a>
                    </li>
                    <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="register.jsp">Register</a>
                    </li>
  </c:otherwise>
</c:choose>

 
                   
   <ul class="nav navbar-nav navbar-right">
          <li>
                        <a href="topic.jsp">New Chart</a>
                    </li>                
       
       
        </div><!--/.nav-collapse -->
      
      
      </div>
    
    
    </div>
<header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('http://i60.tinypic.com/zyd7qu.png&text=Fewcharts') ;"></div>
                <div class="carousel-caption">
                    <h2></h2> 
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://i58.tinypic.com/2vim5gp.pngtext=Fewcharts');"></div>
                <div class="carousel-caption">
                    <h2></h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://i60.tinypic.com/34epchz.png&text=stocazzo che te se incula con la minchia di tua nonna');"></div>
                <div class="carousel-caption">
                    <h2></h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Find the n. 1 and vote now!
                </h1>
            </div>
             <!-- Call to Action Section -->
        <div class="well">
            <div class="row">
                <div class="col-md-8">
                    <p>Fewcharts is a ranking system focused mainly on music that allows you to find out who is the best. Through Fewcharts you can add your own preferences in 50 characters and create topic by voting with your friends. It's 100% free and will always be.</p>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="topic.jsp">Start now!</a>
                </div>
            </div>
        </div>
           
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>TKK - 2014</p>
                    <p>For any inquiries fewcharts[at]gmail.com</p>
                </div>
            </div>
              <ul class="list-unstyled list-inline list-social-icons">
                    <li>
                        <a href="http://www.facebook.com/fewcharts"><i class="fa fa-facebook-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="https://twitter.com/fewcharts"><i class="fa fa-twitter-square fa-2x"></i></a>
                    </li>
                    
                </ul>
        </footer>
        </div>
        <!-- /.row -->

    </div>
            
        
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-61653120-1', 'auto');
  ga('send', 'pageview');

</script>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>