import java.sql.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
public class atmscreen /*implements ActionListener*/{
	CardLayout clt=new CardLayout();
	//double balance=5;
	int nstate=0;//判别多个状态 1、修改密码；2、数据输入；3、菜单
	JPanel Pmenu,Pgetmoney,Pinput,Preset,Panwel,Pqueryleft,PnlMsg,Pmain,Pother_1,Pother_2;
   JFrame frame;
   JLabel name,password,j2;
   JButton ok,cancel;//数字键按钮
   Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12;
   JButton M_input,M_chaxun,M_getmoney,M_reset,M_Exit;//菜单面板的按钮
   JButton b1,b2,b3,b4,b5,b6,b7,b8;//取款按钮
   JButton c1,c2;//查询按钮
   JButton dok,d1,d2;  //修改密码按钮
   JButton e1,e2,e3,e4,e5,e6,e7,e8;//存款按钮
   JButton g1,g2;//取款其他按钮
   JTextField get_m;//取款其他文本框
   Button g_1,g_2,g_3,g_4,g_5,g_6,g_7,g_8,g_9,g_10,g_11,g_12;
   JButton i1,i2;//存款其他按钮
   JTextField input_m;//存款其他文本框
   Button i_1,i_2,i_3,i_4,i_5,i_6,i_7,i_8,i_9,i_10,i_11,i_12;
   JTextArea a1;//主菜单文本域
   TextArea text;
   JLabel lbleft;//查询显示标签
   JLabel msg;//修改密码标签
	JTextField get_money,input_money;
	 JTextField nameinput=new JTextField(15);
  JPasswordField passwordinput=new JPasswordField(15);
	JPasswordField oldpwd,newpwd1,newpwd2;
 BankDatabase bankdata=new BankDatabase();
	 Account accout=new Account();
	 StringBuffer str=new StringBuffer(); 
	 StringBuffer str1=new StringBuffer();
	 StringBuffer str2=new StringBuffer();
	public void mainFram()
	{
      frame=new JFrame("ATM");
      Pmain=new JPanel(clt);
     // Pmain.setBackground(Color red);
      Pmain.setBackground(Color.blue);
		this.showWel();
		this.showMenu();
		this.showInput();
		this.showGetMoney();
		this.showQueryLeft();
		this.showChangePwd();
		this.showother_1();
		this.showother_2();
	
	  
// frame.setLayout(clt);// 卡片布局方式
		
		Pmain.add(Panwel,"wel");	
		Pmain.add(Pmenu,"Menu");
		Pmain.add(Pinput,"input");
		Pmain.add(Preset,"Chgpwd");
		Pmain.add(Pgetmoney,"Getmoney");
		Pmain.add(Pqueryleft,"Queryleft");
		Pmain.add(Pother_1,"other1");
		Pmain.add(Pother_2,"other2");
	//	frame.add(PnlMsg,"Msg");
		frame.add(Pmain);
		frame.setTitle("银行系统");
		frame.setBounds(400, 200, 520, 330);
		frame.setBackground(Color.lightGray);
		//frame.setResizable(false);// 禁止调整框架的大小
		//frame.setSize(550,250);
//	frame.pack();
		frame.setLocation(400,200);
		frame.setVisible(true);	
		//clt.show(Pmain, "wel");
	}
	public void showWel()
	{
	Panwel=new JPanel();
	//Panwel.setBackground(Color.GRAY);
	Panwel.setLayout(null);
	//Panwel.setLayout(new GridLayout(1,2));
	JPanel left = new JPanel();
	left.setBounds(0, 50, 250, 100);
	Panwel.add(left);
	JPanel right = new JPanel();
	right.setBounds(270, 10, 200, 150);
	Panwel.add(right);
	JPanel message = new JPanel();
	message.setBounds(0, 170, 500, 100);
	text = new TextArea("这是信息框！",10,60,TextArea.SCROLLBARS_NONE);
	text.setBackground(Color.WHITE);
	text.setForeground(Color.BLUE);
	//text.setEnabled(false);
	message.add(text);
	Panwel.add(message);
	Panel panel1 = new Panel();
	left.setLayout(new BorderLayout());
	panel1.setLayout(new GridLayout(2,2,5,5));
	Label card = new Label("card",Label.RIGHT);
	card.setForeground(Color.red);
	//id = new TextField();
	Label password = new Label("password",Label.RIGHT);
	password.setForeground(Color.red);
	//pass = new JPasswordField();
//	passwordinput.setEnabled(false);
	//pass.setEnabled(false);
	panel1.add(card);
	panel1.add(nameinput);
	panel1.add(password);
	panel1.add(passwordinput);
	
	Panel panel2 = new Panel();
	ok = new JButton("ok");
	ok.setForeground(Color.red);
	//login.addActionListener(new Bt());
    cancel = new JButton("cancel");
	cancel.setForeground(Color.red);
	//cancel.addActionListener(new Bt());
	panel2.add(ok);
	panel2.add(cancel);
	
	left.add(panel1,"North");
	left.add(panel2,"Center");
	right.setLayout(new BorderLayout(5,5));
	
	Label label = new Label("密码输入键盘");
	label.setForeground(Color.red);
	right.add(label,"North");
	
	Panel panel = new Panel();
	panel.setLayout(new GridLayout(4,3,10,10));
	right.add(panel,"Center");
	n1 = new Button("1");
	n1.setForeground(Color.blue);
	n1.addActionListener(new Bt());
	n2 = new Button("2");
	n2.setForeground(Color.blue);
	n2.addActionListener(new Bt());
	n3 = new Button("3");
	n3.setForeground(Color.blue);
	n3.addActionListener(new Bt());
	n4 = new Button("4");
	n4.setForeground(Color.blue);
	n4.addActionListener(new Bt());
	n5 = new Button("5");
	n5.setForeground(Color.blue);
	n5.addActionListener(new Bt());
	n6 = new Button("6");
	n6.setForeground(Color.blue);
	n6.addActionListener(new Bt());
	n7 = new Button("7");
	n7.setForeground(Color.blue);
	n7.addActionListener(new Bt());
	n8 = new Button("8");
	n8.setForeground(Color.blue);
	n8.addActionListener(new Bt());
	n9 = new Button("9");
	n9.setForeground(Color.blue);
	n9.addActionListener(new Bt());
	n10 = new Button("0");
	n10.setForeground(Color.blue);
	n10.addActionListener(new Bt());
	n11 = new Button("退格");
	n11.setForeground(Color.red);
	n11.addActionListener(new Bt());
	n12 = new Button("清除");
	n12.setForeground(Color.red);
	n12.addActionListener(new Bt());
	panel.add(n1);
	panel.add(n2);
	panel.add(n3);
	panel.add(n4);
	panel.add(n5);
	panel.add(n6);
	panel.add(n7);
	panel.add(n8);
	panel.add(n9);
	panel.add(n10);
	panel.add(n11);
	panel.add(n12);

	ok.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent Event)
    	{
    		String id=nameinput.getText();
    		@SuppressWarnings("deprecation")
			String pass=passwordinput.getText();
    		int i=Integer.parseInt(id);
    		int j=Integer.parseInt(pass);
    		 if(bankdata.authenticateUser(i, j)) 
    	       { 
    	    	  System.out.println("帐号认证通过！");
    			 accout.setAccoutNumber(i);
    	           accout.setPassword(j);
    	     clt.show(Pmain,"Menu");
    	       //  clt.show(Pmain, "input");
    	     //      clt.next(Pmain);
    	           a1.setText("你好"+bankdata.getName(i)+"\n,欢迎使用ATM机！");
//   	           System.out.print("      你好"+bankdata.getName(i));
//    	           System.out.println(",欢迎使用ATM机！");
    	       
    	       }
    		 else
    			System.out.println("Error!");
    		 // j2.setText("sdf"); 
    		text.setText("帐号和密码不对");
    		 nameinput.setText("");
    		 passwordinput.setText("");
    		 str.setLength(0);
    			// clt.show(Pmain, "wel");
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

	}
	class Bt implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			try{
//				if(e2.getSource()==n12){// 选择"清除"清零
//					
//					passwordinput.setText("");
//					//passwordinput.setText("");// 密码清零
//					str.setLength(0);
//					text.setText("一清零");
//					
//				}
				if(e2.getSource()==n12)
				{
					passwordinput.setText("");
					str.setLength(0);
				}
				else if(e2.getSource() == n11){// 选择"退格"按钮
					if(passwordinput.getPassword().length != 0){// 如果密码长度不等于0
						passwordinput.setText(str.delete(str.length() - 1,
								str.length()).toString());
					}else{
						passwordinput.setText("");
						str.setLength(0);
					}
				}
//				
				else if(e2.getSource()==n1||e2.getSource()==n2||e2.getSource()==n3||e2.getSource()==n4||
						e2.getSource()==n5||e2.getSource()==n6||e2.getSource()==n7||e2.getSource()==n8||
						e2.getSource()==n9||e2.getSource()==n10){
					passwordinput.setText(str.append(e2.getActionCommand()).toString());
					//passwordinput.setText("123456");
				}
			}catch(Exception ex){
				text.setText("系统出错！");
			}
		}
	}
	public void showMenu()
	{
		Pmenu=new JPanel();
		Pmenu.setBackground(Color.blue);
		JLabel mj=new JLabel("请选择操作");
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(5,1));
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(5,1));
		M_input=new JButton("存钱");
		M_input.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "input");
			}
			
		}
		);
		M_chaxun=new JButton("查询");
		M_chaxun.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Queryleft");
				double a=bankdata.getTotalBalance(accout.getAccountNumber());
				lbleft.setText("你的余额"+a);
			}
			
		}
		);
		
		M_getmoney=new JButton("取钱");
		M_getmoney.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Getmoney");
			}
			
		}
		);
		
		M_reset=new JButton("修改密码");
		M_reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Chgpwd");
			}
			
		}
		);
		M_Exit=new JButton("退出");
		M_Exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				frame.setVisible(false);
			}
			
		}
		);
		a1=new JTextArea(10,50);
		p1.add(mj);p1.add(a1);
		p2.add(M_input);p2.add(M_chaxun);
		p2.add(M_getmoney);p2.add(M_reset);
		p2.add(M_Exit);
		Pmenu.setLayout(new BorderLayout());
		Pmenu.add(p1,"Center");
		Pmenu.add(p2,"East");
