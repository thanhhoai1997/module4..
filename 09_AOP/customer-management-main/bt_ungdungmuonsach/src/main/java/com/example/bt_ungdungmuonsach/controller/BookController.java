package com.example.bt_ungdungmuonsach.controller;

import com.example.bt_ungdungmuonsach.model.Book;
import com.example.bt_ungdungmuonsach.model.BookCode;
import com.example.bt_ungdungmuonsach.model.Category;
import com.example.bt_ungdungmuonsach.service.book.IBookService;
import com.example.bt_ungdungmuonsach.service.bookcode.IBookCodeService;
import com.example.bt_ungdungmuonsach.service.category.ICategoryService;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBookCodeService iBookCodeService;
    @GetMapping("")
    public ModelAndView showList(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("categorySearch") Optional<String> categorySearch ){
        Sort sort =Sort.by("name").ascending();
        Page<Book> books;
        Pageable pageable = PageRequest.of(page.orElse(0),5,sort);
        if (categorySearch.isPresent()){
            books = iCategoryService.findAllByNameCategory(categorySearch.get(),pageable);
        }else {
            books = iBookService.findAll(pageable);
        }

        ModelAndView mv = new ModelAndView("/list");
        mv.addObject("books",books);
        List<Category> categories = iCategoryService.findAll();
        mv.addObject("categories",categories);
        return mv;
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("/view");
        Book book = iBookService.findById(id);
        mv.addObject("book",book);
        return mv;

    }
    @ExceptionHandler(Exception.class)
    public  ModelAndView showError(){
        return  new ModelAndView("/error2");
    }
    @GetMapping("/{id}/borrow")
    public ModelAndView borrow(@PathVariable("id") Long id) throws Exception {
        int bookCode = (int) (Math.random() * 100000);

        BookCode bookCode1 = new BookCode();
        Book book = iBookService.findById(id);
        if (book.getQuantity() > 0){
            iBookService.updateQuantityBook(id);
            bookCode1.setBook(book);
            bookCode1.setCode(bookCode);
            iBookCodeService.save(bookCode1);
        }else {
            throw new Exception();

        }




        ModelAndView mv = new ModelAndView("redirect:/books");
        return mv;

    }
    @GetMapping("/givebookback")
    public ModelAndView showBookBack(){
        ModelAndView mv = new ModelAndView("/formbookback");
        return mv;
    }
    @PostMapping("/givebookback")
    public ModelAndView bookBack(@RequestParam("code") int code){
        List<BookCode> bookCodes = iBookCodeService.findAll();
        for (BookCode b: bookCodes
             ) {
            if (b.getCode() == code){
                iBookService.updateQuantityBook2(b.getBook().getId());
                return new ModelAndView("redirect:/books");
            }

        }
        return new ModelAndView("/error1");

    }
}
