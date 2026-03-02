package ma.projet.service;

import java.util.List;
import org.hibernate.Session;
import ma.projet.classes.Assurance;
import ma.projet.classes.Contrat;
import ma.projet.dao.AbstractFacade;
import ma.projet.util.HibernateUtil;

public class AssuranceService extends AbstractFacade<Assurance> {

    public AssuranceService() {
        super(Assurance.class);
    }

    public Assurance findByType(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Assurance assurance = (Assurance) session.createQuery(
                "from Assurance a where a.type = :type")
                .setParameter("type", type)
                .uniqueResult();
        session.close();
        return assurance;
    }

    public List<Contrat> findContratsByType(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contrat> contrats = session.createQuery(
                "select c from Contrat c where c.assurance.type = :type")
                .setParameter("type", type)
                .list();
        session.close();
        return contrats;
    }
}