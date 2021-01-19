package ml.kites.projectScheduleReminder;

import ml.kites.canlendar.Date;
public class RemainTimeHandler {
	private ScheduleTable sc;
	private Date.Time time;
	private int index;

	public RemainTimeHandler(ScheduleTable sc, Date.Time now){
		this.sc = sc;
		this.time = now;
		index = indexOfGoingOn();
	}

	public int getNextRemain(){
		if (7 == index) return getRestRemain();
		else return getLessonRemain();
	}

	private int getRestRemain(){
		RemainTimeHandler rt = new RemainTimeHandler(sc, time);
		int t = time.toInt();
		int index;
		for(; 7 == rt.setTime(new Date.Time(t)).indexOfGoingOn(); t += 20){}
		index = rt.setTime(new Date.Time(t)).indexOfGoingOn();
		return ScheduleTable.lessonPeriod[index].getStart().toInt() - time.toInt();
	}

	private int getLessonRemain(){
		return ScheduleTable.lessonPeriod[index].getEnd().toInt() - time.toInt();
	}

	public int indexOfGoingOn(){
		int i;
		loop:
		for(i = 0; i <= 6; i++){
			if(sc.lessonPeriod[i].inPeriod(time)){
				break loop;
			}
		}
		return i;
	}

	public int getIndex(){
		return index;
	}

	public RemainTimeHandler setTime(Date.Time time){
		this.time = time;
		return this;
	}
}
