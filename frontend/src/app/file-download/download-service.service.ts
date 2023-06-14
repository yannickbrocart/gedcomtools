import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DownloadServiceService {
	private baseUrl = 'http://localhost:8080';
	
	constructor(private http: HttpClient) { }
}
