package com.nagarro.services;

import java.util.List;  
import com.nagarro.entities.Notes;

public interface NotesService {

	public List<Notes> getNotes();

	public Notes getNote(long id);

	public Notes addNote(Notes note);
	
	public void deleteNote(long id);

	public List<Notes> findLast10RecentNotes();
	
	public void deleteNotesExcept(List<Notes> recentNotes);
}

