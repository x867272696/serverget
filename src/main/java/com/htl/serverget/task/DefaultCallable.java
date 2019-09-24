package com.htl.serverget.task;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public final class DefaultCallable<V> implements Callable<V>{

	private Method method;
	
	private Object object;
	
	private Object[] params;
	
	private TaskCount taskCount;
	
	public DefaultCallable(Method method, Object object, TaskCount taskCount, Object... params){
		method.setAccessible(true);
		this.method = method;
		this.object = object;
		this.params = params;
		this.taskCount = taskCount;
	}
	
	@SuppressWarnings("unchecked")
	public V call() throws Exception {
		V v = (V) method.invoke(object, params);
		this.taskCount.decrease();
		return v;
	}
	
}