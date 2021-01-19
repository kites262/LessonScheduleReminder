package ml.kites.canlendar;

public class Date {
	public static class Month{
		public static final String[] month = {"Null","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};

		/**
		 *
		 * @param i 1 = "Jan",2 = "Feb" ... 12 = "Dec", and 0 = "Null"
		 * @return That depends on i :1 = "Jan",2 = "Feb" ... 12 = "Dec", and 0 = "Null"
		 */
		public static String toMonth(int i){
			return i >= 0 && i <=12 ? month[i+1] : month[0];
		}
	}

	public static class Second{

	}

	public static class Minute{
		private int value;

		public Minute(int m){
				value = m;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int value() {
			return value;
		}

		public static Minute toMinute(int m){
			return new Minute(m);
		}
	}

	public static class Hour{
		private int value;
		public Hour(int h){
				value = h;
		}
		public void setValue(int value) {
			this.value = value;
		}

		public int value() {
			return value;
		}

		public Hour toHour(int h){
			return new Hour(h);
		}
	}

	public static class Time{
		private Hour hour;
		private Minute minute;

		public Time(int h, int m){
			hour = new Hour(h);
			minute = new Minute(m);
		}

		public Time(int value){
			hour = new Hour(0);
			minute = new Minute(value);
		}

		public Hour getHour() {
			return hour;
		}

		public Minute getMinute() {
			return minute;
		}

		public void setHour(Hour hour) {
			this.hour = hour;
		}

		public void setMinute(Minute minute) {
			this.minute = minute;
		}

		public static Time toTime(int h,int m){
			return new Time(h,m);
		}

		public int toInt(){
			return getHour().value() * 60 + getMinute().value();
		}

		public String toString(){
			StringBuilder s = new StringBuilder();
			if(getHour().value() <= 9 && getHour().value() >= 0){
				s.append("0");
			}
			s.append(getHour().value());
			s.append(":");
			if(getMinute().value() <= 9 && getMinute().value() >= 0){
				s.append("0");
			}
			s.append(getMinute().value());
			return s.toString();
		}
	}

	public static class PeriodTime{
		private Time start;
		private Time end;

		public PeriodTime(Time s,Time e){
			start = s;
			end = e;
		}

		public PeriodTime(int sh,int sm,int eh,int em){
			start = new Time(sh,sm);
			end = new Time(eh,em);
		}

		public void setEnd(Time end) {
			this.end = end;
		}

		public void setStart(Time start) {
			this.start = start;
		}

		public Time getEnd() {
			return end;
		}

		public Time getStart() {
			return start;
		}

		public boolean inPeriod(Time t){
			return
					start.toInt() <= t.toInt()
					&&end.toInt() >= t.toInt()
					;
		}

		public String toString(){
			return start.toString() + " - " + end.toString();
		}
	}
}
