import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import test.IHello;

public class Main {
	public static void main(String[] args) {
		String className = "Script.groovy";
		IHello x = getInstancia(className);
		x.ola();
		x.tela();
	}
	@SuppressWarnings("unchecked")
	public static <T extends Object> T getInstancia(String fileName) {
		File contentScript = new File(fileName);
		ScriptEngineManager engines = new ScriptEngineManager();
		ScriptEngine engine = engines.getEngineByName("groovy");
		try {
			Class<?> classe = (Class<?>) engine.eval(new FileReader(contentScript));
			return (T) classe.newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Class<?> getScript(String file) {
		File scriptFile = new File(file);
		ScriptEngineManager engines = new ScriptEngineManager();
		ScriptEngine engine = engines.getEngineByName("groovy");
		try {
			return (Class<?>) engine.eval(new FileReader(scriptFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void envocaMetodo(String file, String metodo) {
		Class<?> c1 = (Class<?>) getScript(file);
		Method salute;
		try {
			salute = c1.getMethod(metodo);
			Object obj = c1.newInstance();
			salute.invoke(obj);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
