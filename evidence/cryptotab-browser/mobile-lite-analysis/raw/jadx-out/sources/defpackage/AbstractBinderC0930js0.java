package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: js0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0930js0 extends Binder implements InterfaceC0991ks0 {
    public static InterfaceC0991ks0 W0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.chromium.components.payments.IPaymentDetailsUpdateServiceCallback");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0991ks0)) {
            return (InterfaceC0991ks0) iInterfaceQueryLocalInterface;
        }
        is0 is0Var = new is0();
        is0Var.t = iBinder;
        return is0Var;
    }
}
