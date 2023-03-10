import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private httpClient: HttpClient) { }

  title = 'app';
  private url = 'http://localhost:4200/data';
  public body: string | undefined;

  async onClick() {
    this.httpClient.get<Data>(this.url).subscribe(result => {
      this.body = result.data;
    });
  }
}

interface Data {
  data: string
}
