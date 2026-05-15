package defpackage;

import java.util.HashMap;

/* JADX INFO: renamed from: ow, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1239ow {
    public final AbstractC0080Gb0 a;
    public final String b;
    public final String c;

    static {
        new HashMap();
    }

    public AbstractC1239ow(AbstractC0080Gb0 abstractC0080Gb0, String str, String str2) {
        int i = AbstractC1872zv.a;
        this.a = abstractC0080Gb0;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return AbstractC1532tw.b.b(this.b + ":" + this.c);
    }

    public abstract void b(vH1 vh1);
}
