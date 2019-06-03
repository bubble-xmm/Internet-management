package shiyan4;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.JTableHeader;
class Bus{
	String type;  //01:�յ�����02����ͨ����03�����ٹ��� 
	int engine_number; //����ţ�1~10����
	int seating_capacity;//��������
	int route;   //��·�ţ�1~10����
	Bus(){
		System.out.println("��������ģ��");
	 }
	void addBus(String str,String en,String num,String ro){
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
	return ("������Ϣ��"+type+" "+engine_number+" "
	+seating_capacity+" "+route );	
	}	
}
class Route{
	int  num_of_stop;  //0~20���ڵ���
	String start_station;  //��ʼվ
	String end_station;   //�յ�վ
	String run_time;    //����ʱ��**~**
	List  listRoute;//��·�б�
	 Route(){
		 System.out.println("��·����ģ��");
	 }
    void addRoute(String num,String start,String end,String run,String list){
    	String s_insert="insert into Route values("+num+","+start+","
    +end+","+run+","+list+")";
		System.out.println(s_insert);
		DBConnect con_route=new DBConnect();
		con_route.getInsert(con_route.connect(),s_insert );	
	}
	void updateRoute(String num,String start,String end,String run,String list){
		DBConnect con_route=new DBConnect();
		String sql="update Route set ��վ="+num +","+"��ʼվ="
		+start+","+"�յ�վ="+run+","+"��·�б�="+list;
		con_route.getUpdate(con_route.connect(), num,sql);	
	}
	void delRoute(String num){
		DBConnect con_route=new DBConnect();
		String sql="delete from Route where ����="+num;
		con_route.getdelet(con_route.connect(),sql);	
	}
	public String toString(){
	return ("������Ϣ��"+num_of_stop+" "+start_station+" "
	+end_station+" "+run_time+" "+listRoute );	
	}
}
class Employee{
	int ID;  //Ա�����
	String name;   //Ա������
	int age;    //Ա������
	String message;   //��ע��Ϣ
	List  listEmployee; //Ա���б�
	Employee(){
		System.out.println("��·����ģ��");
	}
    void addEmployee(String id,String name,String age,String message,String liste){
    	String s_insert="insert into Route values("+id+","+name+","
    		    +age+","+message+","+liste+")";
    				System.out.println(s_insert);
    				DBConnect con_employee=new DBConnect();
    				con_employee.getInsert(con_employee.connect(),s_insert );	
	}
	
	void updateEmployee(String id,String name,String age,String message,String liste){
		DBConnect con_route=new DBConnect();
		String sql="update Emplouee set  "+id +","+" "
		+age+" "+" "+message+","+" "+liste;
		con_route.getUpdate(con_route.connect(), id,sql);	
	}
	
	void delEmployee(String id){
		DBConnect con_employee=new DBConnect();
		String sql="delete from Employee where ����="+id;
		con_employee.getdelet(con_employee.connect(),sql);	
	}
	public String toString(){
		return ("������Ϣ��"+ID+" "+name+" "
		+age+" "+message+" "+listEmployee );	
		}
}
class Passenger{
	String name;  //Ͷ��������
	char sex;   //Ͷ�����Ա�
	int age;   //Ͷ��������
	String message;    //Ͷ����Ϣ
	Passenger(){
		System.out.println("�˿͹���ģ��");
	}
	void addPassenger(String name,String sex,String age,String message){
		String s_insert="insert into Route values("+name+","+sex+","
    		    +age+","+message+","+message+")";
    				System.out.println(s_insert);
    				DBConnect con_passenger=new DBConnect();
    				con_passenger.getInsert(con_passenger.connect(),s_insert );	
		}
		
	void updatePassenger(String name,String sex,String age,String message){
		DBConnect con_route=new DBConnect();
		String sql="update Passenger set  "+name +","+" "
		+age+" "+" "+message+","+" "+message;
		con_route.getUpdate(con_route.connect(), name,sql);	
		}
		
	void delPassenger(String name){
		DBConnect con_employee=new DBConnect();
		String sql="delete from Employee where ����="+name;
		con_employee.getdelet(con_employee.connect(),sql);	
		}
	public String toString(){
		return ("������Ϣ��"+name+" "+sex+" "
				+age+" "+message+" ");	
		}
}
class Manager extends Employee{
	String position;   //ְ��
	String depart;   //������
	String duty;   //ְ��
	
	Manager(){
		System.out.println("������ģ��");
	}
}

