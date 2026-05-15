package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: uK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1551uK2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ String x;
    public final /* synthetic */ AN2 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1551uK2(AN2 an2, String str) {
        super(an2, true);
        this.y = an2;
        this.x = str;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.y.f)).endAdUnitExposure(this.x, this.u);
    }
}
