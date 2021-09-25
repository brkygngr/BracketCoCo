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

  constructor(private readonly combinationsService: CombinationsService) {}

  onCountClick() {
    if (0 <= this.pairCount) {
      this.combinationsService
        .getBracketCombinations(this.pairCount)
        .subscribe((result) => {
          this.result = result;
        });
    }
  }
}
