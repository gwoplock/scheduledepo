package org.gwoplock.scheduledepo.dateAndTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;;

public class Appointment {
	private Date _startDate;
	private Time _startTime;
	private Date _endDate;
	private Time _endTime;
	private String _name;
	private final String LINE_SEP = "\r\n";

	private Appointment() {

	}

	public Appointment(Date startDate, Time starTime, Date endDate, Time endTime) {
		this(startDate, starTime, endDate, endTime, "Appointment");
	}

	public Appointment(Date startDate, Date endDate) {
		this(startDate, new Time(0, 0), endDate, new Time(23, 59, 59));
	}

	public Appointment(Date startDate, Time starTime, Date endDate, Time endTime, String name) {
		_startDate = startDate;
		_startTime = starTime;
		_endDate = endDate;
		_endTime = endTime;
		_name = name;
	}

	public Appointment(Date startDate, Date endDate, String name) {
		this(startDate, new Time(0, 0), endDate, new Time(23, 59, 59), name);
	}

	/**
	 * @return the _endDate
	 */
	public Date getendDate() {
		return _endDate;
	}

	/**
	 * @return the _endTime
	 */
	public Time getendTime() {
		return _endTime;
	}

	/**
	 * @return the _startDate
	 */
	public Date getstartDate() {
		return _startDate;
	}

	/**
	 * @return the _startTime
	 */
	public Time getstartTime() {
		return _startTime;
	}

	/**
	 * @param _endDate the _endDate to set
	 */
	public void setendDate(Date _endDate) {
		this._endDate = _endDate;
	}

	/**
	 * @param _endTime the _endTime to set
	 */
	public void setendTime(Time _endTime) {
		this._endTime = _endTime;
	}

	/**
	 * @param _startDate the _startDate to set
	 */
	public void setstartDate(Date _startDate) {
		this._startDate = _startDate;
	}

	/**
	 * @param _startTime the _startTime to set
	 */
	public void setstartTime(Time _startTime) {
		this._startTime = _startTime;
	}

	/**
	 * @return the _name
	 */
	public String getname() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void setname(String _name) {
		this._name = _name;
	}

	public void buildiCalFile() throws FileNotFoundException, IOException {
		buildiCalFile(_name);
	}

	public void buildiCalFile(String path) throws FileNotFoundException, IOException {
		File icalFile = new File(path);
		FileWriter iCalOStream = new FileWriter(icalFile);
		iCalOStream.write("BEGIN:VCALENDAR" + LINE_SEP + "VERSION:2.0" + LINE_SEP + "PRODID:scheduledepo v1.0-SNAPSHOT"
				+ LINE_SEP + "BEGIN:VEVENT" + LINE_SEP + "UID:" + toString() + "D" + _startDate + "T" + _startTime
				+ LINE_SEP + "DTSTAMP:" + getCurrentTime());
	}

	public static String getCurrentTime() {
		return ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmSS'Z'"));
	}

}