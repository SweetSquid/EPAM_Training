<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html; charset=utf-8">
</head>
<style>
    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box;}

    /* Full-width input fields */
    input{
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    /* Add a background color when the inputs get focus */
    input:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }


   .clearfix{
       position: absolute;
       left: 37%;
   }

    /* Extra styles for the cancel button */
    .cancelbtn {
        padding: 14px 20px;
        background-color: #f44336;
    }

    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn, .signupbtn {
        float: left;
        width: 100px;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
        position: absolute;
        left: 27%;
    }


</style>
<body>
<form action="/Form">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>

        <hr>

        <label><b>First name</b></label>
        <input type="text" placeholder="Enter Name" name="firstName" minlength="3" maxlength="20" value="<%=request.getAttribute("firstName") != null ? request.getAttribute("firstName") : ""%>" required>

        <label><b>Login</b></label>
        <input type="text" placeholder="Enter login" name="login" minlength="3" maxlength="20" value="<%=request.getAttribute("login") != null ? request.getAttribute("login") : ""%>" required>

        <label><b>Email</b></label>
        <input type="email" placeholder="Enter email" name="email" required value="<%=request.getAttribute("email") != null ? request.getAttribute("email") : ""%>">

        <div class="clearfix">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn" value="register">Sign Up</button>
        </div>
    </div>
</form>
</body>
</html>

