package com.detectiveazul.codeclanstudentsimulator.model.constants;

import java.io.Serializable;

public enum GameStatus implements Serializable {
    WIN("Congratulations! You have complete the coding intensive program!"),
    LOSE("It's a shame, but you fail!"),
    IN_PROGRESS("Game is still in progress");

    private final String endSceneString;

    GameStatus(String endSceneString) {
        this.endSceneString = endSceneString;
    }

    public String getEndSceneString() {
        return endSceneString;
    }
}
