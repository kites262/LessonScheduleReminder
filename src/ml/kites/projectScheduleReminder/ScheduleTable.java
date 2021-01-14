package ml.kites.projectScheduleReminder;

import ml.kites.canlendar.Date;

public class ScheduleTable {

	private String[] lesson = new String[8];
	public static final String day1 = "ZCBMECP";
	public static final String day2 = "EMEZPCB";
	public static final String day3 = "ZZPCBME";
	public static final String day4 = "EBCEMPZ";
	public static final String day5 = "ZEMPZBC";
	public static final String day6 = "EMCPBAA";

	public static final Date.PeriodTime lessonPeriod[] =
			{
					new Date.PeriodTime(6,0,6,30),
					new Date.PeriodTime(8,0,9,30),
					new Date.PeriodTime(9,50,11,20),
					new Date.PeriodTime(14,0,15,30),
					new Date.PeriodTime(15,50,17,20),
					new Date.PeriodTime(18,20,19,50),
					new Date.PeriodTime(20,10,21,40)
			};


	/**
	 * @param day Monday = 1 ... Sunday = 7.
	 */
	public ScheduleTable(int day){
			if(day == 1){
				setTable(toSubject(day1));
			}else if(day == 2){
				setTable(toSubject(day2));
			}else if(day == 3){
				setTable(toSubject(day3));
			}else if(day == 4){
				setTable(toSubject(day4));
			}else if(day == 5){
				setTable(toSubject(day5));
			}else if(day == 6){
				setTable(toSubject(day6));
			}else{
				setTable(toSubject("NNNNNNN"));
			}
	}

	public int indexOfGoingOn(Date.Time t){
		int i;
		main :
		for(i = 0; i <= 6; i++){
			if(lessonPeriod[i].inPeriod(t)){
				break main;
			}
		}
		return i;
	}

	public String getLesson(int i){
		return lesson[i];
	}

	/**
	 *
	 * @param e	A string which has 7 characters, will be translated to Subjects[7] and save to lesson[]
	 * @return The instance of ScheduleTable.
	 */
	private ScheduleTable setTable(Subject[] e){
		lesson[7] = Subject.N.getText();
		if(e.length == 7){
			for(int i = 0; i <= 6; i++){
				lesson[i] = e[i].getText();
			}
		}
		return this;
	}

	private Subject[] toSubject(String s){
		Subject[] sub = new Subject[7];
		if(s.length() == 7){
			char[] key = s.toCharArray();
			for(int i = 0; i <= key.length-1; i++){
					if(key[i] == 'Z'){
						sub[i] = Subject.Chinese;
					}else if(key[i] == 'M'){
						sub[i] = Subject.Math;
					}else if(key[i] == 'E'){
						sub[i] = Subject.English;
					}else if(key[i] == 'P'){
						sub[i] = Subject.Physics;
					}else if(key[i] == 'C'){
						sub[i] = Subject.Chemistry;
					}else if(key[i] == 'B'){
						sub[i] = Subject.Biology;
					}else if(key[i] == 'A'){
						sub[i] = Subject.Exam;
					}else{
						sub[i] = Subject.N;
					}
			}
		}
		return sub;
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i = 0; i <= 6; i++){
			s.append(i+". ");
			s.append(toPeriod(i));
			s.append("  ");
			s.append(lesson[i]);
			if(i != 6){
				s.append("\n");
			}
		}
		return s.toString();
	}

	private String toPeriod(int i){
		String r;
		if(i == 0){
			r = "06:00 - 06:30";
		}else if(i == 1){
			r = "08:00 - 09:30";
		}else if(i == 2){
			r = "09:50 - 11:20";
		}else if(i == 3){
			r = "14:00 - 15:30";
		}else if(i == 4){
			r = "15:50 - 17:20";
		}else if(i == 5){
			r = "18:20 - 19:50";
		}else if(i == 6){
			r = "20:10 - 21:40";
		}else{
			r = "null";
		}
		return r;
	}
}

enum Subject{
	Chinese("Chinese"),
	Math("Math"),
	English("English"),
	Physics("Physics"),
	Chemistry("Chemistry"),
	Biology("Biology"),
	Exam("Exam"),
	N("Nothing");

	private String text;
	Subject(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}
}