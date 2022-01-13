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

<body onload="document.getElementById('formRedirect').submit();">
	<div>
		<form action="${paymentPageURL}?ticketID=${ticketID}" method="POST" id="formRedirect" name="formRedirect">
		</form>				
	</div>		    
</body>
</html>
