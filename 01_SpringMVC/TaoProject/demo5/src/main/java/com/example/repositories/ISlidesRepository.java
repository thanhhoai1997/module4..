package com.example.repositories;

import com.example.model.Category;
import com.example.model.Slides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ISlidesRepository {
@Autowired
    List<Slides> getDataSlides();

}
