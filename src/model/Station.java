package model;

public class Station {
	private int id;
	private int sendQuantity;
	private int arriveQuantity;
	
	public Station(int pId) {
		this.id = pId;
		this.sendQuantity = 0;
		this.arriveQuantity = 0;
	}
	
	public void acutalizeSendQuantity(int pQuantity) {
		this.sendQuantity += pQuantity;
	}
	
	public void acutalizeArriveQuantity(int pQuantity) {
		this.arriveQuantity += pQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSendQuantity() {
		return sendQuantity;
	}

	public void setSendQuantity(int sendQuantity) {
		this.sendQuantity = sendQuantity;
	}

	public int getArriveQuantity() {
		return arriveQuantity;
	}

	public void setArriveQuantity(int arriveQuantity) {
		this.arriveQuantity = arriveQuantity;
	}
	
	
}
