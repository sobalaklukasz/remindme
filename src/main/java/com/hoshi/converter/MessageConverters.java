package com.hoshi.converter;

import com.google.common.collect.Lists;
import com.hoshi.domain.ProcessedRemindMeMessage;
import edu.cmu.sphinx.api.SpeechResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MessageConverters {

    private static final List<RemindMeInXMinutesMessageTemplate> converters = Arrays.asList(
            new RemindMeInBetween21And99MinutesMessageConverter(),
            new RemindMeInLessThan21MinutesMessageConverter()
    );

    public static ProcessedRemindMeMessage convertMessage(SpeechResult speechResult) {
        List<RemindMeInXMinutesMessageTemplate> convert = converters.stream()
                .filter(converter -> converter.isMessageValid(speechResult))
                .collect(Collectors.toList());

        if (convert.size() != 1) {
            throw new IllegalArgumentException(String.format("Found not 1 but %s convert(s) to handle message", convert.size()));
        } else {
            return convert.get(0).processRemindMeMessage(speechResult);
        }
    }
}
