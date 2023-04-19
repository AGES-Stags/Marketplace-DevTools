package inject;

import java.io.IOException;
import java.lang.reflect.*;

import helper.FileManager;

public class Mockup {

	private static FileManager fileManager;

	public static void sout() {
		System.out.println("Print from the library");
	}

	public static void products(Class<Object> listClass, Class<Object> productClass)
			throws NoSuchMethodException, SecurityException {
		Method getInstance = listClass.getDeclaredMethod("getInstance", listClass);
	}

}