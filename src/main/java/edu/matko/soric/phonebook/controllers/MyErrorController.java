package edu.matko.soric.phonebook.controllers;

import edu.matko.soric.phonebook.entities.Contact;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@Controller
public class MyErrorController implements ErrorController {

    Logger logger = LogManager.getLogger(MyErrorController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        logger.info("Error code: " + status);

        model.addAttribute("errorInfo", status);

        return "error";

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


   @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

}