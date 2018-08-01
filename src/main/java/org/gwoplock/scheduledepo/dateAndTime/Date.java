package org.gwoplock.scheduledepo.dateAndTime;

import java.time.Year;

class Date {
	private int _day;
	private int _month;
	private int _year;

	private Date() {

	}

	public Date(int day, int month, int year) {
		_day = day;
		_month = month;
		_year = year;
		if (!isValidDate(this)) {
			throw new IllegalArgumentException(
					"The date (" + _day + "/" + _month + "/" + _year + " (D/M/Y)) given was invalid");
		}
	}

	/**
	 * @return the _day
	 */
	public int getDay() {
		return _day;
	}

	/**
	 * @return the _month
	 */
	public int getMonth() {
		return _month;
	}

	/**
	 * @return the _year
	 */
	public int getYear() {
		return _year;
	}

	/**
	 * @param day the _day to set
	 */
	public void setDay(int day) {
		this._day = day;
	}

	/**
	 * @param month the _month to set
	 */
	public void setMonth(int month) {
		this._month = month;
	}

	/**
	 * @param year the _year to set
	 */
	public void setMear(int year) {
		this._year = year;
	}

	public static boolean isValidDate(Date date) {

		int day = date.getDay();
		int month = date.getMonth();
		int year = date.getYear();
		if (day < 1 || month < 1 || month > 12 || year < 1) {
			return false;
		}
		if (month == 2 && isLeapYear(year)) {
			return day <= 29;
		}
		if ((month == 2 && !isLeapYear(year))) {
			return day <= 28;
		}
		if (month <= 7 && month % 2 == 1) {
			return day <= 31;
		}
		if (month <= 7 && month % 2 == 0) {
			return day <= 30;
		}
		if (month > 7 && month % 2 == 1) {
			return day <= 30;
		}
		if (month > 7 && month % 2 == 0) {
			return day <= 31;
		}
		return false;
	}

	public static boolean isLeapYear(int year) {
		return Year.of(year).isLeap();
	}
}