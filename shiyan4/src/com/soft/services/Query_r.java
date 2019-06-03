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
public class Query_r extends JFrame         //��ѯ
{        
	private JLabel la = new JLabel("���������ѯѧ����ѧ�ţ�");
	private JButton sure = new JButton("ȷ��");
	private JTextField te = new JTextField(10);
	private JTextArea te_1 = new JTextArea(30, 30);
	public Query_r() 
	{
		//UI
		this.setSize(600, 646);
		this.setLocation(600, 300);
		this.setLayout(new FlowLayout());
		 te_1.setLineWrap(true);//�����Զ�����
		// ����ͼ
				String path = ""; // ����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
				ImageIcon background = new ImageIcon(path); // ����ͼƬ
				JLabel label = new JLabel(background); // �ѱ���ͼƬ��ʾ��һ����ǩ����
				label.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
				JPanel imagePanel = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
				imagePanel.setOpaque(false);
				this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

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
		
		    //�Զ���ѯ���н��
		try 
		{
			String sql = "select * from student ";  
			Connection conn = DBUtils.getConnection();//�������ݿ�
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			te_1.setText("�����" + "\n");
			while (rs.next()) {      //��ȡ���
				String s1 = rs.getString("id");
				String s2 = rs.getString("name");
				String s3 = rs.getString("age");
				String s4 = rs.getString("sex");
				String i5 = rs.getString("college");
				String i6 = rs.getString("major");
				String i7 = rs.getString("source");

				te_1.append("ѧ��ѧ��: ");    //��дText�ı�����
				te_1.append(s1);
				te_1.append("   ");
				te_1.append("ѧ������: ");
				te_1.append(s2);
				te_1.append("   ");
				te_1.append("����: ");
				te_1.append(s3);
				te_1.append("   ");
				te_1.append("�Ա�: ");
				te_1.append(s4);
				te_1.append("   ");
				te_1.append("����ѧԺ: ");
				te_1.append(i5 + "");
				te_1.append("   ");
				te_1.append("����רҵ: ");
				te_1.append(i6 + "");
				te_1.append("   ");
				te_1.append("�ɼ�: ");
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
			System.out.println("�������ݿ�ʧ�ܣ�");
		}
		
		sure.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				String id = te.getText();

				String sql = "select * from student where id ='" + id + "'";     //SQl ѡ�����
				try 
				{

					Connection conn = DBUtils.getConnection();//�������ݿ�

					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					te_1.setText("�����" + "\n");
					int flag=1;
					while (rs.next()) {      //��ȡ���
                         flag =0;
						String s1 = rs.getString("id");
						String s2 = rs.getString("name");
						String s3 = rs.getString("age");
						String s4 = rs.getString("sex");
						int i5 = rs.getInt("college");
						int i6 = rs.getInt("major");
						int i7 = rs.getInt("source");

						te_1.append("ѧ��ѧ��: ");    //��дText�ı�����
						te_1.append(s1);
						te_1.append("   ");
						te_1.append("ѧ������: ");
						te_1.append(s2);
						te_1.append("   ");
						te_1.append("����: ");
						te_1.append(s3);
						te_1.append("   ");
						te_1.append("�Ա�: ");
						te_1.append(s4);
						te_1.append("   ");
						te_1.append("����ѧԺ: ");
						te_1.append(i5 + "");
						te_1.append("   ");
						te_1.append("����רҵ: ");
						te_1.append(i6 + "");
						te_1.append("   ");
						te_1.append("�ɼ�: ");
						te_1.append(i7 + "");
						te_1.append("   ");
						te_1.append("\n");
						te_1.append("\n");
					}
					if(flag==1)   te_1.append("���ݿ���û�������Ϣ��");
					rs.close();
					stmt.close();
					conn.close();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
					System.out.println("�������ݿ�ʧ�ܣ�");
				}

			}
		});
	}
	
}
