package w3d5.JSPQuizLab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "NumberQuizServlet", value = "/NumberQuiz")
public class NumberQuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Quiz quiz = (Quiz) request.getSession().getAttribute("sessQuiz");
        String answer = request.getParameter("txtAnswer");

        request.setAttribute("error", "block");

         if (answer != null && answer != "" && quiz.getCurrentAnswr() == Integer.parseInt(answer)) {

            request.setAttribute("error", "hidden");
            quiz.increaseQuizIndex();
            quiz.increaseScore();
        }

        if (quiz.getCurrentQuestion() != "") {
            request.getRequestDispatcher("/Quize.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/QuizOver.jsp").forward(request, response);
        }

        request.getSession().setAttribute("sessQuiz", quiz);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Quiz quiz = new Quiz();
        request.getSession().setAttribute("sessQuiz", quiz);
        request.setAttribute("error", "hidden");
        request.getRequestDispatcher("/Quize.jsp").forward(request, response);
    }
}
