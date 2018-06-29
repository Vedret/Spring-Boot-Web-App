<%@include file="/WEB-INF/jsp/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<div class="container">
An exception occurred! Please contact Support!
</div>

 <b><%= exception %></b>

<%@include file="/WEB-INF/jsp/views/template/footer.jsp"%>