package shiyan4;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.*;
import java.sql.*;
public class Buses extends JFrame implements ActionListener
{
	JMenuItem busad=new JMenuItem("添加汽车");
	JMenuItem buscg=new JMenuItem("更改汽车");
	JMenuItem busdl=new JMenuItem("删除汽车");
	JMenuItem busexit=new JMenuItem("退出");
	JMenuItem routead=new JMenuItem("添加路线");
	JMenuItem routecg=new JMenuItem("更改路线");
	JMenuItem routedl=new JMenuItem("删除路线");
	JMenuItem routeexit=new JMenuItem("退出");
	JMenuItem employeead=new JMenuItem("添加员工");
	JMenuItem employeecg=new JMenuItem("更改员工");
	JMenuItem employeedl=new JMenuItem("删除员工");
	JMenuItem employeeexit=new JMenuItem("退出");
	JMenuItem passagerad=new JMenuItem("汽车添加");
	JMenuItem passagercg=new JMenuItem("汽车更改");
	JMenuItem passagerdl=new JMenuItem("汽车删除");
	JMenuItem passagerexit=new JMenuItem("退出");
	JPanel p=new JPanel();
	

	String type;  //01:空调车；02：普通车；03：快速公交 
	int engine_number; //引擎号：1~10的数
	int seating_capacity;//多少座车
	int route;   //线路号：1~10的数
	
	
	void Bus(){
		System.out.println("汽车管理模块");
		
		
	}
	/*void addBus(String str,String en,String num,String ro){
		
		String s_insert="insert into bus values("+str+","+en+","+num+","+ro+")";
		System.out.println(s_insert);
		DBConnect con_bus=new DBConnect();
		con_bus.getInsert(con_bus.connect(),s_insert );
		
		
	}
		
	void updateBus(String str,String en,String num,String ro) {
		DBConnect con_bus=new DBConnect();
		String sql="update Bus set 类型="+str +","+"引擎号="+en+","+"座位数="+num+","+"线路="+ro;
		con_bus.getUpdate(con_bus.connect(), str,sql);
		
		
	}
	
	void delBus(String str){
		DBConnect con_bus=new DBConnect();
		String sql="delete from Bus where 类型="+str;
		con_bus.getdelet(con_bus.connect(),  sql);
		
		
	}
	public String toString(){
		return ("公交信息："+type+" "+engine_number+" "+seating_capacity+" "+route );
		
	}*/
	


public Buses()
{

    super("公交管理系统");
    JMenu busmg=new JMenu("汽车管理");
    busmg.add(busad);busad.setEnabled(true);
    busmg.add(buscg);buscg.setEnabled(true);
    busmg.add(busdl);busdl.setEnabled(true);
    busmg.addSeparator();
    busmg.add(busexit);busexit.setEnabled(true);
    JMenu routemg=new JMenu("路线管理");
    routemg.add(routead);routead.setEnabled(true);
    routemg.add(routecg);routecg.setEnabled(true);
    routemg.add(routedl);routedl.setEnabled(true);
    routemg.addSeparator();
    routemg.add(routeexit);routeexit.setEnabled(true);
    JMenu employeemg=new JMenu("员工管理");
    employeemg.add(employeead);employeead.setEnabled(true);
    employeemg.add(employeecg);employeecg.setEnabled(true);
    employeemg.add(employeedl);employeedl.setEnabled(true);
    employeemg.addSeparator();
    employeemg.add(employeeexit);employeeexit.setEnabled(true);
    JMenu passagermg=new JMenu("顾客管理");
    passagermg.add(passagerad);passagerad.setEnabled(true);
    passagermg.add(passagercg);passagercg.setEnabled(true);
    passagermg.add(passagerdl);passagerdl.setEnabled(true);
    passagermg.addSeparator();
    passagermg.add(passagerexit);passagerexit.setEnabled(true);
    JMenuBar bar=new JMenuBar();
    setJMenuBar(bar);
    bar.add(busmg);
    bar.add(routemg);
    bar.add(employeemg);
    bar.add(passagermg);
    setLayout(new FlowLayout());
    JLabel wel=new JLabel("欢迎进入公交管理系统");
    add(wel);
   
    validate();
  busexit.addActionListener(this);
  routeexit.addActionListener(this);
  employeeexit.addActionListener(this);
  passagerexit.addActionListener(this);
  setSize(250,200);
  setVisible(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  addMouseListener(new MouseAdapter()
  {
	public void mouseClicked(MouseEvent a)
	{
		if(a.getButton()==MouseEvent.BUTTON1)
		{}
	}
  });

}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==busexit||e.getSource()==routeexit|e.getSource()==employeeexit||e.getSource()==passagerexit)
		System.exit(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane d=new JOptionPane();
		String str=d.showInputDialog(null,"请输入登录密码(123)");
		if(str.equals("123"))
		d.showMessageDialog(null,"登陆成功");
		else
		{
			d.showMessageDialog(null,"登录失败");
			System.exit(0);
		}
		Buses f=new Buses();
		String JDriver="sun.jdbc.odbc.JdbcOdbcDriver";
		String conURL="jdbc:odbc:DB";
		try{
			Class.forName(JDriver);
		}
		catch(java.lang.ClassNotFoundException e){
			System.out.println("ForName:"+e.getMessage());
		}
		try{
			Connection con=DriverManager.getConnection(conURL);
			System.out.println("连接成功");
			Statement s=con.createStatement();
			ResultSet rs1=s.executeQuery("SELECT*FROM bus");
			ResultSet rs2=s.executeQuery("SELECT*FROM passager");
			ResultSet rs3=s.executeQuery("SELECT*FROM employer");
			ResultSet rs4=s.executeQuery("SELECT*FROM route");
			s.close();
			con.close();
		}
		catch(SQLException e){
			System.out.println("SQLException:"+e.getMessage());
			
		}

	}
}



