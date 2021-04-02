package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model){
        Actor actor = new Actor();
        actor.setName("kanchha");
        actor.setRealName("kanchha sharma");

        Movie movie = new Movie();
        movie.setTitle("MountEverest Movie");
        movie.setYear(2017);
        movie.setDescription("it is nice to watch");

        Movie movie1 = new Movie();
        movie1.setTitle("about child love");
        movie1.setYear(2018);
        movie1.setDescription("it is a best child movie");

        Set <Movie> movies = new HashSet<>();
        movies.add(movie);
        movies.add(movie1);
        actor.setMovies(movies);

        actorRepository.save(actor);

        model.addAttribute("actors",actorRepository.findAll());
        return "index";
    }

}
