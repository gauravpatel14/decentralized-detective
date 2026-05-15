package defpackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UC2 implements BI2 {
    public final BI2 a;

    public UC2(BI2 bi2) {
        this.a = bi2;
    }

    @Override // defpackage.BI2
    public final Object zza() {
        File file = (File) this.a.zza();
        if (file == null) {
            return null;
        }
        C23 c23 = C0451cC2.c;
        File file2 = new File(file, "local_testing_config.xml");
        if (!file2.exists()) {
            return C0830iI2.c;
        }
        try {
            FileReader fileReader = new FileReader(file2);
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                xmlPullParserNewPullParser.setInput(fileReader);
                final C0451cC2 c0451cC2 = new C0451cC2(xmlPullParserNewPullParser);
                c0451cC2.a("local-testing-config", new T33() { // from class: C33
                    @Override // defpackage.T33
                    public final void zza() throws XmlPullParserException, IOException {
                        final C0451cC2 c0451cC22 = c0451cC2;
                        c0451cC22.a("split-install-errors", new T33() { // from class: q33
                            @Override // defpackage.T33
                            public final void zza() throws XmlPullParserException, IOException {
                                int i = 0;
                                while (true) {
                                    final C0451cC2 c0451cC23 = c0451cC22;
                                    XmlPullParser xmlPullParser = c0451cC23.a;
                                    if (i >= xmlPullParser.getAttributeCount()) {
                                        c0451cC23.a("split-install-error", new T33() { // from class: c33
                                            @Override // defpackage.T33
                                            public final void zza() throws XmlPullParserException {
                                                C0451cC2 c0451cC24;
                                                XmlPullParser xmlPullParser2;
                                                int i2 = 0;
                                                String attributeValue = null;
                                                String attributeValue2 = null;
                                                while (true) {
                                                    c0451cC24 = c0451cC23;
                                                    xmlPullParser2 = c0451cC24.a;
                                                    if (i2 >= xmlPullParser2.getAttributeCount()) {
                                                        break;
                                                    }
                                                    if ("module".equals(xmlPullParser2.getAttributeName(i2))) {
                                                        attributeValue = xmlPullParser2.getAttributeValue(i2);
                                                    }
                                                    if ("errorCode".equals(xmlPullParser2.getAttributeName(i2))) {
                                                        attributeValue2 = xmlPullParser2.getAttributeValue(i2);
                                                    }
                                                    i2++;
                                                }
                                                if (attributeValue == null || attributeValue2 == null) {
                                                    throw new XmlPullParserException("'split-install-error' element does not contain 'module'/'errorCode' attributes.", xmlPullParser2, null);
                                                }
                                                Integer num = (Integer) KB2.c.get(attributeValue2);
                                                if (num == null) {
                                                    throw new IllegalArgumentException(attributeValue2.concat(" is unknown error."));
                                                }
                                                Map map = c0451cC24.b.b;
                                                if (map == null) {
                                                    throw new IllegalStateException("Property \"splitInstallErrorCodeByModule\" has not been set");
                                                }
                                                map.put(attributeValue, num);
                                                while (xmlPullParser2.next() != 3) {
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    if ("defaultErrorCode".equals(xmlPullParser.getAttributeName(i))) {
                                        String attributeValue = xmlPullParser.getAttributeValue(i);
                                        Integer num = (Integer) KB2.c.get(attributeValue);
                                        if (num == null) {
                                            throw new IllegalArgumentException(String.valueOf(attributeValue).concat(" is unknown error."));
                                        }
                                        c0451cC23.b.a = num;
                                    }
                                    i++;
                                }
                            }
                        });
                    }
                });
                C0830iI2 c0830iI2A = c0451cC2.b.a();
                fileReader.close();
                return c0830iI2A;
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException | XmlPullParserException e) {
            C0451cC2.c.d("%s can not be parsed, using default. Error: %s", "local_testing_config.xml", e.getMessage());
            return C0830iI2.c;
        }
    }
}
