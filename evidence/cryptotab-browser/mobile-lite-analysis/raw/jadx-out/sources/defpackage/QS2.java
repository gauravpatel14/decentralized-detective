package defpackage;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class QS2 implements WS2 {
    public final C1391rR2 a;

    public QS2(C1391rR2 c1391rR2) {
        Preconditions.checkNotNull(c1391rR2);
        this.a = c1391rR2;
    }

    @Override // defpackage.WS2
    public final C0899jR2 b() {
        throw null;
    }

    @Override // defpackage.WS2
    public final Context c() {
        throw null;
    }

    @Override // defpackage.WS2
    public final WO2 d() {
        throw null;
    }

    @Override // defpackage.WS2
    public final Clock e() {
        throw null;
    }

    @Override // defpackage.WS2
    public final C1070mC2 f() {
        throw null;
    }

    public void g() {
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
    }
}
