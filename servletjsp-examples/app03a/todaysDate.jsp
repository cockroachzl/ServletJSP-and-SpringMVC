<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDateTime" %>
<html>
<!-- HTML title -->
<head><title>Today's date</title></head>
<body>
<%-- JSP comments --%>
<%
    DateFormat dateFormat = 
            DateFormat.getDateInstance(DateFormat.LONG);
    String s = dateFormat.format(new Date());
    //print today
    out.println("Today is " + s);
    out.println("Tomorrow is " + LocalDateTime.now().plusDays(1));
%>
</body>
</html>