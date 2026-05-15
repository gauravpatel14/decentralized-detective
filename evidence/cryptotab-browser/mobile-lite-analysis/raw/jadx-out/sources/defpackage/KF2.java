package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class KF2 implements nI {
    public static final /* synthetic */ KF2 a = new KF2();

    @Override // defpackage.nI
    public final Object a(Xv1 xv1) {
        boolean z;
        C0488cf0 c0488cf0 = (C0488cf0) xv1.a(C0488cf0.class);
        Context context = (Context) xv1.a(Context.class);
        InterfaceC1390rR1 interfaceC1390rR1 = (InterfaceC1390rR1) xv1.a(InterfaceC1390rR1.class);
        Preconditions.checkNotNull(c0488cf0);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(interfaceC1390rR1);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (n7.b == null) {
            synchronized (n7.class) {
                if (n7.b == null) {
                    Bundle bundle = new Bundle(1);
                    c0488cf0.a();
                    if ("[DEFAULT]".equals(c0488cf0.b)) {
                        ((C0753h80) interfaceC1390rR1).a(OB2.t, JF2.a);
                        c0488cf0.a();
                        KT kt = (KT) c0488cf0.g.get();
                        synchronized (kt) {
                            z = kt.a;
                        }
                        bundle.putBoolean("dataCollectionDefaultEnabled", z);
                    }
                    n7.b = new n7(AN2.c(context, bundle).c);
                }
            }
        }
        return n7.b;
    }
}
