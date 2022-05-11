package org.fjala.prog102.designpatterns.creational.abstractfactory.controls.factories;

import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.AudioSettings;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Equalizer;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playback;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Playlist;
import org.fjala.prog102.designpatterns.creational.abstractfactory.controls.Subtitles;

public interface AbstractVideoPlayerFactory {
    AudioSettings createAudioSettingsControl();

    Equalizer createEqualizerControl();

    Playback createPlaybackControl();

    Playlist createPlaylistControl();

    Subtitles createSubtitlesControl();
}
