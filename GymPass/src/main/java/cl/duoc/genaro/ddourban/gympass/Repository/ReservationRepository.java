package cl.duoc.genaro.ddourban.gympass.Repository;

import cl.duoc.genaro.ddourban.gympass.Model.GymReservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository {


//primero el nombre de la clase de Model - seguido por el nombre de la lista
    List<GymReservation> gymReservations = new ArrayList<>();

    long currentId = 5L;

    public ReservationRepository() {
        gymReservations.add(new GymReservation(currentId++,
            "Genaro Lagos",
            "Pesas",
            "NEW",
            LocalDateTime.now(),
            null,
            null));
        gymReservations.add(new GymReservation(currentId++,
            "Juan Gimenez",
            "Calistenia",
            "NEW",
            LocalDateTime.now(),
            null,
            null));
      }

      public List<GymReservation> getAll() {
        return gymReservations;
      }

      public GymReservation save(GymReservation newGymReservation) {
        newGymReservation.setId(currentId++);
        gymReservations.add(newGymReservation);
        return newGymReservation;
      }

      public boolean existsByUserName(String aUserName) {
        for (GymReservation r : gymReservations) {
          if (r.getUserName().equals(aUserName)) {
            return true;
          }
        }
        return false;
      }

      public GymReservation getById(Long id) {
        for (GymReservation r : gymReservations) {
          if (r.getId().equals(id)) {
            return r;
          }
        }
        return null;
      }

    public GymReservation deleteById(Long id) {
        GymReservation r = getById(id); // Buscamos primero
        if (r != null) {
            gymReservations.remove(r); // Borramos fuera del bucle
        }
        return r;
    }

    public void update(GymReservation toUpdate) {
        GymReservation f = getById(toUpdate.getId());
        if (f != null) {
            int index = gymReservations.indexOf(f);
            gymReservations.set(index, toUpdate);
        }
    }

}


