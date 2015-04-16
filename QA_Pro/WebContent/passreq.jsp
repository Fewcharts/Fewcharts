<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<jsp:useBean id="question" scope="request" class="com.qapro.entity.Question"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="assets/img/fewchartsfavicon.ico">

 <c:if test="${not empty sessionScope.memberInfo.userName }" >
	<c:redirect url = "DisplayAllQuestions"></c:redirect>
</c:if>
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
         <li><a href="topic.jsp">New Chart</a></li>
          </ul>
           
          
        </div><!--/.nav-collapse -->
 
      
      </div>
     

      

    </div>
    <c:if test="${sessionScope.memberInfo != null}" >
	<c:redirect url = "memberhome.jsp"></c:redirect>
</c:if>
                   
        
   


<div class="container">
<div class="col-sm-4">
      <form class="form-signin"action="ReqPass" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
  

<label for="inputEmail" class="sr-only">Insert email address</label>
<input type="text" id="text" name="email" email class="form-control" placeholder="Email address" required autofocus>


<br>  

<button class="btn btn-lg btn-primary btn-block" type="submit">Request password</button>


</form>

<br>     
<c:if test="${not empty sessionScope.message1 }">
	<p="color: #ff1100"> ${sessionScope.message1} </p>
</c:if>
</br>

<p>Insert your password and check your email</a></p>


<!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>The Kobra Kai - 2014</p>
                </div>
            </div>
        </footer>

    </div>
</div>

    </div> <!-- /container -->
        
            
 
 
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
    
    




</body>
</html>