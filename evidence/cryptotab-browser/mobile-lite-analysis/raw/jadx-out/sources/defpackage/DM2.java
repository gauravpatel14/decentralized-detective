package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DM2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ Bundle x;
    public final /* synthetic */ Activity y;
    public final /* synthetic */ C1839zN2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DM2(C1839zN2 c1839zN2, Bundle bundle, Activity activity) {
        super(c1839zN2.t, true);
        this.z = c1839zN2;
        this.x = bundle;
        this.y = activity;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        Bundle bundle;
        if (this.x != null) {
            bundle = new Bundle();
            if (this.x.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.x.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((DI2) Preconditions.checkNotNull(this.z.t.f)).onActivityCreated(new ObjectWrapper(this.y), bundle, this.u);
    }
}
