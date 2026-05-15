package defpackage;

import J.N;
import java.net.URISyntaxException;
import org.chromium.url.GURL;

/* JADX INFO: renamed from: ij2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0863ij2 extends GURL {
    public C0863ij2(String str) throws URISyntaxException {
        super(str);
        if (!this.b) {
            throw new URISyntaxException(str, "Uri could not be parsed as a valid GURL");
        }
    }

    @Override // org.chromium.url.GURL
    public final GURL f() {
        C0863ij2 c0863ij2 = new C0863ij2();
        N._V_OO(77, this, c0863ij2);
        return c0863ij2;
    }

    @Override // org.chromium.url.GURL
    public final String toString() {
        return this.a;
    }
}
