<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Payment Page</title>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css'>
</head>

<body>

  <div class="jumbotron text-xs-center">
  <div>
		<div align="center"><img src="image/${status}"></div>
	</div>
  <h1 class="display-3">${subject}</h1>
  <p class="lead"><strong>${description}</strong></p>
   <div align="center"><h3>Redirecting to merchant page in <span id="countdown">10</span> seconds</h3></div>
  <hr>
  	<div>
  			<div align="center">For further assistance please contact </div>
		<div align="center">Call center : 021-1234567</div>
	</div>			
 </div> 
 <div align="center"><font color="grey">Copyright(c) Jatelindo Perkasa Abadi</font></div>
 
<script src='https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js'></script>
<script type="text/javascript">
    
    // Total seconds to wait
    var seconds = 10;
    
    function countdown() {
        seconds = seconds - 1;
        if (seconds < 0) {
            // Chanage your redirection link here
            window.location = '${url}';
        } else {
            // Update remaining seconds
            document.getElementById("countdown").innerHTML = seconds;
            // Count down using javascript
            window.setTimeout("countdown()", 1000);
        }
    }
    
    // Run countdown function
    countdown();
    
</script>
  

</body>

</html>