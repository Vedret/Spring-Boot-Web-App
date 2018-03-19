<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Licence</title>

    <!-- Bootstrap Core CSS 
     <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
     <link href="<c:url value="vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
     
    

    <!-- MetisMenu CSS 
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet"> -->
	<link href="<c:url value="vendor/metisMenu/metisMenu.min.css" />" rel="stylesheet">
	
	
    <!-- Custom CSS 
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">-->
    <link href="<c:url value="dist/css/sb-admin-2.css" />"rel="stylesheet">
    

    <!-- Morris Charts CSS 
    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">-->
    <link href="<c:url value="vendor/morrisjs/morris.css" />" rel="stylesheet">

    <!-- Custom Fonts 
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">-->
    <link href="<c:url value="vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<font color="red">${errorMessage}</font>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                       <!--   <form role="form" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Name" name="name" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                
                                
                            </fieldset>
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="login" />
                        </form>-->
                        
                        <form method="POST" action="${contextPath}/login" class="form-signin">
					        <h2 class="form-heading">Log in</h2>
					
					        <div class="form-group ${error != null ? 'has-error' : ''}">
					            <span>${message}</span>
					            <input name="username" type="text" class="form-control" placeholder="Username"
					                   autofocus="true"/>
					            <input name="password" type="password" class="form-control" placeholder="Password"/>
					            <span>${error}</span>
					            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					
					            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
					            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
					        </div>
					
					    </form>
                        
                        
                        
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    
    
    
    </body>
    </html>
    
    
