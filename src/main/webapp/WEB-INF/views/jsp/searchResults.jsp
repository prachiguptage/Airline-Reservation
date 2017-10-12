

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airlines Reservation System</title>
    </head>
    <body><form:form method="POST" action="selectFlight" modelAttribute="searchResults" id="flightSearchResultForm">
            <div>
                <c:choose>
                    <c:when test="${not empty searchResults.searchedFlights}">

                        <ul>
                            <c:forEach var="variable" items="${searchResults.searchedFlights}" varStatus="loopStatus">


                                <li style="list-style-type: none; padding-bottom: 2em">
                                    <form:input type = "hidden" id="${variable.flightSearchResultId}" path="selectedSearchResult" 
                                                /> 
                                    <table style="border-width: 1px;border-style: solid;border-color: black; ">
                                        <tr>
                                            <th>
                                                <c:choose>
                                                    <c:when test="${ret!='0'}">
                                                        <c:set var="total" value="${variable.departureFlightDetails.flightPrice + variable.returnFlightDetails.flightPrice}"/>
                                                        ${variable.departureFlightDetails.flightPrice}+${variable.returnFlightDetails.flightPrice}=${total}
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${variable.departureFlightDetails.flightPrice}
                                                    </c:otherwise>
                                                </c:choose>

                                            </th>
                                            <td style="padding-left: 5em; align-content: right">
                                                <input type="button" value="Select Flight" onclick='selectFlight("${variable.flightSearchResultId}")'>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="<c:url value="/resources/core/img/images.jpg"/>" alt="Flight" width="70" height="50" />
                                            </td>
                                            <td>
                                                ${variable.departureFlightDetails.flightId}
                                            </td>

                                            <td>
                                                ${variable.departureFlightDetails.flightAndAirlineName}
                                            </td>
                                            <td style="padding-left: 5em">
                                                ${variable.departureFlightDetails.flightTime}<br>
                                                ${variable.departureFlightDetails.from}
                                            </td>
                                            <td style="padding-left: 5em">
                                                ${variable.departureFlightDetails.to}

                                            </td>
                                            <td style="padding-left: 5em">
                                                ${variable.departureFlightDetails.flightDuration} 
                                            </td>
                                            <td style="padding-left: 5em">
                                                ${variable.departureFlightDetails.flightPrice} 
                                            </td>
                                            <td></td>

                                        </tr>


                                        <c:if test="${not empty variable.returnFlightDetails}">

                                            <tr>
                                                <td>
                                                    <img src="<c:url value="/resources/core/img/images.jpg"/>" alt="Flight" width="70" height="50" />
                                                </td>
                                                <td>
                                                    ${variable.returnFlightDetails.flightId}
                                                </td>

                                                <td>
                                                    ${variable.returnFlightDetails.flightAndAirlineName}
                                                </td>
                                                <td style="padding-left: 5em">
                                                    ${variable.returnFlightDetails.flightTime}<br><br>
                                                    ${variable.returnFlightDetails.from}
                                                </td>
                                                <td style="padding-left: 5em">

                                                    ${variable.returnFlightDetails.to}
                                                </td>
                                                <td style="padding-left: 5em">
                                                    ${variable.returnFlightDetails.flightDuration} 
                                                </td>
                                                <td style="padding-left: 5em">
                                                    ${variable.returnFlightDetails.flightPrice} 
                                                </td>
                                                <td></td>

                                            </tr>
                                        </c:if>


                                    </table>

                                    <!--<input type="submit" value="Search" />-->

                                </li>
                            </c:forEach>
                        </ul>

                    </c:when>
                    <c:otherwise>
                        No flights found.
                        <input type="button" value="Search Again" onclick='searchAgain()'>

                    </c:otherwise>
                </c:choose>
            </div>
        </form:form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>
                            function selectFlight(flightId)
                            {

                                console.log("flightId --> " + flightId);
                                var buttonId = "#button" + flightId;
                                console.log(buttonId);
                                console.log($(flightId));
                                $("#" + flightId).val(flightId);
                                $("#flightSearchResultForm").submit();

                            }

                            function searchAgain()
                            {
                                $("#flightSearchResultForm").submit();
                            }
        </script>
    </body>
</html>
