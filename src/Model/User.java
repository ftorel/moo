package Model;
import java.io.Serializable;


public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String type;
	private String nom;
	private String prenom;
	private String mail;
	
	public User(String nom, String prenom, String type, String mail)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
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

	public String getMail() {
		return mail;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
