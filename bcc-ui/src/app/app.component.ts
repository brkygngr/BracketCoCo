import { Component } from '@angular/core';
import { CombinationsService } from './services/combinations.service';

@Component({
  selector: 'bcc-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  pairCount = 0;
  result: number | undefined;
  error: string | undefined;

  constructor(private readonly combinationsService: CombinationsService) {}

  onCountClick() {
    if (0 <= this.pairCount) {
      this.resetResult();
      this.combinationsService.getBracketCombinations(this.pairCount).subscribe(
        (result) => {
          this.result = result.totalCombinations;
          this.error = undefined;
        },
        (failure: { e: string }) => {
          this.result = undefined;
          this.error = this.pairCount + ' ' + failure.e;
        }
      );
    } else {
      this.error = 'Number must be bigger than zero.';
    }
  }

  onNumberInputKeyUp() {
    if (this.pairCount < 0) {
      this.error = 'Number must be bigger than zero.';
    } else {
      this.error = undefined;
    }
  }

  private resetResult() {
    this.result = undefined;
    this.error = undefined;
  }
}
