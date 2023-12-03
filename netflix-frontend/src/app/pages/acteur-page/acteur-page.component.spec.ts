import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActeurPageComponent } from './acteur-page.component';

describe('ActeurPageComponent', () => {
  let component: ActeurPageComponent;
  let fixture: ComponentFixture<ActeurPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActeurPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActeurPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
