package defpackage;

import org.chromium.components.payments.Address;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yc1 {
    public static xc1 a(Address address) {
        if (address == null) {
            return null;
        }
        xc1 xc1Var = new xc1(0);
        xc1Var.b = address.a;
        xc1Var.c = address.b;
        xc1Var.d = address.c;
        xc1Var.e = address.d;
        xc1Var.f = address.e;
        xc1Var.g = address.f;
        xc1Var.h = address.g;
        xc1Var.i = address.h;
        xc1Var.j = address.i;
        xc1Var.k = address.j;
        return xc1Var;
    }
}
