package org.usfirst.frc.team869.robot;

import java.util.LinkedList;
import java.util.List;

public class Initializables {
	private static final List<Initializable> initializables = new LinkedList<>();
	private static boolean isInitialized = false;
	
	public static synchronized void register(Initializable initable) {
		initializables.add(initable);
	}
	
	public static synchronized void init() {
		if (!isInitialized) {
			for (Initializable initializable : initializables) {
				initializable.init();
			}
			isInitialized = true;
		}
	}
}
