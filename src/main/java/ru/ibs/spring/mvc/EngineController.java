package ru.ibs.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class EngineController {

    @GetMapping("add")
    public String add() {
        return "add";
    }

    @PostMapping("add")
    @FuelExceptionHandle
    public String postAdd(@RequestParam("type") String type, Model model, EngineStorage engineStorage) throws Exception {
        model.addAttribute("addedText", engineStorage.getEngine(type).powerUp());
        return "show";
    }
}

