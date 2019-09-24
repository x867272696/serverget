package com.htl.serverget.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class FixedThreadPool {
	
	private volatile static ExecutorService fixedThreadPool = null;
	
	private FixedThreadPool(){}
	
	public static ExecutorService getInstance(){
		if(fixedThreadPool == null){
			synchronized(FixedThreadPool.class){
				if(fixedThreadPool == null){
					fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
					System.out.println("当前操作系统内核数量为: " + Runtime.getRuntime().availableProcessors());
				}
			}
		}
		return fixedThreadPool;
	}

}
