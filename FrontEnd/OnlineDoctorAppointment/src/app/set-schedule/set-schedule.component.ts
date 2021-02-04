import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-set-schedule',
  templateUrl: './set-schedule.component.html',
  styleUrls: ['./set-schedule.component.css']
})
export class SetScheduleComponent implements OnInit {

  timeFrames: any =[];
  selectedTime: string[];
  doctorId =1;
  isChecked:boolean = false;

  constructor() { }

  ngOnInit(): void {
    let startTime = 9;
    for (let i=1; i<=8; ++i){
      this.timeFrames.push({
        startTime: startTime + ":00:00",
        endTime: ++startTime + ":00:00",
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
    console.log(this.timeFrames.startTime +" "+ this.timeFrames.isSelected);
  }

}
