package defpackage;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NM0 implements Iterable {
    public final MediaCodecInfo[] t;

    public NM0() {
        try {
            this.t = new MediaCodecList(1).getCodecInfos();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new MM0(this);
    }
}
