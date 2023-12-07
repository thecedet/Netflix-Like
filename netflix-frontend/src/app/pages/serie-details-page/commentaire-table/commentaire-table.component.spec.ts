import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentaireTableComponent } from './commentaire-table.component';

describe('CommentaireTableComponent', () => {
  let component: CommentaireTableComponent;
  let fixture: ComponentFixture<CommentaireTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CommentaireTableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CommentaireTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
