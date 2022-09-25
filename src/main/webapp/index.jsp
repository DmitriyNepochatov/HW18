<%@ page import="ua.com.alevel.model.Request" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%List<Request> requestRepository = (ArrayList<Request>) request.getAttribute("request-repository");%>
<!DOCTYPE html>
<html>
<head>
    <title>IP list</title>
    <style>
        table {
            border: 1px solid black;
            width: 600px;
        }

        td {
            height: 40px;
            width: 200px;
            border: 0.5px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>IP address</td>
        <td>user-agent</td>
        <td>created</td>
    </tr>
    <%Request requestMain = requestRepository.get(requestRepository.size() - 1);%>
    <tr>
        <td style="font-weight: bold;"><%out.println(requestMain.getIp());%></td>
        <td style="font-weight: bold;"><%out.println(requestMain.getUserAgent());%></td>
        <td style="font-weight: bold;"><%out.println(requestMain.getCreated());%></td>
    </tr>

    <%for (Request userRequest : requestRepository) {%>
    <tr>
        <%if (!userRequest.equals(requestRepository.get(requestRepository.size() - 1))) {%>
            <td><%out.println(userRequest.getIp());%></td>
            <td><%out.println(userRequest.getUserAgent());%></td>
            <td><%out.println(userRequest.getCreated());%></td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>