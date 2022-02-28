package memory_tp_note;
import java.awt.event.*;

public class ControleurSouris implements MouseListener {

    private Modele modele;

    /**
     * constructeur 
     * @param m : Modele
     */
    public ControleurSouris(Modele m){
        this.modele=m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Return the card that user click
     * @param e : Mouse Event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Carte c=((VueCarte) e.getSource()).getCarte();
        int i=this.modele.getCartes().indexOf(c);
        this.modele.retournerCarte(i);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
