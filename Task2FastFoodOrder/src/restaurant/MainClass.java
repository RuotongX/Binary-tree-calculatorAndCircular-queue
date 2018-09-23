package restaurant;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;
/**
 * This is the main class, which takes the input and create three terminal, devide the new customer into different terminals and also check are there any leavers.
 * @author RuotongXu
 *
 */
public class MainClass {
	public static void main(String[] args) {
		String input;
		Scanner sc = new Scanner(System.in);
		boolean open = true;
		QueueCArrayBase Terminal1 = new QueueCArrayBase();
		QueueCArrayBase Terminal2 = new QueueCArrayBase();
		QueueCArrayBase Terminal3 = new QueueCArrayBase();
		Random ra = new Random();
		while (open) {
			int terminal;
			System.out.println("Welcome to our restruant, our resturuant has 3 terminal, if you want to run the system type customer name, if you want to stop just type'stop'");
			System.out.println("After you stop the system or the resturant is full, all customer name and which terminal they were in will be display");
			System.out.println("Please type the customer name:");
			input = sc.nextLine();
			if (input.equals("stop")) {
				open = false;
				break;
			}
			Customer customer = new Customer(input);
			boolean other = true;
			while(other == true) {
				terminal = ra.nextInt(3) + 1;//Used a random number to devide people into different terminal, once one terminal is full the random number will generate again until to get a not full terminal number
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

	public static void leavecheck(QueueCArrayBase terminal, int number) {//Check the time with the customer served time with the real time, once the time is arrived or over the customer will leave.
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
