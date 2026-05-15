package androidx.media;

import defpackage.AbstractC1581un2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC1581un2 abstractC1581un2) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = 0;
        audioAttributesImplBase.b = 0;
        audioAttributesImplBase.c = 0;
        audioAttributesImplBase.d = -1;
        audioAttributesImplBase.a = abstractC1581un2.f(0, 1);
        audioAttributesImplBase.b = abstractC1581un2.f(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = abstractC1581un2.f(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = abstractC1581un2.f(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC1581un2 abstractC1581un2) {
        abstractC1581un2.getClass();
        abstractC1581un2.j(audioAttributesImplBase.a, 1);
        abstractC1581un2.j(audioAttributesImplBase.b, 2);
        abstractC1581un2.j(audioAttributesImplBase.c, 3);
        abstractC1581un2.j(audioAttributesImplBase.d, 4);
    }
}
