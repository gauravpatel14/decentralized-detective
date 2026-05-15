package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CJ2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ AN2 A;
    public final /* synthetic */ String x;
    public final /* synthetic */ String y;
    public final /* synthetic */ RH2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CJ2(AN2 an2, String str, String str2, RH2 rh2) {
        super(an2, true);
        this.A = an2;
        this.x = str;
        this.y = str2;
        this.z = rh2;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.A.f)).getConditionalUserProperties(this.x, this.y, this.z);
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void b() {
        this.z.e(null);
    }
}
