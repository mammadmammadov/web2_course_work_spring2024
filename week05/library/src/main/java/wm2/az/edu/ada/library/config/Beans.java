package wm2.az.edu.ada.library.config;

import wm2.az.edu.ada.library.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Beans {

    @Bean
    @Scope("prototype")
    public Book defaultPerson(){
        return new Book(0,"", "", "", "");
    }


}