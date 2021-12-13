package cafe.pja.signcafe.service.command;

public class OrderedCommand {
	private String name1;
	private String temp1;
	private String size1;
	private String price1;
	
	
	public OrderedCommand(String name, String temp, String size, String price) {
		super();
		this.name1 = name;
		this.temp1 = temp;
		this.size1 = size;
		this.price1 = price;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name) {
		this.name1 = name;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp) {
		this.temp1 = temp;
	}
	public String getSize1() {
		return size1;
	}
	public void setSize1(String size) {
		this.size1 = size;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price) {
		this.price1 = price;
	}
	@Override
	public String toString() {
		return "OrderedCommand [name=" + name1 + ", temp=" + temp1 + ", size=" + size1 + ", price=" + price1 + "]";
	}
	
	
}
