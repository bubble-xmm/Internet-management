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
	String type;  //01:空调车；02：普通车；03：快速公交 
	int engine_number; //引擎号：1~10的数
	int seating_capacity;//多少座车
	int route;   //线路号：1~10的数
	Bus(){
		System.out.println("汽车管理模块");
	 }
	void addBus(String str,String en,String num,String ro){
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
	return ("公交信息："+type+" "+engine_number+" "
	+seating_capacity+" "+route );	
	}	
}
class Route{
	int  num_of_stop;  //0~20以内的数
	String start_station;  //起始站
	String end_station;   //终点站
	String run_time;    //运行时间**~**
	List  listRoute;//线路列表
	 Route(){
		 System.out.println("线路管理模块");
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
		String sql="update Route set 车站="+num +","+"起始站="
		+start+","+"终点站="+run+","+"线路列表="+list;
		con_route.getUpdate(con_route.connect(), num,sql);	
	}
	void delRoute(String num){
		DBConnect con_route=new DBConnect();
		String sql="delete from Route where 类型="+num;
		con_route.getdelet(con_route.connect(),sql);	
	}
	public String toString(){
	return ("公交信息："+num_of_stop+" "+start_station+" "
	+end_station+" "+run_time+" "+listRoute );	
	}
}
class Employee{
	int ID;  //员工编号
	String name;   //员工姓名
	int age;    //员工年龄
	String message;   //备注信息
	List  listEmployee; //员工列表
	Employee(){
		System.out.println("线路管理模块");
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
		String sql="delete from Employee where 类型="+id;
		con_employee.getdelet(con_employee.connect(),sql);	
	}
	public String toString(){
		return ("公交信息："+ID+" "+name+" "
		+age+" "+message+" "+listEmployee );	
		}
}
class Passenger{
	String name;  //投诉人姓名
	char sex;   //投诉人性别
	int age;   //投诉人年龄
	String message;    //投诉信息
	Passenger(){
		System.out.println("乘客管理模块");
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
		String sql="delete from Employee where 类型="+name;
		con_employee.getdelet(con_employee.connect(),sql);	
		}
	public String toString(){
		return ("公交信息："+name+" "+sex+" "
				+age+" "+message+" ");	
		}
}
class Manager extends Employee{
	String position;   //职务
	String depart;   //管理部门
	String duty;   //职责
	
