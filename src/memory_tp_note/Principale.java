package memory_tp_note;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * classe principale Memory
 */
public class Principale {

	Modele m;
	VueNbCoups vNC;
	VueNbPaires vNP;
	ControleurBoutons cB;
	ControleurSouris cS;


	public Principale(){

		m=new Modele();

		cB=new ControleurBoutons(m);
		cS=new ControleurSouris(m);

		vNC=new VueNbCoups();
		m.enregistrerObservateur(vNC);
		vNP=new VueNbPaires();
		m.enregistrerObservateur(vNP);


		/**********************************
		 * Création des bords des composants
		 ***********************************/
		Border compound;
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		compound 			= BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

		/*******************************************************************
		 * Le JPanel plateau au nord dans lequel les cartes sont affichees
		 * les JLabel avec une ImageIcon associee a chaque carte
		 * Le choix du jeu de carte est fait selon la valeur de répertoire
		 ********************************************************************/
		JPanel plateau =new JPanel();
		plateau.setBorder(compound);
		plateau.setLayout(new GridLayout(4, 5));
		plateau.setSize(120 * 5, 120 * 4);
		for (int i = 0; i < 20; i++) {
			VueCarte vc=new VueCarte(m.getCartes().get(i),m.getTypeCarte().getRepertoire(),i);
			m.enregistrerObservateur(vc);
			plateau.add(vc);
			vc.addMouseListener(cS);
		}
		m.notifierObservateur();

		/********************************************************************
		 * Le JPanel panneauScore au centre de l'IG contenant des informations
		 * sur le nombre de coups joues et le nombre de paires decouvertes
		 ********************************************************************/
		JPanel panneauScore;
		panneauScore= new JPanel(new GridLayout(2,1));

		vNC.setBorder(compound);
		panneauScore.add(vNC);

		vNP.setBorder(compound);
		panneauScore.add(vNP);

		/********************************************************************
		 * Le JPanel panneauChoix au sud de l'IG contenant les 4 boutons
		 ********************************************************************/
		JPanel panneauChoix=new JPanel();

		JButton boutonSmiley = new JButton("Smiley");
		panneauChoix.add(boutonSmiley);
		boutonSmiley.addActionListener(cB);

		JButton boutonFruits = new JButton("Fruits");
		panneauChoix.add(boutonFruits);
		boutonFruits.addActionListener(cB);

		JButton boutonCacher = new JButton("Cacher");
		panneauChoix.add(boutonCacher);
		boutonCacher.addActionListener(cB);

		JButton boutonMelanger = new JButton("Melanger");
		panneauChoix.add(boutonMelanger);
		boutonMelanger.addActionListener(cB);


		/**************************************
		 * Construction de l'IG dans une JFrame
		 ***************************************/
		JFrame frame=new JFrame("Memory MVC");
		frame.getContentPane().setBackground(Color.BLUE);

		frame.add(plateau,BorderLayout.NORTH);
		frame.add(panneauScore,BorderLayout.CENTER);
		frame.add(panneauChoix, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args){

		new Principale();

	}

}
