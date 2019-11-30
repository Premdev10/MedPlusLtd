<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" type="text/css" href="../css/signup.css">
</head>


<body>
<style= data-spy="scroll" data-target=".navbar" data-offset="100">

<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="jumbotron col-md-4" style="margin-top: 100px; background-color: #696b6b;">
            <h1 style="text-align:center; padding-top: -20px;">SIGN UP</h1>
            <form method="post" action="registration.jsp">
                <input class="form-group form-control" type="text" name="name" placeholder="Name">
                <input class="form-group form-control" type="text" name="age" placeholder="Age">
                <input class="form-group form-control" type="text" name="mobile" placeholder="Phone Number">
                <input class="form-group form-control" type="email" name="mail" placeholder="Email">
                <select class="form-group form-control" name="role">
                    <option disabled="disabled" selected="selected" class="form-control">Role</option>
                    <option class="form-control" name="role" value="ADMIN" >ADMIN</option>

                    <option name="role" value="DOCTOR">DOCTOR</option>
                    <option name="role" value="USER">User</option>
                    <option name="role" value="STORE KEEPER">STORE KEEPER</option>
               </select>
                <input class="form-group form-control" type="text" name="place" placeholder="Place">
                <input class="form-group form-control" type="text" name="username" placeholder="User Name">
                <input class="form-group form-control" type="password" name="password" placeholder="Password">
                <div class="row">
                    <div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">
                        <input class="btn btn-success" type="submit" style="margin-top:30px;" value="SIGNUP">
                    </div>
                    <div class="col-md-8 col-lg-8 col-sm-8 col-xs-8">
                        <a href="index.html" class="btn btn-warning" type="submit" style="margin-top:30px;" >Already have Account</a>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

</body>
</html>