package server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.business.MovieService;

@RestController
@RequestMapping("http://localhost:63342/web%20app/templates/index.html?_ijt=l1hlma9umqd6gc8ak6fik7m61i&_ij_reload=RELOAD_ON_SAVE")
public class WebAppController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", movieService.readAll());
        return "index";
    }

}
