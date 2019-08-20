package cn.ysy.ssmeasycrud.domain;

public class Crud {
	
	private Long id;
	private String upperCase;
	private String lowerCase;
	private String number;
	private String other;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUpperCase() {
		return upperCase;
	}
	public void setUpperCase(String upperCase) {
		this.upperCase = upperCase;
	}
	public String getLowerCase() {
		return lowerCase;
	}
	public void setLowerCase(String lowerCase) {
		this.lowerCase = lowerCase;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Crud [id=" + id + ", upperCase=" + upperCase + ", lowerCase=" + lowerCase + ", number=" + number
				+ ", other=" + other + "]";
	}
	public Crud(Long id, String upperCase, String lowerCase, String number, String other) {
		super();
		this.id = id;
		this.upperCase = upperCase;
		this.lowerCase = lowerCase;
		this.number = number;
		this.other = other;
	}
	public Crud() {
		super();
	}

	
}
