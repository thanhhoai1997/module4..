package com.example.thi_module.controller;

import com.example.thi_module.model.Product;
import com.example.thi_module.model.ProductDTO;
import com.example.thi_module.model.ProductType;
import com.example.thi_module.service.IProductService;
import com.example.thi_module.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping("")
    public ModelAndView showList(@RequestParam("page")Optional<Integer> page,@RequestParam("name") Optional<String> name,
                                 @RequestParam("price") Optional<String> price,
                                 @RequestParam("productType") Optional<String> productType
                                 ){
        ModelAndView mv = new ModelAndView("/list");


//        Sort sort = Sort.by("name").descending();



        Pageable pageable = PageRequest.of(page.orElse(0),3);
        Page<Product> products ;

        if (name.isPresent()){
            products = iProductService.findByName(pageable,name.get());

        }else if (price.isPresent()){
            products = iProductService.findByProduct(pageable,price.get());
        }else if (productType.isPresent()){
            products = iProductService.findByProductType(pageable,productType.get());
        }else {
            products = iProductService.findAll(pageable);
        }


        List<Integer> numberPages = new ArrayList<>();
        for (int i = 1; i <= products.getTotalPages();i++){
            numberPages.add(i);
        }
        mv.addObject("products",products);
        mv.addObject("numberPages",numberPages);
        mv.addObject("productType",iProductTypeService.findAll());


        return mv;
    }

    @GetMapping("/create")
    public  ModelAndView showCreate(@ModelAttribute("product") ProductDTO product){
        List<ProductType> productTypes = iProductTypeService.findAll();

    ModelAndView mv = new ModelAndView("/create");
    mv.addObject("productTypes",productTypes);

    return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){



        new ProductDTO().validate(productDTO,bindingResult);

        if (bindingResult.hasErrors()){
            return new ModelAndView("/create","productTypes",iProductTypeService.findAll());
        }
        Product product = new Product();
        ProductType customerType = iProductTypeService.findById(productDTO.getProductType());
        BeanUtils.copyProperties(productDTO,product);
        product.setProductType(customerType);

        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message","them moi thanh cong");


        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("/edit");
        Product product = iProductService.findById(id);
        mv.addObject("productTypes",iProductTypeService.findAll());
        mv.addObject("product",product);
        return mv;

    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("product") Product product){
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.save(product);
        return mv;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable("id") Long id,RedirectAttributes attributes){
        attributes.addFlashAttribute("message1","xoa thanh cong");
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.deleteById(id);
        return mv;

    }


}
