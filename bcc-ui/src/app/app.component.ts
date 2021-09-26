import { Component } from '@angular/core';
import { CombinationsService } from './services/combinations.service';

@Component({
  selector: 'bcc-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  result: number | undefined;
  error: string | undefined;
  pairCount = 0;
  isLoading = false;

  constructor(private readonly combinationsService: CombinationsService) {}

  onCountClick() {
    if (0 <= this.pairCount) {
      this.resetResult();
      this.isLoading = true;
      this.combinationsService.getBracketCombinations(this.pairCount).subscribe(
        (result) => {
          this.result = result.totalCombinations;
          this.error = undefined;
          this.isLoading = false;
        },
        (failure: { e: string }) => {
          this.result = undefined;
          this.error = this.pairCount + ' ' + failure.e;
          this.isLoading = false;
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
