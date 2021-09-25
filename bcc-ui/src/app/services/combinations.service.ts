import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root',
})
export class CombinationsService {
  private static readonly SERVICE_URL = 'api/combinations/'

  constructor(private readonly httpClient: HttpClient) {}

  getBracketCombinations(pairCount: number): Observable<number> {
    return this.httpClient.get<number>(
      `${CombinationsService.SERVICE_URL}bracket?pairCount=${pairCount}`
    )
  }
}
