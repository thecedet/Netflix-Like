import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActeurDetailsFormComponent } from './acteur-details-form.component';

describe('ActeurDetailsFormComponent', () => {
  let component: ActeurDetailsFormComponent;
  let fixture: ComponentFixture<ActeurDetailsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActeurDetailsFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActeurDetailsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
