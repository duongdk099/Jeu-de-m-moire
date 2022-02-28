package memory_tp_note;

import javax.swing.*;
import java.awt.*;

/**
 * Observateur VueNbCoups permettant l'affichage du nombre de coups joues
 */
public class VueNbCoups extends JLabel implements Observateur {

    /**
     * creation de l'affichage du texte à 0 par default
     */
    public VueNbCoups(){
        super("Number coups joues : 0",JLabel.CENTER);
        this.setPreferredSize(new Dimension(600,60));
        this.setOpaque(true);
        this.setForeground(Color.blue);
    }

    /**
     * actualisation de l'affichage du nombre de coups joues
     * @param s
     */
    @Override
    public void actualiser(Sujet s) {
        Modele m=(Modele)s;
        this.setText("Number coups joues :"+m.getNbCoupsJoues());
    }
}
