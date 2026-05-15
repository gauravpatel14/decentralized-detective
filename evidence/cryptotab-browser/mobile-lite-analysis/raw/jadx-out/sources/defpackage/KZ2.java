package defpackage;

import com.google.android.gms.common.internal.Objects;
import java.security.KeyPair;
import java.security.PublicKey;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KZ2 {
    public final KeyPair a;
    public final long b;

    public KZ2(KeyPair keyPair, long j) {
        this.a = keyPair;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof KZ2)) {
            return false;
        }
        KZ2 kz2 = (KZ2) obj;
        if (this.b == kz2.b) {
            KeyPair keyPair = this.a;
            PublicKey publicKey = keyPair.getPublic();
            KeyPair keyPair2 = kz2.a;
            if (publicKey.equals(keyPair2.getPublic()) && keyPair.getPrivate().equals(keyPair2.getPrivate())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        KeyPair keyPair = this.a;
        return Objects.hashCode(keyPair.getPublic(), keyPair.getPrivate(), Long.valueOf(this.b));
    }
}
