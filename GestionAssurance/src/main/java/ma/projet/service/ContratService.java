package ma.projet.service;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import ma.projet.classes.Contrat;
import ma.projet.dao.AbstractFacade;
import ma.projet.util.HibernateUtil;

public class ContratService extends AbstractFacade<Contrat> {

    public ContratService() {
        super(Contrat.class);
    }

    public List<Contrat> findActiveContrats(Date date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contrat> contrats = session.createQuery(
                "from Contrat c where c.dateFin > :date and c.statut = 'ACTIF'")
                .setParameter("date", date)
                .list();
        session.close();
        return contrats;
    }
}