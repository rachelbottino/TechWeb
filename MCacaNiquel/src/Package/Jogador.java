package Package;

import java.util.Calendar;

public class Jogador {
	private String nome;
	private Calendar horario;
	private String resultado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Calendar getHorario() {
		return horario;
	}
	public void setHorario(Calendar horario) {
		this.horario = horario;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;	
	}
}
