const express = require('express')
const app = express()

app.get('/', function (req, res) {
  console.log('GET / HEAD request received')
  res.set('Link', '<payment-method-manifest.json>; rel="payment-method-manifest"');
  res.send('Hello World!')
})

app.use(express.static('public'))

app.listen(process.env.PORT || 3000, function () {
  console.log('Example app listening!')
})
