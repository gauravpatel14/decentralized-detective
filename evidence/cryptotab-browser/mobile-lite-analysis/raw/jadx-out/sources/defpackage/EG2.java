package defpackage;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EG2 {
    public static final String a(String str, XmlResourceParser xmlResourceParser) {
        for (int i = 0; i < xmlResourceParser.getAttributeCount(); i++) {
            if (xmlResourceParser.getAttributeName(i).equals(str)) {
                return xmlResourceParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static final void b(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i != 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
