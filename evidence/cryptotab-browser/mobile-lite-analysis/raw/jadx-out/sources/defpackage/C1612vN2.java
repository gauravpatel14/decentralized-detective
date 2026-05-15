package defpackage;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: renamed from: vN2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1612vN2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ Activity x;
    public final /* synthetic */ RH2 y;
    public final /* synthetic */ C1839zN2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1612vN2(C1839zN2 c1839zN2, Activity activity, RH2 rh2) {
        super(c1839zN2.t, true);
        this.z = c1839zN2;
        this.x = activity;
        this.y = rh2;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.z.t.f)).onActivitySaveInstanceState(new ObjectWrapper(this.x), this.y, this.u);
    }
}
