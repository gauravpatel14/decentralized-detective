package defpackage;

import java.io.File;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GF2 {
    public final File a;
    public final String b;

    public GF2(File file, String str) {
        this.a = file;
        if (str == null) {
            throw new NullPointerException("Null splitId");
        }
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GF2) {
            GF2 gf2 = (GF2) obj;
            if (this.a.equals(gf2.a) && this.b.equals(gf2.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "SplitFileInfo{splitFile=" + this.a.toString() + ", splitId=" + this.b + "}";
    }
}
