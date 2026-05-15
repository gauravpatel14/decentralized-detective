package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dr0 extends Binder implements InterfaceC0671fr0 {
    public static InterfaceC0671fr0 W0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0671fr0.a);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0671fr0)) {
            return (InterfaceC0671fr0) iInterfaceQueryLocalInterface;
        }
        cr0 cr0Var = new cr0();
        cr0Var.t = iBinder;
        return cr0Var;
    }
}
