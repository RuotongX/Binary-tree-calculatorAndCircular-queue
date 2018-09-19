package restaurant;

public class QueueCArrayBase {
	private int counter = 0;
	private int order = 0;
	private static int number = 0;
	private Customer[] customerqueue;
	
	public QueueCArrayBase(){
		this.customerqueue = new Customer[5];
	}
	
	public Customer[] getCustomerqueue() {
		return customerqueue;
	}

	public void add(Customer customer) {
		while(!hasCustomer(order)) {
			customer.setNumber(number);
			this.customerqueue[order] = customer;
		}
		counter++;
		order++;
		number++;
		if(order==5) {
			order = 0;
		}
	}
	public void remove() {
		int temp = 0;
		int min = 0;
		int i =0;
			while(!hasCustomer(i)) {
				i = i+1;
				min = i;
				if(i == 5) {
					min = 0;
					i=0;
				}
			}
			while(hasCustomer(i)) {
				if(customerqueue[i].getNumber()<customerqueue[min].getNumber()) {
					min = i;
				}
				i = i+1;
				if(i == 5) {
					i=0;
					temp++;
				}
				if(i == min&&temp>5) {
					break;
				}
			}
		customerqueue[min] = null;
		counter--;
	}
	public Customer getfirst() {
		int temp = 0;
		int min = 0;
		int i =0;
			while(!hasCustomer(i)) {
				i = i+1;
				min = i;
				if(i == 5) {
					min = 0;
					i=0;
				}
			}
			while(hasCustomer(i)) {
				if(customerqueue[i].getNumber()<customerqueue[min].getNumber()) {
					min = i;
				}
				i = i+1;
				if(i == 5) {
					i=0;
					temp++;
				}
				if(i == min&&temp>5) {
					break;
				}
			}
		return customerqueue[min];
	}
	public boolean hasCustomer(int i) {
		if(customerqueue[i]!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isFull() {
		if(this.counter==5) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getCounter() {
		return counter;
	}	
}
