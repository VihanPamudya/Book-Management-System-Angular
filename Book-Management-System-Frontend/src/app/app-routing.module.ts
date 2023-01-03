import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookAddComponent } from './components/book/book-add/book-add.component';
import { BookAllListComponent } from './components/book/book-all-list/book-all-list.component';
import { BookUpdateComponent } from './components/book/book-update/book-update.component';

const routes: Routes = [
  {path: '', component: BookAllListComponent},
  {path: 'add', component: BookAddComponent},
  {path: 'update', component: BookUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
