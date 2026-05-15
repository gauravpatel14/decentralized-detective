package defpackage;

import android.database.ContentObserver;

/* JADX INFO: renamed from: kT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0963kT2 extends ContentObserver {
    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        LT2.h.incrementAndGet();
    }
}
