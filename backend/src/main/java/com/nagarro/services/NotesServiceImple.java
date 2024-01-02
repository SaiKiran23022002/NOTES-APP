package com.nagarro.services;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.NotesRepo;
import com.nagarro.entities.Notes;

import jakarta.annotation.PostConstruct;

@Service
public class NotesServiceImple implements NotesService {

	@Autowired
	private NotesRepo notesRepo;
	
	List<Notes> list;
	private long nextId = 0;

	public NotesServiceImple() {
		list = new ArrayList<>();
		list.add(createNote("9999", "Content","title"));
	}
	@PostConstruct
	public void init() {
		// Check if the database is empty
		if (notesRepo.count() == 0) {
			List<Notes> dummyData = createDummyData();
			notesRepo.saveAll(dummyData);
		}
	}

	private List<Notes> createDummyData() {
		List<Notes> dummyData = new ArrayList<>();
		dummyData.add(createNote("9999", "Content","title"));
		return dummyData;
	}

	private Notes createNote(String userId, String Content, String Title) {
		long id = nextId;
		nextId++;
		return new Notes(id, userId, Content, Title);
	}
	
	@Override
	public List<Notes> getNotes() {
		return (List<Notes>) notesRepo.findAll();
	}
	@Override
	public Notes getNote(long id) {
		return notesRepo.findById(id).orElse(null);
	}

	@Override
	public Notes addNote(Notes note) {
		long id = nextId;
		note.setId(id);
		nextId++;
		list.add(note);
		return notesRepo.save(note);
	}
	
	@Override
	public void deleteNote(long id) {
		notesRepo.deleteById(id);

	}
	
	@Override
	public List<Notes> findLast10RecentNotes() {
        return notesRepo.findLast10RecentNotes();
    }

	@Override
    public void deleteNotesExcept(List<Notes> recentNotes) {
		
        for (Notes note : notesRepo.findAll()) {
            if (!recentNotes.contains(note)) {
                notesRepo.delete(note);
            }
        }
    }

}

