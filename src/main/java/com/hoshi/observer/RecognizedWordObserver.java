package com.hoshi.observer;

import edu.cmu.sphinx.api.SpeechResult;

public interface RecognizedWordObserver {

    void reportNewRecognition(SpeechResult speechResult);
}
