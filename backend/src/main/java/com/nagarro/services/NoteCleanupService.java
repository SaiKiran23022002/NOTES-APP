package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

import com.nagarro.entities.*;

@Component
public class NoteCleanupService {

	@Autowired
	private NotesService notesService;

	@Scheduled(cron = "0 0 * * * *")
	public void deleteOldNotes() {

		List<Notes> recentNotes = notesService.findLast10RecentNotes();

		notesService.deleteNotesExcept(recentNotes);
	}
}
