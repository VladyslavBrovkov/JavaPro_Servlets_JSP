package academy.prog;

import jakarta.servlet.http.*;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String age = request.getParameter("age");


        if (LOGIN.equals(login) && Integer.parseInt(age) > 0 && passwordComplexityChecker(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
            session.setAttribute("password", password);
            session.setAttribute("age", age);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", "incorrect");
            session.setAttribute("password", "incorrect");
            session.setAttribute("age", "incorrect");
        }
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");

        response.sendRedirect("index.jsp");
    }

    public static boolean passwordComplexityChecker(String password) {
        boolean x;
        String pat = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{10,}";
        if (password.matches(pat)) {
            return x = true;
        } else {
            return x = false;
        }
    }
}
