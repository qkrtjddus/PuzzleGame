package Puzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//�������Ű cntrl + f11
public class myPuzzle2 extends JFrame implements ActionListener  {    //Ŭ����
	JButton b1, b2;
	
	public static void main(String[] args) { //�޼ҵ� 
		new myPuzzle2();
	}
	
	public myPuzzle2() {  //������-Ư���� �޼ҵ�
		setTitle("���ʶ��� ����2");
		setSize(500, 200);
		setLocation(500, 300);
	    makeButton();	
		setVisible(true);
	}
	
	void makeButton() { //����� ���� �޼ҵ�
		setLayout(new GridLayout(1, 2));
	
        add( b1 = new JButton("1"));
        add( b2= new JButton());
        
        b1.setEnabled(true);  //��ư Ȱ��ȭ
        b2.setEnabled(false); 
        b1.addActionListener(this); // ��ưb1�� �̺�Ʈ ������ ����
        b2.addActionListener(this); // ��ưb1�� �̺�Ʈ ������ ����
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton act, inact;
		if ( b1.isEnabled() ) { // b1�� Ȱ��ȭ�Ǿ� ������
		   act = b1;   //act��ü Ȱ��ȭ�� ����
		   inact = b2; //inact��ü ��Ȱ��ȭ�� ����
		} else {
			act = b2;   //Ȱ��ȭ
			inact = b1; //��Ȱ��ȭ
		}
		act.setEnabled(false);
		act.setText("");
		inact.setEnabled(true);
		inact.setText("1");
		
	}
}





