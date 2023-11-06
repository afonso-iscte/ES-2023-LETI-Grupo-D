package projeto_es;

public class Curso {
	
	private String designacao;
	
	public Curso(String designacao) {
		this.designacao = designacao;
	}
	
	public String getDesignacao() {
		return this.designacao;
	}
	
	@Override
	public String toString() {
		return this.designacao;
	}

}
