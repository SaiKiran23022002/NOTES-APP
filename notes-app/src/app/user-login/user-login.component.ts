import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface CustomWindow extends Window {
  alertVisible: boolean;
}

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css'],
})
export class UserLoginComponent {
  user: any = {};
  error: string | undefined;
  private apiUrl = 'http://localhost:8090/users';

  constructor(private http: HttpClient, private router: Router) {}

  loginUser() {
    this.http.get(this.apiUrl).subscribe(
      (users: any) => {
        const foundUser = users.find(
          (user: any) =>
            user.email === this.user.email &&
            user.password === this.user.password
        );
        if (foundUser) {
          console.log('Login successful');
          localStorage.setItem('userId', foundUser.id);
          this.router.navigate(['/notesmanager']);
        } else {
          console.error('Invalid credentials');
          this.error = 'Invalid email or password.';
        }
      },
      (error) => {
        console.error('Login failed:', error);
        this.error = 'Login failed. Please try again.';
      }
    );
  }
}
