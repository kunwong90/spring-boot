<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DataGrid</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/themes/demo.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg"></table>
</body>

<script type="text/javascript">
    $(function () {

        $('#dg').datagrid({
            url:'<%=request.getContextPath()%>/getPageList',
            columns:[[
                {field:'id',title:'ID',width:100},
                {field:'age',title:'age',width:100},
                {field:'cupSize',title:'cupSize',width:100,align:'right'}
            ]],
            pagination:true
        });
    });
</script>
</html>
