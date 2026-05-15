package defpackage;

import android.content.Intent;
import androidx.fragment.app.n;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: renamed from: Rz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0218Rz2 extends zag {
    public final /* synthetic */ Intent t;
    public final /* synthetic */ n u;
    public final /* synthetic */ int v;

    public C0218Rz2(n nVar, Intent intent, int i) {
        this.t = intent;
        this.u = nVar;
        this.v = i;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.t;
        if (intent != null) {
            this.u.startActivityForResult(intent, this.v);
        }
    }
}
