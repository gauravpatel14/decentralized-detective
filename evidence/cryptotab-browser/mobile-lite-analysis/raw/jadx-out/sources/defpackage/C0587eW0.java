package defpackage;

/* JADX INFO: renamed from: eW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0587eW0 extends AbstractC0921jg0 {
    public final boolean c;
    public Boolean d;

    public C0587eW0(AbstractC0080Gb0 abstractC0080Gb0, String str, boolean z) {
        super(abstractC0080Gb0, str);
        this.c = z;
    }

    public final boolean a() {
        Boolean bool = this.d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!AbstractC0065Fb0.a()) {
            return this.c;
        }
        boolean zF = this.a.f(this.b);
        this.d = Boolean.valueOf(zF);
        return zF;
    }

    public final C0478cW0 b(String str, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        return new C0478cW0(this.a, this.b, str, boolValueOf);
    }
}
