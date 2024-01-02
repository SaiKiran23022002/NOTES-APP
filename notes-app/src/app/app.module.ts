import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AddNoteComponent } from './add-note/add-note.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandComponent } from './land/land.component';
import { NotesManagerComponent } from './notes-manager/notes-manager.component';
import { RouteGaurdGuard } from './route-guard.guard';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { ViewNoteComponent } from './view-note/view-note.component';

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    UserRegistrationComponent,
    LandComponent,
    NotesManagerComponent,
    AddNoteComponent,
    ViewNoteComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [RouteGaurdGuard],
  bootstrap: [AppComponent],
})
export class AppModule {}
