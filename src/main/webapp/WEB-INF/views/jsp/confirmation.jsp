

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airline Reservation System</title>
    </head>
    <body>
        <form:form method="POST" action="bookAnother" >
            <h1>Congratulations, your booking is confirmed. Your booking reference number is ${reservationDetails.bookingReferenceNumber}</h1>
            <input type="submit" value="Book another flight" />
        </form:form>  

    </body>
</html>
