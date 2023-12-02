import { Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SerieService } from '../../services/serie.service';
import { ActivatedRoute } from '@angular/router';
import { MessageDto } from '../../models/message.dto';
import { InputFileComponent } from '../../components/input-file/input-file.component';

@Component({
    selector: 'app-detail-page',
    standalone: true,
    templateUrl: './detail-page.component.html',
    styleUrl: './detail-page.component.css',
    imports: [CommonModule, InputFileComponent]
})
export class DetailPageComponent {
setState() {
throw new Error('Method not implemented.');
}

  public image ?: MessageDto;
  private id : string = this.activatedRoute.snapshot.params["id"]

  @ViewChild(InputFileComponent, { static: false })
  inputFileComponent ?: InputFileComponent;

  constructor(private serieService : SerieService, private activatedRoute : ActivatedRoute) {

  }

  ngOnInit(): void {
    this.fetchImage()
  }

  fetchImage() {
    this.serieService.getPresignedUrl(this.id).subscribe({
      next: image => this.image = image
    });
  }
  
  uploadCover(file : File) : void {
    this.serieService.postImage(this.id,file).subscribe(_ => {
      this.fetchImage()
      if(this.inputFileComponent) this.inputFileComponent.setState(true)
    })
  }

}
