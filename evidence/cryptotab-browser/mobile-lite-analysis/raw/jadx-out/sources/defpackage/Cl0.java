package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Cl0 implements DE1 {
    public final LE1 a;

    public Cl0(LE1 le1) {
        this.a = le1;
    }

    @Override // defpackage.DE1
    public final Iterator iterator() {
        return new C0016Bl0(this);
    }
}
