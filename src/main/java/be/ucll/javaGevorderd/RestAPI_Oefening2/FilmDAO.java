package be.ucll.javaGevorderd.RestAPI_Oefening2;

import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import javax.sql.DataSource;

@Component
public class FilmDAO {
    private final DataSource dataSource;

    public FilmDAO(DataSource dataSource) {
        this.dataSource = dataSource;


    }


    public void insertFilm(Film film){

    }

    public Film getFilm(String titel){

    }
}
