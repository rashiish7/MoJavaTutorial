package com.tutorials_point.DesignPatterns.AdapterPattern;

public class ConsoleLogWriter2 extends ConsoleWriter implements LogWriter {

	@Override
	public void out(String text) {
		writeConsole(text);
	}

}
