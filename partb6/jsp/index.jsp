<html>

<head>
    <title>Registration</title>
</head>

<body bgcolor="pink">
    <h1>Registration Page</font><br>
        <form action="studentinfo.jsp" method="post">
            <table>
                <tr>
                    <th>FirstName :</th>
                    <td><input type="text" name="firstName" length="30" /></td>
                <tr>
                    <th>SurName :</th>
                    <td><input type="text" name="surname" length="30" /></td>
                <tr>
                    <th>USN : </th>
                    <td><input type="text" name="usn" length="30" /></td>
                <tr>
                    <th>Course : </th>
                    <td><input type="text" name="course" length="30" /></td>
                <tr>
                    <th>Sem :</th>
                    <td><input type="text" name="sem" length="30" /></td>
                <tr>
                    <th>Age :</th>
                    <td><input type="text" name="age" length="30" /></td>
                <tr>
                    <th>Address :</th>
                    <td><input type="textarea" name="address" length="30" /></td>
            </table><input type="submit" value="submit" />
            <input type="reset" value="reset" />
        </form>
</body>

</html>