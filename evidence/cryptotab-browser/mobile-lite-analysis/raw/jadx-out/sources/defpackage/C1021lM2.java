package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: lM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1021lM2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ AN2 A;
    public final /* synthetic */ String x;
    public final /* synthetic */ String y;
    public final /* synthetic */ Bundle z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1021lM2(AN2 an2, String str, String str2, Bundle bundle) {
        super(an2, true);
        this.A = an2;
        this.x = str;
        this.y = str2;
        this.z = bundle;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.A.f)).logEvent(this.x, this.y, this.z, true, true, this.t);
    }
}