//		frame.add(Pmenu);
//		frame.setSize(400,300);
//		frame.setLocation(400,200);
//		frame.setVisible(true);	
//		
	}
	public void showGetMoney()
	{
		Pgetmoney=new JPanel();
		JLabel blbl=new JLabel("请选择取款金额");
		GridLayout gdo4=new GridLayout(4,4);
		JLabel msg3=new JLabel("");
		b1=new JButton("100");	
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
			    double i=bankdata.getTotalBalance(accout.getAccountNumber());
			//    balance=i;
				if(100<i)
				{
					
					if(bankdata.debit(accout.getAccountNumber(), 100))
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功取钱100先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("取钱失败!");
					}
							
				}
				else
				{
					clt.show(Pmain, "Menu");
					a1.setText("余额不足");
				}
			}
			
		}
		);
		b2=new JButton("300");
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
			    double i=bankdata.getTotalBalance(accout.getAccountNumber());
				if(300<i)
				{
					
					if(bankdata.debit(accout.getAccountNumber(), 300))
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功取钱300先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("取钱失败!");
					}
							
				}
				else
				{
					clt.show(Pmain, "Menu");
					a1.setText("余额不足");
				}
			}
			
		}
		);
		b3=new JButton("500");
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
			    double i=bankdata.getTotalBalance(accout.getAccountNumber());
				if(500<i)
				{
					
					if(bankdata.debit(accout.getAccountNumber(), 500))
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功取钱500先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("取钱失败!");
					}
							
				}
				else
				{
					clt.show(Pmain, "Menu");
					a1.setText("余额不足");
				}
			}
			
		}
		);
		b4=new JButton("800");
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
			    double i=bankdata.getTotalBalance(accout.getAccountNumber());
				if(800<i)
				{
					
					if(bankdata.debit(accout.getAccountNumber(), 800))
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功取钱800先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("取钱失败!");
					}
							
				}
				else
				{
					clt.show(Pmain, "Menu");
					a1.setText("余额不足");
				}
			}
			
		}
		);
		b5=new JButton("1000");
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
			    double i=bankdata.getTotalBalance(accout.getAccountNumber());
				if(1000<i)
				{
					
					if(bankdata.debit(accout.getAccountNumber(), 1000))
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功取钱1000先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("取钱失败!");
					}
							
				}
				else
				{
					clt.show(Pmain, "Menu");
					a1.setText("余额不足");
				}
			}
			
		}
		);
		b6=new JButton("其他");
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "other1");
				get_m.setText("");
				str1.setLength(0);
			}
			
		}
		);
		b7=new JButton("返回");
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Menu");
			}
			
		}
		);
		//b7.addActionListener(this);
		b8=new JButton("退出");
		b8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				frame.setVisible(false);
			}
			
		}
		);
		JPanel bpnl1=new JPanel();
		bpnl1.add(blbl);
		JPanel bpnl3=new JPanel();
		bpnl3.add(b7);	bpnl3.add(b8);
		JPanel bpnl2=new JPanel();
		bpnl2.setLayout(gdo4);
		bpnl2.add(b1);	bpnl2.add(new Label());	bpnl2.add(b4);
		bpnl2.add(b2);	bpnl2.add(msg3);				bpnl2.add(b5);
		bpnl2.add(b3);	bpnl2.add(new Label());	bpnl2.add(b6);
		bpnl2.add(new Label()); bpnl2.add(bpnl3);	bpnl2.add(new Label());
		Pgetmoney.add(bpnl1,BorderLayout.NORTH);
		Pgetmoney.add(bpnl2,BorderLayout.CENTER);	
