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
		<form id="directDebitCallbackRedirect" name="directDebitCallbackRedirect" role="form" class="form-horizontal" action="${redirectURL}" method="POST">								
			<input type="hidden" name="merchantID" value="${merchantID}">
			<input type="hidden" name="eventOrganizer" value="${eventOrganizer}">
			<input type="hidden" name="transactionAmount" value="${transactionAmount}">
			<input type="hidden" name="formattedTransactionAmount" value="${formattedTransactionAmount}">
			<input type="hidden" name="totalFee" value="${totalFee}">
			<input type="hidden" name="formattedTotalFee" value="${formattedTotalFee}">
			<input type="hidden" name="finalAmount" value="${finalAmount}">
			<input type="hidden" name="formattedFinalAmount" value="${formattedFinalAmount}">
			<input type="hidden" name="transactionNumber" value="${transactionNumber}">
			<input type="hidden" name="transactionDate" value="${transactionDate}">
			<input type="hidden" name="msisdn" value="${msisdn}">
			<input type="hidden" name="description" value="${description}">
			<input type="hidden" name="transactionDescription" value="${transactionDescription}">
			<input type="hidden" name="status" value="${status}">
		</form>
	</div>		    
</body>
</html>
