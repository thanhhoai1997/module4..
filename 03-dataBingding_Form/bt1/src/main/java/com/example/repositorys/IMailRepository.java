package com.example.repositorys;

import com.example.model.Mail;
import org.springframework.stereotype.Repository;

@Repository
public interface IMailRepository {
    void updateMail(int id, Mail mail);
}
