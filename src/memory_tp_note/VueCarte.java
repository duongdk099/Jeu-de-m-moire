package memory_tp_note;

import javax.swing.*;

public class VueCarte extends JLabel implements Observateur{

    private int indexCarte;
    private Carte carte;
    protected String repertoire;


    public VueCarte(Carte c, String repert, int index){
        this.carte=c;
        this.repertoire=repert;
        this.indexCarte=index;
    }

    /**
     * Refreshed the card
     * @param s : Sujet as Modele
     */
    @Override
    public void actualiser(Sujet s) {
        Modele modele=(Modele) s;
        String chemin;


        this.carte=modele.getCartes().get(this.indexCarte);
        this.repertoire=modele.getTypeCarte().getRepertoire();


        if(this.carte.isVisible()){
            chemin="img/"+repertoire+"/im"+carte.getNum()+".png";
        }
        
        else{
            chemin="img/"+repertoire+"/fond.png";
        }

        
        this.setIcon(new ImageIcon(chemin));
        this.repaint();
    }

    public Carte getCarte() {
        return carte;
    }
}
