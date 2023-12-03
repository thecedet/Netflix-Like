import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActeurDetailsPageComponent } from './acteur-details-page.component';

describe('ActeurDetailsPageComponent', () => {
  let component: ActeurDetailsPageComponent;
  let fixture: ComponentFixture<ActeurDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActeurDetailsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActeurDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
