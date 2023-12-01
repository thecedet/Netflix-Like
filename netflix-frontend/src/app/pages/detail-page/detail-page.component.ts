import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SerieService } from '../../services/serie.service';
import { ActivatedRoute } from '@angular/router';
import { MessageDto } from '../../models/message.dto';
import { Observable, map, tap } from 'rxjs';

@Component({
  selector: 'app-detail-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './detail-page.component.html',
  styleUrl: './detail-page.component.css'
})
export class DetailPageComponent {

  public $image : Observable<MessageDto> ;
  private id : string = this.activatedRoute.snapshot.params["id"]

  constructor(private serieService : SerieService, private activatedRoute : ActivatedRoute) {

  }

  ngOnInit(): void {
    this.$image = this.serieService.getPresignedUrl(this.id);
  }

}
