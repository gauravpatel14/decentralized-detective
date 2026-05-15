package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NK2 extends AbstractBinderC1490tF2 implements qI2 {
    public static qI2 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return iInterfaceQueryLocalInterface instanceof qI2 ? (qI2) iInterfaceQueryLocalInterface : new C1024lN2(iBinder);
    }
}
