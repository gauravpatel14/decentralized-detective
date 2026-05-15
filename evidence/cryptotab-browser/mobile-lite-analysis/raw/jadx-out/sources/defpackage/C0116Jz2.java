package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: renamed from: Jz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0116Jz2 extends zag {
    public final /* synthetic */ Intent t;
    public final /* synthetic */ Activity u;
    public final /* synthetic */ int v;

    public C0116Jz2(Activity activity, Intent intent, int i) {
        this.t = intent;
        this.u = activity;
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
