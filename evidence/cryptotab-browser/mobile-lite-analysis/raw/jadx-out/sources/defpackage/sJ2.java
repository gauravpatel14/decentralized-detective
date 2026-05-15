package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class sJ2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ Bundle x;
    public final /* synthetic */ AN2 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sJ2(AN2 an2, Bundle bundle) {
        super(an2, true);
        this.y = an2;
        this.x = bundle;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.y.f)).setConditionalUserProperty(this.x, this.t);
    }
}
