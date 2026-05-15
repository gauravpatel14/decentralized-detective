package defpackage;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IJ2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ AN2 A;
    public final /* synthetic */ Activity x;
    public final /* synthetic */ String y;
    public final /* synthetic */ String z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IJ2(AN2 an2, Activity activity, String str, String str2) {
        super(an2, true);
        this.A = an2;
        this.x = activity;
        this.y = str;
        this.z = str2;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        ((DI2) Preconditions.checkNotNull(this.A.f)).setCurrentScreen(new ObjectWrapper(this.x), this.y, this.z, this.t);
    }
}
