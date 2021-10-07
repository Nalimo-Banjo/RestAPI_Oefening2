package be.ucll.javaGevorderd.RestAPI_Oefening2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.time.Year;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    private FilmDAO dao;

    @Autowired
    public FilmController(FilmDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/allefilms")
    public List<Film> getFilms() throws SQLException {
        return dao.getAlleFilms();
    }

    @GetMapping
    public Film getFilm(@RequestParam("titel")String titel){
        return dao.getFilm(titel);

    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable("id")int id){
        return dao.getFilm(id);
    }

    @PostMapping
    public Film postFilm(@RequestBody Film film){
        dao.insertFilm(film);
        return film;
    }

    @PutMapping
    public void putFilmById(@PathVariable("id")int id){
        dao.changeFilm(id);
    }

    @DeleteMapping("{id}")
    public void deleteFilm(@PathVariable("id")int id){
        dao.deleteFilm(id);
    }

}
