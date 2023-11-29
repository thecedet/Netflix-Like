import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableSerieComponent } from './table-serie.component';

describe('TableSerieComponent', () => {
  let component: TableSerieComponent;
  let fixture: ComponentFixture<TableSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableSerieComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TableSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
