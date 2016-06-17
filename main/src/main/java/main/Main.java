package main;

import controller.Controller;
import model.Model;
import view.View;
//Ceci importe la classe Scanner du package java.util
import java.util.Scanner; 

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
		
		int test  = 0;
		do
		{
			System.out.println("Choose your level (1-6) :");
			Scanner sc = new Scanner(System.in);
			int str = sc.nextInt();
			
			if(str >= 0 && str <= 6) {
				model.loadMap(str);
				test = 1;
			}
			else{
				System.out.println("Error !");
			}
			
		}while (test == 0);
			
	}
}