package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class StudentDTO {

    @NotNull
    @NotEmpty(message = "O nome do aluno não pode ficar vazio.")
    @NotBlank(message = "O nome do aluno não pode ficar vazio.")
    @Size(max = 50, message = "O comprimento do nome não pode exceder 50 caracteres.")
    @Pattern(regexp = "^[A-Z]+[a-zA-Z]*$", message = "O nome do aluno deve começar com letra maiúscula.")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotEmpty(message = "A lista não pode estar vazia.")
    List<SubjectDTO> subjects;
}
