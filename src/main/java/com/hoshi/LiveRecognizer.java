package com.hoshi;

import com.hoshi.controller.RecognitionController;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LiveRecognizer {

    private Logger logger = Logger.getLogger(LiveRecognizer.class.getName());

    private boolean speechRecognizerThreadRunning;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public LiveRecognizer(LiveSpeechRecognizer recognizer, RecognitionController recognitionController) {
        executor.submit(() -> {
            recognizer.startRecognition(true);
            while (speechRecognizerThreadRunning) {
                try {
                    recognitionController.onNewRecognization(recognizer.getResult());
                } catch (Throwable ex) {
                    logger.log(Level.INFO, String.format("Error on report: %s", recognizer.getResult().getHypothesis()), ex);
                }
            }
        });
    }

    public void start() {
        speechRecognizerThreadRunning = true;
    }

    public void stop() {
        speechRecognizerThreadRunning = false;
    }

    public void shutdown() {
        stop();
        executor.shutdown();
    }
}
