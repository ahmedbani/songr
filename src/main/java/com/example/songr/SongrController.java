package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
public class SongrController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "helloWorld";
    }

    @RequestMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text){
        return "Capitalize";
    }

    @RequestMapping("/album")
    public String album(Model model){
        ArrayList albums = new ArrayList();
        Album album1 = new Album("Kamikaze","Eminem",10,2749,"https://upload.wikimedia.org/wikipedia/en/6/62/Eminem_-_Kamikaze.jpg");
        Album album2 = new Album("Ahla W Ahla","Amr Diab",12, 2860,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6YMdbSDdcEuKdVniJIS9MtdTs3_taFBJDy49s8I4&usqp=CAE&s");
        Album album3 = new Album("17","XXXTENTACION",11,1314,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFksMgxOESM5pzLaZKyAigLl52o-miXeXsk0d3-Z8&usqp=CAE&s");
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        model.addAttribute("albums",albums);

        return "albums";
    }

}
