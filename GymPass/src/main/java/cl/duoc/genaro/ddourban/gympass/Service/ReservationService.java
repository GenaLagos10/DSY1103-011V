package cl.duoc.genaro.ddourban.gympass.Service;

import cl.duoc.genaro.ddourban.gympass.Model.GymReservation;
import cl.duoc.genaro.ddourban.gympass.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    //CONSTRUCTOR
    private ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {

        this.repository = repository;
    }

    //GET ALL
    public List<GymReservation> getAll() {
        return repository.getAll();
    }

    //OBTENER POR ID
    public GymReservation getById(Long id) {
        return repository.getById(id);
    }
    //BORRAR POR ID
    public GymReservation deleteById(Long id) {
        return repository.deleteById(id);
    }

    //CREATE
    public GymReservation create(GymReservation reservation) {
        boolean exists = this.repository.existsByUserName(reservation.getUserName());
        if (exists) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDate ldNow = LocalDate.now();
        LocalDate estimated = ldNow.plusDays(5L);

        reservation.setStatus("PENDING");
        reservation.setCreatedAt(now);
        reservation.setExpirationDate(now.plusDays(7));
        return this.repository.save(reservation);
    }

    //UPDATE
    public GymReservation updateById(Long id, GymReservation reservation) {
        GymReservation toUpdate = this.repository.getById(id);
        if (toUpdate == null) {
            return null;
        }
        //reservation nombre solo para esto. las variables de atributos empiezan con mayus
        toUpdate.setUserName(reservation.getUserName());
        toUpdate.setTrainingType(reservation.getTrainingType());
        toUpdate.setStatus(reservation.getStatus());
        toUpdate.setReservationDate(reservation.getReservationDate());
        this.repository.update(toUpdate);
        return toUpdate;
    }

}