// loading page
var myVar;

function loading() {
  myVar = setTimeout(showPage, 500);
}

function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("content").style.display = "block";
  document.getElementById("footer").style.display = "block";
}