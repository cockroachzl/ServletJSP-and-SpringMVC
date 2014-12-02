<%@ tag import="java.util.Date,java.time.LocalDateTime" import="java.text.DateFormat"%>
<%

/*     DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    Date now = new Date(System.currentTimeMillis());
    out.println(dateFormat.format(now)); */
    out.println(LocalDateTime.now());
%>