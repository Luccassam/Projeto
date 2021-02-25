package classe;

public class Aluno extends Usuario {
    
    
    private int idA;
private String ra;


public Aluno(int id, String nome, String email, String senha,int idA,String ra) {
    super(id, nome, email, senha);

    this.idA = idA;
    this.ra = ra;
}


public int getIdA() {
	return idA;
}


public void setIdA(int idA) {
	this.idA = idA;
}


public String getRa() {
	return ra;
}


public void setRa(String ra) {
	this.ra = ra;
}



}