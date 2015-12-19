import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
 
public class Engine {
 
    public static void main(String[] args) throws Exception {
 
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
 
        Object operation = engine.eval("sin(9)");
 
        System.out.println("Evaluado operacion 1: " + operation);
 
    }
}