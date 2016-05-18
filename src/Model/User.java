package Model;
import java.io.Serializable;


public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String nom;
	private String nomFamille;
	private String prenom;
	private String employeeType; 
	private String employeeNumber;
	private String login;
	private String password;
	private String mail;
	
	public User(String login, String password, String nom, String nomFamille, String prenom, String type, String numero, String mail)
	{
		this.nom = nom;
		this.nomFamille = nomFamille;
		this.prenom = prenom;
		this.employeeType = type;
		this.employeeNumber = numero;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}
	
	public User() {
		super();
	}

	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getLogin()
	{
		return login;
	}
	public String getType()
	{
		return employeeType;
	}
	public String getNumber()
	{
		return employeeNumber;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}
	
	public String toString()
	{
		return "login = " + login + " nom = " + nom + " type = " + employeeType + " id = " + employeeNumber;
 	}

	public String getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
