package defpackage;

import org.chromium.url.GURL;
import org.chromium.url.Parsed;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TB1 {
    public String a;
    public Lu1 b;

    public final void a(GURL gurl) {
        Lu1 lu1 = this.b;
        if (lu1 != null && AbstractC0497cm2.f(gurl) && gurl.e().equals("search.yahoo.com")) {
            Parsed parsed = gurl.c;
            for (String str : gurl.d(parsed.m, parsed.n).split("&")) {
                if (str.equals("type=__alt__ddc_cryptobrowser_site")) {
                    QB1 qb1 = new QB1(0, this.a, null);
                    qb1.D = new C0586eW(2.0f, 2500, 4);
                    lu1.a(qb1);
                    return;
                }
            }
        }
    }
}
