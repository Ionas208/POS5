package at.kaindorf.exam.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*
    Created by: Jonas Seidl
    Date: 18.03.2022
    Time: 08:17
*/
@Component
public class Read {

    @PostConstruct
    public void readEmp(){
        System.out.println("asdf");
    }
}
