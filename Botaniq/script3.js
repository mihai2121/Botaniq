function myfunction(e) {
   var x = event.charCode || event.keyCode;
    if (x == 13) { // 
var planta = document.getElementById('x0').value;
alert(planta);
}
  var text1 = '';
  $.ajax({
    type: 'GET',
    url: 'http://79.118.89.209:8080/botaniq/webapi/plant/'+planta,
    data: '{}',
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    success: function (data) {

text1 = '<table border=1>';
text1 +='<tr><td><img src="'+ data.image + '"></td></tr>';
text1 +='<tr><td>Scientific Name </td><td><b>' + data.scientificName + '</b></td></tr>';
text1 +='<tr><td>Description </td><td><b>' + data.abstractd + '</b></td></tr>';
text1 +='<tr><td>Division </td><td><b>' + data.division + '</b></td></tr>';
text1 +='<tr><td>Class </td><td><b>' + data.classd + '</b></td></tr>';
text1 +='<tr><td>Order </td><td><b>' + data.order + '</b></td></tr>';
text1 +='<tr><td>Family </td><td><b>' + data.family + '</b></td></tr>';
text1 +='<tr><td>genus </td><td><b>' + data.genus + '</b></td></tr>';
text1 +='<tr><td>More things </td><td><a href="https://en.wikipedia.org/wiki/' + data.linkWiki + '">more</a></td></tr>';
text1 +='<tr><td>Common name </td><td><b>' + data.commonName + '</b></td></tr>';
text1 += '</table>';
      document.getElementById('x1').innerHTML = text1;
 
    }
  });
}


