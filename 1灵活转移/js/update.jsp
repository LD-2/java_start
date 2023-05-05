<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <title>修改</title>
    <link rel="stylesheet" href="update.css">
</head>

<body>
    <div class="container">
        <div class="update-box">
            <h2>Update</h2>
            <form action="/list.html" method="get">
                <div class="row">
                    <input type="text" id="dno" value="depno">
                    <label for="dno">部门编号</label>
                </div>
                <div class="row">
                    <input type="text" id="dna" value="dname">
                    <label for="dna">部门名称</label>
                </div>
                <div class="row">
                    <input type="text" id="lc" value="loc">
                    <label for="lc">地理位置</label>
                </div>
                <div class="sb">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <input type="submit" value="修改">
                </div>
            </form>
        </div>
    </div>

</body>

</html>