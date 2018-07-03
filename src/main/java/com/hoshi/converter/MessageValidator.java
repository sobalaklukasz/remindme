package com.hoshi.converter;

import edu.cmu.sphinx.api.SpeechResult;

import java.util.stream.Collectors;

class MessageValidator {

    static boolean checkIsRemindMeInHeaderOk(SpeechResult speechResult) {
        return speechResult.getWords().size() > 3 && speechResult.getWords().subList(0, 3).stream()
                .map(word -> word.getWord().getSpelling())
                .collect(Collectors.joining(" ")).equals("remind me in");
    }

    static boolean checkIsRemindMeInEndingOk(SpeechResult speechResult) {
        String lastWord = speechResult.getWords().get(speechResult.getWords().size() - 1).getWord().getSpelling();
        return lastWord.equals("minute") || lastWord.equals("minutes");
    }

    static boolean checkIsMessageConfidenceOk(SpeechResult speechResult) {

//        speechResult.getWords().forEach(word -> System.out.println(word.getWord().getSpelling() + String.format(" %f", word.getScore())));
//
//        return speechResult.getWords().stream()
//                .map(WordResult::getScore)
//                .noneMatch(score -> score < -190000000);
        return true;
    }
}
