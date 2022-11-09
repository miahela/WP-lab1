//Овој сервлет треба да го испечати пребарувачот и оперативниот систем на корисникот, неговото име, адреса, бојата и големината на балонот кој го избрал корисникот.
//Копчето Log out треба да ја поништи тековната сесија на корисникот и да го редиректира на првата страница /.
//Прилагодете го фајлот confirmationInfo.html за изгледот на оваа страница.

package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("balloons", this.balloonService.listAll());
        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("");
    }
}