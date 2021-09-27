package org.launchcode.inventorymanagement.controllers;

import org.launchcode.inventorymanagement.models.Product;
import org.launchcode.inventorymanagement.models.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;


@Controller
public class HomeController {
    @NotNull
    @NotBlank
//    @Size(min = 1, max = 10000, message = "Invalid password. Must be between 5 and 30 characters.")
    private String quantityTaken;

    public String getQuantityTaken() {
        return quantityTaken;
    }

    public void setQuantityTaken(String quantity) {
        this.quantityTaken = quantity;
    }

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
//
//    @RequestMapping(path = "view/submit/{id}")
//    public String processSubmitProductForm(@ModelAttribute @Valid HomeController homeController,Model model, @PathVariable("id") int id) {
//
//        int number = 1;
////        productRepository.(Integer.parseInt(id));
//        model.addAttribute("products", productRepository.findAll());
////given the id you want to change the quantity to what you put in the submit button
//        Optional optProduct = productRepository.findById(id);
//        Product product = (Product) optProduct.get();
//
//        int quantity = Integer.parseInt(product.getQuantity())+10;
////        int quantity = Integer.parseInt(product.getQuantity())+ Integer.parseInt(homeController.getQuantityTaken());
//        product.setQuantity(String.valueOf(quantity));
//        productRepository.save(product);
//
//        return "index";
//
//    }

    @PostMapping("submit")
    public String processSubmitProductForm(@ModelAttribute @Valid Product newProduct,
                                        Errors errors,int id) {
        Optional optProduct = productRepository.findById(id);
        Product product = (Product) optProduct.get();
        int quantity = Integer.parseInt(product.getQuantity())+10;
//        int quantity = Integer.parseInt(product.getQuantity());
        product.setQuantity(String.valueOf(quantity));

        if (errors.hasErrors()) {
            return "submit";
        }

        productRepository.save(newProduct);
        return "redirect:";
    }






    @RequestMapping(path = "view/submit/{id}")
    public String processSubmitProductForm(Model model, @PathVariable("id") int id) {

//
//        productRepository.(Integer.parseInt(id));
        model.addAttribute("products", productRepository.findAll());
//given the id you want to change the quantity to what you put in the submit button
        Optional optProduct = productRepository.findById(id);
        Product product = (Product) optProduct.get();
        int quantity = Integer.parseInt(product.getQuantity())+10;
        product.setQuantity(String.valueOf(quantity));
        productRepository.save(product);


        return "index";

    }


        @GetMapping("view/{productId}")
        public String displayViewProduct (Model model,@PathVariable int productId){

            Optional optProduct = productRepository.findById(productId);
            if (!optProduct.isEmpty()) {
                Product product = (Product) optProduct.get();
                this.quantityTaken="1";
                model.addAttribute("product", product);
                model.addAttribute("HomeController", new HomeController());
                return "view";
            } else {
                return "redirect:/";
            }
        }



}