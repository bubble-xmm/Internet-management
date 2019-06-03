package com.soft.services;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Index extends JFrame     // 主页面
{   
	// 按鈕
	private JButton Query = new JButton("查询记录");
	private JButton Add = new JButton("添加记录");
	private JButton Modify = new JButton("修改记录");
	private JButton Delete = new JButton("删除记录");
	private JButton exit = new JButton("退出");
	private JLabel zero = new JLabel("学生管理系统", JLabel.CENTER);

	public Index()        //主页面UI设计
	{          
		this.setTitle("Mainactivity");
		this.setSize(600, 600);
		this.setLocation(600, 300);
		this.setLayout(null);
		zero.setFont(new java.awt.Font("学生管理系统", 1, 22));
		// 背景图
		String path = "image/004.png"; // 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		ImageIcon background = new ImageIcon(path); // 背景图片
		JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
		JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
        //add(background);
		zero.setBounds(125, 6, 324, 59);
		this.add(zero);
		Query.setBounds(154, 80, 265, 51);
		this.add(Query);
		Add.setBounds(154, 155, 265, 51);
		this.add(Add);
		Modify.setBounds(154, 275, 265, 51);
		this.add(Modify);
		Delete.setBounds(154, 350, 265, 51);
		this.add(Delete);
		exit.setBounds(425, 500, 150, 51);
		this.add(exit);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		Query.addMouseListener(new MouseAdapter() {  //查询
			public void mouseClicked(MouseEvent e) {
				Query_r Q = new Query_r();
			}
		});
		Add.addMouseListener(new MouseAdapter() {  //添加
			public void mouseClicked(MouseEvent e) {
				Add_r A = new Add_r();
			}
		});
		Modify.addMouseListener(new MouseAdapter() { //修改
			public void mouseClicked(MouseEvent e) {
				Modify_r M = new Modify_r();
			}
		});
		Delete.addMouseListener(new MouseAdapter() { //删除
			public void mouseClicked(MouseEvent e) {
				Delete_r D = new Delete_r();
			}
		});
		exit.addMouseListener(new MouseAdapter() {  // 退出
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

	}
	
	public static void main(String[] args)
	{
		new Index();
	}

}
