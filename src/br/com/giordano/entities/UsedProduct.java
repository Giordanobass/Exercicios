package br.com.giordano.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date manufactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		return getName() 
				+ " (used) $ "
				+ String.format("%.2f", getPrice())
				+" (Manufacture date: "
				+ sdf.format(manufactureDate)
				+ ")";

	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

}
