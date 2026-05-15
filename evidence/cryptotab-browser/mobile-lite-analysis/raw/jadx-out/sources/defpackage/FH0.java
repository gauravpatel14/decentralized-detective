package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FH0 extends C0714gW0 {
    public final AbstractC1230og l;
    public Object m;
    public GH0 n;

    public FH0(AbstractC1230og abstractC1230og) {
        this.l = abstractC1230og;
        if (abstractC1230og.a != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        abstractC1230og.a = this;
    }

    @Override // defpackage.AbstractC1493tH0
    public final void e() {
        AbstractC1230og abstractC1230og = this.l;
        abstractC1230og.b = true;
        abstractC1230og.d = false;
        abstractC1230og.c = false;
        abstractC1230og.e();
    }

    @Override // defpackage.AbstractC1493tH0
    public final void f() {
        this.l.b = false;
    }

    @Override // defpackage.AbstractC1493tH0
    public final void g(K21 k21) {
        super.g(k21);
        this.m = null;
        this.n = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [hF0, java.lang.Object] */
    public final void j() {
        ?? r0 = this.m;
        GH0 gh0 = this.n;
        if (r0 == 0 || gh0 == null) {
            return;
        }
        super.g(gh0);
        d(r0, gh0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #0 : ");
        AbstractC1230og abstractC1230og = this.l;
        sb.append(abstractC1230og.getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(abstractC1230og)));
        sb.append("}}");
        return sb.toString();
    }
}
