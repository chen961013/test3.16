<html>
<head>
    <title>欢迎！</title>
</head>
<body>
<h1>活动添加页</h1>
<form action="/activity/add" method="get">
<table>
    <tr>
        <td>活动名称</td>
        <td>
            <input type="text" name="name">
        </td>
    </tr>
    <tr>
        <td>活动描述</td>
        <td>
            <input type="text" name="descripton">
        </td>
    </tr>
    <tr>
        <td>开始日期</td>
        <td>
            <input type="date" name="begindt">
        </td>
    </tr>
    <tr>
        <td>结束日期</td>
        <td>
            <input type="date" name="enddt">
        </td>
    </tr>
    <tr>
        <td>销量</td>
        <td>
            <input type="number" name="total">
        </td>
    </tr>
    <tr>
        <td>状态</td>
        <td>
            <select name="status">
                <option value="">-请选择-</option>
                <option value="0">关闭</option>
                <option value="1">正常</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>商品</td>
        <td>
            <#list products as p>
                <input type="checkbox" value="${p.id}" name="ids">${p.name}
            </#list>
        </td>
    </tr>
    <tr>
        <td colspan="100">
            <button>添加</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>