import java.util.Scanner;
public class ATM 
{
	private BankDatabase bankdata;
    public ATM()
    	{
    
    	userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
       input=new Scanner(System.in);
        bankdata=new BankDatabase();
        cashDispenser = new CashDispenser();//出钱
       accout=new Account();
    		
    	}
    //function method
    public void run()
    {
    	
    	  while(!userAuthenticated) 
            {
                screen.displayMessageLine("\nWelcome!");
                authenticateUser();
            }
            performTransactions();
            userAuthenticated = false;
            currentAccountNumber = 0;
            screen.displayMessageLine("\nThank you! Goodbye!");
        
    }	
    private void performTransactions() {
		// TODO Auto-generated method stub
    	accout.setTotalBalance(cashDispenser.getAmount());
        boolean flag = false;
        do
        {
            if(flag)
                break;
            int i = displayMainMenu();
            switch(i)
            {
            case 1: 
            case 2: 
            case 3:
            case 5:
            	handle(i);break;
            case 4://0004
                screen.displayMessageLine("\nExiting the system...");
                flag = true;
                break;

            default:
                screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
                break;
            }
        } while(true);
    }
   
    private void  handle(int i)
    {
    	int quids=0;int flag=6;
    	int input1=0;
    switch(i)
    	{
  
    	case 1:screen.displayMessage("你的可用金额为：");
    		screen.displayAmount(bankdata.getAvailableBalance(accout.getAccountNumber()));
    	       System.out.println();
    	       screen.displayMessage("你的可透支金额为：");
    	       screen.displayAmount(bankdata.getOverdraft(accout.getAccountNumber()));
    	       System.out.println();
    	       screen.displayMessage("总金额为：");
    	       screen.displayAmount(bankdata.getTotalBalance(accout.getAccountNumber()));
    	break;
    	case 2:
    		do{
    			screen.displayMessageLine("Please take your cash now.");
    		
    	       quids=keypad.getInput();
    	       if(quids<=accout.getAvailableBalance())
    	       {
    	    	   if(bankdata.debit(accout.getAccountNumber(), (double)quids))
       	    	{
       	    	 
       	    		flag=0;screen.displayMessageLine("取钱成功！");
       	    	} 
    	       }
    	       if((quids>accout.getAvailableBalance())&&(quids<accout.getTotalBalance()))
    	       {
    	    	   double b=bankdata.getOverdraft(accout.getAccountNumber())+bankdata.getAvailableBalance(accout.getAccountNumber())-(double)quids;
    	  
    	    	   if(bankdata.debit(accout.getAccountNumber(), (double)quids)&&bankdata.overdraft(accout.getAccountNumber(),b))
    	    	{
    	    	 
    	    		flag=0;screen.displayMessageLine("取钱成功！");
    	    		
    	    	}
    	    	//else  System.out.println("Error"); 
    	       }else{
    	    	   screen.displayMessageLine("Sorry,you have not enough money!,you can try six times");
    	    	   flag--; if(flag==0){screen.displayMessageLine("sorry,you must quit Systrem");}
    	           }
    		  }while(flag!=0);break;
    	case 3:
    	      
    	        input1=keypad.getInput();
    	        double tt=bankdata.getAvailableBalance(accout.getAccountNumber());
    	        double t=bankdata.getOverdraft(accout.getAccountNumber());
    	        if(input1>0)
    	        {
    	        	if(tt>=0)
    	        	{
    	        	if(bankdata.credit(accout.getAccountNumber(), (double)input1))
    	        		System.out.println("存钱成功！");
    	        	else  System.out.println("存钱失败！");
    	        	}
    	        	else
    	        	{
    	        		if((t+input1)>500)
    	        		{
    	        			bankdata.overdraft(accout.getAccountNumber(), 500);
    	        			if(bankdata.credit(accout.getAccountNumber(), (double)input1))
    	        			
    	        				System.out.println("存钱成功！");
    	        	        	else  System.out.println("存钱失败！");
    	        			
    	        		}
    	        		if((t+input1)<500)
    	        		{
    	        			bankdata.overdraft(accout.getAccountNumber(), t+input1);
    	        		if(bankdata.credit(accout.getAccountNumber(), (double)input1))
    	        			
	        				System.out.println("存钱成功！");
	        	        	else  System.out.println("存钱失败！");
    	        		}
    	        	}
    	        }
    	        break;
    	 case 5:
             boolean ff=true;
         while(ff){
        		System.out.println("请输入原密码！");
         	int k = input.nextInt();
         	int kk=accout.getPassword();
         	System.out.println("请输入新密码！");
         	int k_1 =input.nextInt();
         	System.out.println("再输入新密码！");
         	int k_2 = input.nextInt();
         	if(k==kk){
         		if(k_1==k_2)
         		{
         		
         			if(bankdata.rePassword(accout.getAccountNumber(), k, k_1))
         		
         			System.out.println("密码设置成功！");
         			ff=false;
         		}
         		else
         		{
         		System.out.println("两次密码输入不一样，请重新输入");
         		
         		}
         	}
         	else
         		System.out.println("密码不正确，请重新输入！");
         }
              break;
    		
    	}
    }

    private int displayMainMenu() {
		// TODO Auto-generated method stub\
    	screen.displayMessageLine("\n主菜单:");
        screen.displayMessage("1 - 显示余额");
        screen.displayMessage("   2 - 取钱");
        screen.displayMessage("   3 - 存钱");
        screen.displayMessage("   4 - 退出");
        screen.displayMessage("   5修改密码\n");
        screen.displayMessage("请选择1~~5: ");
        return keypad.getInput();
		
	}
	private void authenticateUser() {
	     boolean flag=true;
		  while(flag){
		screen.displayMessage("\nID: ");
        int i = keypad.getInput();
        screen.displayMessage("\nPASS: ");
        int j = keypad.getInput();
        if(bankdata.authenticateUser(i, j)) 
       {
    	   userAuthenticated=true;
    	   accout.setAccoutNumber(i);
           accout.setPassword(j);
           System.out.print("      你好"+bankdata.getName(i));
           System.out.println(",欢迎使用ATM机！");
           flag=false;
       }
       else
       {
    	   System.out.println("密码错误，请重新输入！");
       }
      }
       
         		
	}
	private boolean userAuthenticated;
    @SuppressWarnings("unused")
	private int currentAccountNumber;
	private Screen screen;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    //private DepositSlot depositSlot;
    private Account accout;
    private  Scanner input;
    
    
}


