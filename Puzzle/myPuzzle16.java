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
		setTitle("진똘똘의 16피스퍼즐");
		setSize(400,300);
		setLocation(400,400);
		makeButton();
		setVisible(true);
	}
	
	 void makeButton() {
		 //버튼 16개 만들어야 하니까
		 btn = new JButton[16];
		 setLayout(new GridLayout(4,4));
		 
		for ( int i = 0; i < 16 ; i++) {
			add(btn[i] = new JButton( String.valueOf(i) )) ; //정수값을 String값으로 변환
		
			btn[i].addActionListener(this);
			
		}
		btn[15].setText(""); //제일 마지막 버튼인 15번째는 화면에 안나오도록  라벨이 없어야
    	btn[15].setEnabled(false); // 제일 마지막 버튼은비활성화되도록 합시다.
 
	}
	
//int 정수형 배열선언,nb는 Neighbor를 나타냄.
private int[] nb = new int[4]; 

//매개변수 id를 줬을때 자기 이웃을 구하는 배열 nb에 위,아래, 좌,우 정보를 받는 메소드
private void findNB(int id){
	// nb 배열이 있는데  nb[0]에는 up이 들어가게 nb[1]은 down이.. 
	
	//up 이웃
	nb[0]=	id - 4; 
	if( nb[0] < 0) { // 결과가 음수면 이웃이 없는 것, 결과가 없는 의미로 일부러 -1를 넣음
		nb[0] = -1 ;
	}
	
	//down 이웃
	nb[1] = id + 4; 
	    //결과가 16이상이라면 결과가 없다는 의미로 일부러 음수를 넣음
	  if (nb[1] >= 16) {  // 결과가 16이상이면 이웃이 없는것 ,결과가 없는 의미로 일부러 -1를 넣음
		  nb[1] = -1 ; //
	  }
		
	//left 이웃
	nb[2] = id - 1; 
	//Left = id  - 1;  결과가 -1, 3, 7, 11이라면 이웃이 없다는 의미
	if 	( nb[2] < 0  ||  (nb[2]%4 == 3) )
		 nb[1] = -1 ; 
	
	//right 이웃
	nb[3] = id + 1; 
	if ( nb[3] % 4 == 0) 
		nb[3] = -1;  // 결과가 4, 8, 12, 16이면 이웃이 없는것 , 결과가 없는 의미로 일부러 -1를 넣음
	  
} 
	  
   @Override
   public void actionPerformed(ActionEvent e) {
	// e는 버튼을 눌렀을때 어떤 어떤 버튼이 눌렸는지..actionevent를 발생시킨 소스가 누구냐하는 건데.
	 //e는 object type(객체 타입)이다. 16개 버튼 중에 누가 눌렸나하는 것을 알아보는 겁니다.
	 // b는 눌린 버튼이고, 누가 버튼을 눌렀는지는 코드를 작성
	 JButton b = (JButton) e.getSource();	
	 int id; 
	 // b라는 버튼을 누가 눌렀나? id가 누른 거예요. 
	 // id에 0부터 15까지 어떤 값이 들어가는데, 5를 누르면 id에 5가 들어감.
	 for ( id = 0 ; id < 16 ; id++ )
		if ( b == btn[id] )
			break;
	 
	// 5를 눌렀으면 5의 이웃을 찾아야...
    findNB(id); // 함수 호출, id값을 넣으면 id의 이웃값이 nb배열에 들어가게 됨.
  
    //그다음은 이웃중에서 활성화되지 않은 것이 뭐가 있는가? 클릭한 id가 활성화되지 않은 것과 바꾸어야.
     for (int i = 0; i< 4 ; i++) {
    	//이웃의 버튼 4개가 음수라면 이웃이 없는것이므로 생략해야,
    	//즉 이웃의 버튼 4개가 양수이면서 이웃 4개 버튼 중 비활성화된것이 있으면 for를 돌린다.
    	// id 버튼을 옮겨라
    	 if ( nb[i]>=0  && !btn[nb[i]].isEnabled() ) {
    	 
    	   JButton act, inact;
    	   //현재 버튼이 id이고
    	   act = btn[id];
    	   //비활성화된게 nb버튼이니까
    	   inact = btn[nb[i] ];
    	   //라벨을 맞바꾸고
    	   inact.setText(act.getText());
    	   act.setText("");
    	   //활성화된 것을 비활성화 버튼과 맞 바꾸고
            act.setEnabled(false);
            inact.setEnabled(true);
        //4개 이웃중 하나만 비활성화되어 있을테니까 하나라도 활성화된것이 발견되면 for루프를 더 돌필요는 없다. 
        //비활성화된게 발견되면 루프를 빠져나오면 된다.
            break;
    	 } 	 
     }
     	
   }
}












