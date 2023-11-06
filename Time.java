package projeto_es;

public class Time {

	private String horaInicio;
	private String horaFim;
	
	public Time(String horaInicio, String horaFim) {
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	
	public String getHoraInicio() {
		return this.horaInicio;
	}
	
	public String getHoraFim() {
		return this.horaFim;
	}
	
	@Override
	public String toString() {
		return this.horaInicio + "," + this.horaFim;
	}
	
}
