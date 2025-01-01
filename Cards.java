
public class Cards {
	private String suit;
	private int pointValue;
	public Cards(String s, int p) {
		suit = s;
		pointValue =p;
	}
	
	public void setPoint(int p) {
		pointValue= p;
	}
	public int getPoint() {
		return pointValue;
	}
	public void setSuit(String s) {
		suit = s;
	}
	public String getSuit() {
		return suit;
	}
	public String toString() {
		return "(suit: " + getSuit()+ ", Point value: "+ getPoint()+")";
	}
	
	public boolean matchesSuit(Cards other) {
		if(this.getSuit().equals(other.getSuit())) {
			return true;
		}
		else
			return false;
	}
	public boolean mathcesPointValue(Cards other) {
		if(this.getPoint()==other.getPoint()) {
			return true;
		}
		else {
		return false;}
	}
}
