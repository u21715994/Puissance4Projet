import java.util.Scanner;

public class Partie{
    public static void main(String [] args){
        int partie = 1;
        while(partie == 1){
            Scanner clavier = new Scanner(System.in);
            System.out.println("Bienvenue dans Puissance 4");
            System.out.println();
            System.out.println("Veuillez sélectionnez un mode de jeu");
            System.out.println("1-Joueur contre Joueur  |  2-Joueur contre Ordinateur");
            int p = clavier.nextInt();
            while(p != 1 && p != 2){
                p = clavier.nextInt();
            }
            
            if(p == 1)
                JvsJ.main(args);
            else
                JvsIA.main(args);
                    
            System.out.println();
            System.out.println("Voulez-vous quitter Puissance 4");
            System.out.println("0-Oui  |  1-Non");
            partie = clavier.nextInt();
            while(partie != 1 && partie != 0){
                System.out.println("Erreur.Veuillez entrer les bonnes valeurs");
                partie = clavier.nextInt();
            }
        }
        System.out.println("Fin de Puissance 4");
    }
}
