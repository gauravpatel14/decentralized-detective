package defpackage;

import android.os.SystemClock;
import android.util.SparseLongArray;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IM1 {
    public final boolean a;
    public final SparseLongArray b;

    public IM1(boolean z) {
        SparseLongArray sparseLongArray = new SparseLongArray();
        this.b = sparseLongArray;
        this.a = z;
        sparseLongArray.put(0, SystemClock.uptimeMillis());
    }
}
