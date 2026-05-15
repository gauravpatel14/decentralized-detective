package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: dF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0515dF2 {
    public final ArrayList a = new ArrayList();

    public abstract InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList);

    public final void b(String str) {
        if (!this.a.contains(DS2.d(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
