import java.util.ArrayList;
import java.util.Scanner;

public class DeckCards {
	static String x,y,z,j,b;
static int p1=0,p2=0,p3=0,p4=0,bank=0;
	
public static void main(String [] args) {
	String [] suits = {"Diamond", "Heart","Spade", "Clubs"};
	int [] pointValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	ArrayList<Cards> cardDeck = new ArrayList<Cards>();
	ArrayList<Cards> garbageCards = new ArrayList<Cards>();
	for(int s = 0;s<4; s++) {
		for(int p = 0; p<13; p++) {
			Cards c = new Cards(suits[s], pointValues[p]);
			cardDeck.add(c);
		}
	}
if(cardDeck.size()<10) {
for(int i =0; i<garbageCards.size(); i++) {
	cardDeck.add(garbageCards.get(0));
	garbageCards.remove(0);
}
DeckCards.selectionShuffle(cardDeck);

}
DeckCards.playBank(p1, p2, p3, p4, bank, cardDeck, garbageCards);
}

public static boolean isEmpty(ArrayList<Cards> a) {
	int x = a.size();
	if(x==0) {
		return true;
	}
	else {
		return false;
	}
}
public static int deckSize(ArrayList<Cards> a) {
	return a.size();
}

public static Cards deal(ArrayList<Cards> a) {
	Cards x = a.get(0);
	if(a.size()!=0) {
		a.remove(0);
		return x;
	}
	else {
		return null;
	}	
}

public static void deal(ArrayList<Cards> a, int n) {
	for(int i =0; i<n; i++) {
		Cards x = a.get(0);
		if(a.size()!=0) {
			a.remove(0);
			System.out.print(x + ", ");
		}
}
}
public static void perfectShuffle(ArrayList<Cards> a) {
    Cards[] deck = new Cards[52];
    Cards[] shuffled = new Cards[52];

    for (int i = 0; i < a.size(); i++) {
        deck[i] = a.get(i);
    }

    for (int j = 0, k = 0; j < 26; j++, k += 2) {
        shuffled[k] = deck[j];
    }

    for (int j = 26, k = 1; j < 52; j++, k += 2) {
        shuffled[k] = deck[j];
    }

    for (int i = 0; i < 52; i++) {
        a.set(i, shuffled[i]); 
    }
}
public static void selectionShuffle(ArrayList<Cards> a) {
	Cards[] deck = new Cards[52];
    
    for (int i = 0; i < a.size(); i++) {
        deck[i] = a.get(i);
    }
    int x =0;
    Cards temp;
    for(int k =51; k>=0; k--) {
    	x=(int)(Math.random()*52);
    	temp= deck[k];
    	deck[k]=deck[x];
    	deck[x]= temp;
    }
    
    for(int i =0; i< 52; i++) {
    	a.set(i, deck[i]);
    }

}
public static void play(int p1, int p2, ArrayList<Cards> a) {
	selectionShuffle(a);
	System.out.print("player one first card suit: "+ a.get(0).getSuit() + " player one first card points: "+a.get(0).getPoint()+"\n");
    p1 = deal(a).getPoint();
    System.out.print(" player one second card suit: "+ a.get(0).getSuit()+ " player one second card points: "+a.get(0).getPoint()+"\n");
    p1+= deal(a).getPoint(); 
    p1 = p1 % 10;
    
    
    System.out.print("player two first card suit: "+ a.get(0).getSuit() + " player one first card points: "+a.get(0).getPoint()+"\n");
    p2 = deal(a).getPoint();
    System.out.print(" player two second card suit: "+ a.get(0).getSuit()+ " player one second card points: "+a.get(0).getPoint()+"\n");
    p2+= deal(a).getPoint(); 
    p2 = p2 % 10;

    if (p1 == 9) {
        System.out.println("player one wins");
        System.out.println("player one: " +p1 + " Player two: " + p2);
    } else if (p2 == 9) {
        System.out.println("player two wins");
        System.out.println("player one: " +p1 + " Player two: " + p2);
    } else if (p1 == 9 && p2 == 9) {
        System.out.println("draw");
        System.out.println("player one: " +p1 + " Player two: " + p2);
    } else {
        System.out.println("player one: " +p1 + " Player two: " + p2);


        if (p1>7) {
            p1 = p1 % 10;
        } else if (p1<=7) {
        	System.out.print("player one third card suit: "+ a.get(0).getSuit() + " player one third card points: "+a.get(0).getPoint()+"\n");
            p1 += deal(a).getPoint();
            p1 = p1 % 10;
        }

        if (p2>5) {
            p2 = p2 % 10;
        } else if (p2<=5) {
        	System.out.print("player two third card suit: "+ a.get(0).getSuit() + " player two third card points: "+a.get(0).getPoint()+"\n");
            p2 += deal(a).getPoint();
            p2 = p2 % 10;
        }

        if (p1 > p2) {
            System.out.println("player one is the winner");
            System.out.println("player one: " +p1 + " Player two: " + p2);
        } else if (p2 > p1) {
            System.out.println("player two is the winner");
            System.out.println("player one: " +p1 + " Player two: " + p2);
        } else {
            System.out.println("draw");
            System.out.println("player one: " +p1 + " Player two: " + p2);
        }
    }
}
public static void playBank(int p1, int p2, int p3, int p4, int bank, ArrayList<Cards> a, ArrayList<Cards> b) {
	
	int cp1=0, cp2=0, cp3=0, cp4=0,countBank=0;
	
	selectionShuffle(a);
	
	while(cp1<5&&cp2<5&&cp3<5&&cp4<5&&countBank<10) {
		if(a.size()<30) {
			while(b.size() > 0 && a.size() < 52) {
			    a.add(b.get(0));
			    b.remove(0);
			   
			}
			}
	System.out.print("player one first card suit: "+ a.get(0).getSuit() + " player one first card points: "+a.get(0).getPoint()+"\n");
	b.add(a.get(0));
    p1 = deal(a).getPoint();
    System.out.print("player one second card suit: "+ a.get(0).getSuit() + " player one second card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p1 += deal(a).getPoint();
    p1 = p1 % 10;
    
    System.out.print("player two first card suit: "+ a.get(0).getSuit() + " player two first card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p2 = deal(a).getPoint();
    System.out.print("player two second card suit: "+ a.get(0).getSuit() + " player two second card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p2 += deal(a).getPoint();
    p2 = p2 % 10;
    
    System.out.print("player three first card suit: "+ a.get(0).getSuit() + " player three first card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p3 = deal(a).getPoint();
    System.out.print("player three second card suit: "+ a.get(0).getSuit() + " player three second card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p3 += deal(a).getPoint();
    p3 = p3 % 10;
    
    System.out.print("player four first card suit: "+ a.get(0).getSuit() + " player four first card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p4 = deal(a).getPoint();
    System.out.print("player four second card suit: "+ a.get(0).getSuit() + " player four second card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    p4 += deal(a).getPoint();
    p4 = p4 % 10;
    
    System.out.print("player bank first card suit: "+ a.get(0).getSuit() + " player bank first card points: "+a.get(0).getPoint()+"\n");
    b.add(a.get(0));
    bank = deal(a).getPoint();
    System.out.print("player bank second card suit: "+ a.get(0).getSuit() + " player bank second card points: "+a.get(0).getPoint()+"\n");
    
    bank += deal(a).getPoint();
    bank = bank % 10;
    
    if(bank ==9) {
    	System.out.println("bank wins");
    	System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
    	countBank+=4;
    }
    else if(p1==9) {
    	System.out.println("player 1 wins");
    	System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
     	cp1++;
    }
    else if(p2==9) {
    	System.out.println("player 2 wins");
    	System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
     	cp2++;
    }
    else if(p3==9) {
    	System.out.println("player 3 wins");
    	System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
     	cp3++;
    }
    else if(p4==9) {
    	System.out.println("player 4 wins");
    	System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
     	cp4++;
    }
    else {
    	System.out.println(bank + " " + p1+ " " + p2+ " " + p3+ " " + p4);
    	
        if (p1>7) {
            p1 = p1 % 10;
        } else if (p1<=7) {
        	System.out.print("player one third card suit: "+ a.get(0).getSuit() + " player one third card points: "+a.get(0).getPoint()+"\n");
            p1 += deal(a).getPoint();
            p1 = p1 % 10;
        }
        if (p2>6) {
            p2 = p2 % 10;
        } else if (p2<=6) {
        	System.out.print("player two third card suit: "+ a.get(0).getSuit() + " player two third card points: "+a.get(0).getPoint()+"\n");
            p2 += deal(a).getPoint();
            p2 = p2 % 10;
        }
        if (p3>5) {
            p3 = p3 % 10;
        } else if (p3<=5) {
        	System.out.print("player three third card suit: "+ a.get(0).getSuit() + " player three third card points: "+a.get(0).getPoint()+"\n");
            p3 += deal(a).getPoint();
            p3 = p3 % 10;
        }
        if (p4>4) {
            p4 = p4 % 10;
        } else if (p4<=4) {
        	System.out.print("player four third card suit: "+ a.get(0).getSuit() + " player four third card points: "+a.get(0).getPoint()+"\n");
            p4 += deal(a).getPoint();
            p4 = p4 % 10;
        }
        if (bank>8) {
            bank =  bank % 10;
        } else if (bank<=8) {
        	System.out.print("player bank third card suit: "+ a.get(0).getSuit() + " player bank third card points: "+a.get(0).getPoint()+"\n");
        	 bank += deal(a).getPoint();
        	 bank =  bank % 10;
        }
        
        if (bank > p1) {
            System.out.println("player bank wins against player 1");
         	System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	countBank++;
         	
        } if (bank > p2) {
            System.out.println("player bank wins 2");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	countBank++;
        } if(bank>p3) {
            System.out.println("player bank wins gainst player 3");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	countBank++;
        } if (bank > p4) {
            System.out.println("player bank wins gainst player 4");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	countBank++;
            
            
        }  if(bank<p1) {
            System.out.println("player one wins");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	cp1++;
        } if (bank < p2) {
            System.out.println("player two wins");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	cp2++;
        } if(bank<p3) {
            System.out.println("player three wins");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	cp3++;
        } if (bank < p4) {
            System.out.println("player four wins");
            System.out.println("bank points: " + bank + " p1 points: " + p1+ " p2 points: " + p2+ " p3 points: " + p3+ " p4 points: " + p4);
         	cp4++;
        } 
        
    }
    System.out.println("p1 count "+ cp1+ " p2 count "+ cp2+ " p3 count "+ cp3+ " p4 count "+ cp4+ " bank count "+ countBank);
    
}
	if(countBank>=10){
		System.out.println("p1 count "+ cp1+ " p2 count "+ cp2+ " p3 count "+ cp3+ " p4 count "+ cp4+ " bank count "+ countBank);
    	System.out.println("bank has already won");
    }
	else {
		System.out.println("p1 count "+ cp1+ " p2 count "+ cp2+ " p3 count "+ cp3+ " p4 count "+ cp4+ " bank count "+ countBank);
		System.out.println("the players have already won");
	}
}

}