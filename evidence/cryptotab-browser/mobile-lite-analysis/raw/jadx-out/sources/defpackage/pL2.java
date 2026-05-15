package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pL2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ RH2 A;
    public final /* synthetic */ AN2 B;
    public final /* synthetic */ String x;
    public final /* synthetic */ String y;
    public final /* synthetic */ boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pL2(AN2 an2, String str, String str2, boolean z, RH2 rh2) {
        super(an2, true);
        this.B = an2;
        this.x = str;
        this.y = str2;
        this.z = z;
        this.A = rh2;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.B.f)).getUserProperties(this.x, this.y, this.z, this.A);
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void b() {
        this.A.e(null);
    }
}
