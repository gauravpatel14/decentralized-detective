package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IX2 implements Callable {
    public final /* synthetic */ zzq a;
    public final /* synthetic */ QX2 b;

    public IX2(QX2 qx2, zzq zzqVar) {
        this.b = qx2;
        this.a = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzq zzqVar = this.a;
        String str = (String) Preconditions.checkNotNull(zzqVar.t);
        QX2 qx2 = this.b;
        CD2 cd2K = qx2.K(str);
        EnumC1486tD2 enumC1486tD2 = EnumC1486tD2.ANALYTICS_STORAGE;
        if (cd2K.f(enumC1486tD2) && CD2.b(zzqVar.O).f(enumC1486tD2)) {
            return qx2.I(zzqVar).H();
        }
        qx2.d().n.a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
