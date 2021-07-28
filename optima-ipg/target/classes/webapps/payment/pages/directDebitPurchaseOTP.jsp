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
    <main id="content" style="display: none;">
      <!-- navbar -->
      <nav class="navbar">
        <div class="container">
          <a class="navbar-brand" href="#"><img src="assets/img/logo-nav.png" alt="Narobile"></a>
        </div>
      </nav>
      <!-- end navbar -->
      
      <div class="container mt-4">
		<div class="row m-0 justify-content-between">
			<h3 class="mb-0 judul" style="font-size: 16px;">Kartu Debit</h3>
			<img class="mt-n1" src="assets/img/kartu-debit.png" alt="Kartu Debit">
		</div>
	</div>

      <div class="container mt-4">
        <div class="row m-0 justify-content-between">
          <!-- card kiri -->
          <div class="card card-1">
            <div class="card-body">
              <h3 class="judul">${eventName}</h3>
              <h6 class="sub-judul">Organisasi <span>${eventOrganizer}</span></h6>
              <hr class="my-4">
              <div class="row m-0 justify-content-between">
                <p class="text-uppercase mb-0">Tagihan</p>
                <p class="total-pembayaran mb-0" style="color: #333;">${formattedTransactionAmount}</p>
              </div>
              <hr>
              <div class="row m-0 justify-content-between">
                <p class="text-uppercase mb-0">Biaya Layanan</p>
                <p class="total-pembayaran mb-0" style="color: #333;">${formattedTotalFee}</p>
              </div>
              <hr class="dotted">
              <div class="row m-0 justify-content-between">
                <p class="text-uppercase mb-0">Total Pembayaran</p>
                <p class="total-pembayaran mb-0">${formattedFinalAmount}</p>
              </div>
            </div>
          </div>
          <!-- end card kiri -->
          <!-- card kanan -->
          <div class="card card-2">
            <div class="card-body">
              <div class="alert alert-warning" role="alert">
                <p>Masukkan OTP anda di bawah ini</p> 
              </div>
              <form id="upload" class="needs-validation" role="form" action="/payment/directDebitPurchase" method="POST" modelAttribute="directdebit">
                <div class="form-group">
                    <label for="inputOTP">OTP</label>
                    <input type="text" class="form-control" id="otp" name="otp" placeholder="Masukkan OTP" aria-describedby="inputOTP" required>
                    <div class="invalid-feedback error-msg">
                        OTP tidak boleh kosong.
                    </div>
                </div>
               <div class="d-flex justify-content-end">
               	 <input id="ticketID" name="ticketID" class="form-control" type="hidden" value="${ticketID}">
               	 <input id="ticketVA" name="ticketVA" class="form-control" type="hidden" value="${ticketVA}">
               	 <input id="otpReferenceNo" name="otpReferenceNo" class="form-control" type="hidden" value="${otpReferenceNo}">
                 <a href="index.html" class="btn btn-light btn-batal">Batal</a>
                 <button type="submit" class="btn btn-info btn-submit">Lanjutkan</button>
                </div>
              </form>
            </div>
            <hr class="line-footer">
          </div>
          <!-- end card kanan -->
        </div>
      </div>
    </main>
    <!--end main content -->


    <!-- footer -->
    <footer id="footer" style="display: none;">
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
  </body>
</html>