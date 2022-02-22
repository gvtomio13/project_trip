package trip;

import java.io.*;
import java.sql.*;

/**
 *
 * @author tomio
 */
public class Result{
 
    public static void main(String[] args) throws ClassNotFoundException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/mobi7_code_interview";
        String username = "postgres";
        String password = "postgres";
        String csvfile = "result_trip.csv";
        
        Class.forName("org.postgresql.Driver");     
         
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT placa, qtade_viagem, km_percorrido, tempo_movimento, tempo_parado, data_processamento, mes_viagem FROM trip_import";
             
            BufferedWriter file;
            try (Statement statement = connection.createStatement()) {
                ResultSet result = statement.executeQuery(sql);
                file = new BufferedWriter(new FileWriter(csvfile));
                
                file.write("placa, qtade_viagem, km_percorrido, tempo_movimento, tempo_parado, data_processamento, mes_viagem");
                while (result.next()) {
                    String placa = result.getString("placa");
                    String qtade_viagem = result.getString("qtade_viagem");
                    String km_percorrido = result.getString("km_percorrido");
                    String tempo_movimento = result.getString("tempo_movimento");
                    String tempo_parado = result.getString("tempo_parado");
                    String data_processamento = result.getString("data_processamento");
                    String mes_viagem = result.getString("mes_viagem");
                    
                    if (mes_viagem == null) {
                        mes_viagem = "";  
                    } else {
                        mes_viagem = "\"" + mes_viagem + "\""; 
                    }
                    
                    String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                            placa, qtade_viagem, km_percorrido, tempo_movimento, tempo_parado, data_processamento, mes_viagem);
                    
                    file.newLine();
                    file.write(line);
                }
            }
            file.close();
            System.out.println("Arquivo result_trip.csv gerado com sucesso"); 
            
        } catch (SQLException e) {
            System.out.println("Erro de conexão com o banco de dados");
        } catch (IOException e) {
            System.out.println("Erro de entrada ou saída");
        }
         
    }
 
}
