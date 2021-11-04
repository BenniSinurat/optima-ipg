<!doctype html>
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
          <h3 class="mb-0 judul" style="font-size: 16px;">Kartu Debit</h3>
          <img class="mt-n1" src="assets/img/kartu-debit.png" alt="Kartu Debit">
        </div>
      </div>
      <div class="row waktu-bayar justify-content-between">
        <p class="mb-0"></p>
      </div>
      
      <div class="container container-data">
        <div class="alert alert-warning" role="alert">
            <p>Transaksi berhasil, berikut detail transaksi anda.</p> 
        </div>
        <h3 class="judul" style="font-size: 16px; font-weight: 600;">${eventName}</h3>
        <div class="row m-0 justify-content-between">
            <h6 class="sub-judul">Organisasi <span>${eventOrganizer}</span></h6>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Akun Fello</p>
            <p style="color: #333;">${msisdn}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Tanggal Transaksi</p>
            <p style="color: #333;">${transactionDate}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Nomor Transaksi</p>
            <p style="color: #333;">${transactionNumber}</p>
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

    </script>
    
  </body>
</html>
