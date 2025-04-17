package sn.uasz.ParametresAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NiveauDto {
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être vide.")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères.")
    private String nom;
}
