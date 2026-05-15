package defpackage;

/* JADX INFO: renamed from: ui, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1575ui {
    public String a;
    public int b;
    public String c;
    public String d;
    public Long e;
    public Long f;
    public String g;

    public final C1631vi a() {
        String strA = this.b == 0 ? " registrationStatus" : "";
        if (this.e == null) {
            strA = strA.concat(" expiresInSecs");
        }
        if (this.f == null) {
            strA = F.a(strA, " tokenCreationEpochInSecs");
        }
        if (strA.isEmpty()) {
            return new C1631vi(this.a, this.b, this.c, this.d, this.e.longValue(), this.f.longValue(), this.g);
        }
        throw new IllegalStateException("Missing required properties:".concat(strA));
    }
}
