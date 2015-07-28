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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">CLassifiche <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a  href="SelectAllQuestion">Ultime Classifiche</a>
                            </li>
                            <li>
                                <a href="SelectAllQuestionByDate">Le più votate</a>
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



<div class="col-sm-12">
<h2 class="form-signin-heading">Registrati ora in un solo passaggio!</h2>
 
 <h5 class="form-signin-heading">Entra a far parte della eslcusiva comunity di Fewcharts in soli 30 secondi. E' GRATIS e lo sarà sempre!</h5> 

<br></br>      
<div class="col-sm-4">
<br></br>
<form class="form-signin"action="RegisterMember" method="POST">
        

<label for="UserName" class="sr-only">Username</label>
<input type="text" id="text" name="username"  class="form-control" placeholder="Username" required autofocus>

<label for="Email" class="sr-only">Email</label>
<input type="text" id="text" name="email" class="form-control" placeholder="Email" required autofocus>

<label for="inputPassword" class="sr-only">Password</label>
<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>

<br>
<!-- questo messaggio lo prende da registermember, cfissando un attributo messagio a session -->
<c:if test="${not empty message }">
	<span style="color: #ff1100"> ${sessionScope.message} </span>
</c:if>



<button class="btn btn-lg btn-primary btn-block" type="submit">Registrati</button>


<input type="checkbox" name="Conditions" value="Conditions" > <a href="login.jsp"> Accetta i termini e le condizioni</a><BR>

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
    
    </div>
    <div class="col-sm-8">
<h2> Perchè <em>amerai</em> Fewcharts? </h2>

- Con Fewcharts hai accesso esclusivo a statistiche sulle preferenze degli utenti.
<br></br>
- Con Fewcharts puoi votare o far votare il migliore.
<br></br>
- Con Fewcharts puoi creare delle classifiche e farle votare ai tuoi amici. 
   
<h2> Registrati subito è GRATIS e  lo sarà sempre! </h2> 
</body>
</html>