package entities;

public class Phone {
	private int id;
	private String phone;
	private int person_id;

	public Phone() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone=phone;
	}

	public int getPerson_id(){
		return person_id;
	}

	public void setPerson_id(int person_id){
		this.person_id=person_id;
	}
}