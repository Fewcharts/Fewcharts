<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.qapro.entity.FBConnection"%>


<%
	FBConnection fbConnection = new FBConnection();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css" ></style>

</head>

<body>

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
                        <a href="login.jsp">Login</a>
                    </li>
   
   
         </div>
      
      </div>
      

    </div>

<div class="container">
<div class="col-sm-4">
      <form class="form-signin"action="RegisterMember" method="POST">
        <h2 class="form-signin-heading">Register now in 1 easy step!</h2>
  

<label for="UserName" class="sr-only">Username</label>
<input type="text" id="text" name="username"  class="form-control" placeholder="Username" required autofocus>

<label for="Email" class="sr-only">Email</label>
<input type="text" id="text" name="email" class="form-control" placeholder="Email" required autofocus>

<label for="Name" class="sr-only">Name</label>
<input type="text" id="text" name="name"  class="form-control" placeholder="Birth date dd/mm/yy" required autofocus>

<label for="Surname" class="sr-only">Surname</label>
<input type="text" id="text" name="surname"  class="form-control" placeholder="Surname" required autofocus>

<label for="inputPassword" class="sr-only">Password</label>
<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>

<br>
<!-- questo messaggio lo prende da registermember, cfissando un attributo messagio a session -->
<c:if test="${not empty message }">
	<span style="color: #ff1100"> ${sessionScope.message} </span>
</c:if>
</br>

<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>


<input type="checkbox" name="Conditions" value="Conditions" > <a href="login.jsp"> Accept Terms & Conditions</a><BR>

</form>

<br></br>

<br></br>

		<a href="<%=fbConnection.getFBAuthUrl()%>"> <img
			style="margin-top: 0px;" src="assets/img/Se.png" />
		</a>
	
		
<p>or go to  <a href="login.jsp">Login page</a></p>

<!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>TKK - 2014</p>
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

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    
</body>
</html>