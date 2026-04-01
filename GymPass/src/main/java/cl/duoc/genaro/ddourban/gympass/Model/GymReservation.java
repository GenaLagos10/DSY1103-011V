package cl.duoc.genaro.ddourban.gympass.Model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GymReservation {
    @Min(5)
    @Max(100)
    private Long id;
    @NotBlank(message = "El nombre del cliente es requerido")
    @Size(min = 1, max = 50)
    private String userName;
    @NotBlank
    private String trainingType;
    private String status;
    private LocalDateTime createdAt;
    private LocalDate reservationDate;
    private LocalDateTime expirationDate;


}
