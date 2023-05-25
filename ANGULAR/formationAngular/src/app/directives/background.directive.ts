import { Directive, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[background]',
})
export class BackgroundDirective implements OnInit {
  @Input()
  couleur!: string;

  //pour bosser une directive à besoin de 2 objets
  //Balise sur laquelle la directive est place=>injection ElementRef
  //L'objet pour faire les modifications du DOM=>injection Renderer2
  constructor(private renderer: Renderer2, private elementRef: ElementRef) {}

  ngOnInit(): void {
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      'background-color',
      this.couleur
    );
  }
}
