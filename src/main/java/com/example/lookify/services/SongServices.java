package com.example.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lookify.models.Song;
import com.example.lookify.repositories.SongRepository;

@Service
public class SongServices {
	
	private final SongRepository songRepo;
	
	public SongServices(SongRepository songRepo) {
		this.songRepo= songRepo;
	}
		
		
	    public List<Song> allSongs() {
	        return songRepo.findAll();
	    }

	    public Song createSong(Song s) {
	        return songRepo.save(s);
	    }

	    public Song findSong(Long id) {
	        Optional<Song> optionalSong = songRepo.findById(id);
	        if(optionalSong.isPresent()) {
	            return optionalSong.get();
	        } else {
	            return null;
	        }
	    }
	    public Song updateSong(Song song) {
	        return songRepo.save(song);
	    }
	    
	    public void deleteSong(Long id) {
	    	songRepo.deleteById(id);
	        
	    }
	    
	    public List<Song> topten(){
	    	return songRepo.findTop10ByOrderByRatingDesc();
	    }
	    
	    public List<Song> searchByArtist(String search){
	    	return songRepo.findByArtistContaining(search);
	    }


		
	}

