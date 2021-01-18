import ml.kites.projectScheduleReminder.ScheduleTable;
import ml.kites.canlendar.Date;

import java.util.Calendar;

public class ScheduleReminder {
	
	public static final Calendar date = Calendar.getInstance();
	public static void main(String[] args) {
		Date.Time now = new Date.Time(date.get(Calendar.HOUR_OF_DAY),date.get(Calendar.MINUTE));
		ScheduleTable sc =new ScheduleTable(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1);
		int lessonIndexNow = sc.indexOfGoingOn(now);

		System.out.println("Good day, flew_kites!");
		System.out.println(date.get(Calendar.DATE) + "," + Date.Month.toMonth(date.get(Calendar.MONTH)) + "," + date.get(Calendar.YEAR) + " | " + now + " now.");
		System.out.println("--> " + sc.getLesson(lessonIndexNow) + " <--");
		System.out.println("\tis going on");
		if(lessonIndexNow != 7){
			System.out.println(
					"* Index "
					+ lessonIndexNow
			);
			System.out.println(
					"* "
							+ (ScheduleTable.lessonPeriod[lessonIndexNow].getEnd().toInt() - now.toInt())
							+ " min remaining"
			);
			System.out.println(
					"\t[ "
					+ ScheduleTable.lessonPeriod[lessonIndexNow]
					+ " ]"
			);
		}
		System.out.println("Today's schedule: ");
		System.out.println(sc);

		try{
			Thread.sleep(8000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
