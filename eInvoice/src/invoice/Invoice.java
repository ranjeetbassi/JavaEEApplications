package invoice;

public class Invoice {

	private String client;
	private String address;
	private String dateofShipment;
	private String paymentdue;
	private String product;
	private int quantity;
	private double price;
	private double subtotal;
	private double GST;
	private double total;

	public Invoice(String clientname, String clientaddress,
			String clientdateofshipment, String clientpayment,
			String clientproduct, String clientquantity, String clientprice,
			double clientsubtotal, double clientGST, double clienttotal) {
		client = clientname;
		address = clientaddress;
		dateofShipment = clientdateofshipment;
		paymentdue = clientpayment;
		product = clientproduct;
		quantity = Integer.parseInt(clientquantity);
		price = Double.parseDouble(clientprice);
		subtotal = clientsubtotal;
		GST = clientGST;
		total = clienttotal;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateofShipment() {
		return dateofShipment;
	}

	public void setDateofShipment(String dateofShipment) {
		this.dateofShipment = dateofShipment;
	}

	public String getPaymentdue() {
		return paymentdue;
	}

	public void setPaymentdue(String paymentdue) {
		this.paymentdue = paymentdue;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getGST() {
		return GST;
	}

	public void setGST(double gST) {
		GST = gST;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
