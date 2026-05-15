package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OW implements DE1 {
    public final String a;
    public final int b;
    public final int c;
    public final aQ1 d;

    public OW(String str, int i, int i2, aQ1 aq1) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = aq1;
    }

    @Override // defpackage.DE1
    public final Iterator iterator() {
        return new NW(this);
    }
}
