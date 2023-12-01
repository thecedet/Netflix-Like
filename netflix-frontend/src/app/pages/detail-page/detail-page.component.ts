import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SerieService } from '../../services/serie.service';
import { switchMap, Observable } from 'rxjs';
import { MessageDto } from '../../models/message.dto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detail-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './detail-page.component.html',
  styleUrl: './detail-page.component.css'
})
export class DetailPageComponent {

  public image : string = "";
  private id : string = this.activatedRoute.snapshot.params["id"]

  constructor(private serieService : SerieService, private activatedRoute : ActivatedRoute) {

  }

  ngOnInit(): void {
    this.serieService.getPresignedUrl(this.id).subscribe({
      next: image => this.image = image.message
    })
}

}
