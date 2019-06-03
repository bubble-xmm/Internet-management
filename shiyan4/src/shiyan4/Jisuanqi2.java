package shiyan4;
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Jisuanqi2 extends JFrame implements ActionListener
{
	JMenuItem copy=new JMenuItem("复制");
	JMenuItem paste=new JMenuItem("粘贴");
	JMenuItem exit=new JMenuItem("退出");
	JMenuItem chakan1=new JMenuItem("标准型");
	JMenuItem chakan2=new JMenuItem("科学型");
	JMenuItem chakan3=new JMenuItem("数字分组");
	JMenuItem bangzhu1=new JMenuItem("帮助主题");
	JMenuItem bangzhu2=new JMenuItem("关于计算器");
	JTextField xianshi=new JTextField(15);
	JButton CE=new JButton("CE");
	JButton C=new JButton("C");
	JButton delete=new JButton("×");
	JButton chu=new JButton("/");
	JButton n7=new JButton("7");
	JButton n8=new JButton("8");
	JButton n9=new JButton("9");
	JButton cheng=new JButton("*");
	JButton n4=new JButton("4");
	JButton n5=new JButton("5");
	JButton n6=new JButton("6");
	JButton jian=new JButton("-");
	JButton jia=new JButton("+");
	JButton n1=new JButton("1");
	JButton n2=new JButton("2");
	JButton n3=new JButton("3");
	JButton pingfang=new JButton("^");
	JButton n0=new JButton("0");
	JButton dian=new JButton(".");
	JButton dengyu=new JButton("=");
	public Jisuanqi2()
	{
	super("计算器");	
	JMenu bianji=new JMenu("编辑");
	bianji.add(copy);copy.setEnabled(true);
	bianji.add(paste);paste.setEnabled(true);
	bianji.addSeparator();
	bianji.add(exit);exit.setEnabled(true);
	JMenu chakan=new JMenu("查看");
	chakan.add(chakan1);chakan1.setEnabled(true);
	chakan.add(chakan2);chakan2.setEnabled(true);
	chakan.addSeparator();
	chakan.add(chakan3);chakan3.setEnabled(true);
	JMenu bangzhu=new JMenu("帮助");
	bangzhu.add(bangzhu1);bangzhu1.setEnabled(true);
	bangzhu.addSeparator();
	bangzhu.add(bangzhu2);bangzhu2.setEnabled(true);
	JMenuBar bar=new JMenuBar();
	setJMenuBar(bar);
	bar.add(bianji);
	bar.add(chakan);
	bar.add(bangzhu);
	setSize(220,300);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	add(xianshi);
	add(CE);
	add(C);
	add(delete);
	add(chu);
	add(n7);
	add(n8);
	add(n9);
	add(cheng);
	add(n4);
	add(n5);
	add(n6);
	add(jian);
		add(jia);
		add(n1);
	add(n2);  
	add(n3);

	add(pingfang);
	add(n0);
	add(dian);
	add(dengyu);
	CE.addActionListener(this);
	C.addActionListener(this);
	delete.addActionListener(this);
	chu.addActionListener(this);
	n7.addActionListener(this);
	n8.addActionListener(this);
	n9.addActionListener(this);
	cheng.addActionListener(this);
	n4.addActionListener(this);
	n5.addActionListener(this);
	n6.addActionListener(this);
	jian.addActionListener(this);
	n1.addActionListener(this);
	n2.addActionListener(this);
	n3.addActionListener(this);
	jia.addActionListener(this);
	pingfang.addActionListener(this);
	n0.addActionListener(this);
	dian.addActionListener(this);
	dengyu.addActionListener(this);
	exit.addActionListener(this);
	validate();
	}		
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==exit)
		System.exit(0);
	//e.getSourse()=n7;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jisuanqi2 f=new Jisuanqi2();

	}

}
