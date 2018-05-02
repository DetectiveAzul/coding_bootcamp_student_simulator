package com.detectiveazul.codeclanstudentsimulator.model.constants;

import com.detectiveazul.codeclanstudentsimulator.R;

import java.io.Serializable;

public enum GameStatus implements Serializable {
    WIN(R.string.win),
    LOSE(R.string.lose),
    IN_PROGRESS(R.string.in_progress);

    private final int endSceneString;

    GameStatus(int endSceneString) {
        this.endSceneString = endSceneString;
    }

    public int getEndSceneString() {
        return endSceneString;
    }
}
