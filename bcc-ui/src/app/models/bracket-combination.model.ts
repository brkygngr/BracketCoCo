import { BracketCombinationResponse } from './bracket-combination-response.model';

export class BracketCombination {
  totalCombinations!: number;

  static from(
    bracketCombinationResponse: BracketCombinationResponse
  ): BracketCombination {
    return { totalCombinations: bracketCombinationResponse.tc };
  }
}
