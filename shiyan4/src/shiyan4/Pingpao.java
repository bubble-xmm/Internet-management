package shiyan4;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.*;
class MoveCanvas extends Canvas
{
	MoveCanvas()
	{
		setSize(300,220);
		
	}
	public void paint(Graphics e)
	{
		e.drawLine(50, 50, 120, 50);
		e.drawLine(120, 50,120, 220);
		e.drawLine(120, 220, 300, 220);
		e.setColor(Color.red);
		e.fillOval(110, 40, 10, 10);
		e.setColor(Color.blue);
		int x=10,y=10;
		int i = 112,j=42;
		e.fillOval(i, j,x+1, y+1);

	}
public void moveUp()
{
	//if()
	}
}
public class Pingpao extends JFrame implements ActionListener
{
	JButton yundong=new JButton("运动");
	JTextField sudu=new JTextField(10);
	public MoveCanvas drawing=new MoveCanvas();
	Pingpao(){
	super("小球平抛运动");
	setSize(350,350);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	MoveCanvas c=new MoveCanvas();
	setLayout(new FlowLayout());
	add(c);
	add(sudu);
	add(yundong);
	validate();
	yundong.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//if(sudu.getText()>=0)
		//moveUp();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Pingpao();
	}

	}
