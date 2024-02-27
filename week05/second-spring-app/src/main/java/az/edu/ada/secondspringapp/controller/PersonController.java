package az.edu.ada.secondspringapp.controller;

import az.edu.ada.secondspringapp.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


// @Controller indicates that it is a Spring bean and handles HTTP requests.
@Controller
@RequestMapping("/persons")
public class PersonController {

    @GetMapping
    public String getAllPersons(Model model){
        var list = List.of(new Person(1, "Ali", "Aliyev"),
                new Person(2, "Manaf", "Aghazade"),
                new Person(3, "Gultaj", "Muradova"));

        model.addAttribute("persons", list);

        // The model is a data container that holds information to be displayed in the view.

        return "persons";
    }

}

// In summary, the application defines a controller (PersonController) that handles requests to the /persons endpoint.
// When a GET request is made to /persons, the controller fetches a list of Person objects, adds them to the model,
// and returns the name of the Thymeleaf HTML template (persons.html).
// Thymeleaf then renders the HTML template, populating it with the data from the model,
// and sends the HTML response back to the client.