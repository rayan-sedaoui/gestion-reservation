package ma.projet.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ma.projet.pu");
    public static EntityManagerFactory getEntityManagerFactory() { return emf; }
}