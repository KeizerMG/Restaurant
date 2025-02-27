import java.io.*;
import java.util.ArrayList;

public class Restaurant {
    private int id;
    private String nomRestaurant;
    private String adresse;
    private Menu menu;
    private ArrayList<Commande> commandes;
    private ArrayList<Employe> employes;

    public Restaurant(int id2, String nomRestaurant, String adresse, Menu menu) {
        id = id2;
        this.nomRestaurant = nomRestaurant;
        this.adresse = adresse;
        this.menu = menu;
        this.commandes = new ArrayList<>();
        this.employes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }

    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    public void afficherCommandes() {
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
    }

    public void supprimerEmploye(Employe employe) {
        employes.remove(employe);
    }

    public ArrayList<Employe> chercherEmployeParRole(String role) {
        ArrayList<Employe> result = new ArrayList<>();
        for (Employe employe : employes) {
            if (employe.getRole().equalsIgnoreCase(role)) {
                result.add(employe);
            }
        }
        return result;
    }

    public void afficherEmployes() {
        if (employes.isEmpty()) {
            System.out.println("Ce restaurant n'a pas d'employés.");
            return;
        }
        
        System.out.println("Employés du restaurant " + nomRestaurant + " :");
        for (Employe employe : employes) {
            if (employe != null && employe.getNom() != null && employe.getPrenom() != null && employe.getRole() != null) {
                System.out.println("- " + employe.getRole() + " : " + employe.getNom() + " " + employe.getPrenom() + " (ID: " + employe.getId() + ")");
            } else {
                System.out.println("- [Données d'employé incomplètes]");
            }
        }
    }

    public void sauvegarderCommandes(String fichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            for (Commande commande : commandes) {
                writer.write(commande.toString());
                writer.newLine();
            }
        }
    }

    public void chargerCommandes(String fichier) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the toString format is used for saving
                // Parse the line to create Commande objects
                // Example: Commande #123 : Total : 50.0 euros
                String[] parts = line.split(":");
                if (parts.length > 1) {
                    String commandeDetails = parts[0].trim();
                    String totalDetails = parts[1].trim();

                    // Extract the command number
                    String[] commandeParts = commandeDetails.split("#");
                    int numeroCommande = Integer.parseInt(commandeParts[1].trim());

                    Commande commande = new Commande(numeroCommande);

                    commandes.add(commande);
                }
            }
        }
    }

    public double totalSalaireEmployes() {
        double total = 0.0;
        for (Employe employe : employes) {
            total += employe.getSalaire();
        }
        return total;
    }

    public double totalChiffreAffaire() {
        double total = 0.0;
        for (Commande commande : commandes) {
            total += commande.getTotal();
        }
        return total;
    }

    public void afficherRestaurant() {
        System.out.println("Restaurant #" + id + " : " + nomRestaurant + ", Adresse : " + adresse);
        afficherEmployes();
    }
}
