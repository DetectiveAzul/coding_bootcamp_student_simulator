package com.detectiveazul.codeclanstudentsimulator.model.decks;

public class ModuleDeck extends Deck {
    public ModuleDeck(int module) {
        super(module, 20);
        populateDeck();
    }

    //A special kind of Deck that already has a size (20) and only asks for the module variable
}
