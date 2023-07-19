package com.cg.controller;

import com.cg.model.*;
import com.cg.service.customer.ICustomerService;
import com.cg.service.user.IUserService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IUserService userService;


    @GetMapping
    public String showListPage(Model model) {
        List<Customer> customers = customerService.findAll();

        model.addAttribute("customers", customers);

        String username = appUtils.getPrincipalUsername();

        User user = userService.getByUsername(username);
        Role role = user.getRole();
        String  roleCode = role.getCode();

        model.addAttribute("username", username);
        model.addAttribute("role", roleCode);

        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }


    @PostMapping("/create")
    public String doCreate(Model model, @ModelAttribute Customer customer, BindingResult bindingResult) {

        new Customer().validate(customer, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("hasError", true);
            return "customer/create";
        }

        String email = customer.getEmail();

        Boolean existsEmail = customerService.existsByEmail(email);

        if (existsEmail) {
            model.addAttribute("notValid", true);
            model.addAttribute("message", "Email đã tồn tại");
            return "customer/create";
        }

        customer.setId(null);
        customer.setBalance(BigDecimal.ZERO);
        customerService.save(customer);

        return "customer/create";
    }

}
