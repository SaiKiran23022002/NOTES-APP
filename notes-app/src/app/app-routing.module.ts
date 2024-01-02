import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddNoteComponent } from './add-note/add-note.component';
import { LandComponent } from './land/land.component';
import { NotesManagerComponent } from './notes-manager/notes-manager.component';
import { RouteGaurdGuard } from './route-guard.guard';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { ViewNoteComponent } from './view-note/view-note.component';

const routes: Routes = [
  {
    component: UserLoginComponent,
    path: 'login',
  },
  {
    component: UserRegistrationComponent,
    path: 'register',
  },
  {
    component: LandComponent,
    path: '',
  },
  {
    component: NotesManagerComponent,
    canActivate: [RouteGaurdGuard],
    path: 'notesmanager',
  },
  {
    component: AddNoteComponent,
    path: 'addnote',
  },
  {
    component: ViewNoteComponent,
    path: 'view-note',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
