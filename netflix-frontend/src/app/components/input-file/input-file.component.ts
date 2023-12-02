import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-input-file',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './input-file.component.html',
  styleUrl: './input-file.component.css'
})

export class InputFileComponent {

  status: "initial" | "uploading" | "success" | "fail" = "initial";
  file ?: File;

  @Output() public uploadCover : EventEmitter<File> = new EventEmitter();

  public setState(state : boolean) : void {
    this.status = state ? "success" : "fail"
  }
  
  public onChange(event : Event) {
    const element = event.target as HTMLInputElement;
    if(element.files) {
      this.file = element.files[0]
    }
    
  }

  public onUpload() : void {
    if(this.file) {
      this.status = "uploading";
      this.uploadCover.emit(this.file)
    }
  }  

}

