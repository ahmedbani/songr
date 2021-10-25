package com.example.songr.Controllers;

import com.example.songr.Models.Album;
import com.example.songr.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class SongrController {

    @Autowired
    AlbumRepository albumRepository;

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

    @GetMapping("/albums")
    public String getBooks(Model model){
        System.out.println(albumRepository.findAll());
        model.addAttribute("album",albumRepository.findAll());
        return "albums";
    }
    @GetMapping("/form")
    public String addAlbum(){
        return "form";
    }
    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@RequestParam(value="title") String title,
                                 @RequestParam(value="artist")String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") int length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title, artist, songCount,length, imageUrl );
        albumRepository.save(album);
        return new RedirectView("/albums");

    }

}
