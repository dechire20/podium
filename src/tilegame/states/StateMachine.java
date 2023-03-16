package tilegame.states;

import java.util.HashMap;

public class StateMachine {

    public enum STATESENUM{
        HOMESTATE,
        GAMESTATE
    }

    private final HashMap<STATESENUM, State> states = new HashMap<>();
    private State currentState;
    private STATESENUM currentToken;
    private static StateMachine instance;
    private StateMachine(){
        currentState = null;
    }

    public static StateMachine getInstance(){
        if (instance == null){
            instance = new StateMachine();
        }
        return instance;
    }

    public void addState(STATESENUM key, State state){
        states.put(key, state);
    }
    public void setCurrentState(STATESENUM key) {
        currentState = states.get(key);
        currentToken = key;
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public STATESENUM getCurrentStateKey(){
        return currentToken;
    }

}
