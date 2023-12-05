import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SerieDetailsPageComponent } from './serie-details-page.component';

describe('SerieDetailsPageComponent', () => {
  let component: SerieDetailsPageComponent;
  let fixture: ComponentFixture<SerieDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SerieDetailsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SerieDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
