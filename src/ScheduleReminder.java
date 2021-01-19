import ml.kites.projectScheduleReminder.RemainTimeHandler;
import ml.kites.projectScheduleReminder.ScheduleTable;
import ml.kites.canlendar.Date;

import java.util.Calendar;

public class ScheduleReminder {
	
	public static final Calendar date = Calendar.getInstance();
	public static void main(String[] args) {
		Date.Time now = new Date.Time(date.get(Calendar.HOUR_OF_DAY),date.get(Calendar.MINUTE));
		ScheduleTable sc =new ScheduleTable(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1);
		RemainTimeHandler rt = new RemainTimeHandler(sc,now);
		int lessonIndexNow = rt.indexOfGoingOn();

		System.out.println("Good day, flew_kites!");
		System.out.println(date.get(Calendar.DATE) + "," + Date.Month.toMonth(date.get(Calendar.MONTH)) + "," + date.get(Calendar.YEAR) + " | " + now + " now.");
		System.out.println("--> " + sc.getLesson(lessonIndexNow) + " <--");
		System.out.println("\tis going on");
		System.out.println(
				"* "
				+rt.getNextRemain()
				+" min remaining."
		);
		System.out.println(sc);

		try{
			Thread.sleep(8000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
