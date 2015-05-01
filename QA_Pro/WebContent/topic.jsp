<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page session="true" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="question" scope="request" class="com.qapro.entity.Question"></jsp:useBean> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<script type="text/javascript">
      window.fbAsyncInit = function() {
        FB.init({
          appId      : '351486545042748',
          xfbml      : true,
          version    : 'v2.2'
        });
      };
      FB.logout(function(response) {
    	  // user is now logged out
    	});
      deauth = function(){
          FB.api('/me/permissions', 'DELETE', function(response){
        	  console.log(response);
            });
            
      (function(d, s, id){
         var js, fjs = d.getElementsByTagName(s)[0];
         if (d.getElementById(id)) {return;}
         js = d.createElement(s); js.id = id;
         js.src = "//connect.facebook.net/en_US/sdk.js";
         fjs.parentNode.insertBefore(js, fjs);
       }(document, 'script', 'facebook-jssdk'));
    </script>
<script src="https://connect.facebook.net/en_US/all.js"></script>

 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">Fewcharts.com</a> 
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
    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Topic
                    <small>Write your chart now!</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.jsp">Home</a>
                    </li>
                    <li class="active">Topic</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

                       <ul class="list-unstyled list-inline list-social-icons">
                    <li>
                        <a href="http://www.facebook.com/fewcharts"><i class="fa fa-facebook-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="https://twitter.com/fewcharts"><i class="fa fa-twitter-square fa-2x"></i></a>
                    </li>
                   
                </ul>
                
                <!-- /.row -->

        <!-- Topic Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">
           
            <div class="col-md-8">
            <div class="controls">
           <form action = "CheckUtenteLoggato" method= "POST" >
                <h3>Theme of your chart: </h3>
                                 
                            <p class="help-block"></p>
                        
                
                
                    <div class="control-group form-group">
                        <div class="controls">
                                 <label for="topic">Chart:</label>
                      <textarea maxlength="100" placeholder= " ad Es. Ten best Mozart symphonies (in 180 characters!!)" name= topic rows="5" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button id="submit" type="submit" class="btn btn-primary" >Publish it !</button>
                   </form>
                    </div>
   
			

 
            </div>

        </div>
        

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>TKK - 2014</p>
                </div>
            </div>
        </footer>

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