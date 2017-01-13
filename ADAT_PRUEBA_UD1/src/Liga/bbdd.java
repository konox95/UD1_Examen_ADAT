package Liga;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class bbdd {
	private Connection conection;
	ArrayList<Jugadores>  nombres;

	

	public bbdd() {
		try {
			HashMap<String, String> hmret = loadFichero("conexionbbdd/conexionbbdd.ini");
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection(hmret.get("url"), hmret.get("login"), hmret.get("pwd"));
			System.out.println("todo ok");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado");
		} catch (SQLException e) {
			System.out.println("Error de Conexión con MySQL");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String> loadFichero(String nomFichero) throws IOException {
		HashMap<String, String> hmDatos = new HashMap<String, String>();
		FileReader fr = new FileReader(nomFichero);
		BufferedReader bf = new BufferedReader(fr);
		String lineaLeida = bf.readLine();
		while (lineaLeida != null) {
			String sar[] = lineaLeida.split("=");
			hmDatos.put(sar[0], sar[1]);
			lineaLeida = bf.readLine();
		}
		bf.close();
		fr.close();
		return hmDatos;
	}
	public ArrayList<Jugadores> Jugadores() {
		nombres = new ArrayList<Jugadores>();
		try {
			String query = "SELECT J.nombre , J.apellido , J.puesto,J.altura, E.nombre FROM jugadores J, equipos E WHERE J.equipo= E.id_equipo;";
			PreparedStatement pstmt = conection.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			String sFichero = "jugadores.txt";
			FileWriter file = new FileWriter(sFichero);
			BufferedWriter bw = new BufferedWriter(file);
			while (rset.next()) {
				String nombre = rset.getString("J.nombre");
				String apellido = rset.getString("J.apellido");
				String puesto = rset.getString("J.puesto");
				int altura = rset.getInt("J.altura");
				String equipo = rset.getString("E.nombre");
				Jugadores jugador = new Jugadores();	
				
				jugador.setNombre(nombre);
				jugador.setApellido(apellido);
				jugador.setPuesto(puesto);
				jugador.setAltura(altura);
				jugador.setEquipo(equipo);
				nombres.add(jugador);
				
				bw.write(jugador.getNombre()+ " " + jugador.getApellido() +" " + jugador.getPuesto() +" " + jugador.getAltura() +" " + jugador.getEquipo());
				bw.newLine();
				
			}
			bw.close();
			pstmt.close();
			rset.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombres;
	}
	
	
	
	
}
