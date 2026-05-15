package defpackage;

import android.util.LruCache;

/* JADX INFO: renamed from: rX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1397rX2 extends LruCache {
    public final /* synthetic */ UN0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1397rX2(UN0 un0) {
        super(20);
        this.a = un0;
    }

    @Override // android.util.LruCache
    public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        if (z) {
            this.a.h.add(num);
        }
    }
}
