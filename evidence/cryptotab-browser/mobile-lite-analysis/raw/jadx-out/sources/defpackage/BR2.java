package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public enum BR2 {
    u("BROADCAST_ACTION_UNSPECIFIED"),
    v("PURCHASES_UPDATED_ACTION"),
    w("LOCAL_PURCHASES_UPDATED_ACTION"),
    x("ALTERNATIVE_BILLING_ACTION");

    public final int t;

    BR2(String str) {
        this.t = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.t);
    }
}
