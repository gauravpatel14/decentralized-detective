package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.service.zaa;

/* JADX INFO: renamed from: Kz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0124Kz2 extends zaa {
    public final C1535tz2 t;

    public BinderC0124Kz2(C1535tz2 c1535tz2) {
        this.t = c1535tz2;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zak
    public final void zab(int i) {
        this.t.setResult((Object) new Status(i));
    }
}
