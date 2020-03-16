<html>
<head>
    <title>欢迎！</title>
</head>

<body>

    <h1>活动列表页</h1>
<form action="/activity/list" method="get">
    <#if vo.s??>
        开始时间<input type="text" name="s" value="${vo.s}">-
        <#else>
            <input type="text" name="s">-
    </#if>
    <#if vo.e??>
        结束时间<input type="text" name="e" value="${vo.e}">
    <#else>
        <input type="text" name="e">
    </#if>


    <button>查询</button>
</form>
<form action="/activity/torem" method="post">
    <a href="/activity/toadd">添加</a>
    <button>删除</button>
    <table border="1">
        <tr>
            <th>全选<input type="checkbox" onclick="qx()" id="cls"></th>
            <th>活动名称</th>
            <th>活动描述</th>
            <th>开始日期</th>
            <th>结束日期</th>
            <th>预计销量</th>
            <th>状态</th>
            <th>商品列表</th>
            <th>操作</th>
        </tr>
        <#list vos as vo>
            <tr>
                <td><input type="checkbox" name="ids" value="${vo.id}"></td>
                <td>${vo.name}</td>
                <td>${vo.descripton}</td>
                <td>${vo.begindt?date}</td>
                <td>${vo.enddt?date}</td>
                <td>${vo.total}</td>
                <td>
                    <#if vo.status==0>
                        关闭
                        <#else >
                        正常
                    </#if>
                </td>
                <td>${vo.good_name}</td>
                <td><a href="/activity/toupdate?id=${vo.id}">修改</a></td>
            </tr>
        </#list>
    </table>
    <a href="/activity/list?current=1">首页</a>
    <#if page.current-1 &gt; 0>
        <a href="/activity/list?current=1">上一页</a>

        <#else >
            <a href="/activity/list?current=${page.current-1}">上一页</a>
    </#if>
    <#if page.current+1 &lt; pages>
        <a href="/activity/list?current=${pages}">上一页</a>

    <#else >
        <a href="/activity/list?current=${page.current+1}">下一页</a>
    </#if>
    <a href="/activity/list?current=${pages}">尾页</a>
</form>
</body>
</html>