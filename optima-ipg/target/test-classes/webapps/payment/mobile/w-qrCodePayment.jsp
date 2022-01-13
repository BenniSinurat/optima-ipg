<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
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
    <main id="content" class="wrapper" style="display: none;">
      <!-- navbar -->
      <nav class="navbar">
        <div class="container">
          <a class="navbar-brand" href="#"><img src="assets/img/logo-nav.png" alt="Narobil"></a>
        </div>
      </nav>
      <!-- end navbar -->

      <div class="container mt-4">
          <div class="card">
              <div class="card-header">
                  <div class="row m-0 justify-content-between">
                      <h3 class="judul">Pembayaran QRIS</h3>
                      <img src="assets/img/qris.png" alt="QRIS">
                  </div>
              </div>
            <div class="card-body">
                <!-- card transfer -->
                <div class="row m-0">
                    <div class="card card-transfer" style="width: 58%;">
                        <div class="card-header waktu-bayar py-0">
                            <div class="row m-0 justify-content-between">
                                <!--p class="mb-0">Selesaikan pembayaran dalam waktu</p-->
                                <!-- countdown timer -->
                                <!--div class="timer"><span id="remainingTime">24 : 00 : 00</span></div-->
                            </div>
                        </div>
                        <div class="card-body">
                            <h3 class="judul">${eventName}</h3>
                            <h6 class="sub-judul">Organisasi <span>${eventOrganizer}</span></h6>
                           
                            <hr class="mt-0">
                            <div class="row m-0 justify-content-between">
                                <p>Tagihan</p>
                                <p style="color: #333;">${formattedAmount}</p>
                            </div>
                            <hr class="mt-0">
                            <div class="row m-0 justify-content-between">
                                <p>Biaya Admin</p>
                                <p style="color: #333;">Rp 0</p>
                              </div>
                            <hr class="dotted mt-0">
                            <div class="row m-0 justify-content-between">
                                <p class="m-0">Total Pembayaran</p>
                                <p class="m-0">${formattedAmount}</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                    <!--img class="img-fluid" src="assets/img/scan-qris.png" alt="Scan QRIS"-->
                    <!--img id='barcode' style="display: block;margin-left: auto;margin-right: auto;width: 50%;" src="https://api.qrserver.com/v1/create-qr-code/?data=${qrcode}&amp;size=300x300" alt="Scan QRIS" title="Pembayaran QRIS" /-->
                    <img id='barcode' style="display: block;margin-left: auto;margin-right: auto;width: 50%;" src="http://localhost:18443/payment/qrcode?data=${qrcode}" alt="Scan QRIS" title="Pembayaran QRIS" />
                		</div>
                </div>
                <!-- end card transfer -->
                <div class="card card-pembayaran mt-4">
                    <p class="mb-0">Scan QR Code menggunakan aplikasi yang mendukung metode pembayaran QRIS</p>
                </div>
            </div>
          </div>
      </div>
    </main>
    <!--end main content -->


    <!-- footer -->
    <footer id="footer" style="display: none;" class="position-relative mt-4">
      <div class="container">
        <div class="row m-0 justify-content-between">
          <p class="mb-0">Copyright © 2020</p>
          <p class="mb-0">PT Jatelindo Perkasa Abadi</p>
        </div>
      </div>
    </footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="assets/js/jquery-3.4.1.slim.min.js"></script>
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

    $('.card-pembayaran p').css('font-size','14px');

    // hover tooltip
    $('.btn-salin').hover(function(){
      $('.tooltiptext').toggleClass('hover');
      console.log('hover');
    })
    </script>

  </body>
</html>