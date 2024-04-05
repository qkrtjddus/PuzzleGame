package Puzzle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//실행단축키 cntrl + f11
public class myPuzzle2 extends JFrame implements ActionListener  {    //클래스
	JButton b1, b2;
	
	public static void main(String[] args) { //메소드 
		new myPuzzle2();
	}
	
	public myPuzzle2() {  //생성자-특수한 메소드
		setTitle("진똘똘의 퍼즐2");
		setSize(500, 200);
		setLocation(500, 300);
	    makeButton();	
		setVisible(true);
	}
	
	void makeButton() { //사용자 정의 메소드
		setLayout(new GridLayout(1, 2));
	
        add( b1 = new JButton("1"));
        add( b2= new JButton());
        
        b1.setEnabled(true);  //버튼 활성화
        b2.setEnabled(false); 
        b1.addActionListener(this); // 버튼b1에 이벤트 수신자 붙임
        b2.addActionListener(this); // 버튼b1에 이벤트 수신자 붙임
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton act, inact;
		if ( b1.isEnabled() ) { // b1이 활성화되어 있으면
		   act = b1;   //act객체 활성화로 선언
		   inact = b2; //inact객체 비활성화로 선언
		} else {
			act = b2;   //활성화
			inact = b1; //비활성화
		}
		act.setEnabled(false);
		act.setText("");
		inact.setEnabled(true);
		inact.setText("1");
		
	}
}





