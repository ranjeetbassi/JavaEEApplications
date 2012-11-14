package Exercises;

public class SupplierInfo {

	private String fullName;
	private String phoneNumber;

	public SupplierInfo(String FullName, String PhoneNumber) {
		fullName = FullName;
		phoneNumber = PhoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
