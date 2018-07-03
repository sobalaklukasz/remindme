package com.hoshi;

import com.hoshi.controller.RecognitionController;
import com.hoshi.observer.PrinterRecognizedWordObserver;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

import java.io.IOException;

public class Apllication {

    public static void main(String[] args) throws IOException {
        RecognitionController recognitionController = new RecognitionController();
        recognitionController.subscribe(new PrinterRecognizedWordObserver());

        LiveRecognizer liveRecognizer = new LiveRecognizer(new LiveSpeechRecognizer(getConfiguration()), recognitionController);

        // on click
        liveRecognizer.start();
        // on click
//        liveRecognizer.stop();
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setGrammarPath("resource:/grammars");
        configuration.setGrammarName("grammar");
        configuration.setUseGrammar(true);
        return configuration;
    }
}

