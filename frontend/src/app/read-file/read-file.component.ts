import { Component  } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
	selector: 'app-read-file',
	templateUrl: './read-file.component.html',
	styleUrls: ['./read-file.component.css']
})

export class ReadFileComponent {
	
	gedPattern = "^.*\\.ged$";
	projectNamePattern = "^[a-z0-9_-]{0,60}$";
	fileName!: string;
	filePath!: string;
	fileString!: string;
	fileLastModified!: number;
	fileSize!: number;
	fileType!: string;
		
	fileForm = new FormGroup({
	    fileFullPath: new FormControl('', Validators.required),
	    projectName: new FormControl('', 
	    		[Validators.required, 
	    		 Validators.minLength(3), 
	    		 Validators.maxLength(60),
	    		 Validators.pattern(this.projectNamePattern)]),	    
	});
	
	constructor(private http: HttpClient) {} 
	
	readGedcomFile() {}
	
	fileFullPathChangeValue(fullPath : any) {
		const file: File = fullPath.target.files[0];
		this.filePath = this.fileForm.controls.fileFullPath.value as string;
		if (!this.fileForm.controls.fileFullPath.errors) this.fileName = file.name;	
		this.fileLastModified = file.lastModified;
		this.fileSize = file.size;
		this.fileType = file.type;

	}
	
	projectNameChangeValue() {
		console.log("CHANGE: " + this.fileForm.controls.projectName.value);
	}

	onSubmit(){
	}
}