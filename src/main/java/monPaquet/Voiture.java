package monPaquet;


import java.io.Serializable;

//@Entity
public class Voiture implements Serializable {
    private String pays;
    private String nom;
    private  String prenom;
    private String sex;

    public Voiture(String pays, String nom, String prenom, String sex) {
        this.pays = pays;
        this.nom = nom;
        this.prenom = prenom;
        this.sex = sex;
    }
}
