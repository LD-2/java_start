<html>
<head>
    <title>First-Maven-WebProject</title>
    <script type="text/javascript" src="./jquery_min_3.2.1.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function (){
        $("#show").click(function (){
            $.ajax({
                url:"/firstMaven/hello",
                type:"GET",
                async:true,
                success:function(returnJsonObj){
                    let jsonObj = JSON.parse(returnJsonObj)
                    $("#content").val(jsonObj.name)
                }
            })
        })
    })
</script>
<input type="text" id="content">
<button id="show">show</button>
</body>
</html>
