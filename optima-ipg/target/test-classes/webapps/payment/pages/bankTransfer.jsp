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
                <p>Lengkapi data diri anda dibawah ini untuk mendapatkan ID Bayar</p> 
              </div>
              <form id="upload" class="needs-validation" action="" method="POST" novalidate>
                <div class="form-group">
                    <label for="inputNama">Nama</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Masukkan Nama" aria-describedby="inputNama" required>
                    <div class="invalid-feedback error-msg">
                        Nama tidak boleh kosong.
                    </div>
                </div>
                <div class="form-group">
                  <label for="inputNoTelp">No Telepon</label>
                  <input type="text" class="form-control" id="msisdn" name="msisdn" placeholder="Masukkan No Telepon" aria-describedby="inputNoTelp" required>
                  <div class="invalid-feedback error-msg">
                      No Telepon tidak boleh kosong.
                  </div>
               </div>
               <div class="form-group">
                <label for="inputEmail">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="example@gmail.com" aria-describedby="inputEmail" required>
                <div class="invalid-feedback error-msg">
                    Email tidak boleh kosong.
                </div>
               </div>
               <div class="d-flex justify-content-end">
               	 <input id="ticketID" name="ticketID" class="form-control" type="hidden" value="${ticketID}">
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
    <script>
      $("#inputNoTelp").keypress(function(event) {
        return /\d/.test(String.fromCharCode(event.keyCode));
      });
      $('input').val('');
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';
        window.addEventListener('load', function() {

          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');
          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
                $('#content').css('padding-bottom','80px');
                // $('footer').css('position','relative');
              }
              form.classList.add('was-validated');
              if(form.checkValidity() == true){
                event.preventDefault();
                event.stopPropagation();
                window.location.replace("metode-pembayaran.html");
              }
            }, false);
          });
        }, false);
      })();
    </script>
  </body>
</html>