package defpackage;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MX2 implements InterfaceC0536dY2 {
    public final /* synthetic */ QX2 a;

    public MX2(QX2 qx2) {
        this.a = qx2;
    }

    @Override // defpackage.InterfaceC0536dY2
    public final void a(String str, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        QX2 qx2 = this.a;
        if (!zIsEmpty) {
            qx2.b().o(new KX2(this, str, bundle));
            return;
        }
        C1391rR2 c1391rR2 = qx2.l;
        if (c1391rR2 != null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.b("_err", "AppId not known when logging event");
        }
    }
}
