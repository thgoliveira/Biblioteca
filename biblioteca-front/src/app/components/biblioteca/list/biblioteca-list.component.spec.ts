import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BibliotecaListComponent } from './biblioteca-list.component';

describe('BibliotecaListComponent', () => {
  let component: BibliotecaListComponent;
  let fixture: ComponentFixture<BibliotecaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BibliotecaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BibliotecaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
