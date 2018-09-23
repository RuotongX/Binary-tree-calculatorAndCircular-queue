package restaurant;
/**
 * This is a class which generate the circular array queue
 * @author RuotongXu
 *
 */
public class QueueCArrayBase {
	private int counter = 0;
	private int order = 0;
	private static int number = 0;
	private Customer[] customerqueue;
	
	public QueueCArrayBase(){//This is the constructor of this class which create a circular queue
		this.customerqueue = new Customer[5];
	}
	
	public Customer[] getCustomerqueue() {
		return customerqueue;
	}

	public void add(Customer customer) {//The add method is use the 3 variable, order is the order in the queue, while the queue is full the order become 0, 
		                                //the counter is how many objece in this queue, the number is show the object join early or later. 
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
	public void remove() {//The remove method is use the while loop to check the is the position in array is empty or not,
		                  //it will find the smallest number in this array(due to the queue is first in first out, so it find the smallest number which is the most early object join this array. While object is removed, counter minus 1.
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
	public Customer getfirst() {// The get first method is use the same way as the remove method. To find the most early object join this array.
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
	public boolean hasCustomer(int i) {//The method is check a position in array is empty or not 
		if(customerqueue[i]!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isFull() {//The method is to check the array is full or not.
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
