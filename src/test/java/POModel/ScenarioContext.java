package POModel;

import Browsers.ContextType;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String,Object>scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(ContextType key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(ContextType key){
        return scenarioContext.get(key.toString());
    }

    public Boolean contains(ContextType key){
        return scenarioContext.containsKey(key.toString());
    }
}
