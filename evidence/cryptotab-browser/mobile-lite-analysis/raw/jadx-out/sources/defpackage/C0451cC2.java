package defpackage;

import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: cC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0451cC2 {
    public static final C23 c = new C23("LocalTestingConfigParser");
    public final XmlPullParser a;
    public final LB2 b;

    public C0451cC2(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser;
        C0830iI2 c0830iI2 = C0830iI2.c;
        LB2 lb2 = new LB2();
        lb2.b = new HashMap();
        this.b = lb2;
    }

    public final void a(String str, T33 t33) throws XmlPullParserException, IOException {
        while (true) {
            XmlPullParser xmlPullParser = this.a;
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if (!xmlPullParser.getName().equals(str)) {
                    throw new XmlPullParserException("Expected '" + str + "' tag but found '" + xmlPullParser.getName() + "'.", xmlPullParser, null);
                }
                t33.zza();
            }
        }
    }
}
