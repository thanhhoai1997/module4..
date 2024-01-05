package com.example.controller;

import com.example.model.Product;
import com.example.model.ProductForm;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;

    private static IProductService iProductService = new ProductService();
    @GetMapping
    public ModelAndView index(){
        List<Product> products = iProductService.findAll();
        ModelAndView mv = new ModelAndView("/index","products",products);
        return mv;
    }
    @GetMapping("create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("/create");
        mv.addObject("productForm",new ProductForm());
        return mv;
    }
    @PostMapping("save")
    public ModelAndView savaProduct(@ModelAttribute ProductForm productForm){
        MultipartFile multipartFile = productForm.getImage();
        String filename = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + filename));
        }catch (IOException ex){
            ex.printStackTrace();

        }
        Product product = new Product(productForm.getId(),productForm.getName(),
                productForm.getDescription(),filename);
        iProductService.save(product);
        ModelAndView mv = new ModelAndView("/create");
        mv.addObject("productForm", productForm);
        mv.addObject("message","Created new product successfully !");
        return mv;


    }
}
