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
            <!--a href="#" data-toggle="modal" data-target="#modal-detail" style="line-height: 33px;">Lihat detail</a-->
        </div>
        <hr class="mt-0">
        <!--div class="row m-0 justify-content-between">
            <h6 class="text-uppercase" style="font-size: 13px;">Total Pembayaran</h6>
            <p style="font-weight: 600;">${formattedAmount}</p>
        </div-->
        <div class="row min-vw-100">
            <hr class="w-100 my-1" style="border-top: 10px solid #e8e8e8;">
        </div>
        <h6 class="my-3" style="font-size: 16px;color: #333;">Metode Pembayaran</h6>

            <div class="row m-0 justify-content-between">
            		<form id="bankTransferPayment" name="bankTransferform" role="form" class="form-horizontal" action="/payment/transactionInquiry" method="POST" modelAttribute="transactionInquiry">								
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="1" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
							  <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 1}">
										<input type="hidden" name="cc-channel" id="cc-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
							  <button type="submit" name="cc-submit" id="cc-submit" class="btn btn-default card card-pembayaran" data-toggle="modal" style="height:55px;width:640px;display:none;"><p class="mb-0">Kartu Kredit
								    <span>
			                            <img class="mr-1" src="assets/img/visa.png" alt="Visa">
					                    <img class="mr-1" src="assets/img/master-card.png" alt="Master Card">
					                    <img class="mr-2" src="assets/img/jcb.png" alt="JCB">
					                    <img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
			                        	</span></p>
							  </button>
						</form>
            </div>
            <br>
            <div class="row m-0 justify-content-between">
            		<form id="bankTransferPaymentMandiri" name="bankTransferform" role="form" class="form-horizontal" action="/payment/transactionInquiry" method="POST" modelAttribute="transactionInquiry">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="2" class="form-control validate">
					          <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 2}">
										<input type="hidden" name="bt-channel" id="bt-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
							  <button type="submit" name="bt-submit" id="bt-submit" class="btn btn-default card card-pembayaran" style="height:55px;width:640px;display:none;"><p class="mb-0">Transfer Bank 
							      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							      <span><img class="mr-2" src="assets/img/bank-transfer.png" alt="Bank Transfer">
                    						<img src="assets/img/ic_arrow_right.png" alt="Arrow Right"></span></p>
							  </button>
				</form>
            </div>
            <br>
            <div class="row m-0 justify-content-between">
            		<form id="bankTransferPaymentBca" name="bankTransferform" role="form" class="form-horizontal" action="/payment/transactionInquiry" method="POST" modelAttribute="transactionInquiry">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="6" class="form-control validate">
					          <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 6}">
										<input type="hidden" name="btb-channel" id="btb-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
							  <button type="submit" name="btb-submit" id="btb-submit" class="btn btn-default card card-pembayaran" style="height:55px;width:640px;display:none;"><p class="mb-0">Transfer Bank
							      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							      <span><img class="mr-2" src="assets/img/bca.png" alt="Bank Transfer">
                    						<img src="assets/img/ic_arrow_right.png" alt="Arrow Right"></span></p>
							  </button>
				</form>
            </div>
            <br>
            <div class="row m-0 justify-content-between">
            		<form id="geraiRetailPayment" name="geraiRetailform" role="form" class="form-horizontal" action="/payment/transactionInquiry" method="POST" modelAttribute="transactionInquiry">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="3" class="form-control validate">
					          <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 3}">
										<input type="hidden" name="rt-channel" id="rt-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
					      	  <button type="submit" name="rt-submit" id="rt-submit" class="btn btn-default card card-pembayaran" data-toggle="modal" style="height:55px;width:640px;display:none;"><p class="mb-0">Gerai Retail
					      		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					      		<span>
                            			<img class="mr-2" src="assets/img/alfa-indo.png" alt="Alfamart Indomaret">
                   					<img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
                        			</span></p>
					      	  </button>
					   	</form>
            </div>
            <br>
            <div class="row m-0 justify-content-between">
            		<form id="qrPayment" name="qrForm" role="form" class="form-horizontal" action="/payment/transactionInquiry" method="POST" modelAttribute="transactionInquiry">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="fee" id="fee" value="${fee}" class="form-control validate">
					          <input type="hidden" name="city" id="amount" value="${city}" class="form-control validate">
					          <input type="hidden" name="postalCode" id="postalCode" value="${postalCode}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="4" class="form-control validate">
					      	  <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 4}">
										<input type="hidden" name="qr-channel" id="qr-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
					      	  <button type="submit" name="qr-submit" id="qr-submit" class="btn btn-default card card-pembayaran" data-toggle="modal" style="height:55px;width:640px;display:none;"><p class="mb-0">Pembayaran QRIS
					      		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					      		<span>
                            			<img class="mr-2" src="assets/img/qris.png" alt="QRIS">
                    					<img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
                        			</span></p>
					      	</button>
				</form>
        		</div>
        		<br>
            <div class="row m-0 justify-content-between">
            		<form id="felloPayment" name="felloForm" role="form" class="form-horizontal" action="/payment/transactionInquiry" method="POST" modelAttribute="transactionInquiry">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="5" class="form-control validate">
					          <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 5}">
										<input type="hidden" name="f-channel" id="f-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
					      	  <button type="submit" name="f-submit" id="f-submit" class="btn btn-default card card-pembayaran" data-toggle="modal" style="height:55px;width:640px;display:none;"><p class="mb-0">Fello
					      		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					      		<span>
                            			<img class="mr-2" src="assets/img/fello.png" alt="Fello">
                   					<img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
                        			</span></p>
					      	  </button>
					   	</form>
            </div>
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
    
	<script type="text/javascript">
    		var a = document.getElementById("cc-channel").value;
  		//document.getElementById("demo").innerHTML = x;
    		console.log(a);
    		
    		if(a == 'yes') {
			document.getElementById("cc-submit").style.display = "block";
		}else{
			document.getElementById("cc-submit").style.display = "none";
		}
	</script>
	
	<script type="text/javascript">	
		var b = document.getElementById("bt-channel").value;
    		console.log(b);
    		
    		if(b == 'yes') {
			document.getElementById("bt-submit").style.display = "block";
		}else{
			document.getElementById("bt-submit").style.display = "none";
		}
    </script>
    
    <script type="text/javascript">	
		var b = document.getElementById("btb-channel").value;
    		console.log(b);
    		
    		if(b == 'yes') {
			document.getElementById("btb-submit").style.display = "block";
		}else{
			document.getElementById("btb-submit").style.display = "none";
		}
    </script>
    
    <script type="text/javascript">	
		var c = document.getElementById("rt-channel").value;
    		console.log(c);
    		
    		if(c == 'yes') {
			document.getElementById("rt-submit").style.display = "block";
		}else{
			document.getElementById("rt-submit").style.display = "none";
		}
    </script>
    
    <script type="text/javascript">	
		var d = document.getElementById("qr-channel").value;
    		console.log(d);
    		
    		if(d == 'yes') {
			document.getElementById("qr-submit").style.display = "block";
		}else{
			document.getElementById("qr-submit").style.display = "none";
		}
    </script>
    
    <script type="text/javascript">	
		var d = document.getElementById("f-channel").value;
    		console.log(d);
    		
    		if(d == 'yes') {
			document.getElementById("f-submit").style.display = "block";
		}else{
			document.getElementById("f-submit").style.display = "none";
		}
    </script>

  </body>
</html>