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

<body onload="document.creditCardRedirect.submit();">
	<div>
		<form id="creditCardRedirect" name="creditCardRedirect" role="form" class="form-horizontal" action="${receiveURL}" method="post" modelAttribute="transfer">								
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
		</form>
	</div>		    
</body>
</html>
