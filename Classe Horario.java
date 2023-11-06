package projeto_es;

public class Horario {

	private Curso curso;
	private Unidade_Curricular uc;
	private Turno turno;
	private Turma turma;
	private int turno_size;
	private Day day;
	private Time time;
	private Date date;
	private String caracteristica;
	private Sala sala;

	
	public Horario(Curso curso, Unidade_Curricular uc, Turno turno, 
			Turma turma, int turno_size, Day day, Time time, Date date, 
			String caracteristica, Sala sala) {
		this.curso = curso;
		this.uc = uc;
		this.turno = turno;
		this.turma = turma;
		this.turno_size = turno_size;
		this.date = date;
		this.time = time;
		this.day = day;
		this.sala = sala;
		this.caracteristica = caracteristica;
	}
	
	public Curso getCurso() {
		return this.curso;
	}
	
	public Unidade_Curricular getUC() {
		return this.uc;
	}
	
	public Turno getTurno() {
		return this.turno;
	}
	
	public Turma getTurma() {
		return this.turma;
	}
	
	public int getSizeTurno() {
		return this.turno_size;
	}
	
	public Day getDay() {
		return this.day;
	}
	
	public Time getTime() {
		return this.time;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getSalaCaracteristica() {
		return this.caracteristica;
	}
	
	public Sala getSala() {
		return this.sala;
	}
	
	@Override
	public String toString() {
		return this.curso + "," + this.uc + "," + this.turno + "," 
				+ this.turma + "," + this.turno_size + "," + this.day + "," 
				+ this.time + "," + this.date + "," + this.caracteristica 
				+ "," + this.sala;
	}
	
}
