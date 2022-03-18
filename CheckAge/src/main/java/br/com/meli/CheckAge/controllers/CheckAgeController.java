package br.com.meli.CheckAge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.Period;


@RestController
public class CheckAgeController {
    @GetMapping("/checkAge/{d}/{m}/{a}")
    public String checkAge(@PathVariable(name ="d") String day, @PathVariable(name="m") String month, @PathVariable(name="a") String year) throws Exception {
        if(Integer.parseInt(day) > 31 | Integer.parseInt(day) < 0) {
            throw new Exception("Invalid number of days");
        }
        if(Integer.parseInt(month) > 12 | Integer.parseInt(month) < 0){
            throw new Exception("Invalid number of months");
        }
        if(Integer.parseInt(year) > LocalDate.now().getYear() | Integer.parseInt(year) < 0 | Integer.parseInt(year) < 1000){
            throw new Exception("Invalid number of years");
        }
        String formatedDate = year+"-"+month+"-"+day;

        LocalDate dateToCheck = LocalDate.parse(formatedDate);
        LocalDate todayDate = LocalDate.now();
        String calculatedAge = "Age: "+Period.between(dateToCheck,todayDate).getYears()+" years";

        return calculatedAge;
    }

}
