package defpackage;

import android.os.SystemClock;

/* JADX INFO: renamed from: o30, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1188o30 {
    public final long a = SystemClock.elapsedRealtime();

    public final boolean equals(Object obj) {
        return (obj instanceof C1188o30) && ((C1188o30) obj).a == this.a;
    }
}
