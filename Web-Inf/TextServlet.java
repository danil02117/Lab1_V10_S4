import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numLinesStr = request.getParameter("numLines");
        String fontSizeStr = request.getParameter("fontSize");

        if (numLinesStr != null && fontSizeStr != null) {
            int numLines = Integer.parseInt(numLinesStr);
            int fontSize = Integer.parseInt(fontSizeStr);

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Сгенерированный текст</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Сгенерированный текст:</h2>");
            out.println("<div style=\"font-size:" + fontSize + "px;\">");
            for (int i = 0; i < numLines; i++) {
                out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero.");
                out.println("<br>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<p>Параметры запроса отсутствуют или имеют неверный формат.</p>");
        }
    }
}

