package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class at1 extends Handler {
    public final WeakReference a;

    public at1(Xs1 xs1) {
        this.a = new WeakReference(xs1);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        TO0 to0;
        Xs1 xs1 = (Xs1) this.a.get();
        if (xs1 != null) {
            int i = message.what;
            int i2 = message.arg1;
            int i3 = message.arg2;
            Object obj = message.obj;
            Bundle bundlePeekData = message.peekData();
            SparseArray sparseArray = xs1.h;
            ServiceConnectionC0608et1 serviceConnectionC0608et1 = xs1.i;
            if (i == 0) {
                if (i2 == xs1.g) {
                    xs1.g = 0;
                    if (serviceConnectionC0608et1.G == xs1) {
                        serviceConnectionC0608et1.j();
                    }
                }
                if (((bt1) sparseArray.get(i2)) != null) {
                    sparseArray.remove(i2);
                }
                return;
            }
            Ys1 ys1 = null;
            switch (i) {
                case 2:
                    if (obj == null || (obj instanceof Bundle)) {
                        Bundle bundle = (Bundle) obj;
                        if (xs1.f == 0 && i2 == xs1.g && i3 >= 1) {
                            xs1.g = 0;
                            xs1.f = i3;
                            C0351aP0 c0351aP0A = C0351aP0.a(bundle);
                            if (serviceConnectionC0608et1.G == xs1) {
                                serviceConnectionC0608et1.e(c0351aP0A);
                            }
                            if (serviceConnectionC0608et1.G == xs1) {
                                serviceConnectionC0608et1.H = true;
                                ArrayList arrayList = serviceConnectionC0608et1.D;
                                int size = arrayList.size();
                                for (int i4 = 0; i4 < size; i4++) {
                                    ((Ys1) arrayList.get(i4)).b(serviceConnectionC0608et1.G);
                                }
                                RO0 ro0 = serviceConnectionC0608et1.x;
                                if (ro0 != null) {
                                    Xs1 xs12 = serviceConnectionC0608et1.G;
                                    int i5 = xs12.d;
                                    xs12.d = i5 + 1;
                                    xs12.b(10, i5, 0, ro0.a, null);
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 3:
                    if (obj == null || (obj instanceof Bundle)) {
                        Bundle bundle2 = (Bundle) obj;
                        bt1 bt1Var = (bt1) sparseArray.get(i2);
                        if (bt1Var != null) {
                            sparseArray.remove(i2);
                            bt1Var.a(bundle2);
                        }
                    }
                    break;
                case 4:
                    if (obj == null || (obj instanceof Bundle)) {
                        if (bundlePeekData != null) {
                            bundlePeekData.getString("error");
                        }
                        Bundle bundle3 = (Bundle) obj;
                        if (((bt1) sparseArray.get(i2)) != null) {
                            sparseArray.remove(i2);
                            Objects.toString(bundle3);
                        }
                    }
                    break;
                case 5:
                    if (obj == null || (obj instanceof Bundle)) {
                        Bundle bundle4 = (Bundle) obj;
                        if (xs1.f != 0) {
                            C0351aP0 c0351aP0A2 = C0351aP0.a(bundle4);
                            if (serviceConnectionC0608et1.G == xs1) {
                                serviceConnectionC0608et1.e(c0351aP0A2);
                            }
                        }
                    }
                    break;
                case 6:
                    if (obj instanceof Bundle) {
                        Bundle bundle5 = (Bundle) obj;
                        bt1 bt1Var2 = (bt1) sparseArray.get(i2);
                        if (bundle5 == null || !bundle5.containsKey("routeId")) {
                            bt1Var2.getClass();
                            Objects.toString(bundle5);
                        } else {
                            sparseArray.remove(i2);
                            bt1Var2.a(bundle5);
                        }
                    } else {
                        Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                    }
                    break;
                case 7:
                    if (obj == null || (obj instanceof Bundle)) {
                        Bundle bundle6 = (Bundle) obj;
                        if (xs1.f != 0) {
                            Bundle bundle7 = (Bundle) bundle6.getParcelable("groupRoute");
                            OO0 oo0 = bundle7 != null ? new OO0(bundle7) : null;
                            ArrayList<Bundle> parcelableArrayList = bundle6.getParcelableArrayList("dynamicRoutes");
                            ArrayList arrayList2 = new ArrayList();
                            for (Bundle bundle8 : parcelableArrayList) {
                                if (bundle8 == null) {
                                    to0 = null;
                                } else {
                                    Bundle bundle9 = bundle8.getBundle("mrDescriptor");
                                    to0 = new TO0(bundle9 != null ? new OO0(bundle9) : null, bundle8.getInt("selectionState", 1), bundle8.getBoolean("isUnselectable", false), bundle8.getBoolean("isGroupable", false), bundle8.getBoolean("isTransferable", false));
                                }
                                arrayList2.add(to0);
                            }
                            if (serviceConnectionC0608et1.G == xs1) {
                                Iterator it = serviceConnectionC0608et1.D.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Ys1 ys12 = (Ys1) it.next();
                                        if (ys12.a() == i3) {
                                            ys1 = ys12;
                                        }
                                    }
                                }
                                if (ys1 instanceof C0502ct1) {
                                    ((C0502ct1) ys1).j(oo0, arrayList2);
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    if (serviceConnectionC0608et1.G == xs1) {
                        ArrayList arrayList3 = serviceConnectionC0608et1.D;
                        Iterator it2 = arrayList3.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Ys1 ys13 = (Ys1) it2.next();
                                if (ys13.a() == i3) {
                                    ys1 = ys13;
                                }
                            }
                        }
                        C0674ft1 c0674ft1 = serviceConnectionC0608et1.I;
                        if (c0674ft1 != null && (ys1 instanceof XO0)) {
                            XO0 xo0 = (XO0) ys1;
                            bm0 bm0Var = c0674ft1.a.b;
                            if (bm0Var.d == xo0) {
                                bm0Var.g(bm0Var.c(), 2, true);
                            }
                        }
                        arrayList3.remove(ys1);
                        ys1.c();
                        serviceConnectionC0608et1.k();
                    }
                    break;
            }
        }
    }
}
