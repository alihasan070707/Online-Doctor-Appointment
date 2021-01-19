import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements OnInit {

  timeFrames:any=[];
  selectedTime:string;
  canBook:boolean=false;
  constructor() { 

      
  }

  ngOnInit(): void {
  }
  datePicked(event){
      console.log(event.target.value);
      this.timeFrames=[];
      this.timeFrames.push({startTime:"10:00" ,endTime: "11:00",isBooked:true});
      this.timeFrames.push({startTime:"10:00" ,endTime: "11:00",isBooked:true});
      this.timeFrames.push({startTime:"10:00" ,endTime: "11:00",isBooked:false});
      this.timeFrames.push({startTime:"10:00" ,endTime: "11:00",isBooked:false});
      console.log(this.timeFrames);

  }
  OnTimeSelect(event){
    this.selectedTime = event.target.value;
    console.log(event.target.attributes.value.nodeValue);
    this.canBook = true;
  }


}
