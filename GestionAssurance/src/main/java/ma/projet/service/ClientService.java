package ma.projet.service;

import java.util.List;
import org.hibernate.Session;
import ma.projet.classes.Client;
import ma.projet.classes.Contrat;
import ma.projet.dao.AbstractFacade;
import ma.projet.util.HibernateUtil;

public class ClientService extends AbstractFacade<Client> {

    public ClientService() {
        super(Client.class);
    }

    public List<Contrat> findContratsByCin(String cin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contrat> contrats = session.createQuery(
                "select c from Contrat c where c.client.cin = :cin")
                .setParameter("cin", cin)
                .list();
        session.close();
        return contrats;
    }
}