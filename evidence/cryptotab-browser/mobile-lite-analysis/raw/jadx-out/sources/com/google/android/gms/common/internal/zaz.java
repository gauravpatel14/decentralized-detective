package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException;
import defpackage.Dt1;
import defpackage.Vx1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zaz extends Dt1 {
    private static final zaz zaa = new zaz();

    private zaz() {
    }

    public static View zaa(Context context, int i, int i2) throws RemoteCreator$RemoteCreatorException {
        zaz zazVar = zaa;
        try {
            zax zaxVar = new zax(1, i, i2, null);
            return (View) ObjectWrapper.X0(((zam) zazVar.getRemoteCreatorInstance(context)).zae(new ObjectWrapper(context), zaxVar));
        } catch (Exception e) {
            throw new RemoteCreator$RemoteCreatorException(Vx1.a(i, i2, "Could not get button with size ", " and color "), e);
        }
    }

    @Override // defpackage.Dt1
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof zam ? (zam) iInterfaceQueryLocalInterface : new zam(iBinder);
    }
}
