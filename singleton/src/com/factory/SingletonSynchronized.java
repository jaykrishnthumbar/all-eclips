package com.factory;

public class SingletonSynchronized {

	private static SingletonSynchronized instance;

	private SingletonSynchronized() {

	}

	private static SingletonSynchronized getInstance() {
		
		if(instance==null) {
			synchronized (SingletonSynchronized.class) {
				if(instance==null) {
					instance = new SingletonSynchronized();
				}
			}
		}
		
		return instance;
	}

	public static void main(String[] args) {
		SingletonSynchronized instance = SingletonSynchronized                         .getInstance();
		System.out.println(instance);
	}

}
