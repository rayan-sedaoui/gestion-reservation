package ma.projet;

import java.util.Scanner;
import ma.projet.util.DatabaseMigrationTool;
import ma.projet.util.PerformanceReport;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Executer les scenarios de test");
            System.out.println("2. Executer le script de migration");
            System.out.println("3. Generer un rapport de performance");
            System.out.println("4. Quitter");
            System.out.print("Votre choix: ");

            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("--> Lancement des scenarios de test...");
                        TestScenario.run();
                        break;
                        
                    case 2:
                        System.out.println("--> Lancement de la migration...");
                        try {
                            DatabaseMigrationTool tool = new DatabaseMigrationTool(
                                "jdbc:mysql://localhost:3306/gestion_reservation?serverTimezone=UTC",
                                "root",
                                ""
                            );
                            tool.executeMigration();
                            System.out.println("--> Migration terminee avec succes !");
                        } catch (Exception e) {
                            System.err.println("--> Erreur : Impossible de lire migration_v2.sql");
                            e.printStackTrace();
                        }
                        break;
                        
                    case 3:
                        System.out.println("--> Generation du rapport...");
                        PerformanceReport report = new PerformanceReport("Test Performance Global");
                        report.start();
                        TestScenario.run();
                        report.stop();
                        report.genererRapport();
                        break;
                        
                    case 4:
                        System.out.println("--> Au revoir !");
                        break;
                        
                    default:
                        System.out.println("--> Choix invalide.");
                }
            } else {
                System.out.println("--> Erreur : Veuillez entrer un chiffre.");
                scanner.next(); 
            }

        } while (choix != 4);

        scanner.close();
    }
}