<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Jatelindo Payment Page - Redirect</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>   
</head>

<body onload="document.getElementById('directDebitCallbackRedirect').submit();">
	<div>
		<form id="directDebitCallbackRedirect" name="directDebitCallbackRedirect" role="form" class="form-horizontal" action="/payment/merchantRedirection" method="POST">								
			<input type="hidden" name="merchantID" value="${merchantID}">
			<input type="hidden" name="invoiceID" value="${invoiceID}">
			<input type="hidden" name="amount" value="${amount}">
			<input type="hidden" name="sessionID" value="${sessionID}">
			<input type="hidden" name="eventID" value="${eventID}">
			<input type="hidden" name="currency" value="${currency}">
			<input type="hidden" name="paymentChannel" value="${paymentChannel}">
			<input type="hidden" name="ticketID" value="${ticketID}">
			<input type="hidden" name="transactionNumber" value="${transactionNumber}">
			<input type="hidden" name="name" value="${name}">
			<input type="hidden" name="email" value="${email}">
			<input type="hidden" name="msisdn" value="${msisdn}">
			<input type="hidden" name="description" value="${description}">
			<input type="hidden" name="words" value="${words}">
			<input type="hidden" name="status" value="${status}">
			<input type="hidden" name="fee" value="${fee}">
			<input type="hidden" name="city" value="${city}">
			<input type="hidden" name="postalCode" value="${postalCode}">
		</form>
	</div>		    
</body>
</html>
