import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.component.html',
  styleUrls: ['./add-note.component.css'],
})
export class AddNoteComponent implements OnInit {
  note: any = {};
  userUniqueId: string | null = null;
  pattern: RegExp = /^[a-zA-Z0-9@,;&*+-]*$/;
  error: string | undefined;
  private apiUrl = 'http://localhost:8090/notes';
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');

    if (userId) {
      this.userUniqueId = userId;
      this.note.userId = userId;
    } else {
      console.log('User is not logged in or user ID is not available.');
    }
  }

  addNote() {
    if (
      this.pattern.test(this.note.content) &&
      this.note.content.length <= 500
    ) {
      this.http.post('http://localhost:8090/notes', this.note).subscribe(
        (response) => {
          alert('Notes have been added successfully to your collection.');
          this.router.navigate(['/notesmanager']);
        },
        (error) => {
          console.error('Notes could not be added', error);
          this.error = 'Notes could not be added. Please try again.';
        }
      );
    } else {
      this.error =
        'Note will allow only @ , ; & * + - symbols and the size of content should not exceed 500 characters';
    }
  }
}
