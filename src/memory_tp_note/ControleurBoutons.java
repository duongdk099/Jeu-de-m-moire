package memory_tp_note;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * controleur des boutons
 */
public class ControleurBoutons implements ActionListener {

    private Modele modele;
    /**
     * constructeur de base
     * @param mod
     */
    public ControleurBoutons(Modele mod){
        this.modele=mod;
    }

    /**
     * appel des methodes correspondantes au bouton clique
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Fruits")){
            this.modele.setTypeCarte(new Fruits());
            this.modele.notifierObservateur();
        }
        if(e.getActionCommand().equals("Smiley")){
            this.modele.setTypeCarte(new Smiley());
            this.modele.notifierObservateur();
        }

        if(e.getActionCommand().equals("Cacher")){
            this.modele.cacher();
        }
        if (e.getActionCommand().equals("Melanger")){
            this.modele.melanger();
        }
        
    }

}
