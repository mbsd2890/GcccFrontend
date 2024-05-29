import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = 'https://wonderful-bay-04b3f7303.5.azurestaticapps.net';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  constructor(private http: HttpClient) {}

  postCar(car: any): Observable<any> {
    return this.http.post(
      'https://gcccbackend.azurewebsites.net/api/car',
      car
    );
  }

  getAllCars(): Observable<any> {
    return this.http.get(
      'https://gcccbackend.azurewebsites.net/api/cars'
    );
  }

  getCarById(id: number): Observable<any> {
    return this.http.get(
      'https://gcccbackend.azurewebsites.net/api/car/' + id
    );
  }

  updateCar(id: number, car: any): Observable<any> {
    return this.http.put(
      'https://gcccbackend.azurewebsites.net/api/car/' + id,
      car
    );
  }

  deleteCar(id: number): Observable<any> {
    return this.http.delete(
      'https://wonderful-bay-04b3f7303.5.azurestaticapps.net/api/car/' + id
    );
  }
}
