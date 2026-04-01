package cl.duoc.genaro.ddourban.gympass.Controller;

import cl.duoc.genaro.ddourban.gympass.Model.GymReservation;
import cl.duoc.genaro.ddourban.gympass.Repository.ReservationRepository;
import cl.duoc.genaro.ddourban.gympass.Service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/gympass")
public class ReservationController {


    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }


    //CAMBIAR VARIABLE POR NOMBRE DE LA CLASE MODEL

    @GetMapping
    public List<GymReservation> getAllGymReservations() {
        return this.service.getAll();
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody GymReservation GymReservation) {
        GymReservation created = this.service.create(GymReservation);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("GymReservation Creado");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/by-id/{id}")
    public ResponseEntity<GymReservation> getGymReservationById(
            @PathVariable Long id,
            @RequestBody GymReservation GymReservation) {
        GymReservation updated = this.service.updateById(id, GymReservation);
        if (updated != null) {
            return ResponseEntity.status(200).body(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<GymReservation> getGymReservationById(@PathVariable Long id) {
        GymReservation found = this.service.getById(id);
        if (found != null) {
            return ResponseEntity.status(200).body(found);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/by-id/{id}")
    public ResponseEntity<GymReservation> deleteGymReservationById(@PathVariable Long id) {
        GymReservation found = this.service.deleteById(id);
        if (found != null) {
            return ResponseEntity.status(200).body(found);
        }
        return ResponseEntity.notFound().build();
    }
}
