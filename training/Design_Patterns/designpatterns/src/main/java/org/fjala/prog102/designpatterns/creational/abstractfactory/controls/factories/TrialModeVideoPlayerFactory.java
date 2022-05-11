package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.AudioSettings;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultAudioSettings;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultEqualizer;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultPlayback;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultPlaylist;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.DefaultSubtitles;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Equalizer;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playback;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playlist;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Subtitles;

public class TrialModeVideoPlayerFactory implements AbstractVideoPlayerFactory {

    @Override
    public AudioSettings createAudioSettingsControl() {
        return new DefaultAudioSettings();
    }

    @Override
    public Equalizer createEqualizerControl() {
        return new DefaultEqualizer();
    }

    @Override
    public Playback createPlaybackControl() {
        return new DefaultPlayback();
    }

    @Override
    public Playlist createPlaylistControl() {
        return new DefaultPlaylist();
    }

    @Override
    public Subtitles createSubtitlesControl() {
        return new DefaultSubtitles();
    }

}
