package memory_tp_note;

import javax.swing.*;
import java.awt.*;

/**
 * Observateur VueNbPaires permettant l'affichage du nombre de paires trouvees
 */
public class VueNbPaires extends JLabel implements Observateur {


    public VueNbPaires(){
        super("Number of Paires found : 0",JLabel.CENTER);
        this.setPreferredSize(new Dimension(600,60));
        this.setOpaque(true);
        this.setForeground(Color.blue);
    }

    /**
     * actualisation de l'affichage du nombre de paires trouvees
     * @param s
     */
    @Override
    public void actualiser(Sujet s) {
        Modele m=(Modele) s;
        this.setText("Number of Paires found :"+m.getNbPairesTrouvees());
    }
}
