package com.example.repositories;

import com.example.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music,Long> {

}
