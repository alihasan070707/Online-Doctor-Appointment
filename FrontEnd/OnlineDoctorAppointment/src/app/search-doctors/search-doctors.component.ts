import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-doctors',
  templateUrl: './search-doctors.component.html',
  styleUrls: ['./search-doctors.component.css']
})
export class SearchDoctorsComponent implements OnInit {
  selected;
  cities;
  state;
  spec;
  doctors = [
    {
      name:"ali",
      fee:"2rs",
      specialization:"gyno",
    },
    {
      name:"yash",
      fee:"-100",
      specialization:"power yoga"
    }
  ]
  items = [
    "ActionScript",
    "AppleScript",
    "Asp",
    "BASIC",
    "C",
    "C++",
    "Clojure",
    "COBOL",
    "ColdFusion",
    "Cycle",
    "Erlang",
    "Fortran",
    "Groovy",
    "Haskell",
    "Java",
    "JavaScript",
    "Lisp",
    "Perl",
    "PHP",
    "Python",
    "Ruby",
    "Scala",
    "Scheme"];
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  selectedState() {
    this.http.get<any[]>("http://localhost:8080/doctor/searchCity",).subscribe(data => this.cities = data);
  }

  selectedCity() {
    this.http.get<any[]>("http://localhost:8080/doctor/searchSpec",this.selected).subscribe(data => this.spec = data);
  }

  onSubmit(myForm:NgForm) {
    console.log(myForm.value);
    console.log(this.selected);
    
    const formData = new FormData();
    formData.append('data', JSON.stringify(myForm.value));
    this.http.post("http://localhost:8080/doctor/search", formData).subscribe(data => console.log(data));
  }
  
}
