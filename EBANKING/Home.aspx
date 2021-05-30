<%@ Page Title="" Language="C#" MasterPageFile="~/start.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="EBANKING.Home" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <script type="text/javascript">
        var slideIndex = 0;
        window.onload = showSlides;

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides() {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slideIndex++;
            if (slideIndex > slides.length) { slideIndex = 1 }
            slides[slideIndex - 1].style.display = "block";
            setTimeout(showSlides, 2000); // Change image every 2 seconds
        } 
    </script>
    <style type="text/css">
        *{box-sizing:border-box}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

.mySlides {
    display: none;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text
{
    border: thin solid #000000;
    align: center;
    color: black;
    font-size: xx-large;
    padding: .5px;
    position: absolute;
    bottom: .5px;
    text-align: center;
    font-weight: 900;
    font-family: sans-serif;
    
    
  padding: 8px 12px;
  bottom: 8px;
  width: 100%;
  text-align: center;    
}


/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor:pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
    </style>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="body" runat="server">
    <h2><center>MGGD Banking and Finance</center></h2><br />
    <p><center>With an Account every thing is just a one click away</center></p>
    <div class="slideshow-container" runat="server">
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
     <asp:Image runat="server" src="Images/paybill.jpg" style="width:100%" height="450 px"/>
    <div class="text">Pay Ypur Bills Online From your Account</div>
  </div>

  <div class="mySlides fade" runat="server">
    <div class="numbertext">2 / 3</div>
    <asp:Image runat="server" src="Images/balance.jpg" style="width:100%" height="450 px"/>
    <div class="text">Check you balance after transactions and keep track</div>
  </div>

  <div class="mySlides fade" runat="server">
    <div class="numbertext">3 / 3</div>
    <asp:Image  runat="server" src="Images/nolonglines.png" style="width:100%" height="450 px"/>
    <div class="text">No more visits to the bank in person</div>
  </div>

  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div> 
</asp:Content>