	Manager(){
		System.out.println("管理者模块");
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
		           
		        // String sql = "INSERT INTO basic VALUES ('L004','兰博基尼','2010/5/9','555555')";  
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
		 //String s=sql+"where 引擎号="+sup;
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
		     //String s="select 类型  from bus "; 
		     String s1="";
		    // Statement st;
		     PreparedStatement ps;
	         try{  
	            
	             s1=sql+"where 类型="+sup;
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
	//菜单项的定义
	private JMenuItem busadd = new JMenuItem("添加");
    private JMenuItem busupdate = new JMenuItem("更新");
    private JMenuItem busdel = new JMenuItem("删除");
    private JMenuItem busexit=new JMenuItem("退出");
    private JMenuItem routeadd = new JMenuItem("添加");
    private JMenuItem routeupdate = new JMenuItem("更新");
    private JMenuItem routedel = new JMenuItem("删除");
    private JMenuItem routeexit=new JMenuItem("退出");
    private JMenuItem passadd = new JMenuItem("添加");
    private JMenuItem passupdate = new JMenuItem("更新");
    private JMenuItem passdel = new JMenuItem("删除");
    private JMenuItem employeeexit=new JMenuItem("退出");
    private JMenuItem empadd = new JMenuItem("添加");
    private JMenuItem empupdate = new JMenuItem("更新");
    private JMenuItem empdel = new JMenuItem("删除");
    private JMenuItem passagerexit=new JMenuItem("退出");
    private JMenuItem syshelp = new JMenuItem("帮助");
    private JMenuItem sysexit = new JMenuItem("退出");
    public int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	public int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	private JTableHeader jth;
	int count;
	//各种组件的设置
	JTextField jt=new JTextField(30);
	JPanel jp2;
	JTable tabDemo;
	Object[][] info=new Object[count][4];
	JLabel jl_main;
	MyFrame(){
		super("公交管理系统");
		setLayout(null);
        JMenu busmod = new JMenu("汽车管理模块");
        busmod.add(busadd); busmod.setEnabled(true);
        busmod.add(busupdate); busmod.setEnabled(true);
        busmod.add(busdel); busmod.setEnabled(true);
        busmod.addSeparator();
        busmod.add(busexit);busexit.setEnabled(true);
        JMenu routemod = new JMenu("线路管理模块");
        routemod.add( routeadd);routemod.setEnabled(true);
        routemod.add( routeupdate);routemod.setEnabled(true);
        routemod.add( routedel);routemod.setEnabled(true);
        routemod.addSeparator();
        routemod.add(routeexit);routeexit.setEnabled(true);
        JMenu empmod = new JMenu("员工管理模块");
        empmod.add(empadd); empmod.setEnabled(true);
        empmod.add(empupdate); empmod.setEnabled(true);
        empmod.add(empdel); empmod.setEnabled(true);
        empmod.addSeparator();
        empmod.add(employeeexit);employeeexit.setEnabled(true);
        JMenu passmod = new JMenu("乘客管理模块");
        passmod.add(passadd);passmod.setEnabled(true);
        passmod.add(passupdate);passmod.setEnabled(true);
        passmod.add(passdel);passdel.setEnabled(true);
        passmod.addSeparator();
        passmod.add(passagerexit);passagerexit.setEnabled(true);
        JMenu sysmod = new JMenu("系统");
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
	    
	    jl_main=new JLabel("欢迎使用公交管理系统");
	    jl_main.setForeground(Color.blue);
	    jl_main.setFont(new Font("宋体",Font.BOLD,30));
	    jl_main.setBounds(150, 90, 400, 100); 
	    add(jl_main);
	
	    
	    jp2=new JPanel();
	    
	    add(jp2,"South");
	    
	    String[] title={"公交类型","引擎号","座位数","线路"};
	    tabDemo=new JTable(info,title);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] title1={"车站","起始站","终点站","运行时间","线路列表"};
	    tabDemo=new JTable(info,title1);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] title2={"员工编号","员工姓名","员工年龄","备注信息","员工列表"};
	    tabDemo=new JTable(info,title2);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        String[] title3={"投诉人姓名","投诉人年龄","投诉人性别","投诉信息",};
	    tabDemo=new JTable(info,title3);
	    jth=tabDemo.getTableHeader();    
	    setSize(600,400);
	    setLocation(width/2-500,height/2-300);
	    setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	 public void actionPerformed(ActionEvent e)
	 {  
       String str="这是公交管理系统帮助系统，"
       		+ "该系统只是一个测试版本，还不完善，希望同学们能利用自己学过的知识完善它！";
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
        	//jt.setText("线路管理模块添加");
    	}
       else if(e.getSource()==routeupdate)
        {
    	 	this.setVisible(false);
        	MyFrameRoute mfb1=new MyFrameRoute();
    	   //jt.setText("线路管理模块更新");
        }
       else if(e.getSource()==routedel)
        {
    	 	this.setVisible(false);
        	MyFrameRoute mfb1=new MyFrameRoute();
    	   //jt.setText("线路管理模块删除");
        }
       else if(e.getSource()==empadd)
   	    {
    	 	this.setVisible(false);
    	 	MyFrameEmployee mfb2=new MyFrameEmployee();
   		//Bus b1=new Bus();
   		//b1.addBus(str, en, num, ro);
    	//   jt.setText("员工管理模块添加");
   	
   	    }
       else if(e.getSource()==empupdate)
       {
    	 	this.setVisible(false);
    	 	MyFrameEmployee mfb2=new MyFrameEmployee();
    	  // jt.setText("员工管理模块更新");
       }
       else if(e.getSource()==empdel)
       {
    	 	this.setVisible(false);
    	 	MyFrameEmployee mfb2=new MyFrameEmployee();
    	  // jt.setText("员工管理模块删除");
       }
       else if(e.getSource()==passadd)
     	{
    	 	this.setVisible(false);
    	 	MyFramePassenger mfb3=new MyFramePassenger();
     		//Bus b1=new Bus();
     		//b1.addBus(str, en, num, ro);
    	 //  jt.setText("乘客管理模块添加");
     	
     	}
        else if(e.getSource()==passupdate)
        {
         	this.setVisible(false);
         	MyFramePassenger mfb3=new MyFramePassenger();
        //	jt.setText("乘客管理模块更新");
        }
        else if(e.getSource()==passdel)
        {
         	this.setVisible(false);
         	MyFramePassenger mfb3=new MyFramePassenger();
        	//jt.setText("乘客管理模块删除");
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
	    //界面组件的处理
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(4,3));
		jl_type=new JLabel("公交类型:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("添       加");
		jl_en_num=new JLabel("引 擎 号:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("更       新");
		jl_seat=new JLabel("座 位 数:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("删       除");
		jl_route=new JLabel("线        路");
		jt_route=new JTextField(30);
		jbtn_query=new JButton("线路查询");
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
	    //界面组件的处理
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(5,4));
		jl_type=new JLabel("车站:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("添       加");
		jl_en_num=new JLabel("起始站:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("更       新");
		jl_seat=new JLabel("终点站:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("删       除");
		jl_route=new JLabel("运行时间");
		jt_route=new JTextField(30);
		jl_listr=new JLabel("线路列表");
		jt_listr=new JTextField(30);
		jbtn_query=new JButton("线路查询");
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
	    //界面组件的处理
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(5,4));
		jl_type=new JLabel("员工编号:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("添       加");
		jl_en_num=new JLabel("员工姓名:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("更       新");
		jl_seat=new JLabel("员工年龄:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("删       除");
		jl_route=new JLabel("备注信息");
		jt_route=new JTextField(30);
		jl_listr=new JLabel("员工列表");
		jt_listr=new JTextField(30);
		jbtn_query=new JButton("员工信息查询");
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
	    //界面组件的处理
		super.jl_main.setVisible(false);
		setLayout(new BorderLayout());
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(4,3));
		jl_type=new JLabel("投诉人姓名:");
		jt_type=new JTextField(30);
		jbtn_add=new JButton("添       加");
		jl_en_num=new JLabel("投诉人性别:");
		jt_en_num=new JTextField(30);
		jbtn_update=new JButton("更       新");
		jl_seat=new JLabel("投诉人年龄:");
		jt_seat=new JTextField(30);
		jbtn_del=new JButton("删       除");
		jl_route=new JLabel("投诉信息");
		jt_route=new JTextField(30);
		jbtn_query=new JButton("投诉人信息查询");
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


