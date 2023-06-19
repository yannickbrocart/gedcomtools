import { Component  } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
	selector: 'app-read-file',
	templateUrl: './read-file.component.html',
	styleUrls: ['./read-file.component.css']
})

export class ReadFileComponent {
	
	gedPattern = "^.*\\.ged$";
	projectNamePattern = "^[a-z0-9_-]{1,60}$";
	
	fileForm = new FormGroup({
	    fileFullPath: new FormControl('', Validators.required),
	    projectName: new FormControl('', 
	    		[Validators.required, 
	    		 Validators.minLength(3), 
	    		 Validators.maxLength(60),
	    		 Validators.pattern(this.projectNamePattern)]),	    
	});
	
	constructor() { } 
	
	fileImputChangeValue() {
		console.log("CHANGE " + this.fileForm.value);
	}
  
	onSubmit(){
		console.log('Path: ' + this.fileForm.controls.fileFullPath.value);
		console.log('Path validation status: ' + this.fileForm.controls.fileFullPath.status);
		var filePath = this.fileForm.controls.fileFullPath.value;
		var fileName = filePath.substr(filePath.lastIndexOf('\\') + 1);
		console.log('Name: ' + this.fileForm.controls.projectName.value);
		console.log('Name validation status: ' + this.fileForm.controls.projectName.status);
	}
}