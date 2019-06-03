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

public class Index extends JFrame     // ��ҳ��
{   
	// ���o
	private JButton Query = new JButton("��ѯ��¼");
	private JButton Add = new JButton("��Ӽ�¼");
	private JButton Modify = new JButton("�޸ļ�¼");
	private JButton Delete = new JButton("ɾ����¼");
	private JButton exit = new JButton("�˳�");
	private JLabel zero = new JLabel("ѧ������ϵͳ", JLabel.CENTER);

	public Index()        //��ҳ��UI���
	{          
		this.setTitle("Mainactivity");
		this.setSize(600, 600);
		this.setLocation(600, 300);
		this.setLayout(null);
		zero.setFont(new java.awt.Font("ѧ������ϵͳ", 1, 22));
		// ����ͼ
		String path = "image/004.png"; // ����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
		ImageIcon background = new ImageIcon(path); // ����ͼƬ
		JLabel label = new JLabel(background); // �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		JPanel imagePanel = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
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

		Query.addMouseListener(new MouseAdapter() {  //��ѯ
			public void mouseClicked(MouseEvent e) {
				Query_r Q = new Query_r();
			}
		});
		Add.addMouseListener(new MouseAdapter() {  //���
			public void mouseClicked(MouseEvent e) {
				Add_r A = new Add_r();
			}
		});
		Modify.addMouseListener(new MouseAdapter() { //�޸�
			public void mouseClicked(MouseEvent e) {
				Modify_r M = new Modify_r();
			}
		});
		Delete.addMouseListener(new MouseAdapter() { //ɾ��
			public void mouseClicked(MouseEvent e) {
				Delete_r D = new Delete_r();
			}
		});
		exit.addMouseListener(new MouseAdapter() {  // �˳�
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
