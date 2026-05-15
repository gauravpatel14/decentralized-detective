package androidx.media;

import defpackage.AbstractC1581un2;
import defpackage.InterfaceC1694wn2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC1581un2 abstractC1581un2) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        InterfaceC1694wn2 interfaceC1694wn2H = audioAttributesCompat.a;
        if (abstractC1581un2.e(1)) {
            interfaceC1694wn2H = abstractC1581un2.h();
        }
        audioAttributesCompat.a = (AudioAttributesImpl) interfaceC1694wn2H;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC1581un2 abstractC1581un2) {
        abstractC1581un2.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.a;
        abstractC1581un2.i(1);
        abstractC1581un2.l(audioAttributesImpl);
    }
}
