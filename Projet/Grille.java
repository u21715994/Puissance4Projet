import java.util.Random;

public class Grille{
    /**
     * @author Youssef Oussouf et Assia El Gharbi
     * Grille représente une grille
     * ayant des rangée, des colonnes 
     * et tableau de String
     * et un joueur
     */
    private int row;
    private int column;
    private String  grille[][];
    private Joueur j;

    /**
     * Grille(int rangee, int colonne)
     * crée une instance de Grille 
     * initialisée par les valeurs passées en paramètres
     * @param rangee nombres de rangées dans la grille
     * @param colonne nombres de colonnes dans la grille
     * @param j joueur
     * crée aussi un tableau 2D de String
     * ayant où toutes les valeurs du tableau sont égales à ''
     */
    public Grille(int rangee, int colonne, Joueur j){
        row = rangee;
        column = colonne;
        this.j = j;
        grille = new String [row][column]; 
        for(int i = row-1 ; i >= 0; i--){
            for(int z = column-1; z >= 0; z--){
                grille[i][z] = "'' ";
            }
        }
    }
    
    /**
     * Grille copy()
     * Méthode permettant de crée une copy de Grille
     * retourne une nouvelle instance de Grille(cf void Grille(int rangee, int colonne, Joueur j)
     */
    public Grille copy(){
        return new Grille(this.row, this.column, this.j);
    }
    
    /**
     * String[][] getgrille()
     * Méthode permettant d'obtenir la grille 
     */
    public String[][] getgrille(){
        return grille;
    }
    
    public void setgrille(String[][] grille){
        this.grille = grille;
    }
    
    /**
     * void setjoueur(Joueur j)
     * Méthode mettant à jour le joueur
     */
    public void setjoueur(Joueur j){
        this.j = j;
    }
    
    /**
     * int getrow()
     * Méthode permettant d'obtenir le nombre de rangée de la grille
     */
    public int getrow(){
        return row;
    }
    
    /**
     * int getcolumn()
     * Méthode permettant d'obtenir le nombre de colonne de la grille
     */
    public int getcolumn(){
        return column;
    }
    
    /**
     * Joueur getjoueur()
     * Méthode permettant d'obtenir le joueur
     */
    public Joueur getjoueur(){
        return j;
    }
    
    /**
     * void placerpion(int colonne)
     * Méthode permettant de la placer un pion
     * dans la colonne passée en paramètre
     * @colonne colonne dans laquelle est placée le pion
     * affiche également la grille (cf void actualiseGrille() )
     * verifie également si la partie est terminée (cf void matchnull() et void victoire()) 
     */
    public void placerpion(int colonne){
        int i = 0;
        while(i <= row-1 && this.grille[i][colonne-1] != "'' "){
            i++;
        }
        this.grille[i][colonne-1] = j.getpion();
        actualiseGrille();
        victoire();
        matchnull();
    }
    
    /**
     * void actualiseGrille()
     * Méthode permettant d'afficher la grille
     */
    public void actualiseGrille(){
        for(int i = row-1 ; i >= 0; i--){
            for(int z = 0 ; z <= column-1; z++){
                System.out.print(grille[i][z]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    
    /**
     * boolean verifiepartie()
     * Méthode verifiant si la partie est terminée ou non
     * le programme renvoie vrai s'il y a match null, faux sinon
     */
    public boolean matchnull(){
        int p = row*column;
        int y= 0;
        for(int i = row-1 ; i >= 0; i--){
            for(int z = column-1 ; z >= 0; z--){
                if(grille[i][z] != "'' ")
                y++;
            }
        }
        if (y == p){
            System.out.println("Partie terminé.Match nul");
            return true;
        }
        return false;
    }
    
    /**
     * boolean victoire()
     * Méthode vérifiant si la partie est terminée ou non
     * le programme renvoie vrai s'il y une victoire, faux sinon
     */
    public boolean victoire(){
        int c,p,d,d1;
        p = 0;
        d = 0;
        for(int i = row-1 ; i >= 0; i--){
            c = 0;
            d1 = 0;
            for(int z = column-1 ; z >= 0; z--){
                if(z <= column-3 && grille[i][z] == j.getpion() && grille[i][z+1] == j.getpion() && grille[i][z+2] == j.getpion()){
                    c++;
                }
                if(i <= row-3 && grille[i][z] == j.getpion() && grille[i+1][z] == j.getpion() && grille[i+2][z] == j.getpion()){
                    p++;
                }
                if((i <= row-3 && z <= column-3) && grille[i][z] == j.getpion() && grille[i+1][z+1] == j.getpion() && grille[i+2][z+2] == j.getpion()){
                    d++;
                }
                if((i <= row-4 && z >= 3) && grille[i][z] == j.getpion() && grille[i+1][z-1] == j.getpion() && grille[i+2][z-2] == j.getpion() && grille[i+3][z-3] == j.getpion()){
                    d1++;
                }
            }
            if(c == 2 || p == 2 || d == 2 || d1 == 1){
                System.out.println("Le joueur " + j.getnom() + " à gagner la partie");
                return true;
            }
        }
        return false;
    }
    
    /**
     * void affichechaine()
     * Méthode affichant la représentation de la grille 
     * en chaîne de caractère
     */
    public void affichechaine(){
        System.out.print(column + " " + row + " " ); 
        for(int i = 0 ; i <= row-1; i++){
            for(int z = 0 ; z <= column-1; z++){
                System.out.print(grille[i][z]);
            }
            System.out.print(" ");
        }
    }
    
    /**
     * boolean colonnepleine(int colonne)
     * Méthode vérifiant si la colonne en paramètre est pleine ou non
     * @param colonne colonne où l'on vérifie le contenu
     * retourne vrai si la colonne est pleine, faux sinon
     */
    public boolean colonnepleine(int colonne){
        int i = 0;
        while(i <= row-1 && this.grille[i][colonne-1] != "'' "){
            i++;
        }
        if(i == row)
            return true;
        return false;
    }
    
    /**
     * void IAnaif()
     * Méthode permettant à l'IA de jouer 
     */
    public void IAnaif(){
        Random r = new Random();
        int c = r.nextInt((row - 1) + 1) + 1;
        while(colonnepleine(c) == true){
            c = r.nextInt((row - 1) + 1) + 1;
            colonnepleine(c);
        }
        placerpion(c);
    }
}
