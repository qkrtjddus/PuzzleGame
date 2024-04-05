package Puzzle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class myPuzzle16 extends JFrame implements ActionListener {
	private JButton btn[];
	 
	public static void main(String[] args) {
	 new myPuzzle16();
	}

	public myPuzzle16() {
		setTitle("���ʶ��� 16�ǽ�����");
		setSize(400,300);
		setLocation(400,400);
		makeButton();
		setVisible(true);
	}
	
	 void makeButton() {
		 //��ư 16�� ������ �ϴϱ�
		 btn = new JButton[16];
		 setLayout(new GridLayout(4,4));
		 
		for ( int i = 0; i < 16 ; i++) {
			add(btn[i] = new JButton( String.valueOf(i) )) ; //�������� String������ ��ȯ
		
			btn[i].addActionListener(this);
			
		}
		btn[15].setText(""); //���� ������ ��ư�� 15��°�� ȭ�鿡 �ȳ�������  ���� �����
    	btn[15].setEnabled(false); // ���� ������ ��ư����Ȱ��ȭ�ǵ��� �սô�.
 
	}
	
//int ������ �迭����,nb�� Neighbor�� ��Ÿ��.
private int[] nb = new int[4]; 

//�Ű����� id�� ������ �ڱ� �̿��� ���ϴ� �迭 nb�� ��,�Ʒ�, ��,�� ������ �޴� �޼ҵ�
private void findNB(int id){
	// nb �迭�� �ִµ�  nb[0]���� up�� ���� nb[1]�� down��.. 
	
	//up �̿�
	nb[0]=	id - 4; 
	if( nb[0] < 0) { // ����� ������ �̿��� ���� ��, ����� ���� �ǹ̷� �Ϻη� -1�� ����
		nb[0] = -1 ;
	}
	
	//down �̿�
	nb[1] = id + 4; 
	    //����� 16�̻��̶�� ����� ���ٴ� �ǹ̷� �Ϻη� ������ ����
	  if (nb[1] >= 16) {  // ����� 16�̻��̸� �̿��� ���°� ,����� ���� �ǹ̷� �Ϻη� -1�� ����
		  nb[1] = -1 ; //
	  }
		
	//left �̿�
	nb[2] = id - 1; 
	//Left = id  - 1;  ����� -1, 3, 7, 11�̶�� �̿��� ���ٴ� �ǹ�
	if 	( nb[2] < 0  ||  (nb[2]%4 == 3) )
		 nb[1] = -1 ; 
	
	//right �̿�
	nb[3] = id + 1; 
	if ( nb[3] % 4 == 0) 
		nb[3] = -1;  // ����� 4, 8, 12, 16�̸� �̿��� ���°� , ����� ���� �ǹ̷� �Ϻη� -1�� ����
	  
} 
	  
   @Override
   public void actionPerformed(ActionEvent e) {
	// e�� ��ư�� �������� � � ��ư�� ���ȴ���..actionevent�� �߻���Ų �ҽ��� �������ϴ� �ǵ�.
	 //e�� object type(��ü Ÿ��)�̴�. 16�� ��ư �߿� ���� ���ȳ��ϴ� ���� �˾ƺ��� �̴ϴ�.
	 // b�� ���� ��ư�̰�, ���� ��ư�� ���������� �ڵ带 �ۼ�
	 JButton b = (JButton) e.getSource();	
	 int id; 
	 // b��� ��ư�� ���� ������? id�� ���� �ſ���. 
	 // id�� 0���� 15���� � ���� ���µ�, 5�� ������ id�� 5�� ��.
	 for ( id = 0 ; id < 16 ; id++ )
		if ( b == btn[id] )
			break;
	 
	// 5�� �������� 5�� �̿��� ã�ƾ�...
    findNB(id); // �Լ� ȣ��, id���� ������ id�� �̿����� nb�迭�� ���� ��.
  
    //�״����� �̿��߿��� Ȱ��ȭ���� ���� ���� ���� �ִ°�? Ŭ���� id�� Ȱ��ȭ���� ���� �Ͱ� �ٲپ��.
     for (int i = 0; i< 4 ; i++) {
    	//�̿��� ��ư 4���� ������� �̿��� ���°��̹Ƿ� �����ؾ�,
    	//�� �̿��� ��ư 4���� ����̸鼭 �̿� 4�� ��ư �� ��Ȱ��ȭ�Ȱ��� ������ for�� ������.
    	// id ��ư�� �Űܶ�
    	 if ( nb[i]>=0  && !btn[nb[i]].isEnabled() ) {
    	 
    	   JButton act, inact;
    	   //���� ��ư�� id�̰�
    	   act = btn[id];
    	   //��Ȱ��ȭ�Ȱ� nb��ư�̴ϱ�
    	   inact = btn[nb[i] ];
    	   //���� �¹ٲٰ�
    	   inact.setText(act.getText());
    	   act.setText("");
    	   //Ȱ��ȭ�� ���� ��Ȱ��ȭ ��ư�� �� �ٲٰ�
            act.setEnabled(false);
            inact.setEnabled(true);
        //4�� �̿��� �ϳ��� ��Ȱ��ȭ�Ǿ� �����״ϱ� �ϳ��� Ȱ��ȭ�Ȱ��� �߰ߵǸ� for������ �� ���ʿ�� ����. 
        //��Ȱ��ȭ�Ȱ� �߰ߵǸ� ������ ���������� �ȴ�.
            break;
    	 } 	 
     }
     	
   }
}












