package modeles;

import java.util.Collection;

public class Users {
	private int id;
	private String username;
	private String password;
	private String email;
	private String fname;
	private String mname;
	private String lname;
	private int depot;
	private int retrait;
	private int comptes;
	private Collection<Operation> operations;
	
	
	
	
	//Contructor
	public Users(int id, String username, String password, String email, String fname, String mname, String lname,
			int depot, int retrait, int comptes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.depot = depot;
		this.retrait = retrait;
		this.comptes = comptes;
	}
	
	
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}





	//getter
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getFname() {
		return fname;
	}
	public String getMname() {
		return mname;
	}
	public String getLname() {
		return lname;
	}
	public int getDepot() {
		return depot;
	}
	public int getRetrait() {
		return retrait;
	}
	public int getComptes() {
		return comptes;
	}
	
	//setter
	public void setDepot(int depot) {
		this.depot = depot;
	}
	public void setRetrait(int retrait) {
		this.retrait = retrait;
	}
	public void setComptes(int comptes) {
		this.comptes = comptes;
	}




	public void setId(int id) {
		this.id = id;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public void setFname(String fname) {
		this.fname = fname;
	}




	public void setMname(String mname) {
		this.mname = mname;
	}




	public void setLname(String lname) {
		this.lname = lname;
	}





	public Collection<Operation> getOperations() {
		return operations;
	}
	
	
	
	
	

	
}

