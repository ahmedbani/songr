package com.example.songr.Controllers;

import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import com.example.songr.Repositories.AlbumRepository;
import com.example.songr.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getSongs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "songs";
    }

    @PostMapping("/addSong")
    public RedirectView addSong(String title, int length,int trackNumber,int albumId){
        Album album = albumRepository.findById(albumId).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        return new RedirectView("/songs");
    }

    @GetMapping("/songs/{id}")
    public String albumData(@PathVariable int id,Model model){
        Album album = albumRepository.findById(id).get();
        model.addAttribute("album",album);
        return "album";

    }
}
