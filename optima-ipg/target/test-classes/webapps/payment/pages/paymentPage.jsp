<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
          <a class="navbar-brand" href="#"><img src="assets/img/logo-nav.png" alt="Narobil" width="32px"></a>
      </nav>
      <!-- end navbar -->

      <div class="container mt-3">
        <h3 class="judul">${eventName}</h3>
        <div class="row m-0 justify-content-between">
            <h6 class="sub-judul">Organisasi <span class="d-inline-block text-truncate organisasi">${eventOrganizer}</span></h6>
        </div>
        <hr class="mt-0">
        <div class="row min-vw-100">
            <hr class="w-100 my-1" style="border-top: 10px solid #e8e8e8;">
        </div>
        <h6 class="my-3" style="font-size: 16px;color: #333;">Metode Pembayaran</h6>
        <c:forEach var="menuValue" items="${paymentChannel}">
        		<div class="menu_section">${menuValue}</div>
		</c:forEach>
            
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
                <p>${formattedAmount}</p>
              </div>
              <hr class="mt-0">
              <div class="row m-0 justify-content-between">
                <p class="text-uppercase">Biaya Layanan</p>
                <p>Rp 0</p>
              </div>
              <hr class="mt-0">
              <div class="row m-0 justify-content-between">
                <p class="m-0 text-uppercase">Total Pembayaran</p>
                <p class="m-0">${formattedAmount}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- end modal detail pembayaran -->
      
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

  </body>
</html>