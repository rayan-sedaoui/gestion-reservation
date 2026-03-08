package ma.projet.util;

public class PerformanceReport {

    private String nomOperation;
    private long tempsDebut;
    private long tempsFin;
    private long memoireDebut;
    private long memoireFin;

    public PerformanceReport(String nomOperation) {
        this.nomOperation = nomOperation;
    }

    public void start() {
        Runtime.getRuntime().gc();
        this.memoireDebut = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.tempsDebut = System.currentTimeMillis();
    }

    public void stop() {
        this.tempsFin = System.currentTimeMillis();
        this.memoireFin = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public void genererRapport() {
        long duree = tempsFin - tempsDebut;
        long memoireConsommee = (memoireFin - memoireDebut) / 1024; 

        System.out.println("\n=== RAPPORT DE PERFORMANCE ===");
        System.out.println("Operation        : " + nomOperation);
        System.out.println("Temps d'execution: " + duree + " ms");
        System.out.println("Memoire utilisee : " + memoireConsommee + " KB");
        System.out.println("==============================\n");
    }
}