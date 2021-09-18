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

    @RequestMapping(path = "view/submit/{id}")
    public String processSubmitProductForm(Model model, @PathVariable("id") String id) {


//        productRepository.(Integer.parseInt(id));
        model.addAttribute("products", productRepository.findAll());
//given the id you want to change the quantity to what you put in the submit button

        return "index";
    }



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
// REPLENISH CODE
//    if(currentQuantity < 300){
//        System.out.println("Needs restock soon!");
//    }
//       if(replinishQuantity < 200){
//        System.out.println("Refill!");
//    }
//          if(safetyStock < 100){
//        System.out.println("Refill safety stock!")
//    };



}