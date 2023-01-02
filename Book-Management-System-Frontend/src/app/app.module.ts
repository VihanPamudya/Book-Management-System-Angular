import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBookComponent } from './add-book/add-book.component';
import { AllBookListComponent } from './all-book-list/all-book-list.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BookAddComponent } from './components/book/book-add/book-add.component';
import { BookUpdateComponent } from './components/book/book-update/book-update.component';
import { BookAllListComponent } from './components/book/book-all-list/book-all-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddBookComponent,
    AllBookListComponent,
    HeaderComponent,
    FooterComponent,
    BookAddComponent,
    BookUpdateComponent,
    BookAllListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
