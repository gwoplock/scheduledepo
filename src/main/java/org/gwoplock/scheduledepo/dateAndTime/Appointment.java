package org.gwoplock.scheduledepo.dateAndTime;

class Appointment {
	private Date _startDate;
	private Time _startTime;
	private Date _endDate;
	private Time _endTime;

	private Appointment() {

	}

	public Appointment(Date startDate, Time starTime, Date endDate, Time endTime) {
		_startDate = startDate;
		_startTime = starTime;
		_endDate = endDate;
		_endTime = endTime;
	}

	public Appointment(Date startDate, Date endDate) {
		this(startDate, new Time(0, 0), endDate, new Time(23, 59, 59));
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

}