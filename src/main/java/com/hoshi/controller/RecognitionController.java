package com.hoshi.controller;

import com.hoshi.observer.RecognizedWordObserver;
import edu.cmu.sphinx.api.SpeechResult;

import java.util.LinkedList;
import java.util.List;

public class RecognitionController {

    private List<RecognizedWordObserver> observers;

    public RecognitionController() {
        this.observers = new LinkedList<>();
    }

    public void subscribe(RecognizedWordObserver recognizedWordObserver) {
        observers.add(recognizedWordObserver);
    }

    public void unsubscribe(RecognizedWordObserver recognizedWordObserver) {
        observers.remove(recognizedWordObserver);
    }

    public void onNewRecognization(SpeechResult speechResult) {
        observers.forEach(o -> o.reportNewRecognition(speechResult));
    }
}
