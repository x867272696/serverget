package com.htl.serverget.task;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskCount {

	private AtomicInteger count = new AtomicInteger();

	private final AtomicInteger ai = new AtomicInteger(0);

	public TaskCount(Integer count) {
		this.count.set(count);
	}

	public synchronized void increase() {
		this.count.incrementAndGet();
	}

	public synchronized void decrease() {
		this.count.decrementAndGet();
	}

	public void await() {
		while (ai.get() < count.get()) {
			// ×èÈûµÈ´ýÏß³Ì
		}
	}
	
}
