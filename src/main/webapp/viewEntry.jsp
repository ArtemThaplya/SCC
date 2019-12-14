<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/as3.js" type="text/javascript"></script>

<c:forEach var="listValue" items="${list}">
    <tr>
        <th>${listValue}</th>
        <th><button id="delete" type="button" onsubmit="return deleteEntry(${listValue})">Delete</button></th>
    </tr>

    <li>${listValue}</li>
</c:forEach>

