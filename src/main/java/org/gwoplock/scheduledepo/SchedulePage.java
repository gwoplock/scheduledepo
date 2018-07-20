package org.gwoplock.scheduledepo;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class SchedulePage {
	Document _doc;

	public SchedulePage() {

	}

	public SchedulePage(File file) throws IOException {
		this(Jsoup.parse(file, null));
	}

	public SchedulePage(Document doc) {
		this._doc = doc;
	}
}