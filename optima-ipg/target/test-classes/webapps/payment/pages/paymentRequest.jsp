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
 
<script type="text/javascript">
		var DYN = (new Date%9e6).toString(36);
		
		window['COUNTER' + DYN] = 10;
		setTimeout(countDown,1000);
		
		function countDown(){
				window['COUNTER' + DYN]--;
				if(window['COUNTER' + DYN] > 0){
					setTimeout(countDown,1000);
				}
				else
				{
					$('#TEXT-CONTINUE').show();
					$('#BTN-CONTINUE').show();
				}
		}
			
		$(document).ready(function(){
			$('#TEXT-CONTINUE').hide();
			$('#BTN-CONTINUE').hide();
		});    						
</script>

</head>

<body onload="document.formRedirect.submit()">
	<div>
		<div>
			<div>
				Please wait.<br />
				Your request is being processed...<br />
				<br />
				<span id="TEXT-CONTINUE">Click button below if the page is not change</span>
			</div>
		</div>
		<form action="${paymentPageURL}?ticketID=${ticketID}" method="POST" id="formRedirect" name="formRedirect">
		<input type="submit" id="BTN-CONTINUE" value="Continue">
		</form>				
	</div>		    
</body>
</html>