//		frame.add(Pgetmoney);
//		frame.setSize(400,300);
//		frame.setLocation(400,200);
//		frame.setVisible(true);	
	}
	public void showother_1()
	{
	Pother_1=new JPanel();
	Pother_1.setLayout(null);
	
	JPanel left = new JPanel();
	left.setBounds(0, 50, 250, 100);
	Pother_1.add(left);
	JPanel right = new JPanel();
	right.setBounds(270, 10, 200, 150);
	Pother_1.add(right);
	Panel panel1 = new Panel();
	left.setLayout(new BorderLayout());
	panel1.setLayout(new GridLayout(2,1,5,5));
	Label card = new Label("请输入金额：",Label.CENTER);
	get_m=new JTextField();
	card.setForeground(Color.red);
	panel1.add(card);
	panel1.add(get_m);
	Panel panel2 = new Panel();
	g1 = new JButton("确定");
	g1.setForeground(Color.red);
	//login.addActionListener(new Bt());
	g1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent Event)
		{
			String i_1=get_m.getText();
			int ii=Integer.parseInt(i_1);
			  double i=bankdata.getTotalBalance(accout.getAccountNumber());
				if(ii<i)
				{
					
					if(bankdata.debit(accout.getAccountNumber(), ii))
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功取钱"+ii+"先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("取钱失败!");
					}
							
				}
				else
				{
					clt.show(Pmain, "Menu");
					a1.setText("余额不足");
				}
			
		}
		
	}
	);
    g2 = new JButton("取消");
	g2.setForeground(Color.red);
	//cancel.addActionListener(new Bt());
	panel2.add(g1);
	panel2.add(g2);
	
	left.add(panel1,"North");
	left.add(panel2,"Center");
