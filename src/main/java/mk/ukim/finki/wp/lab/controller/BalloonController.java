package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.exceptions.BalloonDoesntExistException;
import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.BalloonService;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("balloons", balloonService.listAll());
        model.addAttribute("hasError",false);
        if(error != null){
            model.addAttribute("hasError", true);
            model.addAttribute("error",error);
        }

        return "listBalloons";
    }

    @GetMapping("/orders")
    public String allOrders(Model model, HttpServletRequest request) {
        List<Order> orderList = (List<Order>) request.getSession().getAttribute("orders");
        request.getSession().setAttribute("color", null);
        System.out.println(orderList.get(0).getBalloonColor());
        model.addAttribute("allOrders", orderList);
        return "userOrders";
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveBalloon(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("type","add");
        return "add-balloon";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBalloon(@PathVariable Long id) {
        balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getEditBalloonPage(@PathVariable Long id, Model model){

        try{
            model.addAttribute("balloon", balloonService.searchById(id).orElseThrow(BalloonDoesntExistException::new));
        }catch (Exception e){
            return "redirect:/courses?error="+e.getMessage();
        }
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("type","edit");
        return "add-balloon";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveCourse(@RequestParam(required = false) Long balloonId, @RequestParam Long manufacturerId,@RequestParam String balloonName, @RequestParam String balloonDescription) {

        try{
            if(balloonId != null){
                balloonService.editBalloon(balloonId,balloonName,balloonDescription,manufacturerService.findById(manufacturerId));
            }else{
                balloonService.addNewBalloon(balloonName, balloonDescription, manufacturerService.findById(manufacturerId));
            }
        }catch (Exception e){
            return "redirect:/balloons?error="+e.getMessage();
        }

        return "redirect:/balloons";
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addColor(@RequestParam String color, HttpServletRequest req) {

        req.getSession().setAttribute("color", color);

        return "redirect:/selectBalloon";
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        model.addAttribute("bodyContent","access_denied");
        return "master-template";
    }

}
