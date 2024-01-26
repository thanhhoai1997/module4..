package com.example.bt_ungdungmuonsach.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAOP {
    private int count;

    public BookAOP() {
        this.count = 0;
    }



    @After(" execution(* com.example.bt_ungdungmuonsach.controller.BookController.borrow(..))")
    public void checkBookBorrow(){
        System.out.println("co 1 User da muon sach");
    }

    @After(" execution(* com.example.bt_ungdungmuonsach.controller.BookController.bookBack(..))")
    public void checkBackBook(){
        System.out.println("co 1 User da tra sach");
    }

    @Before(" execution(* com.example.bt_ungdungmuonsach.controller.BookController.*(..))")
    public void countUser(){
        System.out.println("so luong nguoi da ghe tham : " + count++);
    }
}
