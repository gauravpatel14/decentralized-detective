package defpackage;

import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabw;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: iz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0871iz2 extends zabw {
    public final WeakReference a;

    public C0871iz2(zabe zabeVar) {
        this.a = new WeakReference(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.a.get();
        if (zabeVar == null) {
            return;
        }
        zabe.zai(zabeVar);
    }
}
