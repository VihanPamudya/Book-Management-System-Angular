import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BookAddComponent } from './components/book/book-add/book-add.component';
import { BookUpdateComponent } from './components/book/book-update/book-update.component';
import { BookAllListComponent } from './components/book/book-all-list/book-all-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BookAddComponent,
    BookUpdateComponent,
    BookAllListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    [HttpClientModule,]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
