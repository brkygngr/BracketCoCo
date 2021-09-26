import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { BracketCombinationResponse } from '../models/bracket-combination-response.model';
import { BracketCombination } from '../models/bracket-combination.model';

@Injectable({
  providedIn: 'root',
})
export class CombinationsService {
  private static readonly SERVICE_URL = 'api/combinations/';

  constructor(private readonly httpClient: HttpClient) {}

  getBracketCombinations(pairCount: number): Observable<BracketCombination> {
    return this.httpClient
      .get<BracketCombinationResponse>(
        `${CombinationsService.SERVICE_URL}bracket?pairCount=${pairCount}`
      )
      .pipe(map((response) => BracketCombination.from(response)));
  }
}
