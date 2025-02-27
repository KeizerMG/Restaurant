import java.util.ArrayList;

public class Commande {
    private int numeroCommande;
    private ArrayList<Plat> plats;
    private double total;

    public Commande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
        this.plats = new ArrayList<>();
        this.total = 0.0;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    } 

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void setPlats(ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
        calculerTotal();
    }

    public void calculerTotal() {
        total = 0.0;
        for (Plat plat : plats) {
            total += plat.getPrix();
        }
    }

    public void afficherCommande() {
        for (Plat plat : plats) {
            System.out.println(plat);
        }
        System.out.println("Total : " + total + " euros");
    }

    @Override
    public String toString() {
        return "Commande #" + numeroCommande + " : Total : " + total + " euros";
    }
}
