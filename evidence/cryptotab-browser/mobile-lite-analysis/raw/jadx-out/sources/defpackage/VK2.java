package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VK2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ RH2 x;
    public final /* synthetic */ AN2 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VK2(AN2 an2, RH2 rh2) {
        super(an2, true);
        this.y = an2;
        this.x = rh2;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.y.f)).getGmpAppId(this.x);
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void b() {
        this.x.e(null);
    }
}
