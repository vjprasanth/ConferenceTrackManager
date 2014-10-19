package co.uk.prash.ctm.registration

import co.uk.prash.ctm.registration.ConferenceRegistration
import co.uk.prash.ctm.registration.InvalidFormatException
import co.uk.prash.ctm.registration.Talk
import spock.lang.Specification


class ConferenceRegistrationSpec extends Specification {

    def "should be able to register a talk with its correct time" () {

        given:
        def talk = 'Writing Fast Tests Against Enterprise Rails 60min'
        ConferenceRegistration conferenceRegistration = new ConferenceRegistration()

        when:
        conferenceRegistration.register(talk)
        List<Talk> registeredTalks = conferenceRegistration.getRegisteredTalks()


        then:
        registeredTalks.size() == 1
        Talk registeredTalk = registeredTalks[0]
        registeredTalk.topic == 'Writing Fast Tests Against Enterprise Rails'
        registeredTalk.duration == 60
    }

    def "should be able to register a lightning talk with its correct time" () {

        given:
        def talk = 'Rails for Python Developers lightning'
        ConferenceRegistration conferenceRegistration = new ConferenceRegistration()

        when:
        conferenceRegistration.register(talk)
        List<Talk> registeredTalks = conferenceRegistration.getRegisteredTalks()


        then:
        registeredTalks.size() == 1
        Talk registeredTalk = registeredTalks[0]
        registeredTalk.topic == 'Rails for Python Developers'
        registeredTalk.duration == 5
    }

    def "should throw an exception if the talk length is not in mins" () {

        given:
        def talk = 'Writing Fast Tests Against Enterprise Rails 60hrs'
        ConferenceRegistration registerTalks = new ConferenceRegistration()

        when:
        registerTalks.register(talk)

        then:
        thrown(InvalidFormatException)
    }
}
