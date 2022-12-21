<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<form action="<c:url value='/j_spring_security_check'/>" method="POST">
    Username: <input type="text" name="j_username"/><br/>
    Password: <input type="password" name="j_password"/><br/>
    <input type="submit" value="Login"/>
</form>