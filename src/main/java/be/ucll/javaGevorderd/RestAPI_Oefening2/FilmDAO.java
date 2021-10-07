package be.ucll.javaGevorderd.RestAPI_Oefening2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmDAO {

    private DataSource dataSource;
    private final Connection connection;

    //SQL PREPARED STATEMENTS
    public static final String INSERT_SQL = "INSERT INTO oefening2.film (titel, jaar, persoonlijkeScore, verantwoording) VALUES (?,?,?,?);";
    public static final String SELECT_ALL_SQL = "SELECT * FROM oefening2.film;";

    @Autowired
    public FilmDAO(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        connection = dataSource.getConnection();

        //creation of in memory db
        Statement createSchema = connection.createStatement();
        createSchema.executeUpdate("CREATE SCHEMA oefening2");

        Statement initTable = connection.createStatement();
        initTable.executeUpdate("CREATE TABLE oefening2.film(" +
                "titel varchar(255) not null," +
                "jaar year," +
                "persoonlijkeScore int(10)," +
                "verantwoording varchar(400)" +
                ");"
        );

        //Dumi film

        Film film = new Film( "Bootleg", 1999,2, "Ronduit slecht");
        insertFilm(film);
    }

    public void insertFilm(Film film){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, film.getTitel());
            preparedStatement.setInt(2, film.getJaar());
            preparedStatement.setInt(3, film.getPersoonlijkeScore());
            preparedStatement.setString(4, film.getVerandtwoording());
            preparedStatement.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

    public Film getFilm(String titel){
        return null;
    }

    public Film getFilm(int id) {
        return null;
    }

    public List<Film> getAlleFilms() throws SQLException {
        List<Film> films = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
        ResultSet resultaat = preparedStatement.executeQuery();
        while(resultaat.next()){
            films.add(new Film(
                    resultaat.getString("titel"),
                    resultaat.getInt("jaar"),
                    resultaat.getInt("persoonlijkeScore"),
                    resultaat.getString("verantwoording")
                    )
            );
        }
        return films;
    }

    public void changeFilm(int id) {
    }

    public void deleteFilm(int id) {
    }


}
