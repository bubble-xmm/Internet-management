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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.soft.db.DBUtils;

public class Delete_r extends JFrame {
	private JLabel la = new JLabel("请输入需删除的学生学号：");
	private JButton sure = new JButton("确定");
	private JTextField te = new JTextField(10);
	final JDialog di = new JDialog(this, "反馈");
	final JDialog di_1 = new JDialog(this, "错误");
	private JButton sure_1 = new JButton("确定");
	private JButton sure_2 = new JButton("确定");
	private JLabel la_1 = new JLabel("删除成功！");
	private JLabel la_2 = new JLabel("删除失败！不存在相关学生信息！");

	public Delete_r() {
		this.setSize(600, 600);
		this.setLocation(600, 300);
		this.setLayout(new FlowLayout());
		 //背景图
		String path = ""; // 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		ImageIcon background = new ImageIcon(path); // 背景图片
		JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
		JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
		this.add(la);
		this.add(te);
		this.add(sure);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		di.setSize(220, 150);
		di.setLocation(800, 500);
		di.setLayout(new FlowLayout());
		di.add(la_1);
		di.add(sure_1);

		di_1.setSize(220, 150);
		di_1.setLocation(800, 500);
		di_1.setLayout(new FlowLayout());
		di_1.add(la_2);
		di_1.add(sure_2);

		te.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				te.setText("");

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

		sure.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String id = te.getText();
				String sql = "delete from student where id = '" + id + "'";
				String sql_1 = "select id from student where id = '" + id + "'";
				try {
					Connection conn = DBUtils.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql_1);
					int flag = 1;
					if (rs.next()) {
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
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("连接数据库失败！");
				}
			}

		});
	}
}
