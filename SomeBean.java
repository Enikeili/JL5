package jlab5;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class with two fields with annotations
 * @author enikeili
 */
public class SomeBean
{
	@AutoInjectable 
	private SomeInterface field1; 
	@AutoInjectable 
	private SomeOtherInterface field2; 
	/**
	 * Runs method doSomething for two fields, implements of method depends on file with properties for annotation analyzer 
	 */
	public void foo()
	{
		field1.doSomething(); 
	    field2.doSomething(); 
	}
	/**
	 * Builds two objects of class with annotation, runs method foo for there objects
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException, IOException
	{
		Injector inj1 = new Injector("C:\\Users\\Jeldar\\eclipse-workspace\\jlab5\\resource\\prop1.properties");
		SomeBean sb1 = inj1.inject(new SomeBean());
		sb1.foo();
		Injector inj2 = new Injector("C:\\Users\\Jeldar\\eclipse-workspace\\jlab5\\resource\\prop2.properties");
		SomeBean sb2 = inj2.inject(new SomeBean());
		sb2.foo();
	}
}