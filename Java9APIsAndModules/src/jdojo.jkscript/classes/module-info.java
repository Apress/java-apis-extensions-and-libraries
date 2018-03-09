// module-info.java
module jdojo.jkscript {
    requires java.scripting;    
    provides javax.script.ScriptEngineFactory with com.jdojo.jkscript.JKScriptEngineFactory;    
}
