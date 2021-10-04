package be.ucll.javaGevorderd.RestAPI_Oefening2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    private FilmDAO dao;

    @Autowired
    public FilmController(FilmDAO doa) {
        this.dao = dao;
    }

    @GetMapping
    public List<Film> getFilms(){

    }

    public Film film getFilm(@RequestParam("titel")String titel){

    }
    @PutMapping
    public void putFilm(){
        Film film = new Film();

        dao.insertFilm();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFilm(@PathVariable("id")Long id){

    }

}
