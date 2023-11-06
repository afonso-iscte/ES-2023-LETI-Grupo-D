package projeto_es;

public class Date {

	public String date;
	
	public Date(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return this.date;
	}
	
	@Override
	public String toString() {
		return this.date;
	}
	
}
