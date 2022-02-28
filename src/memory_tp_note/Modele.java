package memory_tp_note;
import java.util.*;

public class Modele implements Sujet{

    private int nbCoupsJoues;
    private int nbPairesTrouvees;
    private List<Carte> cartes;
    
    //First card clicked
    private Carte cartePrecedente;

    //List of observateurs saved in principale
    private List<Observateur> observateurs;

    // Type of Card
    private TypeCarte typeCarte;


    public Modele(){
        observateurs= new ArrayList<>();
        typeCarte=new Smiley();
        nbCoupsJoues=0;
        nbPairesTrouvees=0;
        cartes= new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Carte carte = new Carte((int) i / 2);
            cartes.add(carte);
        }
        Collections.shuffle(cartes);
        cartePrecedente=null;
        notifierObservateur();
    }

    /**
     * To hide every card and reset the game
     */
    public void cacher(){
        nbCoupsJoues=0;
        nbPairesTrouvees=0;
        cartePrecedente=null;
        Iterator<Carte> it=cartes.iterator();
        while (it.hasNext()){
            it.next().setVisible(false);
            this.notifierObservateur();
        }
    }

    /**
     * Mix all card and reset the game
     */
    public void melanger(){
        this.cacher();
        Collections.shuffle(cartes);
        this.notifierObservateur();
    }

    /**
     * Return a card : make it visible
     * If the cartePrecedente already had, we up the number of coups joues 
     * If it is the same of card right now
     * If not, we return all the 2 
     * The game ended when we found 10 paires
     * @param i index of Card
     */
    public void retournerCarte(int i){
        Carte c=this.cartes.get(i);
        // Check if this card is already showed
        if(!c.isVisible() && nbPairesTrouvees<10){
            c.setVisible(true);
            notifierObservateur();
            // In case one carte is showed
            if(this.cartePrecedente!=null){
                this.nbCoupsJoues+=1;
                // If they all the same
                if(c.getNum()==this.cartePrecedente.getNum()){
                    this.nbPairesTrouvees+=1;
                    notifierObservateur();
                //If not
                } else {
                    this.cartePrecedente.setVisible(false);
                    c.setVisible(false);
                }
                this.cartePrecedente=null;
            // If there's no carte Precedent
            }else{
                this.cartePrecedente=c;
            }

            // Check if we won or not
            if(this.nbPairesTrouvees>=10){
                System.out.println("Finished");
            }

        }
    }

    public List<Carte> getCartes(){
        return this.cartes;
    }

    public int getNbCoupsJoues() {
        return nbCoupsJoues;
    }

    public int getNbPairesTrouvees() {
        return nbPairesTrouvees;
    }

    /**
     * Add observateur to the list
     * @param o : Observateur
     */
    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    /**
     * Remove observateur to the list
     * @param o: Observateur
     */
    @Override
    public void supprimerObservateur(Observateur o) {
        int i=this.observateurs.indexOf(o);
        if (i>=0)
            this.observateurs.remove(i);
    }

    /**
     * F5 (refresh) the osvervateur
     */
    @Override
    public void notifierObservateur() {
        for (Observateur o:observateurs) {
            o.actualiser(this);
        }
    }

    // Set the type of card
    public void setTypeCarte(TypeCarte tc) {
        this.typeCarte=tc;
    }

    // get the type of card
    public TypeCarte getTypeCarte(){
        return this.typeCarte;
    }
}
