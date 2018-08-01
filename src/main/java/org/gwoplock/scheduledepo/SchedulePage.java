package org.gwoplock.scheduledepo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class SchedulePage {
	private Document _doc;
	private ArrayList<Element> _daysWorking = null;

	private SchedulePage() {

	}

	public SchedulePage(File file) throws IOException {
		this(Jsoup.parse(file, null));
	}

	public SchedulePage(Document doc) {
		this._doc = doc;
	}

	public ArrayList<Element> getDaysWorking() {
		if (_daysWorking == null) {
			_daysWorking = new ArrayList<Element>();
			Elements hours = _doc.getElementsByClass("hours");
			for (Element hour : hours) {
				if (hour.parent().hasClass("child8")) {

				} else {
					_daysWorking.add(hour.parent());
				}
			}
		}
		return _daysWorking;
	}
}