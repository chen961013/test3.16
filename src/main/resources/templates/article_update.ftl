<html>
<head>
    <title>欢迎！</title>
</head>
<body>
<h1>活动添加页</h1>
<form action="/activity/update" method="get">
    <input type="text" hidden="hidden" name="id" value="${vo.id}" >
    <table>
        <tr>
            <td>活动名称</td>
            <td>
                <input type="text" name="name" value="${vo.name}">
            </td>
        </tr>
        <tr>
            <td>活动描述</td>
            <td>
                <input type="text" name="descripton" value="${vo.descripton}">
            </td>
        </tr>
        <tr>
            <td>开始日期</td>
            <td>
                <input type="text" name="begindt" value="${vo.begindt?date}">
            </td>
        </tr>
        <tr>
            <td>结束日期</td>
            <td>
                <input type="text" name="enddt" value="${vo.enddt?date}">
            </td>
        </tr>
        <tr>
            <td>销量</td>
            <td>
                <input type="text" name="s_total" value="${vo.total}">
            </td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <select name="status">

                    <option value="0" <#if vo.status == 0>selected="selected"</#if>>关闭</option>
                    <option value="1" <#if vo.status == 1>selected="selected"</#if>>正常</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>商品</td>
            <td>
                <#list products as p>

                    <input type="checkbox" value="${p.id}" name="ids"<#list goods as g> <#if p.name == g>checked="checked"</#if></#list> >${p.name}

                </#list>
            </td>
        </tr>
        <tr>
            <td colspan="100">
                <button>修改</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>