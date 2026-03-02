package ma.projet.test;

import java.util.Date;

import ma.projet.classes.*;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;

public class Test {

    public static void main(String[] args) {

        try {

            ClientService clientService = new ClientService();
            AssuranceService assuranceService = new AssuranceService();
            ContratService contratService = new ContratService();

          Client client = new Client(
                    "AA123",
                    "Rayan",
                    "Sedaoui",
                    "rayan@gmail.com",
                    "0612345678"
            );

            clientService.create(client);

         Assurance assurance = new Assurance(
                    "Auto",
                    5000,
                    "Tous risques"
            );

            assuranceService.create(assurance);

         Contrat contrat = new Contrat();
            contrat.setDateDebut(new Date());
            contrat.setDateFin(new Date(System.currentTimeMillis() + 1000000000));
            contrat.setStatut(Statut.ACTIF);
            contrat.setClient(client);
            contrat.setAssurance(assurance);

            contratService.create(contrat);

            System.out.println("Contrats du client AA123 : "
                    + clientService.findContratsByCin("AA123").size());

            System.out.println("Contrats assurance Auto : "
                    + assuranceService.findContratsByType("Auto").size());

            System.out.println("Contrats actifs : "
                    + contratService.findActiveContrats(new Date()).size());

            System.out.println("✔ Tout fonctionne correctement !");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}