import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notes-manager',
  templateUrl: './notes-manager.component.html',
  styleUrls: ['./notes-manager.component.css'],
})
export class NotesManagerComponent {
  constructor(private router: Router) {}
  logOut(): void {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
