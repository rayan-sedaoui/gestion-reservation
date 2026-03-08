package ma.projet;

import java.time.LocalDateTime;
import ma.projet.entities.Reservation;
import ma.projet.entities.Salle;
import ma.projet.service.ReservationService;
import ma.projet.service.SalleService;

public class TestScenario {

    public static void run() {
        SalleService salleService = new SalleService();
        ReservationService reservationService = new ReservationService();

        Salle salle1 = new Salle();
        salle1.setCode("S101");
        salle1.setLibelle("Salle Informatique");
        salleService.create(salle1);

        Reservation res1 = new Reservation();
        res1.setDateDebut(LocalDateTime.now());
        res1.setDateFin(LocalDateTime.now().plusHours(2));
        res1.setSalle(salle1);
        reservationService.create(res1);

        System.out.println("\n--- RESULTATS DU TEST ---");
        for (Reservation r : reservationService.findAll()) {
            System.out.println("Reservation ID: " + r.getId() + " | Salle: " + r.getSalle().getCode());
        }
        System.out.println("-------------------------\n");
    }
}