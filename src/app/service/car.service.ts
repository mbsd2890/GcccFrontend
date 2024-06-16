import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  //private baseUrl = 'http://localhost:8080/cars/';
  private baseUrl = 'https://gcccbackend.azurewebsites.net/cars/';

  constructor(private http: HttpClient) {}

  postCar(car: any): Observable<any> {
    return this.http.post(
      `${this.baseUrl}`,
      car
    );
  }

  getAllCars(): Observable<any> {
    return this.http.get(
      `${this.baseUrl}`
    );
  }

  getCarById(id: number): Observable<any> {
    return this.http.get(
      `${this.baseUrl}` + id
    );
  }

  updateCar(id: number, car: any): Observable<any> {
    return this.http.put(
      `${this.baseUrl}` + id,
      car
    );
  }

  deleteCar(id: number): Observable<any> {
    return this.http.delete(
      `${this.baseUrl}` + id
    );
  }
}
