package toyproject;

public class Member {

	private String member_ID;;
	private String name;
	private String phone_number;

	public Member() {

	}

	public Member(String member_ID, String name, String phone_number) {
		this.member_ID = member_ID;
		this.name = name;
		this.phone_number = phone_number;
	}

	public String getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "---> Member_ID = "+getMember_ID()+", Name = "+getName()+", PhoneNumber = "+getPhone_number() ;
	}

}
