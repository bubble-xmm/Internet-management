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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.soft.db.DBUtils;
public class Query_r extends JFrame         //查询
{        
	private JLabel la = new JLabel("请输入需查询学生的学号：");
	private JButton sure = new JButton("确定");
	private JTextField te = new JTextField(10);
	private JTextArea te_1 = new JTextArea(30, 30);
	public Query_r() 
	{
		//UI
		this.setSize(600, 646);
		this.setLocation(600, 300);
		this.setLayout(new FlowLayout());
		 te_1.setLineWrap(true);//设置自动换行
		// 背景图
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
		this.add(te_1);
		te_1.setEditable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		te.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				te.setText("");

			}
		});
		
		    //自动查询所有结果
		try 
		{
			String sql = "select * from student ";  
			Connection conn = DBUtils.getConnection();//连接数据库
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			te_1.setText("结果：" + "\n");
			while (rs.next()) {      //获取结果
				String s1 = rs.getString("id");
				String s2 = rs.getString("name");
				String s3 = rs.getString("age");
				String s4 = rs.getString("sex");
				String i5 = rs.getString("college");
				String i6 = rs.getString("major");
				String i7 = rs.getString("source");

				te_1.append("学生学号: ");    //回写Text文本区域
				te_1.append(s1);
				te_1.append("   ");
				te_1.append("学生姓名: ");
				te_1.append(s2);
				te_1.append("   ");
				te_1.append("年龄: ");
				te_1.append(s3);
				te_1.append("   ");
				te_1.append("性别: ");
				te_1.append(s4);
				te_1.append("   ");
				te_1.append("所在学院: ");
				te_1.append(i5 + "");
				te_1.append("   ");
				te_1.append("所在专业: ");
				te_1.append(i6 + "");
				te_1.append("   ");
				te_1.append("成绩: ");
				te_1.append(i7 + "");
				te_1.append("   ");
				te_1.append("\n");
				te_1.append("\n");
			}
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
			System.out.println("连接数据库失败！");
		}
		
		sure.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				String id = te.getText();

				String sql = "select * from student where id ='" + id + "'";     //SQl 选择语句
				try 
				{

					Connection conn = DBUtils.getConnection();//连接数据库

					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					te_1.setText("结果：" + "\n");
					int flag=1;
					while (rs.next()) {      //获取结果
                         flag =0;
						String s1 = rs.getString("id");
						String s2 = rs.getString("name");
						String s3 = rs.getString("age");
						String s4 = rs.getString("sex");
						int i5 = rs.getInt("college");
						int i6 = rs.getInt("major");
						int i7 = rs.getInt("source");

						te_1.append("学生学号: ");    //回写Text文本区域
						te_1.append(s1);
						te_1.append("   ");
						te_1.append("学生姓名: ");
						te_1.append(s2);
						te_1.append("   ");
						te_1.append("年龄: ");
						te_1.append(s3);
						te_1.append("   ");
						te_1.append("性别: ");
						te_1.append(s4);
						te_1.append("   ");
						te_1.append("所在学院: ");
						te_1.append(i5 + "");
						te_1.append("   ");
						te_1.append("所在专业: ");
						te_1.append(i6 + "");
						te_1.append("   ");
						te_1.append("成绩: ");
						te_1.append(i7 + "");
						te_1.append("   ");
						te_1.append("\n");
						te_1.append("\n");
					}
					if(flag==1)   te_1.append("数据库中没有相关信息！");
					rs.close();
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
