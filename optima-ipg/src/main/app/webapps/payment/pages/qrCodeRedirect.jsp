<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Jatelindo Payment Page - Redirect</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>   
</head>

<body onload="document.qrCodeRedirect.submit();">
	<div>
		<form id="qrCodeRedirect" name="qrCodeRedirect" role="form" class="form-horizontal" action="/payment/qrPaymentForm" method="POST" modelAttribute="transfer">								
			<input type="hidden" name="name" id="name" value="${name}" class="form-control validate">
			<input type="hidden" name="email" id="email" value="${email}" class="form-control validate">
			<input type="hidden" name="msisdn" id="msisdn" value="${msisdn}" class="form-control validate">
			<input type="hidden" name="ticketID" id="ticketID" value="${ticketID}" class="form-control validate">
			<input type="hidden" name="description" id="description" value="${description}" class="form-control validate">
			<input type="hidden" name="amount" id="amount" value="${finalAmount}" class="form-control validate">
			<input type="hidden" name="transactionAmount" id="transactionAmount" value="${transactionAmount}" class="form-control validate">
			<input type="hidden" name="totalFee" id="totalFee" value="${totalFee}" class="form-control validate">
			<input type="hidden" name="finalAmount" id="finalAmount" value="${finalAmount}" class="form-control validate">
			<input type="hidden" name="fee" id="fee" value="${fee}" class="form-control validate">
			<input type="hidden" name="city" id="city" value="${city}" class="form-control validate">
			<input type="hidden" name="postalCode" id="postalCode" value="${postalCode}" class="form-control validate">
		</form>
	</div>		    
</body>
</html>
