import { Component } from '@angular/core';
import { CombinationsService } from './services/combinations.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  pairCount: number | undefined;
  result: number | undefined;

  constructor(private readonly combinationsService: CombinationsService) {

  }

  onCountClick() {
    if (this.pairCount) {
      this.combinationsService.getBracketCombinations(this.pairCount).subscribe((result) => {
        this.result = result
      });
    }
  }
}
