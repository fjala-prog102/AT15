package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.AudioSettings;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Equalizer;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playback;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playlist;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Subtitles;

public class ControlsProvider {

    private static AbstractVideoPlayerFactory factory;
    private static AudioSettings audioSettings;
    private static Equalizer equalizer;
    private static Playback playback;
    private static Playlist playlist;
    private static Subtitles subtitles;

    private ControlsProvider() {
    }

    protected static AbstractVideoPlayerFactory getFactory() {
        // choose factory based on license key
        if (factory == null) {
            // Set the default factory as:
            factory = new TrialModeVideoPlayerFactory();

            // look for the license key
            String licenseFilePath = "src/main/resources/videoplayer.license";
            File licenseFile = new File(licenseFilePath);
            try {
                if (licenseFile.exists()) {
                    Path path = Paths.get(licenseFilePath);
                    String licenseContent = Files.readAllLines(path).get(0);
                    if ("AT15".equals(licenseContent.trim())) {
                        factory = new ProfessionalEditionFactory();
                    }/* else if ("FJALA".equals(licenseContent.trim())) {
                        factory = new StandardEditionFactory();
                    }*/
                }
            } catch (IOException e) {
                System.err.println("IOException at trying to read the license file. Using the default factory");
            }

        }
        return factory;
    }

    public static AudioSettings getAudioSettingsControl() {
        if (audioSettings == null) {
            audioSettings = getFactory().createAudioSettingsControl();
        }
        return audioSettings;
    }

    public static Equalizer getEqualizerControl() {
        if (equalizer == null) {
            equalizer = getFactory().createEqualizerControl();
        }
        return equalizer;
    }

    public static Playback getPlaybackControl() {
        if (playback == null) {
            playback = getFactory().createPlaybackControl();
        }
        return playback;
    }

    public static Playlist getPlaylistControl() {
        if (playlist == null) {
            playlist = getFactory().createPlaylistControl();
        }
        return playlist;
    }

    public static Subtitles getSubtitlesControl() {
        if (subtitles == null) {
            subtitles = getFactory().createSubtitlesControl();
        }
        return subtitles;
    }
}
