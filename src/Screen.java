//Screen class 

public class Screen {
	//INITANCE SCREEN
	 public Screen()
	    {
	    }
       
	 //show message on one,there are line
	    public void displayMessage(String s)
	    {
	        System.out.print(s);
	    }
      //show message on one line
	    public void displayMessageLine(String s)
	    {
	        System.out.println(s);
	    }
       //show amount
	    public void displayAmount(double d)
	    {
	        System.out.printf("$%,.2f", new Object[] {
	            Double.valueOf(d)
	        });
	    }
	    
	}
              

