package com.example.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	//finds all songs
	List<Song> findAll();
	
	//finds song from artist search
	List<Song> findByArtistContaining(String search);
	
	//finds top songs
	List<Song> findTop10ByOrderByRatingDesc();
	
	
}
