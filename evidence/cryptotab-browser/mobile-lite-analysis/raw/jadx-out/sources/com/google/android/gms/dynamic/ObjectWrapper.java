package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import defpackage.AbstractBinderC1432sF2;
import defpackage.AbstractC1214oR1;
import defpackage.PF2;
import defpackage.Zr0;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@RetainForClient
@KeepForSdk
public final class ObjectWrapper extends AbstractBinderC1432sF2 implements Zr0 {
    public final Object zza;

    public ObjectWrapper(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper");
        this.zza = obj;
    }

    public static Zr0 W0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof Zr0 ? (Zr0) iInterfaceQueryLocalInterface : new PF2(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static Object X0(Zr0 zr0) {
        if (zr0 instanceof ObjectWrapper) {
            return ((ObjectWrapper) zr0).zza;
        }
        IBinder iBinderAsBinder = zr0.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(AbstractC1214oR1.a(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        Preconditions.checkNotNull(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
