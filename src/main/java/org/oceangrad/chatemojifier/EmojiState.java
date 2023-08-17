package org.oceangrad.chatemojifier;

public enum EmojiState {
    NONE (0),
    EMOJI (1),
    CENSORED (2);
    private int ID;

    EmojiState(int id) {
        this.ID = id;
    }

    public int getID(){
        return ID;
    }

    public static EmojiState getStateByID(int id){
        for(EmojiState state : values()) {
            if(state.ID == id) return state;
        }
        return EmojiState.NONE;
    }

    @Override
    public String toString() {
        return "EmojiState{" +
                "ID='" + ID + '\'' +
                '}';
    }
}
