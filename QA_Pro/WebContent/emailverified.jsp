<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<jsp:useBean id="user" scope="request" class="com.qapro.entity.MemberInfo"></jsp:useBean>




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
          <a class="navbar-brand" href=index.jsp>Fewcharts.com</a> 
         <!-- potremmo aggiungere un logo  -->
        </div>
        
        <div class="navbar-collapse collapse">
     
          <ul class="nav navbar-nav">
        
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Charts <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="portfolio-1-col.html">Ultime Charts</a>
                            </li>
                            <li>
                                <a href="portfolio-2-col.html">Le Più Votate</a>
                            </li>
                            
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
    
        <li><a href="topic.jsp">New Charts</a></li>	
                   
          
        </div><!--/.nav-collapse -->
      </div>
    </div>


<div class="container">
<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"> Your account is now verified go to <a href="login.jsp">Login</a> Page</h1>
                    
</div>
<br></br>


		
	




		
</body>
</html>