package br.com.giordano.entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
		this.customsFee += price;
	}

	@Override
	public String priceTag() {
		return getName() + " $ "
				+ String.format("%.2f",totalPrice())
				+ " (Customs fee: $ "
				+ String.format("%.2f", customsFee)+ ")";
	}
	
	
	public Double totalPrice() {
		return getPrice() + customsFee;
	}

	public Double getCustomFee() {
		return customsFee;
	}

	public void setCustomFee(Double customsFee) {
		this.customsFee = customsFee;
	}

}
