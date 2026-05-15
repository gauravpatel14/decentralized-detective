package defpackage;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LM2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ Activity x;
    public final /* synthetic */ C1839zN2 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LM2(C1839zN2 c1839zN2, Activity activity) {
        super(c1839zN2.t, true);
        this.y = c1839zN2;
        this.x = activity;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.y.t.f)).onActivityResumed(new ObjectWrapper(this.x), this.u);
    }
}
