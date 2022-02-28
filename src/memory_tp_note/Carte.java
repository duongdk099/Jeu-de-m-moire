package memory_tp_note;

/**
classe represnetant une carte
 */
public class Carte {

	/**
	 * true: visible
	 * false: cachee
	 */
	private boolean visible;
	/**
	 * numero du fichier image
	 */
	private int num;

	/**
	 * constructeur de base mettant la carte cachee par default
	 * @param num
	 */
	public Carte(int num) {
		this.num = num;
		this.visible = false;
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getNum() {
		return (this.visible)? this.num : -1; //Si visible == true alors l'attribut num est retourne 
											 // sinon -1 est retourne
	}

	public void setNum(int num) {
		this.num = num;
	}
}
