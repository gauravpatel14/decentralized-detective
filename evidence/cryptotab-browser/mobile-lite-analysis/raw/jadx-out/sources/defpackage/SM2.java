package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SM2 {
    public static final YL2 a = new YL2("CastDynamiteModule");

    public static BS2 a(Context context) {
        try {
            IBinder iBinderB = m50.c(context, m50.b, "com.google.android.gms.cast.framework.dynamite").b("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (iBinderB == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            return iInterfaceQueryLocalInterface instanceof BS2 ? (BS2) iInterfaceQueryLocalInterface : new BS2(iBinderB, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
        } catch (DynamiteModule$LoadingException e) {
            throw new RuntimeException(e);
        }
    }
}
