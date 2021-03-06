package com.darkprograms.speech.recognizer.vad;

import com.darkprograms.speech.microphone.MicrophoneAnalyzer;

/**
 * @see [https://github.com/Sciss/SpeechRecognitionHMM/blob/master/src/main/java/org/ioe/tprsa/audio/preProcessings/EndPointDetection.java]
 */
public interface VoiceActivityDetector {
    enum VadState {
        INITIALISING,
        PAUSED,
        LISTENING,
        DETECTED_SPEECH,
        DETECTED_SILENCE_AFTER_SPEECH,
        CLOSED
    }

    // TODO: optionally provide PipedInputStream to support streaming recognition on Google
    void detectVoiceActivity(MicrophoneAnalyzer mic, VoiceActivityListener listener);
    void detectVoiceActivity(MicrophoneAnalyzer mic, int maxSpeechMs, VoiceActivityListener listener);
    void setVoiceActivityListener(VoiceActivityListener listener);

    void pause();

    void terminate();
}
