<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 

<jsp:useBean id="question" scope="request" class="com.qapro.entity.Question"></jsp:useBean>
<jsp:useBean id="answer" scope="request" class="com.qapro.entity.Answer"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<meta property="og:title" content='${Text}'/>
<meta property="og:type" content="website" />
<meta property="og:url" content='${Url}'/>                                                      													
<meta property="og:image" content="http://www.fewcharts.com/assets/img/bannerfb1200x630.png" />
<meta property="og:site_name" content="Fewcharts" />
<meta property="og:description" content= "Fewcharts is a ranking system focused mainly on music that allows you to find out who is the best. Through Fewcharts you can add your own preferences in 50 characters and create topic by voting with your friends. It's 100% free and will always be."/>


<link rel="shortcut icon" type="image/x-icon" href="assets/img/fewchartsfavicon.ico"/>


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
    
<script type = "text/javascript">
function loadXMLDoc (voteType,aid){
	var xmlhttp;
	
	if (window.XMLHttpRequest){
		xmlhttp= new XMLHttpRequest();
		
	}
	else {
		xmlhttp = new ActiveXObject ("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function (){
	    if (xmlhttp.readyState == 4){
			
			if (xmlhttp.status = 200){
				
				
				if ('ALREADY_VOTED_UP' == xmlhttp.responseText) {
					alert ('You already voted up for this question');
				} else if ('VOTING_SUCCESSFULL' == xmlhttp.responseText) {
					alert ('Your vote is saved thanks! ');
					if (voteType == 'UP'){
						var total = parseId(document.getElementById(aid).innerHTML);
						document.getElementById(aid).innerHTML = total + 1;
					}				
				}
				else {
					alert ('Your vote can not be saved if you are not logged in on Fewcharts. Please go to LOGIN or REGISTER page');
					window.location.href='http://www.fewcharts.com/login.jsp';
				}
			}
	    }
    };

    
    
	xmlhttp.open("POST", "VotingAnswer");
	
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
     
	var answerId = '${answer.id}';
    var questionId = '${question.id}';
	
    xmlhttp.send ("&answerId=" + aid + "&questionId=" + questionId + "&type="+voteType);
		
}
</script>
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
            <ul class="nav navbar-nav navbar-right">
          <li>
                        <a href="topic.jsp">New Chart</a>
                    </li>                
       
    
       	
                   <li>
          
<!--  far appare il logout in alto quando uno è loggato -->
                   
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

 
                   
   
       
        </div><!--/.nav-collapse -->
      
      
      </div>
    
    
    </div>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Topic
                    <small>Tell to the world your opinion</small>
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
                

<!-- VISUALIZZAZIONE RISPOSTA -->

 <div class="row">         
            <div class="col-md-8">
            <div class="controls">
          
   <h3> <c:choose>
	<c:when test="${empty question.id }"> There is no question with this id </c:when>
		

	<c:otherwise>
	<small><c:out value="Added ${question.insertDate}"></c:out></small>
		<p>
		<c:out value="${question.text}"></c:out>
	
		
		 
     </c:otherwise>
	</c:choose>
                  </h3>
                  
   <!--INSERIMENTO RISPOSTE-->   
                
          <form action = "inseriscirisposta" method= "POST" >
                
                            <p class="help-block"></p>
                        
                
                <input type="hidden" name="questionId" value="${question.id}"/>
                <input type="hidden" name="askerId" value="${question.askerId}"/>
                    <div class="control-group form-group">
                        <div class="controls">
                                 <label for="risposta">Your Opinion</label>
                            <textarea maxlength="50" placeholder= " for example : The best Mozart's symphonie is n. 2 ( in 50 characters!)... " name= risposta rows="5" cols="100" class="form-control" id="risposta" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
                    
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button id="submit" type="submit" class="btn btn-primary" >Send your opinion</button>      
                   </form>          
                    </div>
            </div>
        </div>      
 
 
   <!-- SISTEMA DI VOTO DELLE RISPOSTE -->

		<c:forEach var="answer" items="${question.answers}">
		
			<div class="media">
			
   
<span id= "${answer.id}"> <b>${answer.upVote} Votes</b> </span>
<button type= "button" onclick = "loadXMLDoc ('UP',${answer.id})"><span class="glyphicon glyphicon-hand-up"></span> </button>
 <p>
 <small><c:out value="added ${answer.insertDate}"></c:out></small>
  <br></br>
 <c:out value="${answer.text}"></c:out> 
 <p>
 

 -----------------------                          
                        </h4>
		</c:forEach>  
 </div>
 </div>



    <!-- Contact Form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    
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