package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class V23 extends AbstractBinderC1598vB2 {
    public final C1087mP0 t;
    public final HashMap u;

    public V23(C1087mP0 c1087mP0) {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
        this.u = new HashMap();
        this.t = c1087mP0;
    }

    @Override // defpackage.AbstractBinderC1598vB2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        HashMap map = this.u;
        C1569uX2 c1569uX2 = null;
        Bundle bundle = null;
        int i2 = 0;
        C1087mP0 c1087mP0 = this.t;
        switch (i) {
            case 1:
                Bundle bundle2 = (Bundle) QK2.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                    c1569uX2 = iInterfaceQueryLocalInterface instanceof C1569uX2 ? (C1569uX2) iInterfaceQueryLocalInterface : new C1569uX2(strongBinder, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                }
                C0468cP0 c0468cP0B = C0468cP0.b(bundle2);
                if (!map.containsKey(c0468cP0B)) {
                    map.put(c0468cP0B, new HashSet());
                }
                ((Set) map.get(c0468cP0B)).add(new g33(c1569uX2));
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle bundle3 = (Bundle) QK2.a(parcel, Bundle.CREATOR);
                int i3 = parcel.readInt();
                C0468cP0 c0468cP0B2 = C0468cP0.b(bundle3);
                Iterator it = ((Set) map.get(c0468cP0B2)).iterator();
                while (it.hasNext()) {
                    c1087mP0.a(c0468cP0B2, (dP0) it.next(), i3);
                }
                parcel2.writeNoException();
                return true;
            case 3:
                Iterator it2 = ((Set) map.get(C0468cP0.b((Bundle) QK2.a(parcel, Bundle.CREATOR)))).iterator();
                while (it2.hasNext()) {
                    c1087mP0.h((dP0) it2.next());
                }
                parcel2.writeNoException();
                return true;
            case 4:
                Bundle bundle4 = (Bundle) QK2.a(parcel, Bundle.CREATOR);
                int i4 = parcel.readInt();
                C0468cP0 c0468cP0B3 = C0468cP0.b(bundle4);
                c1087mP0.getClass();
                if (c0468cP0B3 == null) {
                    throw new IllegalArgumentException("selector must not be null");
                }
                C1087mP0.b();
                bm0 bm0VarC = C1087mP0.c();
                bm0VarC.getClass();
                if (!c0468cP0B3.d()) {
                    if ((i4 & 2) == 0 && bm0VarC.n) {
                        i2 = 1;
                    } else {
                        ArrayList arrayList = bm0VarC.h;
                        int size = arrayList.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            C0838iP0 c0838iP0 = (C0838iP0) arrayList.get(i5);
                            if (((i4 & 1) == 0 || !c0838iP0.b()) && c0838iP0.f(c0468cP0B3)) {
                                i2 = 1;
                            }
                        }
                    }
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeInt(i2);
                return true;
            case 5:
                String string = parcel.readString();
                c1087mP0.getClass();
                Iterator it3 = C1087mP0.f().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        C0838iP0 c0838iP02 = (C0838iP0) it3.next();
                        if (c0838iP02.c.equals(string)) {
                            C1087mP0.i(c0838iP02);
                        }
                    }
                }
                parcel2.writeNoException();
                return true;
            case 6:
                c1087mP0.getClass();
                C1087mP0.b();
                C0838iP0 c0838iP03 = C1087mP0.c().s;
                if (c0838iP03 == null) {
                    throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                }
                C1087mP0.i(c0838iP03);
                parcel2.writeNoException();
                return true;
            case 7:
                c1087mP0.getClass();
                String str = C1087mP0.g().c;
                C1087mP0.b();
                C0838iP0 c0838iP04 = C1087mP0.c().s;
                if (c0838iP04 == null) {
                    throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                }
                boolean zEquals = str.equals(c0838iP04.c);
                parcel2.writeNoException();
                int i6 = QK2.a;
                parcel2.writeInt(zEquals ? 1 : 0);
                return true;
            case 8:
                String string2 = parcel.readString();
                c1087mP0.getClass();
                Iterator it4 = C1087mP0.f().iterator();
                while (true) {
                    if (it4.hasNext()) {
                        C0838iP0 c0838iP05 = (C0838iP0) it4.next();
                        if (c0838iP05.c.equals(string2)) {
                            bundle = c0838iP05.s;
                        }
                    }
                }
                parcel2.writeNoException();
                int i7 = QK2.a;
                if (bundle == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                }
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                c1087mP0.getClass();
                String str2 = C1087mP0.g().c;
                parcel2.writeNoException();
                parcel2.writeString(str2);
                return true;
            case 10:
                parcel2.writeNoException();
                parcel2.writeInt(12451009);
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                Iterator it5 = map.values().iterator();
                while (it5.hasNext()) {
                    Iterator it6 = ((Set) it5.next()).iterator();
                    while (it6.hasNext()) {
                        c1087mP0.h((dP0) it6.next());
                    }
                }
                map.clear();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
