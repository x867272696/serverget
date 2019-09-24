package com.htl.serverget.task;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MyTask {

	public static String getData(String url) {
		RestTemplate rt = new RestTemplate();
		HttpHeaders hh = new HttpHeaders();
		// hh.add("InnaiTypeMark", "1");
		HttpEntity he = new HttpEntity(hh);

		ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, he, String.class);

		System.out.println(Thread.currentThread().getName() + ": " + response.getBody());
		return response.getBody();
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		long st = System.currentTimeMillis();
		MyTask mt = new MyTask();
		Task task = new Task();
		for (int i = 1; i <= 100; i++) {
			task.put(mt.getClass().getDeclaredMethod("getData", String.class), mt,
					"http://rtfront.com/rtfrontier/api/v2/front/banner/getBanners");
		}
		task.await();
		System.out.println("共花费时间: " + (System.currentTimeMillis() - st) + "毫秒");
	}

}
