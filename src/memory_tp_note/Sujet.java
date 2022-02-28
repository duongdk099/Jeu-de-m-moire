package memory_tp_note;

/**
 * interface Sujet
 */
public interface Sujet {

    void enregistrerObservateur(Observateur o);

    void supprimerObservateur(Observateur o);

    void notifierObservateur();

}
