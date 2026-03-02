package ma.projet.classes;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "contrat")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "assurance_id", nullable = false)
    private Assurance assurance;

    public Contrat() {
    }

    public Contrat(Date dateDebut, Date dateFin, Statut statut, Client client, Assurance assurance) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.client = client;
        this.assurance = assurance;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Assurance getAssurance() { return assurance; }
    public void setAssurance(Assurance assurance) { this.assurance = assurance; }
}