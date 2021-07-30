<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="mobile/css/m-style.css">
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Rubik&display=swap" rel="stylesheet"> 
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/font-awesome/css/all.min.css">
    <link rel="stylesheet" href="plugins/font-awesome/css/fontawesome.min.css">
    <!-- icon -->
    <link rel="shortcut icon" href="assets/img/icon.png">

    <title>Narobil</title>
  </head>

  <!-- loading -->
  <div id="loader" class="spinner">
    <div class="bounce1"></div>
    <div class="bounce2"></div>
    <div class="bounce3"></div>
  </div>

  <body onload="loading()">
    
    <!-- main content -->
    <main id="content" style="display: none;">
      <!-- navbar -->
      <nav class="navbar">
          <a class="navbar-brand" href="#"><img src="assets/img/logo-nav.png" alt="Narobil" height="32px"></a>
      </nav>
      <!-- end navbar -->

      <div class="container mt-4">
      <c:choose>
      	<c:when test = "${paymentChannel == 6}">
	        <div class="row m-0 justify-content-between">
	           <h3 class="mb-0 judul" style="font-size: 16px;">Virtual Account</h3>
		       <img class="mt-n1" src="assets/img/bca.png" alt="Virtual Account">
	        </div>
	     </c:when>
	     <c:otherwise>
	     	<div class="row m-0 justify-content-between">
	     	  <h3 class="mb-0 judul" style="font-size: 16px;">Transfer Bank</h3>
	          <img class="mt-n1" src="assets/img/bank-transfer.png" alt="Bank Transfer">
		     </div>
		  </c:otherwise>
      </c:choose>
      </div>
      <div class="row waktu-bayar justify-content-between">
        <p class="mb-0">Selesaikan pembayaran dalam waktu</p>
        <!-- countdown timer -->
        <div class="timer"><span id="remainingTime">24 : 00 : 00</span></div>
      </div>
      <div class="container container-data">
        <h3 class="judul" style="font-size: 16px; font-weight: 600;">${eventName}</h3>
        <div class="row m-0 justify-content-between">
            <h6 class="sub-judul">Organisasi <span>${eventOrganizer}</span></h6>
        </div>
        <hr class="mt-1">
        <div class="row mt-1 mx-0 justify-content-between">
          <p class="text-uppercase mt-2">Id Bayar</p>
          <div>
              <!-- Target -->
              <input id="id-tagihan" value="${paymentCode}" readonly><button class="btn btn-salin" data-clipboard-target="#id-tagihan">
                  <img src="assets/img/ic-salin.png" alt="Copy to clipboard">
              </button>
          </div>
        </div>
      <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Tagihan</p>
            <p style="color: #333;">${formattedTransactionAmount}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Biaya Layanan</p>
            <p style="color: #333;">${formattedTotalFee}</p>
          </div>
        <hr class="dotted mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase m-0">Total Pembayaran</p>
            <p class="m-0" style="color: #333; font-weight: 600;">${formattedFinalAmount}</p>
        </div>
        <div class="row min-vw-100">
          <hr class="w-100 my-4" style="border-top: 10px solid #e8e8e8;">
        </div>
        <div class="row m-0">
          <p class="mb-0">Cara Melakukan Pembayaran <a href="https://cm.narobil.id/nb/howto">Lihat Detail</a> </p>
        </div>
        <div class="row min-vw-100">
          <hr class="w-100" style="margin-top: 20px;">
      </div>
      </div>
    </main>
    <!--end main content -->

    <footer id="footer" style="display: none;">
        <p>Copyright © 2020 - Jatelindo Perkasa Abadi</p>
    </footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="assets/js/jquery-3.4.1.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/script.js"></script>
    <!-- Clipboard -->
    <script src="plugins/clipboard/js/clipboard.min.js"></script>

    <script>
  $('.btn-salin').tooltip({
        trigger: 'click',
        placement: 'bottom'
      });

      function setTooltip(message) {
        $('.btn-salin').tooltip('hide')
          .attr('data-original-title', message)
          .tooltip('show');
      }

      function hideTooltip() {
        setTimeout(function() {
          $('.btn-salin').tooltip('hide');
        }, 1000);
      }
      var clipboard = new ClipboardJS('.btn-salin');

      clipboard.on('success', function(e) {
        setTooltip('ID bayar disalin!');
        hideTooltip();
      });

      clipboard.on('error', function(e) {
        setTooltip('Gagal!');
        hideTooltip();
      });

    //   timer
    function Timer(duration, display) 
    {
        var timer = duration, hours, minutes, seconds;
        setInterval(function () {
            hours = parseInt((timer /3600)%24, 10)
            minutes = parseInt((timer / 60)%60, 10)
            seconds = parseInt(timer % 60, 10);

                    hours = hours < 10 ? "0" + hours : hours;
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            display.text(hours +" : "+minutes + " : " + seconds);

                    --timer;
        }, 1000);
    }

    jQuery(function ($) 
    {
        var twentyFourHours = 24 * 60 * 60;
        var display = $('#remainingTime');
        Timer(twentyFourHours, display);
    });
    </script>
  </body>
</html>
