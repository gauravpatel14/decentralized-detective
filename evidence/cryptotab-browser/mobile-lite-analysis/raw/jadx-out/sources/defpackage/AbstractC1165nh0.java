package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: nh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1165nh0 {
    public static InterfaceC0923jh0 a(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            c(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC0305Yp1.FontFamily);
        String string = typedArrayObtainAttributes.getString(AbstractC0305Yp1.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(AbstractC0305Yp1.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(AbstractC0305Yp1.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(AbstractC0305Yp1.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(AbstractC0305Yp1.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(AbstractC0305Yp1.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(AbstractC0305Yp1.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlResourceParser.next() != 3) {
                c(xmlResourceParser);
            }
            return new C1104mh0(new C0599eh0(string, string2, string3, b(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 3) {
            if (xmlResourceParser.getEventType() == 2) {
                if (xmlResourceParser.getName().equals("font")) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC0305Yp1.FontFamilyFont);
                    int i = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(AbstractC0305Yp1.FontFamilyFont_fontWeight) ? AbstractC0305Yp1.FontFamilyFont_fontWeight : AbstractC0305Yp1.FontFamilyFont_android_fontWeight, 400);
                    boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(AbstractC0305Yp1.FontFamilyFont_fontStyle) ? AbstractC0305Yp1.FontFamilyFont_fontStyle : AbstractC0305Yp1.FontFamilyFont_android_fontStyle, 0);
                    int i2 = typedArrayObtainAttributes2.hasValue(AbstractC0305Yp1.FontFamilyFont_ttcIndex) ? AbstractC0305Yp1.FontFamilyFont_ttcIndex : AbstractC0305Yp1.FontFamilyFont_android_ttcIndex;
                    String string5 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(AbstractC0305Yp1.FontFamilyFont_fontVariationSettings) ? AbstractC0305Yp1.FontFamilyFont_fontVariationSettings : AbstractC0305Yp1.FontFamilyFont_android_fontVariationSettings);
                    int i3 = typedArrayObtainAttributes2.getInt(i2, 0);
                    int i4 = typedArrayObtainAttributes2.hasValue(AbstractC0305Yp1.FontFamilyFont_font) ? AbstractC0305Yp1.FontFamilyFont_font : AbstractC0305Yp1.FontFamilyFont_android_font;
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i4, 0);
                    String string6 = typedArrayObtainAttributes2.getString(i4);
                    typedArrayObtainAttributes2.recycle();
                    while (xmlResourceParser.next() != 3) {
                        c(xmlResourceParser);
                    }
                    arrayList.add(new C1043lh0(string6, i, z, string5, i3, resourceId2));
                } else {
                    c(xmlResourceParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C0983kh0((C1043lh0[]) arrayList.toArray(new C1043lh0[0]));
    }

    public static List b(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static void c(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