class Local extends Route {
	
}

class LongDistance extends Route{
	
}

class MyPanel extends JPanel{
	
}

class DBConnect{
	
	 public static Connection connect(){  
		         try{  
		            Class.forName("com.hxtt.sql.access.AccessDriver");  
		             String url = "jdbc:Access:///D:/db1.mdb"; 
		             Connection con = DriverManager.getConnection(url);  
		             return con;  
		             }catch(Exception e){  
		             System.out.println("wrong");  
		             e.getCause();  
		             return null;  
		         }
	 } 
	 public static void getInsert(Connection con,String sql){  
		           
		        // String sql = "INSERT INTO basic VALUES ('L004','��������','2010/5/9','555555')";  
		         try{  
		             PreparedStatement ps = con.prepareStatement(sql);  
		            // System.out.println(sql);
		             ps.executeUpdate();  
		             con.close();  
		         }catch(Exception e){  
		             e.getMessage();  
		        } 
        }
	  public static void getdelet(Connection con,String sql){
		 //String s=sql+"where �����="+sup;
		 try{  
             PreparedStatement ps = con.prepareStatement(sql);  
            // System.out.println(sql);
             ps.executeUpdate();  
             con.close();  
         }catch(Exception e){  
             e.getMessage();  
        }  
	 } 
	 public static void getUpdate(Connection con,String sup,String sql){   
		     //String s="select ����  from bus "; 
		     String s1="";
		    // Statement st;
		     PreparedStatement ps;
	         try{  
	            
	             s1=sql+"where ����="+sup;
	           //  st = con.createStatement(); 
	             ps = con.prepareStatement(s1);  
	             System.out.println(sql);
	             // ResultSet rs=st.executeQuery(s);  
	             ps.executeUpdate();
	            
	             //JOptionPane.showMessageDialog(null, "no suit record!");
	          //  st.close();
	 	        ps.close();	 
	            con.close();  
	         }catch(Exception e){  
	             e.getMessage();  
	        }
	         

 }
	 public static void getSelect(Connection con,Statement st){  
		           
		         String sql = "select * from basic";  
		         try{  
		               
		             ResultSet rs = st.executeQuery(sql);      
		             while(rs.next()){  
		                 for(int i = 1; i <= 4; i++){  
		                     System.out.print(rs.getString(i)+" ");  
		                 }  
		                 System.out.println();  
		             }  
		         }catch(Exception e){  
		             System.out.println("sssss");  
		             e.getCause();  
		         }  
		       
		           
		     }  
		    public static void  close(Connection con)throws SQLException{  
		         con.close();  
		    } 
}
class MyFrame  extends JFrame implements ActionListener
{
	final static  long serialVersionUID=1L;
	//�˵���Ķ���
	private JMenuItem busadd = new JMenuItem("���");
    private JMenuItem busupdate = new JMenuItem("����");
    private JMenuItem busdel = new JMenuItem("ɾ��");
    private JMenuItem busexit=new JMenuItem("�˳�");
    private JMenuItem routeadd = new JMenuItem("���");
    private JMenuItem routeupdate = new JMenuItem("����");
    private JMenuItem routedel = new JMenuItem("ɾ��");
    private JMenuItem routeexit=new JMenuItem("�˳�");
    private JMenuItem passadd = new JMenuItem("���");
    private JMenuItem passupdate = new JMenuItem("����");
    private JMenuItem passdel = new JMenuItem("ɾ��");
    private JMenuItem employeeexit=new JMenuItem("�˳�");
    private JMenuItem empadd = new JMenuItem("���");
    private JMenuItem empupdate = new JMenuItem("����");
    private JMenuItem empdel = new JMenuItem("ɾ��");
    private JMenuItem passagerexit=new JMenuItem("�˳�");
    private JMenuItem syshelp = new JMenuItem("����");
    private JMenuItem sysexit = new JMenuItem("�˳�");
    public int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	public int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	private JTableHeader jth;
	int count;
	//�������������
	JTextField jt=new JTextField(30);
	JPanel jp2;
	JTable tabDemo;
	Object[][] info=new Object[count][4];
	JLabel jl_main;
	MyFrame(){
		super("��������ϵͳ");
		setLayout(null);
        JMenu busmod = new JMenu("��������ģ��");
        busmod.add(busadd); busmod.setEnabled(true);
        busmod.add(busupdate); busmod.setEnabled(true);
        busmod.add(busdel); busmod.setEnabled(true);
        busmod.addSeparator();
        busmod.add(busexit);busexit.setEnabled(true);
        JMenu routemod = new JMenu("��·����ģ��");
        routemod.add( routeadd);routemod.setEnabled(true);
        routemod.add( routeupdate);routemod.setEnabled(true);
        routemod.add( routedel);routemod.setEnabled(true);
        routemod.addSeparator();
        routemod.add(routeexit);routeexit.setEnabled(true);
        JMenu empmod = new JMenu("Ա������ģ��");
        empmod.add(empadd); empmod.setEnabled(true);
        empmod.add(empupdate); empmod.setEnabled(true);
        empmod.add(empdel); empmod.setEnabled(true);
        empmod.addSeparator();
        empmod.add(employeeexit);employeeexit.setEnabled(true);
        JMenu passmod = new JMenu("�˿͹���ģ��");
        passmod.add(passadd);passmod.setEnabled(true);
        passmod.add(passupdate);passmod.setEnabled(true);
        passmod.add(passdel);passdel.setEnabled(true);
        passmod.addSeparator();
        passmod.add(passagerexit);passagerexit.setEnabled(true);
        JMenu sysmod = new JMenu("ϵͳ");
        sysmod.add(syshelp);sysmod.setEnabled(true);
        sysmod.addSeparator();
        sysmod.add(sysexit);sysmod.setEnabled(true);
	    JMenuBar bar = new JMenuBar();
        bar.add(busmod);
	    bar.add(routemod); 
	    bar.add(empmod);
	    bar.add(passmod);
	    bar.add(sysmod);
	    setJMenuBar(bar);
	    sysexit.addActionListener(this);
	    busadd.addActionListener(this);
	    busupdate.addActionListener(this);
	    busdel.addActionListener(this);
	    routeadd.addActionListener(this);
	    routeupdate.addActionListener(this);
	    routedel.addActionListener(this);
	    empadd.addActionListener(this);
	    empupdate.addActionListener(this);
	    empdel.addActionListener(this);
	    passadd.addActionListener(this);
	    passupdate.addActionListener(this);
	    passdel.addActionListener(this);
	    syshelp.addActionListener(this);
	    busexit.addActionListener(this);
	    routeexit.addActionListener(this);
	    employeeexit.addActionListener(this);
	    passagerexit.addActionListener(this);
	    
	    jl_main=new JLabel("��ӭʹ�ù�������ϵͳ");
	    jl_main.setForeground(Color.blue);
	    jl_main.setFont(new Font("����",Font.BOLD,30));
	    jl_main.setBounds(150, 90, 400, 100); 
	    add(jl_main);
	
	    
	    jp2=new JPanel();
	    
	    add(jp2,"South");
	    
	    String[] title={"��������","�����","��λ��","��·"};
	    tabDemo=new JTable(info,title);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] title1={"��վ","��ʼվ","�յ�վ","����ʱ��","��·�б�"};
	    tabDemo=new JTable(info,title1);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] title2={"Ա�����","Ա������","Ա������","��ע��Ϣ","Ա���б�"};
	    tabDemo=new JTable(info,title2);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] title3={"Ͷ��������","Ͷ��������","Ͷ�����Ա�","Ͷ����Ϣ",};
	    tabDemo=new JTable(info,title3);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	 public void actionPerformed(ActionEvent e)
	 {  
       String str="���ǹ�������ϵͳ����ϵͳ��"
       		+ "��ϵͳֻ��һ�����԰汾���������ƣ�ϣ��ͬѧ���������Լ�ѧ����֪ʶ��������";
		 if(e.getSource()==busexit||e.getSource()==routeexit|e.getSource()==employeeexit||e.getSource()==passagerexit||e.getSource() == sysexit)
	         System.exit(0);
        else if(e.getSource()==syshelp)
        {
        	JOptionPane  d_input = new JOptionPane();
        	 d_input.showMessageDialog(null, str);
        }
        else if(e.getSource()==busadd)
        	{
        	this.setVisible(false);
        	MyFrameBus mfb=new MyFrameBus();
        	}
        else if(e.getSource()==busupdate)
        {
        	this.setVisible(false);
        	MyFrameBus mfb=new MyFrameBus();
        }
        else if(e.getSource()==busdel)
        {
        	this.setVisible(false);
        	MyFrameBus mfb=new MyFrameBus();
        }
        else if(e.getSource()==routeadd)
    	{
         	this.setVisible(false);
        	MyFrameRoute mfb1=new MyFrameRoute();
    		//Bus b1=new Bus();
    		//b1.addBus(str, en, num, ro);
        	//jt.setText("��·����ģ�����");
    	}
       else if(e.getSource()==routeupdate)
        {
    	 	this.setVisible(false);
        	MyFrameRoute mfb1=new MyFrameRoute();
    	   //jt.setText("��·����ģ�����");
        }
       else if(e.getSource()==routedel)
        {
    	 	this.setVisible(false);
        	MyFrameRoute mfb1=new MyFrameRoute();
    	   //jt.setText("��·����ģ��ɾ��");
        }
       else if(e.getSource()==empadd)
   	    {
    	 	this.setVisible(false);
    	 	MyFrameEmployee mfb2=new MyFrameEmployee();
   		//Bus b1=new Bus();
   		//b1.addBus(str, en, num, ro);
    	//   jt.setText("Ա������ģ�����");
   	
   	    }
       else if(e.getSource()==empupdate)
       {
    	 	this.setVisible(false);
    	 	MyFrameEmployee mfb2=new MyFrameEmployee();
    	  // jt.setText("Ա������ģ�����");
       }
       else if(e.getSource()==empdel)
       {
    	 	this.setVisible(false);
    	 	MyFrameEmployee mfb2=new MyFrameEmployee();
    	  // jt.setText("Ա������ģ��ɾ��");
       }
       else if(e.getSource()==passadd)
     	{
    	 	this.setVisible(false);
    	 	MyFramePassenger mfb3=new MyFramePassenger();
     		//Bus b1=new Bus();
     		//b1.addBus(str, en, num, ro);
    	 //  jt.setText("�˿͹���ģ�����");
     	
     	}
        else if(e.getSource()==passupdate)
        {
         	this.setVisible(false);
         	MyFramePassenger mfb3=new MyFramePassenger();
        //	jt.setText("�˿͹���ģ�����");
        }
        else if(e.getSource()==passdel)
        {
         	this.setVisible(false);
         	MyFramePassenger mfb3=new MyFramePassenger();
        	//jt.setText("�˿͹���ģ��ɾ��");
        }
		
      }
}
 
