import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Nashorn {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		engine.eval("function sum(a,b){return a+b;}"
				+ "function getPair(){var data= [1,2,3,4,5,6,7,8,9,10,323,43,12,435,346,789,234,542,234,542,234,542,34,65,234,234]; "
				+ "var filtered = data.filter(function(i){return i%2 == 0}); "
				+ "var list = Java.type('java.lang.String[]'); "
				+ "return Java.to(filtered, list);}");
		
		
		String [] a = (String[]) engine.eval("getPair();");
		System.out.println("Soma "+ engine.eval("sum(1,2);"));
		for (String string : a) {
			System.out.println(string);
		}
//		System.out.println(a);
//		System.out.println("Pair "+ engine.eval("getPair();"));
//		for (String string : list) {
//			System.out.println(string);
//		}
		
	}
	
	
}
