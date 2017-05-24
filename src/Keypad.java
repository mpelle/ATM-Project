//Keyboard
import java.util.*;
public class Keypad {
	//INITIAL Keypad,create Scanner to obtain input from command
       	Keypad()
        {
        	input=new Scanner(System.in);
        	      	
        }
       	//return the input
		public int getInput()
	    {
	        return input.nextInt();
	    }
		public double getDouble()
		{
			return input.nextDouble();
		}
       //create Scanner object
	    private Scanner input;
	}

