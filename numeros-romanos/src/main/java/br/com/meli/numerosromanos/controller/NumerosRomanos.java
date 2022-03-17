package br.com.meli.numerosromanos.controller;

import br.com.meli.numerosromanos.utils.IntegerToRoman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NumerosRomanos {

    @GetMapping("/ping")
    @ResponseBody
    public String retornPong() {
        return "pong";
    }

    @GetMapping("/roman")
    @ResponseBody
    public StringBuilder returnRomanEquivalent(@RequestParam int numero) {
        StringBuilder retorno = new StringBuilder();
        retorno = IntegerToRoman.integerToRoman(numero);
        return retorno;
    }
}
