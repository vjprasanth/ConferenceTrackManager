package co.uk.prash.ctm.registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by prasanth on 19/10/2014.
 */
public class ConferenceRegistration {

    private static final String LIGHTNING = "lightning";
    private static final int LIGHTNING_TALK_DURATION = 5;
    private static final String TALK_REGEX = "(.*)[\\s](([\\d]*)min|lightning)";
    private List<Talk> registeredTalks;

    private final Pattern pattern;

    public ConferenceRegistration() {
        this.pattern = Pattern.compile(TALK_REGEX);
        this.registeredTalks = new ArrayList<>();
    }

    public void register(String talk) throws InvalidFormatException {
        Matcher matcher = pattern.matcher(talk);
        if(matcher.matches()){
            registerATalk(matcher);
        } else {
            throw new InvalidFormatException("Invalid format");
        }
    }

    public List getRegisteredTalks() {
        return Collections.unmodifiableList(registeredTalks);
    }

    private void registerATalk(Matcher matcher) {
        int duration;
        String topic = matcher.group(1);
        if(matcher.group(2).equals(LIGHTNING)) {
            duration = LIGHTNING_TALK_DURATION;
        }else {
            duration = Integer.parseInt(matcher.group(3));
        }
        registeredTalks.add(new Talk(topic, duration));
    }

}
