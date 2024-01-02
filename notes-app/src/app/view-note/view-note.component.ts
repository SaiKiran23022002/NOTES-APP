import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-note',
  templateUrl: './view-note.component.html',
  styleUrls: ['./view-note.component.css']
})
export class ViewNoteComponent {

  constructor( private http: HttpClient, private router: Router) { }
  
  note: any={};
  noteCollection: any[] = [];
  collection: any[] = [];
  userId: String | null = null;
  maxNotesToShow: number = 10;

  ngOnInit(): void {
      const userId = localStorage.getItem('userId');
      this.userId=userId;
      this.viewNote();
    }

  viewNote():void{
    const apiUrl = `http://localhost:8090/notes/${this.userId}`;
    this.http.get(apiUrl).subscribe((note: any) => {
      this.collection = note;  
      this.noteCollection=this.collection;
      console.log(this.noteCollection);
    
    });
  }
  deleteNote(id: number) {
    this.http
      .delete(`http://localhost:8090/notes/${id}`) 
      .subscribe(
        () => {
          alert("Your Note has been deleted successfully!!!");
          this.viewNote();
        },
        (error) => {
          console.error('Error deleting item:', error);
        }
      );
  }
  
}
