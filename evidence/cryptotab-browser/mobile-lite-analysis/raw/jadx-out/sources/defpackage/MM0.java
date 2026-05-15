package defpackage;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MM0 implements Iterator {
    public int t;
    public final /* synthetic */ NM0 u;

    public MM0(NM0 nm0) {
        this.u = nm0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int codecCount;
        int i = this.t;
        MediaCodecInfo[] mediaCodecInfoArr = this.u.t;
        if (mediaCodecInfoArr != null) {
            codecCount = mediaCodecInfoArr.length;
        } else {
            try {
                codecCount = MediaCodecList.getCodecCount();
            } catch (RuntimeException unused) {
                codecCount = 0;
            }
        }
        return i < codecCount;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int codecCount;
        int i = this.t;
        NM0 nm0 = this.u;
        MediaCodecInfo[] mediaCodecInfoArr = nm0.t;
        if (mediaCodecInfoArr != null) {
            codecCount = mediaCodecInfoArr.length;
        } else {
            try {
                codecCount = MediaCodecList.getCodecCount();
            } catch (RuntimeException unused) {
                codecCount = 0;
            }
        }
        if (i == codecCount) {
            throw new NoSuchElementException();
        }
        int i2 = this.t;
        this.t = i2 + 1;
        MediaCodecInfo[] mediaCodecInfoArr2 = nm0.t;
        return mediaCodecInfoArr2 != null ? mediaCodecInfoArr2[i2] : MediaCodecList.getCodecInfoAt(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
