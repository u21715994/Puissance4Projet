public class Joueur{
    /**
     * @author Youssef Oussouf et Assia El Gharbi
     * Partie représente un joueur
     * ayant un nom et un pion
     */
    private String nom;
    private String pion;
    
    /**
     * Joueur(String nom, String pion)
     * crée une instance de Joueur
     * initialisée par les valeurs passées en paramètres
     * @nom nom du joueur
     * @pion pion du joueur
     */
    public Joueur(String nom, String pion){
        this.nom = nom;
        this.pion = pion;
    }
    
    /**
     * String getpion()
     * Méthode permettant d'obtenir le pion du joueur
     */
    public String getpion(){
        return pion;
    }
    
    /**
     * String getnom()
     * Méthode permettant d'obtenir le nom du joueur
     */
    public String getnom(){
        return nom;
    }
}
