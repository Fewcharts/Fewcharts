<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 

<jsp:useBean id="question" scope="request" class="com.qapro.entity.Question"></jsp:useBean>
<jsp:useBean id="answer" scope="request" class="com.qapro.entity.Answer"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
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
          <a class="navbar-brand" href="index.jsp">Fewcharts.com</a> 
         <!-- potremmo aggiungere un logo  -->
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Charts <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Top rated</a></li>
                <li><a href="#">Latest</a></li>
                <li><a href="#">In growth</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Topic
                    <small>Dicci la tua opinione e vota</small>
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
                        <a href="#"><i class="fa fa-facebook-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-twitter-square fa-2x"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a>
                    </li>
                </ul>
                
                <!-- /.row -->
 <div class="row">
           
            <div class="col-md-8">
            <div class="controls">
          
   <h3> <c:choose>
	<c:when test="${empty question.id }"> There is no question with this id </c:when>
		

	<c:otherwise>
	<label>Chart by <c:out value="${question.askerId}"></c:out></label>
		<c:out value="${question.text}"></c:out> <form action="Voting">
	<input type="hidden" name="questionId" value="${question.id}"/>
	
	<input type="hidden" name="type" value="UP"/>
	 ${question.upVote} <b>Vote</b>
	<button type="submit"><img width="20px" height="20px" src="assets/img/Hands-Thumb-Up-icon.png"></img></button>
</form>
		<c:set var="QuestionId" value="${question.id}" scope="request"/>
     </c:otherwise>
	</c:choose>
                  </h3>
               <!-- /.row -->                
          <form action = "inseriscirisposta" method= "POST" >
                
                            <p class="help-block"></p>
                        
                
                <input type="hidden" name="questionId" value="${question.id}"/>
                <input type="hidden" name="askerId" value="${question.askerId}"/>
                    <div class="control-group form-group">
                        <div class="controls">
                                 <label for="risposta">La tua risposta</label>
                            <textarea maxlength="50" placeholder= " for example : The best is symphonie n. 2 ( in 50 characters!!!!)... " name= risposta rows="5" cols="100" class="form-control" id="risposta" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
                       
                       
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button id="submit" type="submit" class="btn btn-primary" >invia la tua opinione</button>
                   
                   </form>
                   
                   
                    </div>
   
			

 
            </div>

        </div>
        
        
        <!-- SISTEMA DI VOTO DELLA DOMANDA !-->
        
        



		<c:forEach var="answer" items="${question.answers}">
			
			<div class="media">
                    <!-- SISTEMA DI VOTO DELLE RISPOSTE -->
                        <form action="VotingAnswer">
	<input type="hidden" name="answerId" value="${answer.id}"/>
	<input type="hidden" name="questionId" value="${question.id}"/>
	<input type="hidden" name="type" value="UP"/> 
	<b> ${answer.upVote} Votes</b>
	<button type="submit"><img width="20px" height="20px" src="assets/img/Hands-Thumb-Up-icon.png"></img></button>
</form>
			
			 <c:out value="${answer.text}"></c:out>
			<!-- pollice in su -->
			
                



                    
                            
                        </h4>
		</c:forEach>  
		               
		
		   </div>
                </div>


		
		
		
		





 <!-- jQuery Version 1.11.0 -->
    <script src="js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>
        
<script type="text/javascript" src="javascript/main.js"></script>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-61653120-1', 'auto');
  ga('send', 'pageview');

</script>

</body>
</html>