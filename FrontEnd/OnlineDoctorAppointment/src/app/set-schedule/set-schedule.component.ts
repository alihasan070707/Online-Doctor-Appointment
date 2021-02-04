import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { start } from 'repl';

@Component({
  selector: 'app-set-schedule',
  templateUrl: './set-schedule.component.html',
  styleUrls: ['./set-schedule.component.css']
})
export class SetScheduleComponent implements OnInit {

  timeFrames: any =[];
  selectedTime: any = [];
  doctorId:string ='2';
  isChecked:boolean = false;

  constructor (private http: HttpClient) { }

  ngOnInit(): void {
    let startTime = 9;
    for (let i=1; i<=8; ++i){
      let start_time;
      let end_time;
      if(startTime < 10){
        start_time = "0" + startTime + ":00:00";
        if(++startTime < 10)
          end_time = "0" + startTime + ":00:00"; 
        else
          end_time = ++startTime + ":00:00"; 
      }
      else{
        start_time = startTime + ":00:00";
        end_time = ++startTime + ":00:00";
      }
      
      this.timeFrames.push({
        startTime: start_time,
        endTime: end_time,
        isSelected: false
      })
      
    }
  }
  toggleSelected(event: Event) {
      if (this.timeFrames.isSelected == false)
      this.timeFrames.isSelected = true;
      else 
      this.timeFrames.isSelected = false;
  }
  OnSetSchedule(){
    this.selectedTime=[];
    console.log(this.timeFrames);
    for (let i=0; i<8; ++i){
      if ( this.timeFrames[i].isSelected){
        this.selectedTime.push(this.timeFrames[i].startTime);
      }
    }
    console.log(this.selectedTime + " " +this.selectedTime.length);
    const formData = new FormData();
    formData.append('doctor_id', this.doctorId);
    formData.append('times', this.selectedTime)
    this.http
      .post('http://localhost:8080/doctor/timeFrames', formData)
      .subscribe((data) => console.log(data));

  }


}
