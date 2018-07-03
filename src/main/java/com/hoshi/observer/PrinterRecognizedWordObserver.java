package com.hoshi.observer;

import com.hoshi.converter.MessageConverters;
import com.hoshi.domain.ProcessedRemindMeMessage;
import edu.cmu.sphinx.api.SpeechResult;

public class PrinterRecognizedWordObserver implements RecognizedWordObserver {

    @Override
    public void reportNewRecognition(SpeechResult speechResult) {
        ProcessedRemindMeMessage message = MessageConverters.convertMessage(speechResult);
        System.out.println(String.format("You said %s minutes", message.getMinutes()));
    }
}
