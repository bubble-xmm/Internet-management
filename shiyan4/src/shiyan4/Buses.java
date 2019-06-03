package shiyan4;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.*;
import java.sql.*;
public class Buses extends JFrame implements ActionListener
{
	JMenuItem busad=new JMenuItem("�������");
	JMenuItem buscg=new JMenuItem("��������");
	JMenuItem busdl=new JMenuItem("ɾ������");
	JMenuItem busexit=new JMenuItem("�˳�");
	JMenuItem routead=new JMenuItem("���·��");
	JMenuItem routecg=new JMenuItem("����·��");
	JMenuItem routedl=new JMenuItem("ɾ��·��");
	JMenuItem routeexit=new JMenuItem("�˳�");
	JMenuItem employeead=new JMenuItem("���Ա��");
	JMenuItem employeecg=new JMenuItem("����Ա��");
	JMenuItem employeedl=new JMenuItem("ɾ��Ա��");
	JMenuItem employeeexit=new JMenuItem("�˳�");
	JMenuItem passagerad=new JMenuItem("�������");
	JMenuItem passagercg=new JMenuItem("��������");
	JMenuItem passagerdl=new JMenuItem("����ɾ��");
	JMenuItem passagerexit=new JMenuItem("�˳�");
	JPanel p=new JPanel();
	

	String type;  //01:�յ�����02����ͨ����03�����ٹ��� 
	int engine_number; //����ţ�1~10����
	int seating_capacity;//��������
	int route;   //��·�ţ�1~10����
	
	
	void Bus(){
		System.out.println("��������ģ��");
		
		
	}
	/*void addBus(String str,String en,String num,String ro){
		
		String s_insert="insert into bus values("+str+","+en+","+num+","+ro+")";
		System.out.println(s_insert);
		DBConnect con_bus=new DBConnect();
		con_bus.getInsert(con_bus.connect(),s_insert );
		
		
	}
		
	void updateBus(String str,String en,String num,String ro) {
		DBConnect con_bus=new DBConnect();
		String sql="update Bus set ����="+str +","+"�����="+en+","+"��λ��="+num+","+"��·="+ro;
		con_bus.getUpdate(con_bus.connect(), str,sql);
		
		
	}
	
	void delBus(String str){
		DBConnect con_bus=new DBConnect();
		String sql="delete from Bus where ����="+str;
		con_bus.getdelet(con_bus.connect(),  sql);
		
		
	}
	public String toString(){
		return ("������Ϣ��"+type+" "+engine_number+" "+seating_capacity+" "+route );
		
	}*/
	


public Buses()
{

    super("��������ϵͳ");
    JMenu busmg=new JMenu("��������");
    busmg.add(busad);busad.setEnabled(true);
    busmg.add(buscg);buscg.setEnabled(true);
    busmg.add(busdl);busdl.setEnabled(true);
    busmg.addSeparator();
    busmg.add(busexit);busexit.setEnabled(true);
    JMenu routemg=new JMenu("·�߹���");
    routemg.add(routead);routead.setEnabled(true);
    routemg.add(routecg);routecg.setEnabled(true);
    routemg.add(routedl);routedl.setEnabled(true);
    routemg.addSeparator();
    routemg.add(routeexit);routeexit.setEnabled(true);
    JMenu employeemg=new JMenu("Ա������");
    employeemg.add(employeead);employeead.setEnabled(true);
    employeemg.add(employeecg);employeecg.setEnabled(true);
    employeemg.add(employeedl);employeedl.setEnabled(true);
    employeemg.addSeparator();
    employeemg.add(employeeexit);employeeexit.setEnabled(true);
    JMenu passagermg=new JMenu("�˿͹���");
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
    JLabel wel=new JLabel("��ӭ���빫������ϵͳ");
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
		String str=d.showInputDialog(null,"�������¼����(123)");
		if(str.equals("123"))
		d.showMessageDialog(null,"��½�ɹ�");
		else
		{
			d.showMessageDialog(null,"��¼ʧ��");
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
			System.out.println("���ӳɹ�");
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



