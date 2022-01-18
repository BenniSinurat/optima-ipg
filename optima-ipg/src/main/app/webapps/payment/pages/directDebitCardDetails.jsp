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
		   <div class="row m-0 justify-content-between">
		        <h3 class="mb-0 judul" style="font-size: 16px;">Kartu Debit</h3>
		        <img class="mt-n1" src="assets/img/kartu-debit.png" alt="Kartu Debit">
		   </div>
	  </div>
         
	  <hr class="mt-0">
      <div class="container container-data mt-3" style="padding-bottom: 10vh">
        <h3 class="judul">${eventName}</h3>
        <div class="row m-0 justify-content-between">
            <h6 class="sub-judul">Organisasi <span class="d-inline-block text-truncate organisasi">${eventOrganizer}</span></h6>
        </div>
        <hr class="mt-0">
        <div class="row min-vw-100">
            <hr class="w-100 my-1 line" style="border-top: 10px solid #e8e8e8;">
        </div>
        <div class="alert alert-warning" role="alert">
            <p>Detail Kartu Anda</p> 
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Akun Fello</p>
            <p style="color: #333;">${msisdn}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Nomor Kartu</p>
            <p style="color: #333;">**** **** **** ${debitCard.maskedCardNumber}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Masa Berlaku</p>
            <p style="color: #333;">${debitCard.expiredDate}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Kode Bank</p>
            <p style="color: #333;">${debitCard.bankCode}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <p class="text-uppercase">Nama Bank</p>
            <p style="color: #333;">${debitCard.bankName}</p>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <a href="${limitURL}?msisdn=${msisdn}&merchantID=${merchantID}" class="btn btn-light btn-batal">Set Limit Kartu</a>
        </div>
        <hr class="mt-0">
        <div class="row m-0 justify-content-between">
            <a href="${deleteURL}?msisdn=${msisdn}&merchantID=${merchantID}" class="btn btn-light btn-batal">Hapus Kartu</a>
        </div>
        
         <hr class="mt-0">
        <form id="directDebitRedirectForm" name="directDebitRedirectForm" class="needs-validation" action="/payment/directDebitPurchaseForm" method="POST" modelAttribute="directdebit">
           <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
			<input type="hidden" name="paymentChannel" id="paymentChannel" value="${paymentChannel}" class="form-control validate">
          
           <div class="d-flex justify-content-center mt-5 mb-3 box-btn">
               <button type="submit" class="btn btn-info btn-submit">Lanjutkan Transaksi</button>
           </div>
         </form>
      </div>
      
    </main>
    <!--end main content -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="assets/js/jquery-3.4.1.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/script.js"></script>
    
  </body>
</html>