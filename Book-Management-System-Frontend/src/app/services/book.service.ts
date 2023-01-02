import {HttpClient} from '@angular/common/http'
import { Injectable } from '@angular/core'
import { BookModel } from '../models/book.model'

@Injectable({
    providedIn : 'root'
})
export class BookService{
    private baseUrl = 'http://localhost:8082/book-management/book';

  constructor(private http: HttpClient) {}

  getList() {
    return this.http.get<BookModel[]>(`${this.baseUrl}/list`);
  }
  getBook(id:any) {
    return this.http.get<BookModel[]>(`${this.baseUrl}/view/`+id);
  }

  create(book: BookModel) {
    return this.http.post(`${this.baseUrl}/add`, book);
  }
  update(id:any, book: BookModel) {
    return this.http.put<BookModel>(`${this.baseUrl}/update/`+id,book);
  }
  delete(id : any) {
    return this.http.delete<string>(`${this.baseUrl}/delete/`+id);
  }
}