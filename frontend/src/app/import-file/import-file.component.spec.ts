import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportFileComponent } from './import-file.component';

describe('ImportFileComponent', () => {
  let component: ImportFileComponent;
  let fixture: ComponentFixture<ImportFileComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ImportFileComponent]
    });
    fixture = TestBed.createComponent(ImportFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
