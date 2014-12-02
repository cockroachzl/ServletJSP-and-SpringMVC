<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag import="java.util.Date,java.text.DateFormat,java.time.*,java.time.format.*"%>
<%@ variable name-given="longDate" %>
<%@ variable name-given="shortDate" %>
<%
	/*     Date now = new Date(System.currentTimeMillis());
    DateFormat longFormat = DateFormat.getDateInstance(DateFormat.LONG);
    DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    jspContext.setAttribute("longDate", longFormat.format(now));
    jspContext.setAttribute("shortDate", shortFormat.format(now)); */
	LocalDateTime now = LocalDateTime.now();
	String longDateString = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(now);
	String shortDateString = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(now);
/* 	jspContext.setAttribute("longDate", longDateString);
	jspContext.setAttribute("shortDate", shortDateString); */
%>
<c:set var="longDate" value="abc" scope="page"/>
<c:set var="shortDate" value="${shortDateString}"/>
<jsp:doBody/>