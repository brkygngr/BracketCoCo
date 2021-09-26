import { Component } from '@angular/core';
import { CombinationsService } from './services/combinations.service';

@Component({
  selector: 'bcc-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  pairCount = 0;
  result = 0;
  error = '';

  constructor(private readonly combinationsService: CombinationsService) {}

  onCountClick() {
    if (0 <= this.pairCount) {
      this.result = 0;
      this.error = '';
      this.combinationsService.getBracketCombinations(this.pairCount).subscribe(
        (result) => {
          this.result = result.totalCombinations;
        },
        (error) => {
          this.error = error;
        }
      );
    }
  }
}
