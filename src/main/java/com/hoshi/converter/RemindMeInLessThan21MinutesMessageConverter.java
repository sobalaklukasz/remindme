package com.hoshi.converter;

import com.hoshi.domain.ProcessedRemindMeMessage;
import com.hoshi.util.TextNumberMapper;
import edu.cmu.sphinx.api.SpeechResult;

class RemindMeInLessThan21MinutesMessageConverter extends RemindMeInXMinutesMessageTemplate {

    @Override
    ProcessedRemindMeMessage processRemindMeMessage(SpeechResult speechResult) {
        return new ProcessedRemindMeMessage(TextNumberMapper.getIntForTextNumber(speechResult.getWords().get(3).getWord().getSpelling()));
    }

    @Override
    boolean isMessageValid(SpeechResult speechResult) {
        return speechResult.getWords().size() == 5 &&
                super.isMessageValid(speechResult) &&
                areMinutesLessThan21(speechResult);
    }

    private boolean areMinutesLessThan21(SpeechResult speechResult) {
        return TextNumberMapper.getIntForTextNumber(speechResult.getWords().get(3).getWord().getSpelling()) < 21;
    }
}
