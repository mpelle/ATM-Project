import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Atm_Swing extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BankDatabase bankdata;
	private Account accout;
  static final int WIDTH=300;
  static final int HEIGHT=150;
  JTextField nameinput=new JTextField(15);
	JPasswordField passwordinput=new JPasswordField(15);
  JFrame loginframe;
  public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)
  {
	  constraints.gridx=x;
	  constraints.gridy=y;
	  constraints.gridwidth=w;
	  constraints.gridheight=h;
	  add(c,constraints);
	  
  }
  public Atm_Swing()
  {
	  bankdata=new BankDatabase();
	  accout=new Account();
	loginframe=new JFrame("欢迎使用Atm机");  
	loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GridBagLayout lay=new GridBagLayout();
	setLayout(lay);
	loginframe.add(this,BorderLayout.WEST);
	loginframe.setSize(WIDTH,HEIGHT);
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int width=screenSize.width;
	int height=screenSize.height;
	int x=(width-WIDTH)/2;
	int y=(height-HEIGHT)/2;
	loginframe.setLocation(x, y);
	JButton ok=new JButton("确认");
	    
	JButton cancel=new JButton("取消");
	JLabel name=new JLabel("用户名");
//	name.addActionListener(this);
	JLabel title=new JLabel("布局管理器测试窗口");
	JLabel password=new JLabel("密码");
	
	ok.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent Event)
    	{
    		String id=nameinput.getText();
    		String pass=passwordinput.getText();
    		int i=Integer.parseInt(id);
    		int j=Integer.parseInt(pass);
    		 if(bankdata.authenticateUser(i, j)) 
    	       {
    	    	 //  userAuthenticated=true;
    	    	   accout.setAccoutNumber(i);
    	           accout.setPassword(j);
    	           System.out.print("      你好"+bankdata.getName(i));
    	           System.out.println(",欢迎使用ATM机！");
    	         //  flag=false;
    	       }
    		 else
    			 System.out.println("Error!");
    	}
    }
    );
	cancel.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent Event)
		{
			nameinput.setText("");
			passwordinput.setText("");
		}
		
	}
	);
	GridBagConstraints constraints=new GridBagConstraints();
	constraints.fill=GridBagConstraints.NONE;
	constraints.anchor=GridBagConstraints.EAST;
	constraints.weightx=3;
	constraints.weighty=4;
	add(title,constraints,0,0,4,1);
	add(name,constraints,0,1,1,1);
	add(password,constraints,0,2,1,1);
	add(nameinput,constraints,2,1,1,1);
	add(passwordinput,constraints,2,2,1,1);
	add(ok,constraints,0,3,1,1);
	add(cancel,constraints,2,3,1,1);
	loginframe.setResizable(false);
	loginframe.setVisible(true);
	  
  }
  
  public static void main(String args[])
  {
	  
	  Atm_Swing  a =new  Atm_Swing();
  }
}
