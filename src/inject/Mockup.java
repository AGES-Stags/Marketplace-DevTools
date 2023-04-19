package inject;

import java.io.IOException;
import java.lang.reflect.*;

import helper.FileManager;

public class Mockup {

	private static FileManager fileManager;
	static {
		try {
			fileManager = new FileManager("config.yaml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

	}

	public static void test() {
		System.out.println("test");
	}

	public static void products(Class<Object> listClass, Class<Object> productClass)
			throws NoSuchMethodException, SecurityException {
		Method getInstance = listClass.getDeclaredMethod("getInstance", listClass);
	}

}