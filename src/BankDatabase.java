import java.sql.*;

public class BankDatabase
{
    private Account accounts[];
    private DataCon databaseCon;
    private ResultSet rs;
   private double totalMoney;
   private double avBalance;
    
    public BankDatabase()
    {
    	rs=null;
    	databaseCon=new DataCon();
        accounts = new Account[2];
       
      
    }
    
    private Account getAccount(int i)
    {
        Account aaccount[] = accounts;
        int j = aaccount.length;
        for(int k = 0; k < j; k++)
        {
            Account account = aaccount[k];
            if(account.getAccountNumber() == i)
                return account;
        }

        return null;
    }

    public boolean authenticateUser(int i, int j)
    {
    	if(databaseCon.connection())
    	{
    		String check="select * from customer where accuntNumber="+i+"and password="+j;
    		rs=databaseCon.exeSQL(check);
    		
    		try {
				while(rs.next())
				{
					 totalMoney=rs.getDouble("totalBalance");
					 avBalance=rs.getDouble("availableBalance");
					accounts[0] = new Account(i, j,avBalance,totalMoney, avBalance);
					return true;
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
    	   	
    	}
                 return false;
    }
    public boolean authenticateUser(int i)
    {
    	if(databaseCon.connection())
    	{
    		String check="select * from customer where accuntNumber="+i;
    		rs=databaseCon.exeSQL(check);
    		
    		try {
				while(rs.next())
				{
					int pin=rs.getInt("password");
					 totalMoney=rs.getDouble("totalBalance");
					 avBalance=rs.getDouble("availableBalance");
					 
					accounts[1] = new Account(i, pin,avBalance,totalMoney, avBalance);
					return true;
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
    	   	
    	}
                 return false;
    }


    public double getAvailableBalance(int i)
    {
        return getAccount(i).getAvailableBalance();
    }

    public double getTotalBalance(int i)
    {
        return getAccount(i).getTotalBalance();
    }

    public boolean credit(int i, double d)
    {
        getAccount(i).credit(d);
           totalMoney=getAccount(i).getTotalBalance();
          if(databaseCon.connection())
        	{
        		String check="update customer set  totalBalance="+totalMoney+" where accuntNumber="+i;
        		int rs=databaseCon.exeUpdate(check);
        		if(rs!=0)return true;
        		else return false;
        	}
            return false;
        }


    public boolean debit(int i, double d)
    {
        getAccount(i).debit(d);
         totalMoney=getAccount(i).getTotalBalance();
        avBalance=getAccount(i).getAvailableBalance();
        if(databaseCon.connection())
    	{
    		String check="update customer set  totalBalance="+totalMoney+",availableBalance="+avBalance+" where accuntNumber="+i;
    		int rs=databaseCon.exeUpdate(check);
    		if(rs!=0)return true;
    		else return false;
    	}
        return false;
    }
    public boolean rePassword(int i,int OPass,int NPass)  
    {   
    	if(getAccount(i).validatePassword(OPass))
    	{
    	String check="update customer set password="+NPass+" where accuntNumber="+i;
    	int rs=databaseCon.exeUpdate(check);
		if(rs!=0)return true;
		else return false;
	}
	     	return false;
    }

	public double getOverdraft(int accountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean overdraft(int accountNumber, double b) {
		// TODO Auto-generated method stub
		return false;
	}

   
}