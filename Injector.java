package jlab5;

import java.lang.reflect.*;
import java.util.Properties;
import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.*;

/**
 * MyAnalyzer of annotation AutoInjector
 * @author enikeili
 */
@SupportedAnnotationTypes("AutoInjector")
public class Injector
{
	private String pathToPropertiesFile;
	/**
	 * Constructor with parameter for class Injector, set given path to pathToPropertiesFile
	 * @param path path to file with properties for annotation analyzer
	 */
	public Injector(String path)
	{
		pathToPropertiesFile=path;
	};
	/**
	 * Finds fields with annotation AutoInjectable and initializes there objects into line with implements of interface (data is in properties file) 
	 * @param object an object of some class
	 * @return initialized object
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public <T> T inject(T object) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException, IOException
	{
		Properties props = new Properties();
		props.load(new FileInputStream(pathToPropertiesFile));
		Class _class = object.getClass();
		Field[] fields = _class.getDeclaredFields();
		for(Field f: fields)
		{
			Annotation a = f.getAnnotation(AutoInjectable.class); 
			f.setAccessible(true);
			if (a!=null)
			{
				String type = props.getProperty(f.getType().getName());
				Object object_class = Class.forName(type).newInstance();
				f.set(object, object_class);
			}
		}
		return object;
	}
}
