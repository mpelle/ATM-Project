//DepositSlot.java
public class DepositSlot {
	public DepositSlot(int i, Screen screen1,Keypad keypad1,Account accout1)
    {
		screen=screen1;
		keypad = keypad1;
		accout=accout1;
		bankdata=new BankDatabase();
    }

    public boolean isEnvelopeReceived()
    {
        return true;
    }
    public void execute()
    {
        amount = promptForDepositAmount();
        if(amount != 0.0D)
        {
            screen.displayMessage("\nPlease insert a deposit envelope containing ");
            screen.displayAmount(amount);
            screen.displayMessageLine(".");
            boolean flag = isEnvelopeReceived();
            if(flag)
            {
                screen.displayMessageLine("\nYour envelope has been received.\nNOTE: The money just deposited will not be available until we verify the amount of any enclosed cash and your checks clear.");
              if(bankdata.credit(accout.getAccountNumber(),amount))
              {
                 System.out.println("¥Ê«Æ≥…π¶£°");
            	  //accout.credit(amount);
              }
            
            } else
            {
                screen.displayMessageLine("\nYou did not insert an envelope, so the ATM has canceled your transaction.");
            }
        } else
        {
            screen.displayMessageLine("\nCanceling transaction...");
        }
    }

    private double promptForDepositAmount()
    {
       
        screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): ");
        int i = keypad.getInput();
        if(i == 0)
            return 0.0D;
        else
            return (double)i;
    }
    private double amount;
    private Keypad keypad;
    private BankDatabase bankdata;
    private Screen screen;
    private static final int CANCELED = 0;
    private Account accout;
}

