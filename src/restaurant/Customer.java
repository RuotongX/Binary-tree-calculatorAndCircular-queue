package restaurant;
import java.time.LocalTime;
import java.util.Random;

public class Customer {
	private String name;
	private int servedtime;
	private String starttime;
	private String leavetime;
	private LocalTime localTime;
	private int number;
	
	public Customer(String name) {
		Random ra = new Random();
		this.localTime = LocalTime.now(); 
		this.servedtime = ra.nextInt(5)+4;
		this.name = name;
		this.setStarttime(localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond());
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getServedtime() {
		return servedtime;
	}

	public void setServedtime(int servedtime) {
		this.servedtime = servedtime;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}
	public String join() {
		return("Customer: "+name+" get in at "+starttime+" ");
	}
	public String leave() {
		this.localTime = LocalTime.now(); 
		this.setLeavetime(localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond());
		return this.leavetime;
	}
}
