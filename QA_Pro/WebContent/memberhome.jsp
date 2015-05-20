<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<jsp:useBean id="user" scope="request" class="com.qapro.entity.MemberInfo"></jsp:useBean>





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

<div id="fb-root"></div>
   <script>
   
   
var AccessToken;

window.fbAsyncInit = function() {
FB.init({
        appId: '351486545042748',
        xfbml: true, //for parsing social plugins
        status: true, //for getting user status
        cookie: true, //save cookie
        version:'v2.0' //version of graph API
      });
    
FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
FB.logout(function(response) {
	  FB.Auth.setAuthResponse(null, 'unknown');
	  setTimeout('document.location.reload()',0);

	});
};

(function(d, s, id) {
   var js, fjs = d.getElementsByTagName(s)[0];
   if (d.getElementById(id)) return;
   js = d.createElement(s); js.id = id;
   js.src = "//connect.facebook.net/en_US/sdk.js";
   fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));


  //checking login status of user
 function statusChangeCallback(response) {
 
        if(response && response.status == 'connected') {
          alert('User is authorized');
         AccessToken = response.authResponse.accessToken; //Get the user access token from the auth                         //response
         console.log('Welcome!  Fetching your information.... ');
         FB.api('/me', function(response) {
               console.log('Good to see you, ' + response.name + '.' +  response.id);
         });
         console.log(AccessToken);
       } else {
         alert('User is not authorized');
       }
}

 function checkLoginState() {
     FB.getLoginStatus(function(response) {
       statusChangeCallback(response);  });
   }
</script>
   



 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href=index.jsp>Fewcharts.com</a> 
         <!-- -->
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
    
        <li><a href="topic.jsp">New Charts</a></li>	
                   <li><c:if test="${not empty sessionScope.memberInfo.userName }" >
	
	<ul class="nav navbar-nav navbar-right">
   
                    <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="DisplayAllQuestions" style="color: #F0FFFF">  Logged in as ${sessionScope.memberInfo.userName} </a>
                    </li>
                    </ul>
                    <li>
                       <a href="Logout" onclick="FB.logout();">Logout</a>
                    </li>
                     </ul>
        </c:if>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </div>


<div class="container">
<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Welcome
                    <small><span style="color: #333333"> <b> ${sessionScope.memberInfo.userName} </b></span></small>
</div>
<br></br>

<div class="panel-body">
                        <h4><span style="color: #333333"> Your latest charts: </span></h4>
                        <p>	
<c:choose>
	<c:when test="${user.userId eq null}"> There is no user with this id </c:when>

	<c:otherwise>
		
		<c:out value="${question.text}"></c:out>
		
		<br></br>
		<c:forEach var="question" items="${user.questions}">
			
			<a href="DisplayQuestion?qId=${question.id}"><c:out value="${question.text}"></c:out></a>
			<br></br>
		</c:forEach>
		
		
	</c:otherwise>
	
</c:choose>
</p>
             <c:if test="${ empty question.text }" >
	
	<small><h5>Insert new chart! Start now!  </h5>
	<h5>insert new <a  href="topic.jsp"> charts</a></h5>
		<h5> or vote  <a  href="SelectAllQuestionByDate"> old ones</a> </h5>
	</small>

</form>
</c:if>	           

                    </div>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-61653120-1', 'auto');
  ga('send', 'pageview');

</script>
    
    
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>
        
<script type="text/javascript" src="javascript/main.js"></script>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
 	
		
</body>
</html>