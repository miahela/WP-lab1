package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/balloons")
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

    @GetMapping("/add")
    public String saveBalloon(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        model.addAttribute("type","add");
        return "add-balloon";
    }

    @GetMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {
        balloonService.deleteById(id);
        return "redirect:/balloons";
    }

}
