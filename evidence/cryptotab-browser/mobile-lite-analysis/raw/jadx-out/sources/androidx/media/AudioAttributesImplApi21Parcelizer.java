package androidx.media;

import android.media.AudioAttributes;
import defpackage.AbstractC1581un2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC1581un2 abstractC1581un2) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.a = (AudioAttributes) abstractC1581un2.g(audioAttributesImplApi21.a, 1);
        audioAttributesImplApi21.b = abstractC1581un2.f(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC1581un2 abstractC1581un2) {
        abstractC1581un2.getClass();
        abstractC1581un2.k(audioAttributesImplApi21.a, 1);
        abstractC1581un2.j(audioAttributesImplApi21.b, 2);
    }
}
