package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DAO {
	private Connection connection = null;
	public DAO() throws Exception {
	    Class.forName("com.mysql.jdbc.Driver");
	    connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "123456");
	}
	
	public void adiciona(Jogador jogador) {
		String sql = "INSERT INTO Jogadores" +
		"(nome, horario, resultado) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,jogador.getNome());
		stmt.setDate(2, new Date(
				jogador.getHorario().getTimeInMillis()));
		stmt.setString(3,jogador.getResultado());
		stmt.execute();
		stmt.close();
	}
	
	public List<Jogador> getLista() {

		List<Jogador> jogadores = new ArrayList<Jogador>();

		PreparedStatement stmt = connection.
		    prepareStatement("SELECT * FROM Jogador");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Jogador jogador = new Jogador();
			jogador.setId(rs.getInt("id"));
			jogador.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("horario"));
			jogador.setHorario(data);
			jogador.setResultado(rs.getString("resultado"));		
			jogadores.add(jogador);
		}
		rs.close();
		stmt.close();

		return jogadores;
	}
	
	public void altera(Jogador jogador) {
		String sql = "UPDATE Jogador SET " +
	          "nome=?, horario=?, resultado=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, jogador.getNome());
		stmt.setDate(2, new Date(jogador.getHorario()
				.getTimeInMillis()));
		stmt.setString(3, jogador.getResultado());
		stmt.setInt(4, jogador.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Integer id) {
		PreparedStatement stmt = connection
		   .prepareStatement("DELETE FROM Jogador WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void close() {
		connection.close();
	}
}

