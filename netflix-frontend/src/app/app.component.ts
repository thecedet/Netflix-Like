import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { NotificationComponent } from "./components/notification/notification.component";
import { NotificationService } from './services/notification.service';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [CommonModule, RouterOutlet, NotificationComponent]
})
export class AppComponent {

  constructor(private ntfService : NotificationService) {

  }

  notify() {
    this.ntfService.success("Yay !", 1000);
  }
}
