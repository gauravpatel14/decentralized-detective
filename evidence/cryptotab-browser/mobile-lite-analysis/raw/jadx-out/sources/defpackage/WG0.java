package defpackage;

import android.database.DataSetObserver;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WG0 extends DataSetObserver {
    public final /* synthetic */ ZG0 a;

    public WG0(ZG0 zg0) {
        this.a = zg0;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        ZG0 zg0 = this.a;
        if (zg0.S.isShowing()) {
            zg0.a();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.a.dismiss();
    }
}
