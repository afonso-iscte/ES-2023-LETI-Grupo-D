package projeto_es;

public class Unidade_Curricular {

	private String name;
	
	public Unidade_Curricular(String name) {
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
