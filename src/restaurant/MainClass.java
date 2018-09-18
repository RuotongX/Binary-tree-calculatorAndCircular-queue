package restaurant;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;

public class MainClass {
	public static void main(String[] args) {
//		QueueCArrayBase terminal = new QueueCArrayBase();
//		String input;
//		Scanner sc = new Scanner(System.in);
//		boolean open = true;
//		while(!terminal.isFull()) {
//			System.out.println("input");
//			input =sc.nextLine();
//			Customer c = new Customer(input);
//			terminal.add(c);
//		}
//		terminal.remove();
//		terminal.remove();
//		Customer b = new Customer("6jjin");
//		terminal.add(b);
//		for(int i =0;i<terminal.getCustomerqueue().length;i++) {
//			if(!terminal.hasCustomer(i)) {
//				
//			}else {
//			System.out.println(terminal.getCustomerqueue()[i].join());
//			}
//		}
//	}
		String input;
		Scanner sc = new Scanner(System.in);
		boolean open = true;
		QueueCArrayBase Terminal1 = new QueueCArrayBase();
		QueueCArrayBase Terminal2 = new QueueCArrayBase();
		QueueCArrayBase Terminal3 = new QueueCArrayBase();
		Random ra = new Random();
		while (open) {
			int terminal;
			System.out.println("Please type the customer name:");
			input = sc.nextLine();
			if (input.equals("stop")) {
				open = false;
				break;
			}
			Customer customer = new Customer(input);
			boolean other = true;
			while(other == true) {
				terminal = ra.nextInt(3) + 1;
				switch (terminal) {
				case 1:
					if (Terminal1.isFull()) {
						other = true;
					} else {
						Terminal1.add(customer);
						System.out.println("Terminal 1: " + customer.join());
						leavecheck(Terminal1, 1);
						leavecheck(Terminal2, 2);
						leavecheck(Terminal3, 3);
						other = false;
						break;
					}
				case 2:
					if (Terminal2.isFull()) {
						other = true;
					} else {
						Terminal2.add(customer);
						System.out.println("Terminal 2: " + customer.join());
						leavecheck(Terminal1, 1);
						leavecheck(Terminal2, 2);
						leavecheck(Terminal3, 3);
						other = false;
						break;
					}
				case 3:
					if (Terminal3.isFull()) {
						other = true;
					} else {
						Terminal3.add(customer);
						System.out.println("Terminal 3: " + customer.join());
						leavecheck(Terminal1, 1);
						leavecheck(Terminal2, 2);
						leavecheck(Terminal3, 3);
						other = false;
						break;
					}
				}
				if (Terminal1.isFull() && Terminal2.isFull() && Terminal3.isFull()) {
					open = false;
					System.out.println("Now this restauant is full, so the system closed.");
				}
			} 
		}
			System.out.println("All people in this restruant");
			System.out.println("Terminal 1");
			for(int i =0;i<5;i++) {
				if(!Terminal1.hasCustomer(i)) {
					
				}else {
				System.out.println(Terminal1.getCustomerqueue()[i].join());
				}
			}
			System.out.println("Terminal 2");
			for(int i =0;i<5;i++) {
				if(!Terminal2.hasCustomer(i)) {
					
				}else {
				System.out.println(Terminal2.getCustomerqueue()[i].join());
				}		
			}
			System.out.println("Terminal 3");
			for(int i =0;i<5;i++) {
				if(!Terminal3.hasCustomer(i)) {
					
				}else {
				System.out.println(Terminal3.getCustomerqueue()[i].join());
				}
		}
	}

	public static void leavecheck(QueueCArrayBase terminal, int number) {
		LocalTime localtime = LocalTime.now();
		if (terminal.getCounter() == 0) {
			return;
		}
		int time = localtime.getMinute() * 60 + localtime.getSecond() - terminal.getfirst().getStartT();
		if (time > terminal.getfirst().getServedtime()) {
			System.out.println("Terminal " + number+": " + terminal.getfirst().leave());
			terminal.remove();
		}
	}
}
