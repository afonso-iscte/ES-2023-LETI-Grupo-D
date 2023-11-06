package projeto_es;

public class Turno {

	private String name;
	
	public Turno(String name) {
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
