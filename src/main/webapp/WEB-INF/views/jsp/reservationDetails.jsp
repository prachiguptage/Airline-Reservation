
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airline Reservation System</title>
    </head>
    <body>
        <h2>Passengers Traveling</h2>
        <form:form method="POST" action="flightCheckout" modelAttribute="reservationDetails">

            <div>
                <c:if test="${not empty reservationDetails.passengers}">
                    <c:forEach  items="${reservationDetails.passengers}" var="passenger" varStatus="loopStatus">
                        <table>
                            <tr>
                                <th>
                                    <c:choose>
                                        <c:when test="${passenger.isAdult}">
                                            Adult Passenger ${loopStatus.count}
                                        </c:when>

                                        <c:otherwise >
                                            Child Passenger ${loopStatus.count}
                                        </c:otherwise>
                                    </c:choose>

                                </th>
                            </tr>
                            <tr>

                                <td><form:label path="passengers[${loopStatus.index}].firstName">First Name</form:label></td>
                                <td> <input name="passengers[${loopStatus.index}].firstName"  required="true"/></td>
                                <td><form:label path="passengers[${loopStatus.index}].lastName">Last Name</form:label></td>
                                <td><input name="passengers[${loopStatus.index}].lastName" required="true"/></td>
                            </tr>


                            <tr>
                                <td><form:label path="passengers[${loopStatus.index}].dateOfBirth">Date of Birth</form:label></td>
                                <td><input name="passengers[${loopStatus.index}].dateOfBirth" class="dateOfBirth" required="true"/></td>
                            </tr>

                            <tr>
                                <td><form:label path="passengers[${loopStatus.index}].gender">Gender</form:label></td>
                                <td><form:radiobutton path="passengers[${loopStatus.index}].gender" value="M"/> Male</td>
                                <td><form:radiobutton path="passengers[${loopStatus.index}].gender" value="F"/> Female</td>
                            </tr>


                            <tr>

                                <td><form:checkbox path="passengers[${loopStatus.index}].mealAdded" />Add Meal</td>
                                <td><form:checkbox path="passengers[${loopStatus.index}].extraLuggageAdded" /> Add Extra Luggage</td>

                            </tr>

                        </table>
                    </c:forEach>
                </c:if>
                <input type="submit" value="Continue Booking" />
            </div>
        </form:form>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

        <script>

            $(function () {
                $(".dateOfBirth").datepicker();
            });

        </script>

    </body>
</html>
