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

<body onload="document.frm_request.submit();">
	<div>
		<form name="frm_request" id="frm_request" role="form" class="form-horizontal" action="${url}/MTIDDPortal/registration" method="post">								
			<input type="hidden" name="jwt" value="${jwt}">
			<input type="hidden" name="requestID" value="${requestID}"/>
			<input type="hidden" name="journeyID" value="${journeyID}" />
			<input type="hidden" name="tokenRequestorID" value="${tokenRequestorID}"/>
			<input type="hidden" name="merchantID" value="${merchantID}"/>
			<input type="hidden" name="terminalID" value="${terminalID}"/>
			<input type="hidden" name="language" value="ID"/>
			<input type="hidden" name="isBindAndPay" value="N"/>
			<input type="hidden" name="additionalData" id="additionalData" value="${additionalData}"/>
			<input type="hidden" name="publicKey" value="${publicKey}"/>
			<input type="hidden" name="signature" value="${signature}"/>
		</form>
	</div>		    
	
	<script type="text/javascript">
		document.getElementById("additionalData").value = '${additionalData}';
	</script> 
</body>
</html>
