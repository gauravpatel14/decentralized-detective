package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: renamed from: uL2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1553uL2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ String x;
    public final /* synthetic */ Exception y;
    public final /* synthetic */ AN2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1553uL2(AN2 an2, String str, Exception exc) {
        super(an2, false);
        this.z = an2;
        this.x = str;
        this.y = exc;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.z.f)).logHealthData(5, this.x, new ObjectWrapper(this.y), new ObjectWrapper(null), new ObjectWrapper(null));
    }
}
