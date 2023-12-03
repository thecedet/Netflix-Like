import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActeurDetailsImageComponent } from './acteur-details-image.component';

describe('ActeurDetailsImageComponent', () => {
  let component: ActeurDetailsImageComponent;
  let fixture: ComponentFixture<ActeurDetailsImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActeurDetailsImageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActeurDetailsImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
