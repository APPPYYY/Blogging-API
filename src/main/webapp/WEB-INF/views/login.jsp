<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Document</title>
    <style>
        body{
            background-image: url('https://www.esspl.com/wp-content/uploads/2018/09/bbsr-2.jpg');
            background-size: cover;
            
        }
        .main-container
        {
            height: 600px;
           
        }
        
    </style>
</head>

<body>
    <div class="container-fluid main-container d-flex justify-content-center align-items-center">
        <div class="row">
            <div class="col-md-7 d-flex justify-content-center">
                <div class="heading d-flex align-items-center text-light text-wrap">
                    <h1 class="auto-typed"></h1>
                </div>
            </div>
            <div class="col-md-5">
                
                <form action="/dologin" method="post" name="loginForm"  onsubmit="return loginValidation()" class="bg-light p-5 rounded m-5 shadow-lg">
                    <div class="row">
                        <img class="card-img" src="https://partners.boomi.com/partner_content/71/1341071/logo.png?t=8d8e7de02d68bc1" alt="">
                    </div>
                    <div class="input-icons">
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Email address</label>
                      <i class="fa-solid fa-user-secret"></i>
                     <input type="text" name="username"
									class="form-control" id="email" placeholder="Enter username"
									 name="email">
                      <div id="emailHelp" class="form-text"></div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Password</label>
                       <input type="password" name="password"
									class="form-control" id="pwd" placeholder="Enter password"
									 name="pwd">
                      <div id="passwordHelp" class="form-text"></div>
                    </div>
                    <div class="mb-3 d-flex justify-content-center">
                      <a href="#">Forgot Password?</a>
                    </div>
                    <div class="button d-flex justify-content-center">

                        <button type="submit" class="btn btn-primary btn-large" id="submitBtn">Submit</button>
                    </div>
                  </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>

    <script>
        var typed=new Typed(".auto-typed",{
            strings:["Recruitment-Process-Application","Welcome to ESSPL &#128148; "],
            typeSpeed:150,
            backSpeed:150,
            loop:true
        });
    </script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>