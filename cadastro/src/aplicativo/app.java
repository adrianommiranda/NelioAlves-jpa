package aplicativo;
import dominio.Pessoa;

public class app {

	public static void main(String[] args) {
		Pessoa p = new Pessoa(01, "Adriano","adrianogmail");
		Pessoa p1 = new Pessoa(02, "Joyce","joycegmail");
		
		System.out.println(p.toString());
	}

}
