package org.gwoplock.scheduledepo.dateAndTime;

enum TIMEZONE {
	EASTERN, CENTRAL, MOUNTAN, PASIFIC
}

class Time {
	private TIMEZONE _timeZone;
	private int _hour;
	private int _min;
	private int _second;
}