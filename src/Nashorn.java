import java.util.Arrays;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Nashorn {

	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		engine.eval("function sum(a,b){return a+b;}"
				+ "function getPair(){var data= [1,2,3,4,5,6,7,8,9,10,323,43,12,435,346,789,234,542,234,542,234,542,34,65,234,128]; "
				+ "var filtered = data.filter(function(i){return i%2 == 0}); "
				+ "var list = Java.type('int[]'); "
				+ "return Java.to(filtered, list);}"
				+ "function sumNumberPar(array){"
//				+ "var int = Java.type('int[]'); "
				+ "var jsArray = Java.from(array);"
//				+ "print(jsArray);"
				+ "var sumNumber = jsArray.reduce(function(acc, next){return acc + next},0);"
//				+ "var intJava = Java.type('java.lang.Integer');"
//				+ "return Java.to(a, intJava)},0);"
//				+ "print(sumNumber);"
				+ "return sumNumber;" 
				+ "}");
		
		
		int [] a = (int[]) engine.eval("getPair();");
		for (int i : a) {
			System.out.println(i);
		}
		//		System.out.println("Soma "+ engine.eval("sum(1,2);"));
//		for (String string : a) {
//			System.out.println(string);
//		}
	
		Invocable invocable = (Invocable) engine;
		
		
		Object result = invocable.invokeFunction("sumNumberPar", a);
		
		System.out.println("SUM "+result);
//		System.out.println(a);
//		System.out.println("Pair "+ engine.eval("getPair();"));
//		for (String string : list) {
//			System.out.println(string);
//		}
		
	}
	
	
}
