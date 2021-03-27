package monPaquet;



import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@XmlRootElement

@Getter
@Data
//@Builder
public class Livre implements Serializable {
    @XmlAttribute
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID studentId;
    private String Categorie  ;
    private String nom ;
    private String auteur ;

    public Livre() {
        studentId = UUID.randomUUID();
    }
    public UUID getId() {
        return studentId;
    }
    public Livre(String nom, String auteur ,String categorie) {
        super();
        studentId = UUID.randomUUID();
        this.nom = nom;
        this.auteur = auteur;
        this.Categorie=	categorie;
    }
    public String getCategorie() {
        return Categorie;
    }
    public void setCategorie(String categorie) {
        Categorie = categorie;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    @Override
    public String toString() {
        return " " + Categorie + " " + nom + " " + auteur + "";
    }

}
