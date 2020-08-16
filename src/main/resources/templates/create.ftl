<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>支付</title>
</head>
<body>
<div id="myQRcode">

</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
    jQuery('#myQRcode').qrcode({
        text: "${codeUrl}"
    });
</script>
</body>
</html>
