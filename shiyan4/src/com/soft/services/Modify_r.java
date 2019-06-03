package com.soft.services;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.soft.db.DBUtils;

public class Modify_r extends JFrame 
{
	private JLabel la = new JLabel("学生学号: ");
	private JLabel la_1 = new JLabel("学生姓名: ");
	private JLabel la_2 = new JLabel("年龄: ");
	private JLabel la_3 = new JLabel("性别: ");
	private JLabel la_4 = new JLabel("所在学院: ");
	private JLabel la_5 = new JLabel("所在专业: ");
	private JLabel la_6 = new JLabel("成绩: ");
	private JTextField te = new JTextField(10);
	private JTextField te_1 = new JTextField(10);
	private JTextField te_2 = new JTextField(10);
	private JTextField te_3 = new JTextField(10);
	private JTextField te_4 = new JTextField(10);
	private JTextField te_5 = new JTextField(10);
	private JTextField te_6 = new JTextField(10);
	private JButton sure = new JButton("确定");

	final JDialog di = new JDialog(this, "反馈");
	final JDialog di_1 = new JDialog(this, "错误");
	private JButton sure_1 = new JButton("确定");
	private JButton sure_2 = new JButton("确定");
	private JLabel l_1 = new JLabel("更改成功！");
	private JLabel l_2 = new JLabel("更改失败！不存在相关信息！");

	public  Modify_r() {

		this.setSize(600, 600);
		this.setLocation(600, 300);
		this.setLayout(null);
		this.setTitle("请输入要修改的学生信息: ");
		// 背景图
		String path = "image/011.png"; // 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		ImageIcon background = new ImageIcon(path); // 背景图片
		JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
		JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景

		la.setBounds(20, 10, 80, 20);
		this.add(la);
		te.setBounds(100, 10, 120, 20);
		this.add(te);
		la_1.setBounds(270, 10, 80, 20);
		this.add(la_1);
		te_1.setBounds(350, 10, 120, 20);
		this.add(te_1);
		la_2.setBounds(20, 40, 80, 20);
		this.add(la_2);
		te_2.setBounds(100, 40, 120, 20);
		this.add(te_2);
		la_3.setBounds(270, 40, 80, 20);
		this.add(la_3);
		te_3.setBounds(350, 40, 120, 20);
		this.add(te_3);
		la_4.setBounds(20, 70, 80, 20);
		this.add(la_4);
		te_4.setBounds(100, 70, 120, 20);
		this.add(te_4);
		la_5.setBounds(270, 70, 80, 20);
		this.add(la_5);
		te_5.setBounds(350, 70, 120, 20);
		this.add(te_5);
		la_6.setBounds(20, 100, 80, 20);
		this.add(la_6);
		te_6.setBounds(100, 100, 120, 20);
		this.add(te_6);
		sure.setBounds(200, 150, 60, 30);
		this.add(sure);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		di.setSize(220, 150);
		di.setLocation(800, 500);
		di.setLayout(new FlowLayout());
		di.add(l_1);
		di.add(sure_1);

		di_1.setSize(220, 150);
		di_1.setLocation(800, 500);
		di_1.setLayout(new FlowLayout());
		di_1.add(l_2);
		di_1.add(sure_2);

		te.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				te.setText("");

			}
		});
		te_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				te_1.setText("");

			}
		});
		sure_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				di.dispose();

			}
		});
		sure_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				di_1.dispose();

			}
		});

		sure.addMouseListener(new MouseAdapter() 
		{

			public void mouseClicked(MouseEvent e) 
			{
				String s1 = te.getText();
				String s2 = te_1.getText();
				String s3 = te_2.getText();
				String s4 = te_3.getText();
				String s5 = te_4.getText();
				String s6 = te_5.getText();
				String s7 = te_6.getText();
				String sql = "update student set name ='" + s2 + "' ,age = '" + s3 +"' ,sex = '" + s4 +"' ,college = '" + s5 +"', major = '" + s6 +"' ,source = '" + s7 +"'   where id = '" + s1 + "'";   //修改
				String sql_1 = "select id from student where id='" + s1 + "'";
				try {
					Connection conn = DBUtils.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet r = stmt.executeQuery(sql_1);
					int flag = 1;
					if (r.next()) {   //判断信息是否已存在
						flag = 0;
					}
					if (flag == 0) {
						stmt.executeUpdate(sql);
						di.setModal(true);
						di.setVisible(true);
					} else {
						di_1.setModal(true);
						di_1.setVisible(true);
					}

					stmt.close();
					conn.close();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
					System.out.println("连接数据库失败！");
				}
			}
		});
	}
}
