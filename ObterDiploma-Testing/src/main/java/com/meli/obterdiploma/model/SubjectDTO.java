package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull
    @NotEmpty(message = "O nome do assunto não pode ficar vazio.")
    @NotBlank(message = "O nome do aluno não pode ficar vazio.")
    @Size(max = 30, message= "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-Z][a-záàâãéèêíïóôõöúçñ]+[a-zA-Z]*$", message= "O nome do assunto deve começar com letra maiúscula.")
    String name;
    @NotNull
    @DecimalMin(value = "0.0", message = "A nota mínima é 0,0.")
    @DecimalMax(value = "10.0", message =  "A nota máxima é 10,0.")
    Double score;
}
