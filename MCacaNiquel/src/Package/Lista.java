package Package;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")
public class Lista extends HttpServlet {

    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws  ServletException, IOException {

		DAO dao = new DAO();

		List<Jogador> jogadores = dao.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>ID</td><td>Nome</td>" + 
                    "<td>Horario</td><td>Resultado</td></tr>");
		for (Jogadores jogador : jogadores) {
	         out.println("<tr><td>" + jogador.getId() + "</td>");
	         out.println("<td>" + jogador.getNome() + "</td>");
	         out.println("<td>" + jogador.getHorario().getTime() + "</td>");
	         out.println("<td>" + jogador.getResultado() + "</td></tr>");	         
		}
		out.println("</table></body></html>");
        
		dao.close();
        
    } 
}
