import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BoderRadiusComponent } from './boder-radius.component';

describe('BoderRadiusComponent', () => {
  let component: BoderRadiusComponent;
  let fixture: ComponentFixture<BoderRadiusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoderRadiusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoderRadiusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
