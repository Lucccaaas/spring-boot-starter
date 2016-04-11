var express = require('express');
var app = express();


app.use(express.static('public'));

app.listen(9090, function () {
  console.log('server listening on 9090!') ;
});