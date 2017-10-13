package model;

public class Personne {
	
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private Role role;
	
	public Personne(String nom, String prenom, String login, String password, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
