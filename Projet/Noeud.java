public class Noeud{
    private Grille info;
    private Noeud[] fils;
    
    public Noeud(Grille info , Noeud[] fils){
        this.info = info;
        this.fils = fils;
    }
    
    public Noeud(Noeud[] fils){
        this.fils = fils;
    }
    
    public void setinfo(Grille info){
        this.info = info;
    }
    
    public Grille getinfo(){
        return info;
    }
    
    public Noeud[] getn(){
        return fils;
    }
    
    public Noeud getfils(int colonne){
        return fils[colonne];
    }
    
    public void setracine(Noeud[] fils){
        this.fils = fils;
    }
}
