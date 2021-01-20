import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-doctors',
  templateUrl: './search-doctors.component.html',
  styleUrls: ['./search-doctors.component.css'],
})
export class SearchDoctorsComponent implements OnInit {
  selected;
  cities: any = [];
  state;
  city;
  states: any = [];
  spec;
  specs: any = [];
  doctors = [
    {
      name: 'ali',
      fee: '2rs',
      specialization: 'gyno',
    },
    {
      name: 'yash',
      fee: '-100',
      specialization: 'power yoga',
    },
  ];
  items = [
    'ActionScript',
    'Maharashtra',
    'AppleScript',
    'Asp',
    'BASIC',
    'C',
    'C++',
    'Clojure',
    'COBOL',
    'ColdFusion',
    'Cycle',
    'Erlang',
    'Fortran',
    'Groovy',
    'Haskell',
    'Java',
    'JavaScript',
    'Lisp',
    'Perl',
    'PHP',
    'Python',
    'Ruby',
    'Scala',
    'Scheme',
  ];
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get('http://localhost:8080/doctor/searchState')

      .subscribe((data) => (this.states = data));
    console.log(this.states);
  }

  selectedState() {
    this.http
      .get('http://localhost:8080/doctor/searchCity/?state=' + this.state)

      .subscribe((data) => (this.cities = data));
    console.log(this.cities);
  }

  selectedCity() {
    this.http
      .get(
        'http://localhost:8080/doctor/searchSpec/?state=' +
          this.state +
          '&city=' +
          this.city
      )
      .subscribe((data) => (this.specs = data));
  }

  onSubmit(myForm: NgForm) {
    console.log(myForm.value);
    console.log(this.selected);

    const formData = new FormData();
    formData.append('data', JSON.stringify(myForm.value));
    this.http
      .post('http://localhost:8080/doctor/search', formData)
      .subscribe((data) => console.log(data));
  }
}
