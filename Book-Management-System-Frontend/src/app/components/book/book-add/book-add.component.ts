import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/services/book.service';
import {BookModel} from 'src/app/models/book.model'

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit {

  book = new BookModel();

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.bookService.create(this.book).subscribe({
      next: (res) => {
        if(res){
          alert("Book create sucess")
          this.book = new BookModel();
          this.router.navigate(["/"]);
        }

      },
      error: (err) => {
        alert("Something went wrong!");
      },
    });

  }
}
