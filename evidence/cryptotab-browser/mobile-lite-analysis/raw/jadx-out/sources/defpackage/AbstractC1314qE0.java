package defpackage;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: qE0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1314qE0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static lE0 a(int i, InterfaceC0798hk0 interfaceC0798hk0) {
        int iB = aM1.b(i);
        if (iB == 0) {
            return new C0646fU1(interfaceC0798hk0);
        }
        C0797hj2 c0797hj2 = C0797hj2.a;
        if (iB == 1) {
            Wx1 wx1 = new Wx1();
            wx1.t = (RC0) interfaceC0798hk0;
            wx1.u = c0797hj2;
            return wx1;
        }
        if (iB != 2) {
            throw new NoWhenBranchMatchedException();
        }
        C1348qk2 c1348qk2 = new C1348qk2();
        c1348qk2.t = (RC0) interfaceC0798hk0;
        c1348qk2.u = c0797hj2;
        return c1348qk2;
    }
}
