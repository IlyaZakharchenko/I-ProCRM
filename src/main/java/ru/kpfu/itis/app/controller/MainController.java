package ru.kpfu.itis.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.app.service.ClientService;

@Controller
public class MainController {

    private ClientService service;

    public MainController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getClients(Model model) {
        service.addClient("Ivanov Ivan Ivanovich", null, null, null);
        model.addAttribute("clients", service.getAllClients());

        return "main";
    }
}
