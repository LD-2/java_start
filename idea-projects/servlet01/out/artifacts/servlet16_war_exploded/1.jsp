<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%--核心标签库中的if标签--%>
<%--test属性是必须的 test支持el表达式 属性只能是boolean 点开看就知道了--%>
<c:if test="${empty param.username}">
    <h1>用户名不可以为空</h1>
</c:if>
<%--没有else标签的时候 就两个if即可--%>

<%--if标签中还有var属性 不是必须的--%>
<%--if标签中还有scope属性 也不是必须的 用来指定var的储存域--%>
<%--scope有四个可选值 page(pageContext域)、request(request域)、session(session域)、application(application域)--%>
<%--将var中的v储存到request中--%>
<c:if test="${not empty param.username}" var="v" scope="request">
    <h1>欢迎你: ${param.username}</h1>
</c:if>
<hr/>
${v}
<%--通过el表达式将request域中的v取出来--%>
<%--v变量存储的是test属性--%>