import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            int choix = getIntInput();
            scanner.nextLine(); // Clear buffer after getting menu choice
            
            switch (choix) {
                case 1:
                    ajouterRestaurant();
                    break;
                case 2:
                    ajouterEmployeToRestaurant();
                    break;
                case 3:
                    ajouterPlatAuMenu();
                    break;
                case 4:
                    supprimerEmployeDUnRestaurant();
                    break;
                case 5:
                    afficherEmployesDUnRestaurant();
                    break;
                case 6:
                    prendreCommandePourRestaurant();
                    break;
                case 7:
                    afficherCommandesDUnRestaurant();
                    break;
                case 8:
                    sauvegarderCommandesDUnRestaurant();
                    break;
                case 9:
                    chargerCommandesDUnRestaurant();
                    break;
                case 10:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("Menu utilisateur :");
        System.out.println("1. Ajouter un restaurant");
        System.out.println("2. Ajouter un employé à un restaurant");
        System.out.println("3. Ajouter un plat au menu d'un restaurant");
        System.out.println("4. Supprimer un employé d'un restaurant");
        System.out.println("5. Afficher les employés d'un restaurant");
        System.out.println("6. Prendre une commande pour un restaurant");
        System.out.println("7. Afficher toutes les commandes d'un restaurant");
        System.out.println("8. Sauvegarder les commandes d'un restaurant");
        System.out.println("9. Charger les commandes d'un restaurant");
        System.out.println("10. Quitter");
    }

    private static void ajouterRestaurant() {
        System.out.println("Ajouter un restaurant");
        
        System.out.print("ID du restaurant : ");
        int id = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Nom du restaurant : ");
        String nomRestaurant = scanner.nextLine();
        
        System.out.print("Adresse du restaurant : ");
        String adresse = scanner.nextLine();
        
        System.out.print("ID du menu : ");
        int menuId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Nom du menu : ");
        String nomMenu = scanner.nextLine();
        
        Date dateCreation = new Date();
        
        System.out.print("Type de menu : ");
        String typeMenu = scanner.nextLine();
        
        Menu menu = new Menu(menuId, nomMenu, dateCreation, typeMenu);
        Restaurant restaurant = new Restaurant(id, nomRestaurant, adresse, menu);
        restaurants.add(restaurant);
        System.out.println("Restaurant ajouté avec succès.");
    }

    private static void ajouterEmployeToRestaurant() {
        System.out.println("Ajouter un employé à un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.print("ID de l'employé : ");
        int id = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Nom de l'employé : ");
        String nom = scanner.nextLine();
        
        System.out.print("Prénom de l'employé : ");
        String prenom = scanner.nextLine();
        
        System.out.print("Rôle de l'employé : ");
        String role = scanner.nextLine();
        
        Date dateEmbauche = new Date();
        
        System.out.print("Salaire de l'employé : ");
        double salaire = getDoubleInput();
        scanner.nextLine(); // Clear buffer
        
        Employe employe = new Employe(id, nom, prenom, role, dateEmbauche, salaire);
        
        System.out.println("Données de l'employé avant ajout:");
        System.out.println("ID: " + employe.getId());
        System.out.println("Nom: " + employe.getNom());
        System.out.println("Prénom: " + employe.getPrenom());
        System.out.println("Rôle: " + employe.getRole());
        System.out.println("Salaire: " + employe.getSalaire());
        
        restaurant.ajouterEmploye(employe);
        System.out.println("Employé ajouté avec succès au restaurant " + restaurant.getNomRestaurant() + ".");
        
        // Vérifier la liste des employés après ajout
        System.out.println("Liste des employés après ajout:");
        restaurant.afficherEmployes();
    }

    private static void ajouterPlatAuMenu() {
        System.out.println("Ajouter un plat au menu d'un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.print("Nom du plat : ");
        String nom = scanner.nextLine();
        
        System.out.print("Description du plat : ");
        String description = scanner.nextLine();
        
        System.out.print("Prix du plat : ");
        double prix = getDoubleInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Calories du plat : ");
        int calories = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Catégorie du plat : ");
        String categorie = scanner.nextLine();
        
        System.out.print("Taille de la portion : ");
        String taillePortion = scanner.nextLine();
        
        Date dateAjout = new Date();
        
        System.out.print("Disponibilité (true/false) : ");
        boolean disponibilite = getBooleanInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Ingrédients : ");
        String ingredients = scanner.nextLine();
        
        System.out.print("Type de cuisine : ");
        String typeCuisine = scanner.nextLine();
        
        System.out.print("Temps de préparation : ");
        int tempsPreparation = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Prix spécial : ");
        double prixSpecial = getDoubleInput();
        scanner.nextLine(); // Clear buffer
        
        System.out.print("URL de l'image : ");
        String imageURL = scanner.nextLine();
        
        Plat plat = new Plat(nom, description, prix, calories, categorie, taillePortion, dateAjout, disponibilite, ingredients, typeCuisine, tempsPreparation, prixSpecial, imageURL);
        restaurant.getMenu().ajouterPlat(plat);
        System.out.println("Plat ajouté avec succès au menu du restaurant " + restaurant.getNomRestaurant() + ".");
    }

    private static void supprimerEmployeDUnRestaurant() {
        System.out.println("Supprimer un employé d'un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.print("ID de l'employé à supprimer : ");
        int employeId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Employe employeToRemove = null;
        for (Employe employe : restaurant.getEmployes()) {
            if (employe.getId() == employeId) {
                employeToRemove = employe;
                break;
            }
        }
        
        if (employeToRemove == null) {
            System.out.println("Employé non trouvé dans ce restaurant.");
            return;
        }
        
        restaurant.supprimerEmploye(employeToRemove);
        System.out.println("Employé supprimé avec succès du restaurant " + restaurant.getNomRestaurant() + ".");
    }

    private static void afficherEmployesDUnRestaurant() {
        System.out.println("Afficher les employés d'un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        restaurant.afficherEmployes();
    }

    private static void prendreCommandePourRestaurant() {
        System.out.println("Prendre une commande pour un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.print("Numéro de la commande : ");
        int numeroCommande = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Commande commande = new Commande(numeroCommande);
        
        while (true) {
            System.out.print("Nom du plat à ajouter (ou 'fin' pour terminer) : ");
            String nomPlat = scanner.nextLine();
            
            if (nomPlat.equalsIgnoreCase("fin")) {
                break;
            }
            
            Plat plat = restaurant.getMenu().chercherPlatParNom(nomPlat);
            if (plat == null) {
                System.out.println("Plat non trouvé dans le menu.");
            } else {
                commande.ajouterPlat(plat);
                System.out.println("Plat ajouté à la commande.");
            }
        }
        
        restaurant.ajouterCommande(commande);
        System.out.println("Commande prise avec succès.");
    }

    private static void afficherCommandesDUnRestaurant() {
        System.out.println("Afficher toutes les commandes d'un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.println("Commandes du restaurant " + restaurant.getNomRestaurant() + ":");
        restaurant.afficherCommandes();
    }

    private static void sauvegarderCommandesDUnRestaurant() {
        System.out.println("Sauvegarder les commandes d'un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.print("Nom du fichier pour sauvegarder les commandes : ");
        String nomFichier = scanner.nextLine();
        
        try {
            restaurant.sauvegarderCommandes(nomFichier);
            System.out.println("Commandes sauvegardées avec succès dans le fichier " + nomFichier + ".");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des commandes : " + e.getMessage());
        }
    }

    private static void chargerCommandesDUnRestaurant() {
        System.out.println("Charger les commandes d'un restaurant");
        
        System.out.print("ID du restaurant : ");
        int restaurantId = getIntInput();
        scanner.nextLine(); // Clear buffer
        
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant == null) {
            System.out.println("Restaurant non trouvé.");
            return;
        }
        
        System.out.print("Nom du fichier pour charger les commandes : ");
        String nomFichier = scanner.nextLine();
        
        try {
            restaurant.chargerCommandes(nomFichier);
            System.out.println("Commandes chargées avec succès depuis le fichier " + nomFichier + ".");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des commandes : " + e.getMessage());
        }
    }

    private static Restaurant findRestaurantById(int id) {
        System.out.println("Recherche du restaurant avec ID: " + id);
        System.out.println("Nombre de restaurants disponibles: " + restaurants.size());
        
        for (Restaurant restaurant : restaurants) {
            System.out.println("Vérification du restaurant avec ID: " + restaurant.getId());
            if (restaurant.getId() == id) {
                System.out.println("Restaurant trouvé: " + restaurant.getNomRestaurant());
                return restaurant;
            }
        }
        
        System.out.println("Restaurant avec ID " + id + " non trouvé.");
        return null;
    }

    private static int getIntInput() {
        while (true) {
            try {
                int value = scanner.nextInt();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                double value = scanner.nextDouble();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    private static boolean getBooleanInput() {
        while (true) {
            try {
                boolean value = scanner.nextBoolean();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer true ou false.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }
}
