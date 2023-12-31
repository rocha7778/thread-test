package com.rocha.thread.write.read.thread;

/**
 * Several users reading a calendar, but only a few users updating it
 */

import java.util.concurrent.locks.*;

public class CalendarUser extends Thread {

	private static final String[] WEEKDAYS = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	private static int today = 0;
	private static ReentrantLock marker = new ReentrantLock();

	public CalendarUser(String name) {
		this.setName(name);
	}

	public void run() {
		while (today < WEEKDAYS.length - 1) {
			if (this.getName().contains("Writer")) { // update the shared calendar
				marker.lock();
				try {
					today = (today + 1) % 7;
					System.out.println(this.getName() + " updated date to " + WEEKDAYS[today]);
				} catch (Exception e) {
					e.printStackTrace();
				}
				{
					marker.unlock();
				}
			} else { // Reader - check to see what today is
				marker.lock();
				try {
					System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today]);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					marker.unlock();
				}
			}
		}
	}
}
