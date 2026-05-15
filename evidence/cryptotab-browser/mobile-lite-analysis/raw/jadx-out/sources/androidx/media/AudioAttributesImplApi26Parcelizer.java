package androidx.media;

import android.media.AudioAttributes;
import defpackage.AbstractC1581un2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC1581un2 abstractC1581un2) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.a = (AudioAttributes) abstractC1581un2.g(audioAttributesImplApi26.a, 1);
        audioAttributesImplApi26.b = abstractC1581un2.f(audioAttributesImplApi26.b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC1581un2 abstractC1581un2) {
        abstractC1581un2.getClass();
        abstractC1581un2.k(audioAttributesImplApi26.a, 1);
        abstractC1581un2.j(audioAttributesImplApi26.b, 2);
    }
}
