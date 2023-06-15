import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadFileComponent } from './read-file.component';

describe('ReadFileComponent', () => {
  let component: ReadFileComponent;
  let fixture: ComponentFixture<ReadFileComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReadFileComponent]
    });
    fixture = TestBed.createComponent(ReadFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