class MyFrameBus extends MyFrame implements ActionListener{
	JPanel jp1;
	JLabel jl_type;
	JTextField jt_type;
	JLabel jl_en_num;
	JTextField jt_en_num;
	JButton jbtn_update;
	JLabel jl_route;
	JTextField jt_route;
	JLabel jl_num;
	JTextField jt_num;
	JLabel jl_seat;
	JTextField jt_seat;
	JButton jbtn_add;
	JButton jbtn_del;
	JButton jbtn_query;
	Bus b=new Bus();
	public MyFrameBus(){
		super();
	    //��������Ĵ���
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(4,3));
		jl_type=new JLabel("��������:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("��       ��");
		jl_en_num=new JLabel("�� �� ��:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("��       ��");
		jl_seat=new JLabel("�� λ ��:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("ɾ       ��");
		jl_route=new JLabel("��        ·");
		jt_route=new JTextField(30);
		jbtn_query=new JButton("��·��ѯ");
		jp1.add(jl_type);
		jp1.add(jt_type);
		jp1.add(jbtn_add);
		jp1.add(jl_en_num);
		jp1.add(jt_en_num);
		jp1.add(jbtn_update);
		jp1.add(jl_seat);
		jp1.add(jt_seat);
		jp1.add(jbtn_del);
		jp1.add(jl_route );
		jp1.add(jt_route);
		jp1.add(jbtn_query);
		add(jp1,"North");
		this.jbtn_add.addActionListener(this);
		this.jbtn_update.addActionListener(this);
		this.jbtn_del.addActionListener(this);
		this.jbtn_query.addActionListener(this);	
	}
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==this.jbtn_add){
			String s_type="'"+jt_type.getText()+"'";
	    	String s_en_num="'"+jt_en_num.getText()+"'";
	    	String s_seat="'"+jt_seat.getText()+"'";
	    	String s_route="'"+jt_route.getText()+"'";
	    	b.addBus(s_type, s_en_num, s_seat, s_route);
		 }
		 else if(e.getSource()==this.jbtn_update){
			String s_type="'"+jt_type.getText()+"'";
		    String s_en_num="'"+jt_en_num.getText()+"'";
		    String s_seat="'"+jt_seat.getText()+"'";
		    String s_route="'"+jt_route.getText()+"'";
		    b.updateBus(s_type, s_en_num, s_seat, s_route);
		  }
		 else if(e.getSource()==this.jbtn_del){
			 String s_type="'"+jt_type.getText()+"'";
			 b.delBus(s_type);
		    	
		    } 
	 }
	
}
class MyFrameRoute extends MyFrame implements ActionListener{
	JPanel jp1;
	JLabel jl_type;
	JTextField jt_type;
	JLabel jl_en_num;
	JTextField jt_en_num;
	JButton jbtn_update;
	JLabel jl_route;
	JTextField jt_route;
	JLabel jl_listr;
	JTextField jt_listr;
	JLabel jl_num;
	JTextField jt_num;
	JLabel jl_seat;
	JTextField jt_seat;
	JButton jbtn_add;
	JButton jbtn_del;
	JButton jbtn_query;
	Route b=new Route();
	public MyFrameRoute(){
		super();
	    //��������Ĵ���
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(5,4));
		jl_type=new JLabel("��վ:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("��       ��");
		jl_en_num=new JLabel("��ʼվ:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("��       ��");
		jl_seat=new JLabel("�յ�վ:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("ɾ       ��");
		jl_route=new JLabel("����ʱ��");
		jt_route=new JTextField(30);
		jl_listr=new JLabel("��·�б�");
		jt_listr=new JTextField(30);
		jbtn_query=new JButton("��·��ѯ");
		jp1.add(jl_type);
		jp1.add(jt_type);
		jp1.add(jbtn_add);
		jp1.add(jl_en_num);
		jp1.add(jt_en_num);
		jp1.add(jbtn_update);
		jp1.add(jl_seat);
		jp1.add(jt_seat);
		jp1.add(jbtn_del);
		jp1.add(jl_route );
		jp1.add(jt_route);
		jp1.add(jbtn_query);
		jp1.add(jl_listr);
		jp1.add(jt_listr );
		
	
		add(jp1,"North");
		this.jbtn_add.addActionListener(this);
		this.jbtn_update.addActionListener(this);
		this.jbtn_del.addActionListener(this);
		this.jbtn_query.addActionListener(this);	
	}
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==this.jbtn_add){
			String s_stop="'"+jt_type.getText()+"'";
	    	String s_start="'"+jt_en_num.getText()+"'";
	    	String s_end="'"+jt_seat.getText()+"'";
	    	String s_run="'"+jt_route.getText()+"'";
	    	String s_listr="'"+jt_listr.getText()+"'";
	    	b.addRoute(s_stop,s_start,s_end,s_run,s_listr);                   	
		 }
		 else if(e.getSource()==this.jbtn_update){
			String s_stop="'"+jt_type.getText()+"'";
		    String s_start="'"+jt_en_num.getText()+"'";
		    String s_end="'"+jt_seat.getText()+"'";
		    String s_run="'"+jt_seat.getText()+"'";
		    String s_listr="'"+jt_route.getText()+"'";
		    b.updateRoute(s_stop,s_start,s_end,s_run,s_listr);
		  }
		 else if(e.getSource()==this.jbtn_del){
			 String s_stop="'"+jt_type.getText()+"'";
			 b.delRoute(s_stop);	    	
	    } 
	 }	
}
class MyFrameEmployee extends MyFrame implements ActionListener{
	JPanel jp1;
	JLabel jl_type;
	JTextField jt_type;
	JLabel jl_en_num;
	JTextField jt_en_num;
	JButton jbtn_update;
	JLabel jl_route;
	JTextField jt_route;
	JLabel jl_listr;
	JTextField jt_listr;
	JLabel jl_num;
	JTextField jt_num;
	JLabel jl_seat;
	JTextField jt_seat;
	JButton jbtn_add;
	JButton jbtn_del;
	JButton jbtn_query;
	Employee b=new Employee();
	public MyFrameEmployee(){
		super();
	    //��������Ĵ���
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(5,4));
		jl_type=new JLabel("Ա�����:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("��       ��");
		jl_en_num=new JLabel("Ա������:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("��       ��");
		jl_seat=new JLabel("Ա������:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("ɾ       ��");
		jl_route=new JLabel("��ע��Ϣ");
		jt_route=new JTextField(30);
		jl_listr=new JLabel("Ա���б�");
		jt_listr=new JTextField(30);
		jbtn_query=new JButton("Ա����Ϣ��ѯ");
		jp1.add(jl_type);
		jp1.add(jt_type);
		jp1.add(jbtn_add);
		jp1.add(jl_en_num);
		jp1.add(jt_en_num);
		jp1.add(jbtn_update);
		jp1.add(jl_seat);
		jp1.add(jt_seat);
		jp1.add(jbtn_del);
		jp1.add(jl_route );
		jp1.add(jt_route);
		jp1.add(jbtn_query);
		jp1.add(jl_listr);
		jp1.add(jt_listr );
		
		add(jp1,"North");
		this.jbtn_add.addActionListener(this);
		this.jbtn_update.addActionListener(this);
		this.jbtn_del.addActionListener(this);
		this.jbtn_query.addActionListener(this);	
	}
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==this.jbtn_add){
			String s_stop="'"+jt_type.getText()+"'";
	    	String s_start="'"+jt_en_num.getText()+"'";
	    	String s_end="'"+jt_seat.getText()+"'";
	    	String s_run="'"+jt_route.getText()+"'";
	    	String s_listr="'"+jt_listr.getText()+"'";
	    	b.addEmployee(s_stop,s_start,s_end,s_run,s_listr);                   	
		 }
		 else if(e.getSource()==this.jbtn_update){
			String s_stop="'"+jt_type.getText()+"'";
		    String s_start="'"+jt_en_num.getText()+"'";
		    String s_end="'"+jt_seat.getText()+"'";
		    String s_run="'"+jt_seat.getText()+"'";
		    String s_listr="'"+jt_route.getText()+"'";
		    b.updateEmployee(s_stop,s_start,s_end,s_run,s_listr);
		  }
		 else if(e.getSource()==this.jbtn_del){
			 String s_stop="'"+jt_type.getText()+"'";
			 b.delEmployee(s_stop);	    	
	    } 
	 }	
}
class MyFramePassenger extends MyFrame implements ActionListener{
	JPanel jp1;
	JLabel jl_type;
	JTextField jt_type;
	JLabel jl_en_num;
	JTextField jt_en_num;
	JButton jbtn_update;
	JLabel jl_route;
	JTextField jt_route;
	JLabel jl_num;
	JTextField jt_num;
	JLabel jl_seat;
	JTextField jt_seat;
	JButton jbtn_add;
	JButton jbtn_del;
	JButton jbtn_query;
	Passenger b=new Passenger();
	public MyFramePassenger(){
		super();
	    //��������Ĵ���
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(4,3));
		jl_type=new JLabel("Ͷ��������:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("��       ��");
		jl_en_num=new JLabel("Ͷ�����Ա�:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("��       ��");
		jl_seat=new JLabel("Ͷ��������:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("ɾ       ��");
		jl_route=new JLabel("Ͷ����Ϣ");
		jt_route=new JTextField(30);
		jbtn_query=new JButton("Ͷ������Ϣ��ѯ");
		jp1.add(jl_type);
		jp1.add(jt_type);
		jp1.add(jbtn_add);
		jp1.add(jl_en_num);
		jp1.add(jt_en_num);
		jp1.add(jbtn_update);
		jp1.add(jl_seat);
		jp1.add(jt_seat);
		jp1.add(jbtn_del);
		jp1.add(jl_route );
		jp1.add(jt_route);
		jp1.add(jbtn_query);
		add(jp1,"North");
		this.jbtn_add.addActionListener(this);
		this.jbtn_update.addActionListener(this);
		this.jbtn_del.addActionListener(this);
		this.jbtn_query.addActionListener(this);	
	}
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==this.jbtn_add){
			String s_type="'"+jt_type.getText()+"'";
	    	String s_en_num="'"+jt_en_num.getText()+"'";
	    	String s_seat="'"+jt_seat.getText()+"'";
	    	String s_route="'"+jt_route.getText()+"'";
	    	b.addPassenger(s_type, s_en_num, s_seat, s_route);
		 }
		 else if(e.getSource()==this.jbtn_update){
			String s_type="'"+jt_type.getText()+"'";
		    String s_en_num="'"+jt_en_num.getText()+"'";
		    String s_seat="'"+jt_seat.getText()+"'";
		    String s_route="'"+jt_route.getText()+"'";
		    b.updatePassenger(s_type, s_en_num, s_seat, s_route);
		  }
		 else if(e.getSource()==this.jbtn_del){
			 String s_type="'"+jt_type.getText()+"'";
			 b.delPassenger(s_type);
		    	
		    } 
	 }
	
}


