package com.musicstorewebsite.controller;

import com.musicstorewebsite.model.Customer;
import com.musicstorewebsite.model.Product;
import com.musicstorewebsite.model.UserStatistics;
import com.musicstorewebsite.service.CustomerService;
import com.musicstorewebsite.service.ProductService;
import com.musicstorewebsite.service.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by Le on 1/23/2016.
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserStatisticsService userStatisticsService;

    @RequestMapping("/productList/all")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/productList")
    public String getProductsByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        model.addAttribute("searchCondition", searchCondition);

        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProductByCategory(@PathVariable int productId, Model model, @AuthenticationPrincipal User activeUser) throws IOException {

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Product product = productService.getProductById(productId);
        UserStatistics userStatistics = userStatisticsService.getUserStatisticsByCustomerAndProduct(customer.getCustomerId(), productId);
        if(userStatistics == null){
            userStatistics = new UserStatistics();
            userStatistics.setCustomer(customer);
            userStatistics.setProduct(product);
            userStatistics.setButtonName("View Product");
            userStatistics.setClicksCount(userStatistics.getClicksCount() + 1);
        }
        else{
            userStatistics.setClicksCount(userStatistics.getClicksCount() + 1);
        }



        model.addAttribute(product);

        return "viewProduct";
    }
}
