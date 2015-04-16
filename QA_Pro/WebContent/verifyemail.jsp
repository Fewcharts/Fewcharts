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
                    <li>
                        <a href="Logout">Logout</a>
                    </li>
                    <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="DisplayAllQuestions">Home</a>
                    </li>
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

<div class="container">
<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"> Check your email account and verify your email
  
 
</body>                 
</div>
<br></br>


		
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


		
</body>
</html>