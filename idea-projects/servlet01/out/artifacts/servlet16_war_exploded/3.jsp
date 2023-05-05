<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
choose when 固定结构 相当于
if(){

}else if(){

}else if(){

}else{

}
--%>
<c:if test="${empty param.age}">
    请输入你的年龄
</c:if>
<%--此嵌套结构是固定的--%>
<c:choose>
    <c:when test="${param.age<=20 and param.age>0}">
        你是青少年...
    </c:when>
    <c:when test="${param.age<=50}">
        你是中年人...
    </c:when>
    <c:when test="${param.age>50}">
        你是...
    </c:when>
</c:choose>