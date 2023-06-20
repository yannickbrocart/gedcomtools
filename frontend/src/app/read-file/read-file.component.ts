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
	projectNamePattern = "^[a-zA-Z]{1,}[\\w-]{2,60}$";
	fileName!: string;
	filePath!: string;
	fileString!: string;
	fileLastModified!: Date;
	fileSize!: string;
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
		this.fileName = file.name;	
		this.fileLastModified = new Date(file.lastModified);
		this.fileSize = formatBytes(file.size,2);
		this.fileType = file.type;

	}
	
	projectNameChangeValue() {
		console.log("CHANGE: " + this.fileForm.controls.projectName.value);
	}

	onSubmit(){
	}
}

function formatBytes(bytes: number, dm = 2) {
	  if (bytes == 0) return '0 Bytes';
	  var k = 1024,
	    sizes = [`${bytes <= 1 ? "Byte" : "Bytes"}`, 'Kb', 'Mb', 'Gb', 'Tb', 'Pb', 'Eb', 'Zb', 'Yb'],
	    i = Math.floor(Math.log(bytes) / Math.log(k));
	  return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
	}