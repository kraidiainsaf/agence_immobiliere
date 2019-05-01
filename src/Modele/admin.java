package Modele;

public class admin extends personne{
	private String  grade;

	public admin(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,
			String email, String num_telephone) {
		super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
	}
	
	public admin(int id_personne, String cart_identite, String pseudo, String password, String nom, String prenom,
			String email, String num_telephone, String grade) {
		super(id_personne, cart_identite, pseudo, password, nom, prenom, email, num_telephone);
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public admin(){}
	public admin(String grade){
		super();
		this.grade=grade;
	}

}