right.setLayout(new BorderLayout(5,5));
	
	Label label = new Label("数字键盘");
	label.setForeground(Color.red);
	right.add(label,"North");
	
	Panel panel = new Panel();
	panel.setLayout(new GridLayout(4,3,10,10));
	right.add(panel,"Center");
	g_1 = new Button("1");
	g_1.setForeground(Color.blue);
	g_1.addActionListener(new Ct());
	g_2 = new Button("2");
	g_2.setForeground(Color.blue);
	g_2.addActionListener(new Ct());
	g_3 = new Button("3");
	g_3.setForeground(Color.blue);
	g_3.addActionListener(new Ct());
	g_4 = new Button("4");
	g_4.setForeground(Color.blue);
	g_4.addActionListener(new Ct());
	g_5 = new Button("5");
	g_5.setForeground(Color.blue);
	g_5.addActionListener(new Ct());
	g_6 = new Button("6");
	g_6.setForeground(Color.blue);
	g_6.addActionListener(new Ct());
	g_7 = new Button("7");
	g_7.setForeground(Color.blue);
	g_7.addActionListener(new Ct());
	g_8 = new Button("8");
	g_8.setForeground(Color.blue);
	g_8.addActionListener(new Ct());
	g_9 = new Button("9");
	g_9.setForeground(Color.blue);
	g_9.addActionListener(new Ct());
	g_10 = new Button("0");
	g_10.setForeground(Color.blue);
	g_10.addActionListener(new Ct());
