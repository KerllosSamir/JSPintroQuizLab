<%--
  Created by IntelliJ IDEA.
  User: 610149
  Date: 8/9/2019
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Numbers Quiz</title>
</head>
<body>

<form method='post'>
    <h3>Have fun with NumberQuiz!</h3>
    <p>Your current score is:${sessQuiz.numCorrect}
        </br></br>
    <p>Guess the next number in the sequence!
        ${sessQuiz.currentQuestion} </p>

    <p>Your answer:<input type='number' name='txtAnswer' value=''/></p>


    <p style='color:red;visibility:${error}'>Your last answer was not correct! Please try again</p>

    <p><input type='submit' name='btnNext' value='Next'/></p>

</form>


</body>
</html>
