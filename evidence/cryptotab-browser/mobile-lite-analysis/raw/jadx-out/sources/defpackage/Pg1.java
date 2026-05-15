package defpackage;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Pg1 {
    public static final Pattern a = Pattern.compile("(\\b|^)(((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))))(/(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))*)?(\\b|$)");
    public static final Pattern b = Pattern.compile("^(?:Caused by: )?java\\.lang\\.(?:ClassNotFoundException|NoClassDefFoundError):|(?:[\"' ]/(?:apex|data|mnt|proc|sdcard|storage|system))/");
    public static final Pattern c = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
    public static final Pattern d = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
    public static final String[] e = {"org.chromium.", "com.google.", "com.chrome."};
    public static final String[] f = {"android.", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull.", "System."};

    public static String a(String str) {
        if (b.matcher(str).find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        Pattern pattern = a;
        Matcher matcher = pattern.matcher(sb);
        int i = 0;
        while (matcher.find(i)) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strSubstring = sb.substring(iStart, iEnd);
            String[] strArr = e;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (strSubstring.startsWith(strArr[i2])) {
                        break;
                    }
                    i2++;
                } else if (!strSubstring.startsWith("chromium-") || (!strSubstring.endsWith(".apk") && !strSubstring.endsWith(".aab"))) {
                    String[] strArr2 = f;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            try {
                                Class.forName(strSubstring, false, AbstractC1499tM.a.getClassLoader());
                                break;
                            } catch (Throwable unused) {
                                int iLastIndexOf = strSubstring.lastIndexOf(".");
                                if (iLastIndexOf != -1) {
                                    try {
                                        Class.forName(strSubstring.substring(0, iLastIndexOf), false, AbstractC1499tM.a.getClassLoader());
                                    } catch (Throwable unused2) {
                                        sb.replace(iStart, iEnd, "HTTP://WEBADDRESS.ELIDED");
                                        i = iStart + 24;
                                        matcher = pattern.matcher(sb);
                                    }
                                }
                                sb.replace(iStart, iEnd, "HTTP://WEBADDRESS.ELIDED");
                                i = iStart + 24;
                                matcher = pattern.matcher(sb);
                            }
                        } else {
                            if (strSubstring.startsWith(strArr2[i3])) {
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            i = iEnd;
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\\n");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!strArrSplit[i].startsWith("\tat ")) {
                strArrSplit[i] = a(strArrSplit[i]);
            }
        }
        return TextUtils.join("\n", strArrSplit);
    }
}