//	g_11 = new Button("退格");
//	g_11.setForeground(Color.red);
//	g_11.addActionListener(new Ct());
//	g_12 = new Button("清除");
//	g_12.setForeground(Color.red);
//	g_12.addActionListener(new Ct());
	panel.add(g_1);
	panel.add(g_2);
	panel.add(g_3);
	panel.add(g_4);
	panel.add(g_5);
	panel.add(g_6);
	panel.add(g_7);
	panel.add(g_8);
	panel.add(g_9);
	panel.add(g_10);
//	panel.add(g_11);
//	panel.add(g_12);

//		Pother_1.setLayout(new GridLayout(3,1));
//		Label clbl=new Label("帐户余额");
//	    //clbl.setAlignmentX(Center);
//		clbl.setAlignment(Label.CENTER);
//		get_money=new JTextField(15);
//		JPanel p=new JPanel();
//		p.setLayout(new GridLayout(1,2));
//		g1=new JButton("确定");
		
//		g2=new JButton("清除");
		g2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				get_m.setText("");
				str1.setLength(0);
			}
			
		}
		);
//		p.add(g1);
//		p.add(g2);
//		Pother_1.add(clbl);
//		Pother_1.add(get_money);
//		Pother_1.add(p);
		
	}
	class Ct implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			try{
//				if(e2.getSource()==n12){// 选择"清除"清零
//					
//					passwordinput.setText("");
//					//passwordinput.setText("");// 密码清零
//					str.setLength(0);
//					text.setText("一清零");
//					
//				}
				if(e2.getSource()==g_12)
				{
					get_m.setText("");
					str1.setLength(0);
				}
				else if(e2.getSource()==g_11){// 选择"退格"按钮
               if(!get_m.getText().equals(""))
               {
					get_m.setText(str1.delete(str.length() - 1,
							str1.length()).toString());
					System.out.println("lllll");
               }else{
            	   get_m.setText("");
               str1.setLength(0);
               }
//					if(get_m.getPassword().length != 0){// 如果密码长度不等于0
//						passwordinput.setText(str.delete(str.length() - 1,
//								str.length()).toString());
//					}else{
//						passwordinput.setText("");
//						str.setLength(0);
//					}
				}
//				
				else if(e2.getSource()==g_1||e2.getSource()==g_2||e2.getSource()==g_3||e2.getSource()==g_4||
						e2.getSource()==g_5||e2.getSource()==g_6||e2.getSource()==g_7||e2.getSource()==g_8||
						e2.getSource()==g_9||e2.getSource()==g_10){
					get_m.setText(str1.append(e2.getActionCommand()).toString());
					//passwordinput.setText("123456");
				}
			}catch(Exception ex){
				text.setText("系统出错！");
			}
		}
	}
	public void showother_2()
	{

		Pother_2=new JPanel();
		Pother_2.setLayout(null);
		
		JPanel left = new JPanel();
		left.setBounds(0, 50, 250, 100);
		Pother_2.add(left);
		JPanel right = new JPanel();
		right.setBounds(270, 10, 200, 150);
		Pother_2.add(right);
		Panel panel1 = new Panel();
		left.setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(2,1,5,5));
		Label card = new Label("请输入金额：",Label.CENTER);
		input_m=new JTextField();
		card.setForeground(Color.red);
		panel1.add(card);
		panel1.add(input_m);
		Panel panel2 = new Panel();
		i1 = new JButton("确定");
		i1.setForeground(Color.red);
		//login.addActionListener(new Bt());
		i1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				String i_1=input_m.getText();
				int ii=Integer.parseInt(i_1);
				//  double i=bankdata.getTotalBalance(accout.getAccountNumber());
					if(ii>0)
					{
						
						if(bankdata.credit(accout.getAccountNumber(), ii))
							{
							   clt.show(Pmain, "Menu");
							   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
							   		"你已成功存钱"+ii+"先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
							   		);
							}
						else
						{
							  clt.show(Pmain, "Menu");
							  a1.setText("存钱失败!");
						}
								
					}
				
				
			}
			
		}
		);
	    i2 = new JButton("取消");
		i2.setForeground(Color.red);
		//cancel.addActionListener(new Bt());
		panel2.add(i1);
		panel2.add(i2);
		
		left.add(panel1,"North");
		left.add(panel2,"Center");
	right.setLayout(new BorderLayout(5,5));
		
		Label label = new Label("数字键盘");
		label.setForeground(Color.red);
		right.add(label,"North");
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(4,3,10,10));
		right.add(panel,"Center");
		i_1 = new Button("1");
		i_1.setForeground(Color.blue);
		i_1.addActionListener(new Dt());
		i_2 = new Button("2");
		i_2.setForeground(Color.blue);
		i_2.addActionListener(new Dt());
		i_3 = new Button("3");
		i_3.setForeground(Color.blue);
		i_3.addActionListener(new Dt());
		i_4 = new Button("4");
		i_4.setForeground(Color.blue);
		i_4.addActionListener(new Dt());
		i_5 = new Button("5");
		i_5.setForeground(Color.blue);
		i_5.addActionListener(new Dt());
		i_6 = new Button("6");
		i_6.setForeground(Color.blue);
		i_6.addActionListener(new Dt());
		i_7 = new Button("7");
		i_7.setForeground(Color.blue);
		i_7.addActionListener(new Dt());
		i_8 = new Button("8");
		i_8.setForeground(Color.blue);
		i_8.addActionListener(new Dt());
		i_9 = new Button("9");
		i_9.setForeground(Color.blue);
		i_9.addActionListener(new Dt());
		i_10 = new Button("0");
		i_10.setForeground(Color.blue);
		i_10.addActionListener(new Dt());
