package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EL2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ String x;
    public final /* synthetic */ RH2 y;
    public final /* synthetic */ AN2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EL2(AN2 an2, String str, RH2 rh2) {
        super(an2, true);
        this.z = an2;
        this.x = str;
        this.y = rh2;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.z.f)).getMaxUserProperties(this.x, this.y);
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void b() {
        this.y.e(null);
    }
}
