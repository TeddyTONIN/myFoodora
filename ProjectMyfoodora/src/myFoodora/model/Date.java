package myFoodora.model;

public class Date {
	int day;
	int month;
	int year;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
	public boolean isBefore(Date date) {
		boolean result=false;
		if (date.year>=this.year) {
			if(date.month>=this.month) {
				if(date.day>=this.day) {
					result=true;
				}
			}
		}
		return (result);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this)return true;
		if(obj!=null && obj.getClass()==this.getClass()) {
			return((Date)obj).day==this.day && ((Date)obj).month==this.month && ((Date)obj).year==this.year;
		}
		return false;
	}


	@Override
	public String toString() {
		return "Date:" + day + "/" + month + "/" + year;
	}
	
}
