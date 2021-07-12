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
        <div class="row m-0 justify-content-between">
          <!-- card kiri -->
          <div class="card card-1">
            <div class="card-body">
                <h3 class="judul">${eventName}</h3>
                <h6 class="sub-judul">Organisasi <span>${eventOrganizer}</span></h6>
                <hr class="my-4">
                <div class="row m-0 justify-content-between">
                  <p class="text-uppercase mb-0">Tagihan</p>
                  <p class="total-pembayaran mb-0" style="color: #333;">${formattedAmount}</p>
                </div>
                <hr>
                <div class="row m-0 justify-content-between">
                  <p class="text-uppercase mb-0">Biaya Admin</p>
                  <p class="total-pembayaran mb-0" style="color: #333;">Rp 0</p>
                </div>
                <hr class="dotted">
                <div class="row m-0 justify-content-between">
                  <p class="text-uppercase mb-0">Total Pembayaran</p>
                  <p class="total-pembayaran mb-0">${formattedAmount}</p>
                </div>
              </div>
          </div>
          <!-- end card kiri -->
          <!-- card kanan -->
          <div class="card card-2">
            <div class="card-header">
                <h3 class="judul">Metode Pembayaran</h3>
            </div>
            <!--select name="bankID" class="select2_single form-control" tabindex="-1" required/>
					<option value="">Select Bank</option>
				<c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
					<option name="paymentChannel" id="paymentChannel" value="${paymentChannel.id}">${paymentChannel.id}-${paymentChannel.name}</option>
				</c:forEach>
			</select>
			<p id="demo"></p-->
            <div class="card-body">
                        <form id="bankTransferPayment" name="bankTransferform" role="form" class="form-horizontal" action="${receiveURL}" method="post" modelAttribute="transfer">								
					          <input type="hidden" name="MALLID" id="MALLID" value="${mallID}" class="form-control validate">
					          <input type="hidden" name="CHAINMERCHANT" id="CHAINMERCHANT" value="NA" class="form-control validate">
					          <input type="hidden" name="AMOUNT" id="AMOUNT" value="${amount}" class="form-control validate">
					          <input type="hidden" name="PURCHASEAMOUNT" id="PURCHASEAMOUNT" value="${amount}" class="form-control validate">
							  <input type="hidden" name="TRANSIDMERCHANT" id="TRANSIDMERCHANT" value="${transID}" class="form-control validate">
					          <input type="hidden" name="WORDS" id="WORDS" value="${words}" class="form-control validate">
					          <input type="hidden" name="REQUESTDATETIME" id="REQUESTDATETIME" value="${requestDate}" class="form-control validate">
					          <input type="hidden" name="SESSIONID" id="SESSIONID" value="${sessionID}" class="form-control validate">
					          <input type="hidden" name="EMAIL" id="EMAIL" value="${email}" class="form-control validate">
					          <input type="hidden" name="NAME" id="NAME" value="${name}" class="form-control validate">
					          <input type="hidden" name="CURRENCY" id="CURRENCY" value="${currency}" class="form-control validate">
					          <input type="hidden" name="PURCHASECURRENCY" id="PURCHASECURRENCY" value="${currency}" class="form-control validate">
					          <input type="hidden" name="PAYMENTCHANNEL" id="PAYMENTCHANNEL" value="15" class="form-control validate">
					          <input type="hidden" name="BASKET" id="BASKET" value="${basket}" class="form-control validate">
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
			                            <img class="mr-4" src="assets/img/jcb.png" alt="JCB">
			                            <img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
			                        	</span></p>
							  </button>
						</form>
                  		<br>
                        <form id="bankTransferPayment" name="bankTransferform" role="form" class="form-horizontal" action="/payment/bankTransfer" method="POST" modelAttribute="transfer">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <c:forEach var="paymentChannel" items="${paymentChannel.paymentChannel}">
							  	<c:if test="${not empty paymentChannel.id}">
									<c:if test="${paymentChannel.id eq 2}">
										<input type="hidden" name="bt-channel" id="bt-channel" value="yes"  class="form-control validate">
									</c:if>
								</c:if>
							  </c:forEach>
							  <button type="submit" name="bt-submit" id="bt-submit" class="btn btn-default card card-pembayaran" style="height:55px;width:640px;display:none;"><p class="mb-0">Transfer Bank 
							      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							      <span><img class="mr-4" src="assets/img/bank-transfer.png" alt="Bank Transfer"><img src="assets/img/ic_arrow_right.png" alt="Arrow Right"></span></p>
							  </button>
					    </form>
                   		<br>
                        <form id="bankTransferPayment" name="bankTransferform" role="form" class="form-horizontal" action="/payment/retail" method="POST" modelAttribute="retail">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="paymentChannel" id="paymentChannel" value="4" class="form-control validate">
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
                            			<img class="mr-4" src="assets/img/alfa-indo.png" alt="Alfamart Indomaret">
                            			<img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
                        			</span></p>
					      	  </button>
					   	</form>
                    		<br>
                    		<form id="bankTransferPayment" name="bankTransferform" role="form" class="form-horizontal" action="/payment/qrPaymentForm" method="POST" modelAttribute="transfer">								
					          <input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
					          <input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
					          <input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					          <input type="hidden" name="fee" id="fee" value="${fee}" class="form-control validate">
					          <input type="hidden" name="city" id="amount" value="${city}" class="form-control validate">
					          <input type="hidden" name="postalCode" id="postalCode" value="${postalCode}" class="form-control validate">
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
                            			<img class="mr-4" src="assets/img/qris.png" alt="QRIS">
                            			<img src="assets/img/ic_arrow_right.png" alt="Arrow Right">
                        			</span></p>
					      	</button>
					   </form>
          </div>
          <!-- end card kanan -->
          
          <!-- BANK TRANSFER MODAL -->
		  <div class="modal fade" id="modalBankTransferForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
			 	    <div class="modal-header text-center">
						<h4 class="modal-title w-100 font-weight-bold">Bank Transfer Payment</h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						  <span aria-hidden="true">&times;</span>
						</button>
						<br />
					</div>
					<div class="modal-body mx-3">
						<form id="bankTransferPayment" name="bankTransferform" role="form" class="form-horizontal" action="/payment/bankTransfer" method="post" modelAttribute="transfer">								
					        <div class="md-form mb-5">
					          <label data-error="wrong" data-success="right" for="defaultForm-email">Your Name :</label>
					          <input type="text" name="name" id="name" class="form-control validate">
					        </div>
							<br />
					        <div class="md-form mb-5">
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Your Email :</label>
					          <input type="text" name="email" id="email" class="form-control validate">
					        </div>
					        <br />
					        <div class="md-form mb-5">
					          <label data-error="wrong" data-success="right" for="defaultForm-pass">Your Reference Number :</label>
					          <input type="text" name="msisdn" id="msisdn" class="form-control validate">
					          <input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
					          <input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
					          <input type="hidden" name="amount" id="amount" value="${amount}" class="form-control validate">
					        </div>
					        <br />
					        <div class="modal-footer d-flex justify-content-center">
					          <button type="submit" class="btn btn-primary">Process Payment</button>
					        </div>
					   	  </form>
					 </div>
				</div>
			</div>
		</div>
          
        </div>
      </div>
    </main>
    <!-- end main content -->

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
  </body>
</html>