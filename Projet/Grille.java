import java.util.Random;

public class Grille{
    /**
     * @authors Youssef Oussouf et Assia El Gharbi
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
    
    public Grille(Grille g){
        row = g.row;
        column = g.column;
        j = g.j;
        grille = new String[row][column];
        for(int i = row-1 ; i >= 0; i--){
            for(int z = column-1; z >= 0; z--){
                grille[i][z] = g.grille[i][z];
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
        if(!victoire())
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
    
    /**
     * void arbre()
     * Méthode créant un arbre de Noeud(cf class Noeud) de profondeur 1
     * et joue le meilleur coup 
     * (cf int verif(Noeud n)) 
     */
    public void arbre(){
        Noeud n[] = new Noeud[column];
        Noeud r = new Noeud((this),n);
        r.getinfo().copy();
        r.getinfo().setgrille(grille);
        Arbre a = new Arbre(r);
        int i = 0;
        for(int z = 0; z <= column-1; z++){
            for(int y = row-1; y >= 0; y--){
                if(grille[y][z] == "'' "){ 
                    this.grille[y][z] = j.getpion();
                    n[i] = new Noeud(new Grille(this),null);
                    this.grille[y][z] = "'' ";
                }
            }
            i++;
        }
        int j = 0;
        int b = 0;
        int c = 0;
        while(j <= column-1){
            if(b <= verif(r.getfils(j))){
                b = verif(r.getfils(j));
                c = j;
            }
            j++;
        }
        if(c <= column-2){
            while(colonnepleine(c+1)){
                c++;
            }
        }else{
            while(colonnepleine(c+1)){
                c--;
            }
        }
        grille = r.getfils(c).getinfo().grille;
        actualiseGrille();
        if(!victoire())
            matchnull();
    }
    
    /**
     * verif(Noeud n)
     * Méthode vérifiant la grille du Noeud
     * @param Noeud n 
     * renvoie un entier positif si c'est un bon coup
     * sinon renvoie un entier négatif
     */
    public int verif(Noeud n){
        if(n == null)
            return 0;
        int a = 0;
        int b = 0;
        for(int i = 0 ; i <= row-1; i++){
            for(int z = 0 ; z <= column-1; z++){
                if(n.getinfo().grille[i][z] == j.getpion())
                    a++;
                if(i >= 1 && n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i-1][z] == j.getpion() || i <= row-2 && n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z] == j.getpion())
                    b--;
                if(i <= row-4 && n.getinfo().grille[i][z] == j.getpion() && n.getinfo().grille[i+1][z] == "'' " && n.getinfo().grille[i+2][z] == "'' " && n.getinfo().grille[i+3][z] == "'' ")
                    a++;
                if(i <= row-2 && n.getinfo().grille[i][z] == j.getpion() && n.getinfo().grille[i+1][z] == "'' ")
                    a++;
                if(i <= row-2 && n.getinfo().grille[i][z] == j.getpion() && n.getinfo().grille[i+1][z] == j.getpion())
                    a+=3;
                if(i <= row-4 && n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z] == " X " && n.getinfo().grille[i+2][z] == " X " && n.getinfo().grille[i+3][z] == j.getpion())
                    a+=4;
                if( (z <= column-4 && n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i][z+1] == " X " && n.getinfo().grille[i][z+2] == " X " && n.getinfo().grille[i][z+3] == j.getpion())
                || (z <= column-4 && n.getinfo().grille[i][z] == j.getpion() && n.getinfo().grille[i][z+1] == " X " && n.getinfo().grille[i][z+2] == " X " && n.getinfo().grille[i][z+3] == " X ") )
                    a+=4;
                if((i <= row-4 && z >= 3) && ( (n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z-1] == " X " && n.getinfo().grille[i+2][z-2] == " X " && n.getinfo().grille[i+3][z-3] == j.getpion()) ||
                (n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z-1] == " X " && n.getinfo().grille[i+2][z-2] == j.getpion() && n.getinfo().grille[i+3][z-3] == " X ") ||
                (n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z-1] == j.getpion() && n.getinfo().grille[i+2][z-2] == " X " && n.getinfo().grille[i+3][z-3] == " X ") ||
                (n.getinfo().grille[i][z] == j.getpion() && n.getinfo().grille[i+1][z-1] == " X " && n.getinfo().grille[i+2][z-2] == " X " && n.getinfo().grille[i+3][z-3] == " X ") ))
                    a+=6;
                if((i <= row-4 && z <= column-4) && ( (n.getinfo().grille[i][z] == j.getpion() && n.getinfo().grille[i+1][z+1] == " X " && n.getinfo().grille[i+2][z+2] == " X " && n.getinfo().grille[i+3][z+3] == " X ") ||
                (n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z+1] == j.getpion() && n.getinfo().grille[i+2][z+2] == " X " && n.getinfo().grille[i+3][z+3] == " X ") ||
                (n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z+1] == " X " && n.getinfo().grille[i+2][z+2] == j.getpion() && n.getinfo().grille[i+3][z+3] == " X ") ||
                (n.getinfo().grille[i][z] == " X " && n.getinfo().grille[i+1][z+1] == " X " && n.getinfo().grille[i+2][z+2] == " X " && n.getinfo().grille[i+3][z+3] == j.getpion()) )){
                    a+=6;
                }
            }
        }
        
        if(a <= -b)
            return b;
        return a;
    }
}
