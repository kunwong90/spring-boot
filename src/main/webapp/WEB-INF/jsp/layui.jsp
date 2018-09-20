<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DataGrid</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/layui/css/layui.css" media="all">
    <script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"></script>
</head>
<body>
<table id="demo" lay-filter="test"></table>
</body>

<script type="text/javascript">
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '<%=request.getContextPath()%>/layuiData' //数据接口
            ,page: true //开启分页
            ,method:'post'
            ,cols: [[ //表头
                {field:'id',title:'ID',width:100},
                {field:'age',title:'age',width:100},
                {field:'cupSize',title:'cupSize',width:100,align:'right'}
            ]]
        });

    });
</script>
</html>
