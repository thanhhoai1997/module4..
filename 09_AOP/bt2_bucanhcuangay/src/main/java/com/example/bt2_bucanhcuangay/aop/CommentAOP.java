package com.example.bt2_bucanhcuangay.aop;

import com.example.bt2_bucanhcuangay.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Aspect
@Component
public class CommentAOP {



    @AfterThrowing("execution(* com.example.bt2_bucanhcuangay.controller.PhotoOfTheDayController.create(..) ) ")
    public void checkComment(){
        System.out.println("error");

    }
}
