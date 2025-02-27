import java.util.Date;

public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private String role;
    private Date dateEmbauche;
    private double salaire;

    public Employe(int id, String nom, String prenom, String role, Date dateEmbauche, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return role + " : " + nom + " " + prenom + " (ID: " + id + ")";
    }
}
