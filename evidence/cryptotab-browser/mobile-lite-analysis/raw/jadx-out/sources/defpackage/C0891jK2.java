package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.zzcl;

/* JADX INFO: renamed from: jK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0891jK2 extends AbstractRunnableC1610vM2 {
    public final /* synthetic */ Context x;
    public final /* synthetic */ Bundle y;
    public final /* synthetic */ AN2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0891jK2(AN2 an2, Context context, Bundle bundle) {
        super(an2, true);
        this.z = an2;
        this.x = context;
        this.y = bundle;
    }

    @Override // defpackage.AbstractRunnableC1610vM2
    public final void a() {
        DI2 di2AsInterface;
        try {
            Preconditions.checkNotNull(this.x);
            AN2 an2 = this.z;
            Context context = this.x;
            an2.getClass();
            try {
                di2AsInterface = AbstractBinderC1832zI2.asInterface(m50.c(context, m50.c, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
            } catch (DynamiteModule$LoadingException e) {
                an2.a(e, true, false);
                di2AsInterface = null;
            }
            an2.f = di2AsInterface;
            if (this.z.f == null) {
                this.z.getClass();
                Log.w("FA", "Failed to connect to measurement client.");
            } else {
                int iA = m50.a(this.x, ModuleDescriptor.MODULE_ID);
                ((DI2) Preconditions.checkNotNull(this.z.f)).initialize(new ObjectWrapper(this.x), new zzcl(64000L, Math.max(iA, r2), m50.d(this.x, ModuleDescriptor.MODULE_ID, false) < iA, null, null, null, this.y, WQ2.a(this.x)), this.t);
            }
        } catch (Exception e2) {
            this.z.a(e2, true, false);
        }
    }
}
