package models;

public class Identificador {
public static String user;
private String pass;
public Identificador(String user, String pass) {
	super();
	this.user = user;
	this.pass = pass;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}

}
