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
	private JLabel la = new JLabel("��������ɾ����ѧ��ѧ�ţ�");
	private JButton sure = new JButton("ȷ��");
	private JTextField te = new JTextField(10);
	final JDialog di = new JDialog(this, "����");
	final JDialog di_1 = new JDialog(this, "����");
	private JButton sure_1 = new JButton("ȷ��");
	private JButton sure_2 = new JButton("ȷ��");
	private JLabel la_1 = new JLabel("ɾ���ɹ���");
	private JLabel la_2 = new JLabel("ɾ��ʧ�ܣ����������ѧ����Ϣ��");

	public Delete_r() {
		this.setSize(600, 600);
		this.setLocation(600, 300);
		this.setLayout(new FlowLayout());
		 //����ͼ
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
					System.out.println("�������ݿ�ʧ�ܣ�");
				}
			}

		});
	}
}
