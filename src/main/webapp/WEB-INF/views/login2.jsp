<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
    <style>
        

        body{
            
            
            background-repeat: no-repeat;
            background-size: cover;
            
            background: -webkit-linear-gradient(rgba(1, 1, 3, 0.8), rgba(195, 55, 100, 0.8)), url("https://srengineeringbbsr.com/wp-content/uploads/2022/06/1-03.jpg");
        }

       
        
    </style>
</head>
<body>
    <div class="container-fluid d-flex align-items-center h-100 mt-5 p-4">
        <div class="main-container d-flex justify-content-center shadow-lg p-3 mb-5 bg-body rounded">
            <div class="row overlay overlay-intensity-lg">
                <div class="col overlay-content ">
                    <img src="https://srengineeringbbsr.com/wp-content/uploads/2022/06/1-03.jpg" alt="">
                </div>
                <div class="col">
                    <div class="row">
                        <img src="https://partners.boomi.com/partner_content/71/1341071/logo.png?t=8d8e7de02d68bc1" alt="">
                    </div>
                    <div class="row d-flex align-items-center">
                        <form action="/dologin" method="post" name="loginForm"  onsubmit="return loginValidation()">
                            <div class="mb-3">
                              <label for="exampleInputEmail1" class="form-label">Email address</label>
                               <input type="text" name="username"
									class="form-control" id="email" placeholder="Enter username">
                              <div id="emailHelp" class="form-text"></div>
                            </div>
                            <div class="mb-3">
                              <label for="exampleInputPassword1" class="form-label">Password</label>
                              <input type="password" name="password"
									class="form-control" id="pwd" placeholder="Enter password">
                              <div id="passwordHelp" class="form-text"></div>
                            </div>
                            <div class="mb-3 d-flex justify-content-center">
                              <a href="javascript:void(0)">Forgot Password?</a>
                            </div>
                            <div class="button d-flex justify-content-center">

                                <button type="submit" class="btn btn-primary btn-large" id="submitBtn">Submit</button>
                            </div>
                          </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
    function loginValidation()
    {
       
        let email=document.forms.loginForm.email.value;
        let password=document.forms.loginForm.password.value;
        let emailHelp=document.querySelector('#emailHelp');
        let passwordHelp=document.querySelector('#passwordHelp');
        if(email.length<1|| email.length>20)
        {
            emailHelp.innerHTML="Please Enter a Valid Email"
            
        }
        if(password.length<1|| password.length>10)
        {
            
            passwordHelp.innerHTML="Please Enter a Valid Password"
        }
    }
    </script>

 
</body>
</html>