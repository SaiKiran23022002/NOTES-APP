import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css'],
})
export class UserRegistrationComponent {
  user: any = {};

  error: string | undefined;
  private apiUrl = 'http://localhost:8090/users';
  constructor(private http: HttpClient, private router: Router) {}

  registerUser() {
    this.http.get(this.apiUrl).subscribe((users: any) => {
      const foundUser = users.find(
        (user: any) => user.email === this.user.email
      );
      if (foundUser) {
        console.error('Registration failed');
        this.error = 'Registration failed. User Already exists.';
      } else {
        this.http.post('http://localhost:8090/users', this.user).subscribe(
          (response) => {
            console.log('Registration successful');
            this.router.navigate(['/login']);
          },
          (error) => {
            console.error('Registration failed:', error);
            this.error = 'Registration failed. Please try again.';
          }
        );
      }
    });
  }
}
