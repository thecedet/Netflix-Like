import { Component, EventEmitter, Output } from '@angular/core';
import { InputFileComponent } from "../../../components/input-file/input-file.component";
import { CommonModule } from '@angular/common';
import { IMessage } from '../../../models/message.models';
import { NotificationService } from '../../../services/notification.service';

@Component({
    selector: 'app-acteur-details-image',
    standalone: true,
    templateUrl: './acteur-details-image.component.html',
    styleUrl: './acteur-details-image.component.css',
    imports: [CommonModule,InputFileComponent]
})
export class ActeurDetailsImageComponent {

    public image ?: IMessage;

    @Output() public uploadImage : EventEmitter<File> = new EventEmitter();

    constructor(private readonly ntfService : NotificationService) {}

    public onErrorImage() : void {
        this.ntfService.error("Impossible de charger les images")
      }

}
