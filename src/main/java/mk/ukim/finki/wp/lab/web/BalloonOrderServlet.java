//Страната генерирана од овој сервлет има Submit копче кое не’ носи на сервлетот со локација /ConfirmationInfo.
//За да поставите информации во сесија, искористете: request.getSession().setAttribute(“yourAttributeName”, attributeValue)
//Прилагодете го фајлот deliveryInfo.html за изгледот на оваа страница.

package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.processing.AbstractProcessor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BallonOrder", urlPatterns = "/BalloonOrder")
public class BalloonOrderServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
//        if (req.getSession().getAttribute("color") == null){
//            springTemplateEngine.process("listBalloons.html", context, resp.getWriter());
//        }

//        context.setVariable("balloons", this.balloonService.listAll());
        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("clientName", req.getParameter("clientName"));
        req.getSession().setAttribute("clientAddress", req.getParameter("clientAddress"));
//        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
//        System.out.println(userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion());
        resp.sendRedirect("/ConfirmationInfo");
    }
}
