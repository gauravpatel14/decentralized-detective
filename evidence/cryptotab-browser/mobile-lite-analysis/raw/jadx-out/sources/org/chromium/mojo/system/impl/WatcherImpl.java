package org.chromium.mojo.system.impl;

import J.N;
import defpackage.AbstractC1468sn0;
import defpackage.InterfaceC0177Oq2;
import defpackage.InterfaceC1409rn0;
import defpackage.SN;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class WatcherImpl {
    public long a;
    public InterfaceC0177Oq2 b;

    public final void a(InterfaceC1409rn0 interfaceC1409rn0, SN sn, InterfaceC0177Oq2 interfaceC0177Oq2) {
        long j = this.a;
        if (j != 0 && (interfaceC1409rn0 instanceof AbstractC1468sn0)) {
            if (N._I_IJJO(0, sn.a, j, ((AbstractC1468sn0) interfaceC1409rn0).t, this) == 0) {
                this.b = interfaceC0177Oq2;
            }
        }
    }

    public final void onHandleReady(int i) {
        this.b.a(i);
    }
}
