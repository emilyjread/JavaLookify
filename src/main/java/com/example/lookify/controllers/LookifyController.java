package com.example.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongServices;

@Controller
public class LookifyController {
	private final SongServices songService;
	
	public LookifyController(SongServices songService) {
		this.songService= songService;
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "songs/index.jsp";
	}
	
	//shows all songs
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs= songService.allSongs();
		model.addAttribute("songs", songs);
		return "songs/dashboard.jsp";
	}
	
	//shows one song
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
	    Song song = songService.findSong(id);
	    model.addAttribute("song", song);
	    return "/songs/show.jsp";
	}
	
	//create song
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song s) {
		return "/songs/new.jsp";
		
	}
	
	@RequestMapping(value= "/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result){
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		}
		else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
		
	}
	
	//update song
	@RequestMapping("/songs/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
	    Song song = songService.findSong(id);
	    model.addAttribute("song", song);
	    return "/songs/edit.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
            return "/songs/edit.jsp";
        } else {
            songService.updateSong(song);
            return "redirect:/songs";
        }
	}
	
	//delete song
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable ("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
		
	}
	
	//top ten songs
	@RequestMapping(value="/songs/topten")
	public String topTen(Model model) {
		List<Song> topsongs= songService.topten();
		model.addAttribute("topsongs", topsongs);
		return "/songs/topten.jsp";
	}
	
	//searching by artist
	
	@RequestMapping("/search/{query}")
	public String search(Model model, @PathVariable("query") String query) {
		List<Song> artistsongs= songService.searchByArtist(query);
		model.addAttribute("artistsongs", artistsongs);
		model.addAttribute("query", query);
		return "/songs/search.jsp";
		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String update(@RequestParam("query") String query) {
		
		return ("redirect:/search/"+query);
		
	}
	

	
}
