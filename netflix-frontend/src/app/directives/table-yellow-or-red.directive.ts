import {Directive, ElementRef, Input, Renderer2} from "@angular/core"

@Directive({
    selector: "[appTableYellowOrRed]",
    standalone: true
})
export class TableYellowOrRedDirective {

    @Input()
    set appTableYellowOrRed(value: string) {
        if(parseInt(value) >= 4) {
            this.renderer.setStyle(
                this.elRef.nativeElement,
                "background-color",
                "green"
            );    
        }else if(parseInt(value) >= 3) {
            this.renderer.setStyle(
                this.elRef.nativeElement,
                "background-color",
                "yellow"
            );
        }else {
            this.renderer.setStyle(
                this.elRef.nativeElement,
                "background-color",
                "red"
            );
        }
    }

    constructor(private elRef: ElementRef, private renderer: Renderer2) {

    }
}