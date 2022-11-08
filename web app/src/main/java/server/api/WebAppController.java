package server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.business.MovieService;

@RestController
@RequestMapping("http://localhost:63342/web%20app/templates/index.html?_ijt=aumlrvam7bjhj3s2lrom9kaqj8&_ij_reload=RELOAD_ON_SAVE")
public class WebAppController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("movies", movieService.readAll());
        return "index.html";
    }

}
