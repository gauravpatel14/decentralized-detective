package defpackage;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: renamed from: Xz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0298Xz2 extends zag {
    public final /* synthetic */ Intent t;
    public final /* synthetic */ LifecycleFragment u;

    public C0298Xz2(Intent intent, LifecycleFragment lifecycleFragment) {
        this.t = intent;
        this.u = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.t;
        if (intent != null) {
            this.u.startActivityForResult(intent, 2);
        }
    }
}
