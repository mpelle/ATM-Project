// CashDispenser.java
public class CashDispenser {
	
	//INITIAL COUNT
	 public CashDispenser()
	    {
	        count = 500;
	    }

	 //credit input cash and minus from cash
	    public void dispenseCash(int i)
	    {
	          count -= i;
	    }
        //judge customer have enough cash
	    public boolean isSufficientCashAvailable(int i)
	    {
	       
	        return count >= i;
	    }
	    public double getAmount()
	    {
	    	return count;
	    	
	    }
        //varible declear
	    private static final int INITIAL_COUNT = 500;
		private int count;
	}
