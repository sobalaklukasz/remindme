package com.hoshi.converter;

import com.hoshi.domain.ProcessedRemindMeMessage;
import com.hoshi.util.TextNumberMapper;
import edu.cmu.sphinx.api.SpeechResult;

class RemindMeInBetween21And99MinutesMessageConverter extends RemindMeInXMinutesMessageTemplate {

    @Override
    ProcessedRemindMeMessage processRemindMeMessage(SpeechResult speechResult) {
        return new ProcessedRemindMeMessage(TextNumberMapper.getIntForTextNumber(speechResult.getWords().get(3).getWord().getSpelling())
                + TextNumberMapper.getIntForTextNumber(speechResult.getWords().get(4).getWord().getSpelling()));
    }

    @Override
    boolean isMessageValid(SpeechResult speechResult) {
        return speechResult.getWords().size() == 6 &&
                super.isMessageValid(speechResult) &&
                areFirstMinutesMoreThan20(speechResult) &&
                areSecondMinutesLessThan10(speechResult);
    }

    private boolean areFirstMinutesMoreThan20(SpeechResult speechResult) {
        return TextNumberMapper.getIntForTextNumber(speechResult.getWords().get(3).getWord().getSpelling()) >= 20;
    }

    private boolean areSecondMinutesLessThan10(SpeechResult speechResult) {
        return TextNumberMapper.getIntForTextNumber(speechResult.getWords().get(4).getWord().getSpelling()) < 10;
    }
}
