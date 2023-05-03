package com.factory;

class LazyInitilaization {

	private static LazyInitilaization instance;

	private LazyInitilaization() {
	}

	public static LazyInitilaization getInstance() {
		if (instance == null) {
			instance = new LazyInitilaization();
		}
		return instance;
	}

	public static void main(String a[]) {
		LazyInitilaization instance = LazyInitilaization.getInstance();
		System.out.println(instance);
	}
}