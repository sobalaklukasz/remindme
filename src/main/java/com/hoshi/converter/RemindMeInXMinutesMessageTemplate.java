package com.hoshi.converter;

import com.hoshi.domain.ProcessedRemindMeMessage;
import edu.cmu.sphinx.api.SpeechResult;

abstract class RemindMeInXMinutesMessageTemplate {

    abstract ProcessedRemindMeMessage processRemindMeMessage(SpeechResult speechResult);

    boolean isMessageValid(SpeechResult speechResult) {
        return MessageValidator.checkIsRemindMeInHeaderOk(speechResult) &&
                MessageValidator.checkIsRemindMeInEndingOk(speechResult) &&
                MessageValidator.checkIsMessageConfidenceOk(speechResult);
    }
}