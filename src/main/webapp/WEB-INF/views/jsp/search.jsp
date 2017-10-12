<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Airlines Reservation System</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script>
            $(function () {
                $("#departureDate").datepicker();
            });
            $(function () {
                $("#returnDate").datepicker();
            });

            function ReturnDate(show) {
                if (show) {
                    document.getElementById('returnLabelCol').style.visibility = "visible";
                    document.getElementById('returnDateCol').style.visibility = "visible";
                } else {
                    document.getElementById('returnLabelCol').style.visibility = "hidden";
                    document.getElementById('returnDateCol').style.visibility = "hidden";
                    // document.getElementById('returnDate').value='01/01/1800';
                }
            }
        </script>

    </head>

    <body>
        <h2>Search Flights</h2>

        <form:form method="POST" action="search" modelAttribute="search" id="searchForm">


            <form:radiobutton path="isTwoWay" value="false" name="RoundTrip"  onclick="ReturnDate(false)"/>One Way
            <form:radiobutton path="isTwoWay" value="true"  name="RoundTrip"  checked="true" onclick="ReturnDate(true)"/>Round trip


            <table>

                <tr>
                    <td><form:label path="flyingFrom">Flying From</form:label></td>
                    <td><form:input path="flyingFrom" required="true"/></td>
                    <td><form:label path="flyingTo">Flying to</form:label></td>
                    <td><form:input path="flyingTo" required="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="departureDate">Departing</form:label></td>
                    <td><form:input path="departureDate" id="departureDate"  required="true"/></td>

                    <td id="returnLabelCol"><form:label path="returnDate">Returning</form:label></td>
                    <td id="returnDateCol"><form:input path="returnDate" id="returnDate"/></td>

                </tr>
                <tr>
                    <td><label></label></td>
                    <td><font id="dateError" style="color: red;">${dateError} 
                        </font></td>   
                </tr>
                <tr>
                    <td><form:label path="numberOfAdults">Adults</form:label></td>
                    <td><form:select path="numberOfAdults" id="dropdown1">
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="3">3</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="5">5</form:option>
                            <form:option value="6">6</form:option>
                        </form:select></td>
                    <td><form:label path="numberOfChild">Child</form:label></td>
                    <td><form:select path="numberOfChild" id="dropdown2">
                            <form:option value="0">0</form:option>
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="3">3</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="5">5</form:option>
                            <form:option value="6">6</form:option>
                        </form:select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Search" onclick="return validate()"/></td>
                </tr>
            </table>
        </form:form>
        <script>

            function validate() {
                var f = document.getElementById("searchForm");
                var departureDate = f["departureDate"].value;
                var returnDate = f["returnDate"].value;
                console.log("returnDate --> " + returnDate);
                var depDate = new Date(departureDate);
                var retDate = new Date(returnDate);
                var todayDate = new Date();
                if (returnDate === '') {
                    if ((todayDate < depDate)) {
                        f["returnDate"].value = '01/01/1800';
                        return true;
                    } else if ((todayDate > depDate)) {

                        var error = document.getElementById("dateError");
                        error.innerHTML = "Departure date is in past";
                        return false;
                    }
                } else {
                    if ((todayDate < depDate) && (retDate > depDate)) {
                        return true;
                    } else if ((todayDate > depDate)) {

                        var error = document.getElementById("dateError");
                        error.innerHTML = "Departure date is in past";
                        return false;
                    } else if ((retDate <= depDate)) {

                        var error = document.getElementById("dateError");
                        error.innerHTML = "Return Date is before or on departure date";
                        return false;
                    }


                }

            }


        </script>
    </body>
</html>