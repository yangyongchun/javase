package db2;

public class Customer {
	private int cid;
	private String name;
	private String principalship;
	private String company;
	private String telephone;
	private String address;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrincipalship() {
		return principalship;
	}
	public void setPrincipalship(String principalship) {
		this.principalship = principalship;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "\r Customer [cid=" + cid + ", name=" + name + ", principalship=" + principalship + ", company=" + company
				+ ", telephone=" + telephone + ", address=" + address + "] \r";
	}
	

}
