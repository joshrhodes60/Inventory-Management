package org.launchcode.inventorymanagement.controllers;

import org.launchcode.inventorymanagement.models.Product;
import org.launchcode.inventorymanagement.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddProductForm(Model model) {
        model.addAttribute(new Product());
        return "add";
    }

    @PostMapping("add")
    public String processAddProductForm(@ModelAttribute @Valid Product newProduct,
                                    Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        productRepository.save(newProduct);
        return "redirect:";
    }
    @RequestMapping(path = "view/delete/{id}")
    public String processDeleteProductForm(Model model, @PathVariable("id") String id) {

//        if (errors.hasErrors()) {
//            return "view";// handle when errors
//        }

        productRepository.deleteById(Integer.parseInt(id));
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

//    @PostMapping("/delete")
//    public String processDeleteJobForm(@RequestParameter("id") long jobId) {
//
//
//        jobRepository.deleteJob(jobId);
//        return "redirect:";
//    }

//    @RequestMapping(path = "/delete/{id}")
//    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
//            throws RecordNotFoundException
//    {
//        service.deleteEmployeeById(id);
//        return "redirect:/";
//    }


        @GetMapping("view/{productId}")
        public String displayViewProduct (Model model,@PathVariable int productId){

            Optional optProduct = productRepository.findById(productId);
            if (!optProduct.isEmpty()) {
                Product product = (Product) optProduct.get();
                model.addAttribute("product", product);
                return "view";
            } else {
                return "redirect:/";
            }
        }


}