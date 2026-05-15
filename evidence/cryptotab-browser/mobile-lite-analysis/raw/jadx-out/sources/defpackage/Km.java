package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Km {
    public final String a;
    public final int b;
    public int c;

    public Km(int i, int i2, String str) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public static Km a(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 3 && !strArrSplit[0].isEmpty() && !strArrSplit[1].isEmpty() && !strArrSplit[2].isEmpty()) {
            try {
                return new Km(Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), strArrSplit[0]);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final String toString() {
        return this.a + ":" + this.b + ":" + this.c;
    }
}
