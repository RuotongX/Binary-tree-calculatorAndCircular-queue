package restaurant;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		String input;
		Scanner sc = new Scanner(System.in);
		QueueCArrayBase queue = new QueueCArrayBase();
		while(!queue.isFull()) {
			System.out.println("Please type the customer name:");
			input = sc.nextLine();
			Customer customer = new Customer(input);
			queue.add(customer);
		}
//		for(int i = 0;i<5;i++) {
//			if(!queue.hasCustomer(i)) {
//				
//			}else {
//				System.out.println(queue.getCustomerqueue()[i].join());
//			}
//		}
//		
	}
}
