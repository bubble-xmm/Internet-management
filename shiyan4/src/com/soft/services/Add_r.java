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


public class Add_r extends JFrame      //���
{

	private JLabel la = new JLabel("ѧ��ѧ��: ");
	private JLabel la_1 = new JLabel("ѧ������: ");
	private JLabel la_2 = new JLabel("����: ");
	private JLabel la_3 = new JLabel("�Ա�: ");
	private JLabel la_4 = new JLabel("����ѧԺ: ");
	private JLabel la_5 = new JLabel("����רҵ: ");
	private JLabel la_6 = new JLabel("�ɼ�: ");
	private JTextField te = new JTextField(10);
	private JTextField te_1 = new JTextField(10);
	private JTextField te_2 = new JTextField(10);
	private JTextField te_3 = new JTextField(10);
	private JTextField te_4 = new JTextField(10);
	private JTextField te_5 = new JTextField(10);
	private JTextField te_6 = new JTextField(10);
	private JButton sure = new JButton("ȷ��");
	final JDialog di = new JDialog(this, "����");
	final JDialog di_1 = new JDialog(this, "����");
	private JButton sure_1 = new JButton("ȷ��");
	private JButton sure_2 = new JButton("ȷ��");
	private JLabel l_1 = new JLabel("��ӳɹ���");
	private JLabel l_2 = new JLabel("���ʧ�ܣ�ѧ����Ϣδ�ϴ������ݿ��У���ȷ�����ٲ�����");
	private JButton cl = new JButton("���");

	public Add_r() {
		this.setSize(600, 600);
		this.setLocation(600, 300);
		this.setLayout(null);
		// ����ͼ
		String path = ""; // ����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
		ImageIcon background = new ImageIcon(path); // ����ͼƬ
		JLabel label = new JLabel(background); // �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		JPanel imagePanel = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

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
		cl.setBounds(310, 150, 60, 30);
		this.add(cl);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		di.setSize(220, 150);
		di.setLocation(800, 500);
		di.setLayout(new FlowLayout());
		di.add(l_1);
		di.add(sure_1);

		di_1.setSize(440, 150);
		di_1.setLocation(800, 500);
		di_1.setLayout(new FlowLayout());
		di_1.add(l_2);
		di_1.add(sure_2);
        //ȷ����ť
		sure.addMouseListener(new MouseAdapter() {              
			public void mouseClicked(MouseEvent e) {
				String s1 = te.getText();
				String s2 = te_1.getText();
				String s3 = te_2.getText();
				String s4 = te_3.getText();
				String s5 = te_4.getText();
				String s6 = te_5.getText();
				String s7 = te_6.getText();
				String sql = "insert into student(id,name,age,sex,college,major,source) values('" + s1 + "','" + s2 + "','" + s3
						+ "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "')";
			
				try 
				{
					Connection conn = DBUtils.getConnection();
					Statement stmt = conn.createStatement();
				    stmt.executeUpdate(sql);
				    di.setModal(true);
			    	di.setVisible(true);
				   	stmt.close();
					conn.close();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
					di_1.setModal(true);
					di_1.setVisible(true);
					System.out.println("�������ݿ�ʧ�ܣ�");
				}
			}
		});
		//��հ�ť
		cl.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				te.setText("");
				te_1.setText("");
				te_2.setText("");
				te_3.setText("");
				te_4.setText("");
				te_5.setText("");
				te_6.setText("");

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
	}

}
