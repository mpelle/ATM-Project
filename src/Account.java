//create Accout.java to save message
public class Account {
	 public Account(int i,int j,double avBalance,double totalMoney,double ov)
	 {
	      accountNumber=i;
			password=j;
			availableBalance=avBalance;
			 totalBalance=totalMoney;
			 overdraft=ov;
	 }
	 public void setAccoutNumber(int i) {
		accountNumber = i;
	}
   public Account()
   {}
	public void setPassword(int j) {
		password = j;
	}
	
	public void setAvailableBalance(double d){
		availableBalance = d;
	}
	
	public void setTotalBalance(double d1){
		totalBalance = d1;
	}

	public void setOverdraft(double j)
	{
		overdraft=j;
	}
	public double getOverdraft()
	{
		return overdraft;
	}
    public int getPassword()
    {
    	return password;
    }
	public double getAvailableBalance() {//可用钱增加
		return availableBalance;
	}

	public double getTotalBalance() {//总的钱增加
		return totalBalance;
	}

	public void credit(double d) {//总的钱减少
		totalBalance += d;
		
	}
	public void credit_1(double d)//可用钱减少
	{
		availableBalance+=d;
	}
	public void debit(double d) {

		totalBalance -= d;
	}
	  public void debit_1(double d)
	  {
		 
		  availableBalance-=d;
		
	  }
	public int getAccountNumber() {
		return accountNumber;
	}
    private double overdraft;//透支
	private int accountNumber;
	private int password;
	private double availableBalance;
	private double totalBalance;
	public boolean validatePassword(int oPass) {
		// TODO Auto-generated method stub
		return false;
	}
}