//		g_11 = new Button("退格");
//		g_11.setForeground(Color.red);
//		g_11.addActionListener(new Ct());
//		g_12 = new Button("清除");
//		g_12.setForeground(Color.red);
//		g_12.addActionListener(new Ct());
		panel.add(i_1);
		panel.add(i_2);
		panel.add(i_3);
		panel.add(i_4);
		panel.add(i_5);
		panel.add(i_6);
		panel.add(i_7);
		panel.add(i_8);
		panel.add(i_9);
		panel.add(i_10);
//		panel.add(g_11);
//		panel.add(g_12);

//			Pother_1.setLayout(new GridLayout(3,1));
//			Label clbl=new Label("帐户余额");
//		    //clbl.setAlignmentX(Center);
//			clbl.setAlignment(Label.CENTER);
//			get_money=new JTextField(15);
//			JPanel p=new JPanel();
//			p.setLayout(new GridLayout(1,2));
//			g1=new JButton("确定");
			
//			g2=new JButton("清除");
			i2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent Event)
				{
					input_m.setText("");
					str2.setLength(0);
				}
				
			}
			);
//		Pother_2.setLayout(new GridLayout(3,1));
//		Label clbl=new Label("帐户余额");
//	    //clbl.setAlignmentX(Center);
//		clbl.setAlignment(Label.CENTER);
//		input_money=new JTextField(15);
//		JPanel p=new JPanel();
//		p.setLayout(new GridLayout(1,2));
//		i1=new JButton("确定");
//		
//		
//		i2=new JButton("清除");
//		i2.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent Event)
//			{
//				input_money.setText("");
//			}
//			
//		}
//		);
//		p.add(i1);
//		p.add(i2);
//		Pother_2.add(clbl);
//		Pother_2.add(input_money);
//		Pother_2.add(p);
	}
	class Dt implements ActionListener{
		public void actionPerformed(ActionEvent e2){
			try{
//				if(e2.getSource()==n12){// 选择"清除"清零
//					
//					passwordinput.setText("");
//					//passwordinput.setText("");// 密码清零
//					str.setLength(0);
//					text.setText("一清零");
//					
//				}
				if(e2.getSource()==i_12)
				{
					get_m.setText("");
					str2.setLength(0);
				}
				else if(e2.getSource()==i_11){// 选择"退格"按钮
               if(!get_m.getText().equals(""))
               {
					get_m.setText(str1.delete(str.length() - 1,
							str2.length()).toString());
					System.out.println("lllll");
               }else{
            	   get_m.setText("");
               str2.setLength(0);
               }
//					if(get_m.getPassword().length != 0){// 如果密码长度不等于0
//						passwordinput.setText(str.delete(str.length() - 1,
//								str.length()).toString());
//					}else{
//						passwordinput.setText("");
//						str.setLength(0);
//					}
				}
//				
				else if(e2.getSource()==i_1||e2.getSource()==i_2||e2.getSource()==i_3||e2.getSource()==i_4||
						e2.getSource()==i_5||e2.getSource()==i_6||e2.getSource()==i_7||e2.getSource()==i_8||
						e2.getSource()==i_9||e2.getSource()==i_10){
					input_m.setText(str2.append(e2.getActionCommand()).toString());
					//passwordinput.setText("123456");
				}
			}catch(Exception ex){
				text.setText("系统出错！");
			}
		}
	}
	public void showInput()
	{
		Pinput=new JPanel();
		JLabel blbl=new JLabel("请选择存款金额");
		GridLayout gdo4=new GridLayout(4,4);
		JLabel msg3=new JLabel("");
		e1=new JButton("100");
		e1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				if(bankdata.credit(accout.getAccountNumber(), 100))
			
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功存款100先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("存钱失败!");
					}

				
			}
			
		}
		);
		e2=new JButton("300");
		e2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				if(bankdata.credit(accout.getAccountNumber(), 300))
			
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功存款300先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("存钱失败!");
					}

				
			}
			
		}
		);
		e3=new JButton("500");
		e3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				if(bankdata.credit(accout.getAccountNumber(), 500))
			
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功存款500先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("存钱失败!");
					}

				
			}
			
		}
		);
		e4=new JButton("800");
		e4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				if(bankdata.credit(accout.getAccountNumber(), 800))
			
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功存款800先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("存钱失败!");
					}

				
			}
			
		}
		);
		e5=new JButton("1000");
		e5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				if(bankdata.credit(accout.getAccountNumber(), 1000))
			
						{
						   clt.show(Pmain, "Menu");
						   a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n" +
						   		"你已成功存款1000先帐户余额为"+bankdata.getTotalBalance(accout.getAccountNumber())
						   		);
						}
					else
					{
						  clt.show(Pmain, "Menu");
						  a1.setText("存钱失败!");
					}

				
			}
			
		}
		);
		e6=new JButton("其他");
		e6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "other2");
				input_m.setText("");
				str2.setLength(0);
			}
			
		}
		);
		e7=new JButton("返回");
		e7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Menu");
				
			}
			
		}
		);
		//b7.addActionListener(this);
		e8=new JButton("退出");
		e8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				frame.setVisible(false);
			}
			
		}
		);
		JPanel bpnl1=new JPanel();
		bpnl1.add(blbl);
		JPanel bpnl3=new JPanel();
		bpnl3.add(e7);	bpnl3.add(e8);
		JPanel bpnl2=new JPanel();
		bpnl2.setLayout(gdo4);
		bpnl2.add(e1);	bpnl2.add(new Label());	bpnl2.add(e4);
		bpnl2.add(e2);	bpnl2.add(msg3);				bpnl2.add(e5);
		bpnl2.add(e3);	bpnl2.add(new Label());	bpnl2.add(e6);
		bpnl2.add(new Label()); bpnl2.add(bpnl3);	bpnl2.add(new Label());
		Pinput.add(bpnl1,BorderLayout.NORTH);
		Pinput.add(bpnl2,BorderLayout.CENTER);	
		
	}
	public void showQueryLeft()
	{
		Pqueryleft=new JPanel();
		Pqueryleft.setLayout(new BorderLayout());
		Label clbl=new Label("帐户余额");
	    //clbl.setAlignmentX(Center);
		clbl.setAlignment(Label.CENTER);
		 lbleft=new JLabel("");
		Panel cpnl1=new Panel();
		cpnl1.add(lbleft);
	//	double a=bankdata.getTotalBalance(accout.getAccountNumber());
	//String a=bankdata.getName(accout.getAccountNumber());
	//lbleft.setText("$"+ a);
		Panel cpnl2=new Panel();		
		c1=new JButton("返回");
		c1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Menu");
				a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n,欢迎使用ATM机！");
			}
			
		}
		);
		//c1.addActionListener(this);
		c2=new JButton("退出");
		c2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				frame.setVisible(false);
			}
			
		}
		);
		//c2.addActionListener(this);			
		//cpnl2.add(edok);Button edok=new Button("确定");	
		cpnl2.add(c1);	cpnl2.add(c2);
		Pqueryleft.add(clbl,BorderLayout.NORTH);
		Pqueryleft.add(cpnl1,BorderLayout.CENTER);
		Pqueryleft.add(cpnl2,BorderLayout.SOUTH);	
