package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabf;

/* JADX INFO: renamed from: Oy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0182Oy2 extends AbstractC0933jz2 {
    public final /* synthetic */ ConnectionResult b;
    public final /* synthetic */ C0202Qy2 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0182Oy2(C0202Qy2 c0202Qy2, zabf zabfVar, ConnectionResult connectionResult) {
        super(zabfVar);
        this.c = c0202Qy2;
        this.b = connectionResult;
    }

    @Override // defpackage.AbstractC0933jz2
    public final void a() {
        this.c.v.zaD(this.b);
    }
}
