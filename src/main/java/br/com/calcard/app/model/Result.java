package br.com.calcard.app.model;

public class Result {

	private String description;
	private String creditLimit;

	public Result(String description, String creditLimit) {
		this.description = description;
		this.creditLimit = creditLimit;
	}

	public static Result approve(String creditLimit) {
		return new Result("Aprovado", creditLimit);
	}
	
	public static Result decline(String creditLimit) {
		return new Result("Negado", creditLimit);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

}
