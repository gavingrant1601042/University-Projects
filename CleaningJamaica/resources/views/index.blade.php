<!doctype html>
<html lang="en-US">
<head>
<link href="{{ asset('style.css') }}" rel="stylesheet">
<link href="{{ asset('slideshow.css') }}" rel="stylesheet">
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
  
     <link href="{{ asset('slideshow.css') }}" rel="stylesheet">
     <link rel="icon" href="{{ URL::asset('favicon.ico') }}" type="image/x-icon"/>
</head>
<body>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
<div class="galleryContainer">
    <div class="slideShowContainer">
        <div id="playPause" onclick="playPauseSlides()"></div>
        <div onclick="plusSlides(-1)" class="nextPrevBtn leftArrow"><span class="arrow arrowLeft"></span></div>
        <div onclick="plusSlides(1)" class="nextPrevBtn rightArrow"><span class="arrow arrowRight"></span></div>
        <div class="captionTextHolder"><p class="captionText slideTextFromTop"></p></div>
        <div class="imageHolder">
            <img src="img_1.jpg">1366X768
            <p class="captionText">We Clean Houses, Cars and furniture at a low cost </p>
        </div>
        <div class="imageHolder">
            <img src="img_2.jpg">
            <p class="captionText">Purchase our at low cost, compared to the supermarket</p>
        </div>
        <div class="imageHolder">
            <img src="img_3.jpg">
            <p class="captionText">Our Employees are trained professionals and customer service orientated</p>
        </div>
        <div class="imageHolder">
            <img src="img_4.jpg">
            <p class="captionText">We have a wide-range of products shop now at a reduce cost</p>
     
         </div>
    </div>
    <div id="dotsContainer"></div>
</div>
<script src="myScript.js"></script>
</br>
</br>
</br>

  <!-- More Info Section -->

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
