import { Component  } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';

@Component({
	selector: 'app-read-file',
	templateUrl: './read-file.component.html',
	styleUrls: ['./read-file.component.css']
})

export class ReadFileComponent {
	
	gedPattern = "^[a-zA-Z]$";
	fileInputControl = new FormControl(null, [Validators.required]);
	
	constructor() { } 
	
	fileImputChangeValue() {
		console.log("CHANGE " + this.fileInputControl.value);
	}
  
	submitFileInput(){
		console.log('Name: ' + this.fileInputControl.value);
		console.log('Validation Status: ' + this.fileInputControl.status);
	}
}