<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="row m-0 justify-content-between">
          <h3 class="mb-0 judul" style="font-size: 16px;">QRIS</h3>
          <img class="mt-n1" src="assets/img/qris.png" alt="QRIS">
        </div>
      </div>
      <div class="row waktu-bayar mt-0 justify-content-between">
        <p class="mb-0">Selesaikan pembayaran dalam waktu</p>
        <!-- countdown timer -->
        <div class="timer"><span id="remainingTime">24 : 00 : 00</span></div>
      </div>
      <div class="container">
        <h3 class="judul" style="font-size: 16px; font-weight: 600;">${eventName}</h3>
        <div class="row m-0 justify-content-between">
            <h6 class="sub-judul">Organisasi <span class="d-inline-block text-truncate organisasi">${eventOrganizer}</span></h6>
            <a href="#" data-toggle="modal" data-target="#modal-detail" style="line-height: 33px;">Lihat detail</a>
        </div>
        <hr class="mt-1">
        <div class="row m-0 justify-content-between">
            <h6 class="text-uppercase" style="font-size: 13px;">Total Pembayaran</h6>
            <p style="font-weight: 600;">${formattedFinalAmount}</p>
        </div>
        <div class="row min-vw-100">
            <hr class="w-100 my-1" style="border-top: 10px solid #e8e8e8;">
        </div>
        <div class="card card-qris">
            <p class="mb-0">Scan QR Code menggunakan aplikasi yang mendukung metode pembayaran QRIS</p>
        </div>  
      </div>
      <div class="container qris px-0">
        <img id='barcode' style="display: block;margin-left: auto;margin-right: auto;width: 50%;" src="http://149.129.215.223/payment/qrcode?data=${qrcode}" alt="Scan QRIS" title="Pembayaran QRIS" />
    </div>
          <!-- modal detail pembayaran -->
          <div class="modal fade" id="modal-detail" tabindex="-1" role="dialog" aria-labelledby="modal-detail" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Detail Pembayaran</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <img src="assets/img/ic-close.png" alt="Close">
                  </button>
                </div>
                <div class="modal-body">
                  <div class="row m-0 justify-content-between">
                    <p class="text-uppercase">Tagihan</p>
                    <p>${formattedTransactionAmount}</p>
                  </div>
                  <hr class="mt-0">
                  <div class="row m-0 justify-content-between">
                    <p class="text-uppercase">Biaya Layanan</p>
                    <p>${formattedTotalFee}</p>
                  </div>
                  <hr class="mt-0">
                  <div class="row m-0 justify-content-between">
                    <p class="m-0 text-uppercase">Total Pembayaran</p>
                    <p class="m-0">${formattedFinalAmount}</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- end modal detail pembayaran -->
    </main>
    <!--end main content -->

    <footer class="position-relative" id="footer" style="display: none;">
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
