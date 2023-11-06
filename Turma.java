package projeto_es;

public class Turma {

	private String name;
	
	public Turma(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
