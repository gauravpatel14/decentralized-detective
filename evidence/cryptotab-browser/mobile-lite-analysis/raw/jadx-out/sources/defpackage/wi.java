package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class wi {
    public String a;
    public Long b;
    public int c;

    public final xi a() {
        String str = this.b == null ? " tokenExpirationTimestamp" : "";
        if (str.isEmpty()) {
            return new xi(this.c, this.a, this.b.longValue());
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }
}
