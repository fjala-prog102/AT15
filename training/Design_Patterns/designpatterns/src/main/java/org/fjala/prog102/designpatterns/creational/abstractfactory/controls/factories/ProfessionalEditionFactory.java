package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.AudioSettings;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Equalizer;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playback;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playlist;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Subtitles;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional.ProfessionalAudioSettings;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional.ProfessionalEqualizer;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional.ProfessionalPlayback;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional.ProfessionalPlaylist;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.professional.ProfessionalSubtitles;

public class ProfessionalEditionFactory implements AbstractVideoPlayerFactory {

    @Override
    public AudioSettings createAudioSettingsControl() {
        return new ProfessionalAudioSettings();
    }

    @Override
    public Equalizer createEqualizerControl() {
        return new ProfessionalEqualizer();
    }

    @Override
    public Playback createPlaybackControl() {
        return new ProfessionalPlayback();
    }

    @Override
    public Playlist createPlaylistControl() {
        return new ProfessionalPlaylist();
    }

    @Override
    public Subtitles createSubtitlesControl() {
        return new ProfessionalSubtitles();
    }

}
