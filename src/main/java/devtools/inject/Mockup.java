package devtools.inject;

import java.lang.reflect.*;
import devtools.helper.FileManager;

public class Mockup {

	public static void main(String args[]){}
	private static FileManager fileManager;

	public static void sout() {
		System.out.println("Print from the library");
	}

	public static void products(Class<Object> listClass, Class<Object> productClass)
			throws NoSuchMethodException, SecurityException {
		Method getInstance = listClass.getDeclaredMethod("getInstance", listClass);
	}

}