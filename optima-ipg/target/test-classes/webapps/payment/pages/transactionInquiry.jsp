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
      
      <c:choose>
         <c:when test = "${paymentChannel == 1}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">Credit Card</h3>
		          <span>
		          <img class="mt-n1" src="assets/img/visa.png" alt="Credit Card">
		          <img class="mt-n1" src="assets/img/master-card.png" alt="Credit Card">
		          <img class="mt-n1" src="assets/img/jcb.png" alt="Credit Card">
		          </span>
		        </div>
		      </div>
         </c:when>
         <c:when test = "${paymentChannel == 2}">
            <div class="container mt-4">
	            <div class="row m-0 justify-content-between">
		            <h3 class="mb-0 judul" style="font-size: 16px;">Transfer Bank</h3>
		            <img class="mt-n1" src="assets/img/bank-transfer.png" alt="Bank Transfer">
            		</div>
            	</div>
         </c:when>
         <c:when test = "${paymentChannel == 3}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">Gerai Retail</h3>
		          <img class="mt-n1" src="assets/img/alfa-indo.png" alt="Alfamart Indomaret">
		        </div>
		    </div>
         </c:when>
         <c:when test = "${paymentChannel == 4}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">QRIS</h3>
		          <img class="mt-n1" src="assets/img/qris.png" alt="QRIS">
		        </div>
		    </div>
         </c:when>
         <c:when test = "${paymentChannel == 6}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">Virtual Account</h3>
		          <img class="mt-n1" src="assets/img/bca.png" alt="Virtual Account">
		        </div>
		    </div>
         </c:when>
         <c:when test = "${paymentChannel == 7}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">LinkAja</h3>
		          <img class="mt-n1" src="assets/img/LinkAja.png" alt="LinkAja">
		        </div>
		    </div>
         </c:when>
         <c:when test = "${paymentChannel == 8}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">Kartu Debit</h3>
		          <img class="mt-n1" src="assets/img/kartu-debit.png" alt="Kartu Debit">
		        </div>
		    </div>
         </c:when>
         <c:when test = "${paymentChannel == 9}">
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">Bank Transfer</h3>
		          <img class="mt-n1" src="assets/img/permata.png" alt="Bank Transfer">
		        </div>
		    </div>
         </c:when>
         <c:otherwise>
            <div class="container mt-4">
		        <div class="row m-0 justify-content-between">
		          <h3 class="mb-0 judul" style="font-size: 16px;">Fello</h3>
		          <img class="mt-n1" src="assets/img/fello.png" alt="Fello">
		        </div>
		    </div>
         </c:otherwise>
      </c:choose>
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
            <p>Berikut ini adalah detail pembayaran anda.</p> 
        </div>
        <form id="transactionInquiry" name="transactionInquiryForm" class="needs-validation" action="/payment/transactionRedirect" method="POST" modelAttribute="transactionInquiry">
            <div class="form-group">
                <div class="row m-0 justify-content-between">
		            <p class="text-uppercase">Tagihan</p>
		            <p style="color: #333;">${formattedTransactionAmount}</p>
		        </div>
            </div>
            <div class="form-group">
              	<div class="row m-0 justify-content-between">
		            <p class="text-uppercase">Biaya Layanan</p>
		            <p style="color: #333;">${formattedTotalFee}</p>
		        </div>
           </div>
           <div class="form-group">
            		<div class="row m-0 justify-content-between">
		            <p class="text-uppercase m-0">Total Pembayaran</p>
		            <p class="m-0" style="color: #333; font-weight: 600;">${formattedFinalAmount}</p>
		        </div>
           </div>
           <!-- Credit Card -->

           <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
           <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
           <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
           <input type="hidden" name="paymentChannel" id="paymentChannel" value="${paymentChannel}" class="form-control validate">
           
           <!-- Bank Transfer and Gerai Retail-->
           <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
           <input type="hidden" name="transactionAmount" id="transactionAmount" value="${transactionAmount}" class="form-control validate">
           <input type="hidden" name="totalFee" id="totalFee" value="${totalFee}" class="form-control validate">
           <input type="hidden" name="finalAmount" id="finalAmount" value="${finalAmount}" class="form-control validate">
           
           <!-- QR Code -->
           <input type="hidden" name="city" id="city" value="${city}" class="form-control validate">
           <input type="hidden" name="postalCode" id="postalCode" value="${postalCode}" class="form-control validate">
           
           <div class="d-flex justify-content-center mt-5 mb-3 box-btn">
               <button type="submit" class="btn btn-info btn-submit">Lanjutkan</button>
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