//		frame.add(Pqueryleft);
//		frame.setSize(400,300);
//		frame.setLocation(400,200);
//		frame.setVisible(true);	
	}
	public void showChangePwd()
	{
		Preset=new JPanel();
		GridLayout gdo6=new GridLayout(6,1);
		Preset.setLayout(gdo6);
		Label dlbl1=new Label("修改密码");
		dlbl1.setAlignment(Label.CENTER);
		JLabel dlbl2=new JLabel("请输入原密码：");
		JLabel dlbl3=new JLabel("请输入新密码：");
		JLabel dlbl4=new JLabel("请再输入新密码：");
		msg=new JLabel();
		oldpwd=new JPasswordField(15);
		newpwd1=new JPasswordField(15);
		newpwd2=new JPasswordField(15);
		dok=new JButton("确定");
		dok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				int i=Integer.parseInt(oldpwd.getText());
				int i1=Integer.parseInt(newpwd1.getText());
				int i2=Integer.parseInt(newpwd2.getText());
				int ps=accout.getPassword();
				if(i==ps)
				{
					if(i1==i2)
					{
						if(bankdata.rePassword(accout.getAccountNumber(),i,i1))
						{
							msg.setText("密码修改成功");
						}
					}
					else
					{
						msg.setText("两次密码输入不一样");
						oldpwd.setText("");
						newpwd1.setText("");
						newpwd2.setText("");
					}
				}
				else
				{
					msg.setText("密码不正确");
					oldpwd.setText("");
					newpwd1.setText("");
					newpwd2.setText("");
				}
					
			}
			
		}
		);
		
		d1=new JButton("返回");
		d1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				clt.show(Pmain, "Menu");
				 a1.setText("你好"+bankdata.getName(accout.getAccountNumber())+"\n,欢迎使用ATM机！");
				
			}
			
		}
		);
		//d1.addActionListener(this);
		d2=new JButton("退出");
		d2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				frame.setVisible(false);
			}
			
		}
		);
		//d2.addActionListener(this);	
		Panel dpnl1=new Panel();
		Panel dpnl2=new Panel();
		Panel dpnl3=new Panel();
		Panel dpnl4=new Panel();
		Panel dpnl5=new Panel();
		dpnl1.add(dlbl1);
		dpnl2.add(dlbl2);	dpnl2.add(oldpwd);	
		dpnl3.add(dlbl3);	dpnl3.add(newpwd1);
		dpnl4.add(dlbl4);	dpnl4.add(newpwd2);
		dpnl5.add(dok);		dpnl5.add(d1);	dpnl5.add(d2);
				
		Preset.add(dpnl1);	Preset.add(dpnl2);
		Preset.add(dpnl3);	Preset.add(dpnl4);
		Preset.add(msg);
		Preset.add(dpnl5);		
//		frame.add(Preset);
//		frame.setSize(400,300);
//		frame.setLocation(400,200);
//		frame.setVisible(true);	
	}

	public static void main(String args[])
	{
		atmscreen atms=new atmscreen();
		
	atms.mainFram();
		
	}
}
