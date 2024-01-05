package com.example.repositorys;

import com.example.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailRepository implements IMailRepository{
    private static int id = 0;
    private static List<Mail> mailList;
    static {
        mailList = new ArrayList<>();
        mailList.add(new Mail(id++,"English",5,true,"abc"));
        mailList.add(new Mail(id++,"Vietnamese",10,false,"xyz"));
        mailList.add(new Mail(id++,"English",15,false,"tre"));

    }
    @Override
    public void updateMail(int id, Mail mail) {
        for (Mail m: mailList
             ) {
            if (m.getId() == id){
                mailList.set(id,mail);
            }

        }
    }
}
