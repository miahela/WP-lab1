//Страната генерирана од овој сервлет има Submit копче кое не’ носи на сервлетот со локација /ConfirmationInfo.
//За да поставите информации во сесија, искористете: request.getSession().setAttribute(“yourAttributeName”, attributeValue)
//Прилагодете го фајлот deliveryInfo.html за изгледот на оваа страница.

package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Order;
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
import java.util.ArrayList;
import java.util.List;

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
        WebContext context = new WebContext(req,resp,req.getSession().getServletContext());
        context.setVariable("color", req.getSession().getAttribute(("color")));
        context.setVariable("size", req.getSession().getAttribute(("size")));
        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("clientName", req.getParameter("clientName"));
        req.getSession().setAttribute("clientAddress", req.getParameter("clientAddress"));
        List<Order> orderArrayList;
        if(req.getSession().getAttribute("orders") == null) {
            orderArrayList = new ArrayList<>();
        } else {
            orderArrayList = (ArrayList<Order>) req.getSession().getAttribute("orders");
            System.out.println(orderArrayList);
        }
        orderArrayList.add(new Order( (String) req.getSession().getAttribute(("color")),(String) req.getSession().getAttribute(("size")), req.getParameter("clientName"), req.getParameter("clientAddress")));
        req.getSession().setAttribute("orders", orderArrayList);

        resp.sendRedirect("/ConfirmationInfo");
    }
}
