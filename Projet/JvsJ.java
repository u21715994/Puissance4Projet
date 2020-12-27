import java.util.Scanner;

public class JvsJ{
    public static void main(String [] args){
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
        System.out.println("Entrez votre nom");
        Joueur j2 = new Joueur(clavier.nextLine()," O ");
        System.out.println("Vous :" + j2.getnom() + " ,joueur2");
            
        Grille g2 = g.copy();
        g2.setjoueur(j2);
        g2.setgrille(g.getgrille());
        g.actualiseGrille();
            
        while((g.victoire() != true) && (g2.victoire() != true) && (g.matchnull() != true) && (g2.matchnull() != true)){
            System.out.println("Joueur 1: Veuillez sélectionner la colonne où vous souhaiter placez votre pion");
            g.placerpion(clavier.nextInt());
            if(g.victoire() == false && g.matchnull() == false){
                System.out.println("Joueur 2: Veuillez sélectionner la colonne où vous souhaiter placez votre pion");
                g2.placerpion(clavier.nextInt());
            }
        }
            
        if(g.victoire())
            System.out.println("Le joueur " + g.getjoueur().getnom() + " à gagner la partie");
        else if(g2.victoire())
            System.out.println("Le joueur " + g2.getjoueur().getnom() + " à gagner la partie");
        else
            System.out.println("Partie terminé.Match nul");
    }
}
