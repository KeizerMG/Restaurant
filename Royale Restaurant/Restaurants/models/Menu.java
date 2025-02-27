import java.util.ArrayList;
import java.util.Date;

public class Menu {
    private int id;
    private String nom;
    private Date dateCreation;
    private String type;
    private ArrayList<Plat> plats;

    public Menu(int id, String nom, Date dateCreation, String type) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.type = type;
        this.plats = new ArrayList<>();
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
    }

    public void supprimerPlat(Plat plat) {
        plats.remove(plat);
    }

    public Plat chercherPlatParNom(String nom) {
        for (Plat plat : plats) {
            if (plat.getNom().equalsIgnoreCase(nom)) {
                return plat;
            }
        }
        return null;
    }

    public void afficherMenu() {
        System.out.println("Menu " + nom + " (" + type + "):");
        for (Plat plat : plats) {
            System.out.println(plat);
        }
    }
    
    @Override
    public String toString() {
        return "Menu #" + id + " : " + nom + " (" + type + ")";
    }
}
