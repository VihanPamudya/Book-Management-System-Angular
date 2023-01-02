import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import {BookModel} from 'src/app/models/book.model'
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-all-list',
  templateUrl: './book-all-list.component.html',
  styleUrls: ['./book-all-list.component.css']
})
export class BookAllListComponent implements OnInit {

  isLoading = false;
  bookList: BookModel[] | undefined;
  book: any;

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.isLoading = true;
    this.bookService.getList().subscribe({
      next: (res) => {
        this.bookList = res;
        this.isLoading = false;
        console.log(this.bookList);
      },
      error: (error) => {
        console.log(error);
        this.isLoading = false;
      },
    });
  }

  delete(id: any){
    let text= "Do you want to delete the book?"
    if(confirm(text)==true){
    this.bookService.delete(id).subscribe({
      next: (res) =>{
        console.log(res);
        if(res == null){
          alert("Book deleted");
          console.log(res);
          this.getList();
          this.router.navigate(["/"]);
        }
      },
    error : (error)=>{
      console.log(error);
      this.isLoading = false;
      console.log(error);
      alert("Book can't delete")
    },
  });
}
  }

  edit(id: number){
    localStorage.setItem('id',JSON.stringify(id))
  }
}
