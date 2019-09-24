package com.htl.serverget.task;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

import com.htl.serverget.pool.FixedThreadPool;

public class Task {

	private TaskCount taskCount = new TaskCount(0);

	public synchronized <V> Future<V> put(Method method, Object object, Object... params) {

		this.taskCount.increase();
		DefaultCallable<V> callable = new DefaultCallable<V>(method, object, this.taskCount, params);
		Future<V> future = FixedThreadPool.getInstance().submit(callable);
		return future;

	}

	public void await() {
		taskCount.await();
	}

}
