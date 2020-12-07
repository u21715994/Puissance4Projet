import java.util.Scanner;

public class JvsIA{
    public static void main(String [] args){
        int continuer = 1;
        while(continuer == 1){
            Scanner clavier = new Scanner(System.in);
            System.out.println("Entrez le nombre de rangée que vous voulez ");
            int rangee = clavier.nextInt();
            System.out.println("Entrez le nombre de colonne que vous voulez ");
            int colonne = clavier.nextInt();
            clavier.nextLine();
            
            System.out.println("Entrez votre nom");
            Joueur j1 = new Joueur(clavier.nextLine()," X ");
            System.out.println("Vous: " + j1.getnom() + " ,joueur 1");
            Grille g = new Grille(rangee,colonne,j1);
            
            Joueur ia = new Joueur("IA"," O ");
            System.out.println("Adversaire: " + ia.getnom() +" ,Ordinateur");
            Grille g2 = g.copy();
            g2.setjoueur(ia);
            g2.setgrille(g.getgrille());
            g.actualiseGrille();
            
            while((g.victoire() != true) && (g.matchnull() != true) && (g2.victoire() != true) && (g2.matchnull() != true)){
                System.out.println("Joueur 1: Veuillez sélectionner la colonne où vous souhaiter placez votre pion");
                g.placerpion(clavier.nextInt());
                if(g.victoire() == false && g.matchnull() == false){
                    g2.IAnaif();
                }
            }
            System.out.println("Voulez-vous recommencer une nouvelle partie");
            System.out.println("1 : Commencer une nouvelle partie   |  0 : Quitter le puissance 4 ");
            continuer = clavier.nextInt();
            while(continuer != 0 && continuer != 1){
                System.out.println("Veuillez réssayez");
                System.out.println("1 : Commencer une nouvelle partie   |  0 : Quitter le puissance 4 ");
                continuer = clavier.nextInt();
            }
        }
    }
}
