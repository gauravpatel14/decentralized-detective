package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class N72 {
    public final M72 a;
    public final boolean b;

    public N72(M72 m72, boolean z) {
        this.a = m72;
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    public final boolean b(int i, CharSequence charSequence) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        M72 m72 = this.a;
        if (m72 == null) {
            return a();
        }
        int iA = m72.a(i, charSequence);
        if (iA == 0) {
            return true;
        }
        if (iA != 1) {
            return a();
        }
        return false;
    }
}
