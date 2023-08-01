package com.example.animashelter;

import com.example.animashelter.model.*;
import com.example.animashelter.repositories.ContactRequestDAOImpl;
import com.example.animashelter.model.Adress;
import com.example.animashelter.model.CatShelter;
import com.example.animashelter.model.ContactRequest;
import com.example.animashelter.model.DogShelter;
import com.example.animashelter.repositories.ContactRequestDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AnimaShelterApplication {

    @PostConstruct
    private static void beginning () throws InterruptedException {
        //Shelter.getExample();
        //ContactRequest.getExample();
    }

    public static void main(String[] args) {
        SpringApplication.run(AnimaShelterApplication.class, args);
        Adress adress1 = new Adress("Москва", "Великолукская ул.", "3", "1A", "65");
        Adress adress2 = new Adress("Химки", "Ленинградское шоссе", "21", null, "2");
        CatShelter catShelter = new CatShelter("Кошачий приют №8", "Пн-Пт", adress1);
        DogShelter dogShelter = new DogShelter("Нос и хвост", "Пн, Ср, Чт, Пт, Сб", adress2);
        ContactRequest contactRequest = new ContactRequest(1, catShelter, "Степан", "89154921779");
        System.out.println(contactRequest);
        ContactRequestDAOImpl contactRequestDAOimpl = new ContactRequestDAOImpl();
        contactRequestDAOimpl.sendToDateBase(contactRequest);
        System.out.println(contactRequestDAOimpl.findById(1));
    }

}
