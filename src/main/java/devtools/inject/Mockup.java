package devtools.inject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.io.IOException;

import devtools.helper.ResourceReader;
import devtools.helper.adaptor.Yaml;

public class Mockup {

	private static ResourceReader resource;
	private static Yaml dataset;

	static {
		try {
			resource = new ResourceReader("dataset.json");
			dataset = Yaml.decode(resource.getBuilder());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void products(Class<?> listClass, Class<?> productClass) {
		Method getInstance;
		try {
			getInstance = listClass.getMethod("getInstance", (Class[]) null);
			try {
				Constructor<?>[] constructors = productClass.getDeclaredConstructors();
				Class<?>[] parameterTypes;
				parameterTypes = constructors[0].getParameterTypes();
				Object product = constructors[0].newInstance("Celular", 0.0, "roubado");
				System.out.println(product);
			} catch (InstantiationException | IllegalArgumentException | InvocationTargetException
					| IllegalAccessException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}