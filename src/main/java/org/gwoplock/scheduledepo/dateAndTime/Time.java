package org.gwoplock.scheduledepo.dateAndTime;

import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Time {
	private double _timeZone;
	private int _hour;
	private int _min;
	private int _second;

	private Time() {

	}

	public Time(int hr, int min) {
		this(hr, min, getCurrentTimeZone());
	}

	public Time(int hr, int min, double tz) {
		this(hr, min, 0, tz);
	}

	public Time(int hr, int min, int sec) {
		this(hr, min, sec, getCurrentTimeZone());
	}

	public Time(int hr, int min, int sec, double tz) {
		_hour = hr;
		_min = min;
		_second = sec;
		_timeZone = tz;
		if (!isValidTime(this)) {
			throw new IllegalArgumentException("The time given (" + _hour + _min + _second + ") is invalid");
		}
	}

	/**
	 * @return the _hour
	 */
	public int getHour() {
		return _hour;
	}

	/**
	 * @return the _min
	 */
	public int getMin() {
		return _min;
	}

	/**
	 * @return the _second
	 */
	public int getSecond() {
		return _second;
	}

	/**
	 * @return the _timeZone
	 */
	public double getTimeZone() {
		return _timeZone;
	}

	/**
	 * @param _hour the _hour to set
	 */
	public void setHour(int _hour) {
		this._hour = _hour;
	}

	/**
	 * @param _min the _min to set
	 */
	public void setMin(int _min) {
		this._min = _min;
	}

	/**
	 * @param _second the _second to set
	 */
	public void setSecond(int _second) {
		this._second = _second;
	}

	/**
	 * @param _timeZone the _timeZone to set
	 */
	public void setTimeZone(double _timeZone) {
		this._timeZone = _timeZone;
	}

	public static double getCurrentTimeZone() {
		String offset = getCurrentTimezoneOffset();
		int minSepLoc = offset.indexOf(":");
		String hrOffsetStr = offset.substring(0, minSepLoc);
		int hrOffset = Integer.parseInt(hrOffsetStr);
		String minOffsetStr = offset.substring(minSepLoc + 1, offset.length());
		int minOffset = Integer.parseInt(minOffsetStr);
		return (hrOffset + ((double) minOffset / (double) 60));
	}

	public static boolean isValidTime(Time time) {
		int hr = time.getHour();
		int min = time.getMin();
		int sec = time.getSecond();
		return hr > 0 || hr < 24 || min > 0 || min < 60 || sec > 0 || sec < 60;
	}

	public static String getCurrentTimezoneOffset() {

		TimeZone tz = TimeZone.getDefault();
		Calendar cal = GregorianCalendar.getInstance(tz);
		int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

		String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000),
				Math.abs((offsetInMillis / 60000) % 60));
		offset = (offsetInMillis >= 0 ? "+" : "-") + offset;
		return offset;
	}

}