package defpackage;

import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: Sy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0229Sy2 extends AbstractBinderC1705wz2 {
    public final WeakReference t;

    public BinderC0229Sy2(zaaw zaawVar) {
        this.t = new WeakReference(zaawVar);
    }

    @Override // defpackage.InterfaceC0266Vz2
    public final void zab(zak zakVar) {
        zaaw zaawVar = (zaaw) this.t.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.zaa.zal(new C0216Ry2(zaawVar, zaawVar, zakVar));
    }
}
