import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-input-file',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './input-file.component.html',
  styleUrl: './input-file.component.css'
})
export class InputFileComponent {

  file ?: File;

  @Output() public uploadCover : EventEmitter<File> = new EventEmitter();

  constructor(private ntfService : NotificationService) {}

  public setState(state : boolean) : void {
    if(state) {
      this.ntfService.success("L'image s'est bien téléversée", 2000);
    }else {
      this.ntfService.error("Erreur pendant le téléversement", 2000);
    }
  }
  
  public onChange(event : Event) {
    const element = event.target as HTMLInputElement;
    if(element.files) {
      this.file = element.files[0]
    }
    
  }

  public onUpload() : void {
    if(this.file) {
      this.ntfService.warning("Téléversement en cours de l'image", 2000)
      this.uploadCover.emit(this.file)
    }
  }

}
