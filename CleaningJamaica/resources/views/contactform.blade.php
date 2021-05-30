<!doctype html>
<html lang="en-US">
<head>
<link href="{{ asset('style.css') }}" rel="stylesheet">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cleaning Jamaica</title>
<link href="file:///C|/Users/Gavin Grant/AppData/Roaming/Adobe/Dreamweaver 2021/en_US/Configuration/Temp/Assets/eam2A7.tmp/css/singlePageTemplate.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>var __adobewebfontsappname__="dreamweaver"</script>
<script src="http://use.edgefonts.net/source-sans-pro:n2:default.js" type="text/javascript"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link rel="stylesheet" href="form.css" >
        <script src="form.js"></script>



</head>
<body>



<!-- Main Container -->
<div class="container"> 
  <!-- Navigation -->
  <header> <a href="">
    <h4 class="logo">CleaningJamaica</h4>
    </a>
    <nav>
      <ul>
        <li><a href="{{url('/')}}">HOME</a></li>
        <li><a href={{url('about')}}>ABOUT</a></li>
        <li> <a href="{{url('contactform')}}">CONTACT</a></li>
        <li> <a href="{{url('login')}}">LOGIN</a></li>
      </ul>
    </nav>
  </header>
  
  <!-- About Section -->
  <form method="POST" action="{{route('contact.send')}}" enctype="multipart/form-data">
          @csrf
          </br>
</br>
</br>


  <center>
  <section style="padding-top:60px;"> 
    <div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
        <div clas="card-header">
         
    </div>
    <div class="card-body">
        @if(Session::has('message_sent'))
        <div class="alert alert-success" role="alert">
            {{Session::get('message_sent')}}
</div>
        @endif

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h2>Contact Us</h2> Got a question ? Feedback? Awesome! 
                    <p> Send your message in the form below and we will get back to you as early as possible. </p>
                    <form role="form" method="post" id="reused_form" >
                        <div class="form-group">
                            <label for="name"> Name:</label>
                            <input type="text" class="form-control" id="name" name="name" required maxlength="50">
                        </div>
                        <div class="form-group">
                            <label for="email"> Email:</label>
                            <input type="email" class="form-control" id="email" name="email" required maxlength="50">
                        </div>
                        <div class="form-group">
                            <label for="phone"> Phone Number:</label>
                            <input type="phone" class="form-control" id="phone" name="phone" required maxlength="50">
                        </div>


                        <div class="form-group">
                            <label for="name"> Message:</label>
                            <textarea class="form-control" type="textarea" name="msg" id="msg" placeholder="Your Message Here" maxlength="6000" rows="7"></textarea>
                        </div>
                        <button type="submit" class="btn btn-lg btn-success pull-right" id="btnContactUs">Submit &rarr;</button>
                    </form>
                    <div id="success_message" style="width:100%; height:100%; display:none; "> <h3>Sent your message successfully!</h3> </div>
                    <div id="error_message" style="width:100%; height:100%; display:none; "> <h3>Error</h3> Sorry there was an error sending your form. </div>
              
              
              
                    </div>
            </div>
        </div>
</center>
 </form>










 <!-- Footer Section -->
  <section class="footer_banner" id="contact">
    <h2 class="hidden">Footer Banner Section </h2>
    <p class="hero_header">FOR THE LATEST NEWS &amp; UPDATES</p>
    <div class="button"  >Make an Appointment
    
    </div>
  </section>
  <!-- Copyrights Section -->
  <div class="copyright">&copy;2020- <strong>ALL RIGHTS RESERVED CLEANING JAMAICA</strong></div>
</div>
<!-- Main Container Ends -->

</body>
</html>
