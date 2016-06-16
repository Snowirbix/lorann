package main;

import controller.Controller;
import model.Model;
import view.View;
//Ceci importe la classe Scanner du package java.util
import java.util.Scanner; 
//Ceci importe toutes les classes du package java.util
import java.util.*;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		final Model model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		//controller.control();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose your level (1-5) :");
		int str = sc.nextInt();
		System.out.println("Loading level " + str);
		model.loadMap(str);
	}
}