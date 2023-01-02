import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css']
})
export class BookUpdateComponent implements OnInit {

  id!: number;
  isUpdating = false;
  book: any;
  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.id = JSON.parse(localStorage.getItem('id') || '{}');
    this.bookService.getBook(this.id).subscribe({
      next: (res) => {
        this.book = res;
        console.log(this.book.id);
      },
      error: (error) => {
        console.log(error);
      },

    });
  }

  onSubmit() {
    console.log(this.book);
    this.isUpdating = true;

    this.bookService.update(this.id, this.book).subscribe({
      next: (res) => {
        if (res) {
          this.isUpdating = false;
          alert("Book Details Updated");
          console.log('response: ' + res);
          this.router.navigate(["/"]);
        }
      },
      error: (err) => {
        this.isUpdating = false;
        console.log('Error: ' + err);
        alert("Book Details not updated...!")
      },
    });


  }
}
