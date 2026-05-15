package defpackage;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ML2 {
    public static final Api.ClientKey a = new Api.ClientKey();
    public static final boolean b;

    static {
        new Api.ClientKey();
        new Api.ClientKey();
        new Api.ClientKey();
        new Api.ClientKey();
        try {
            Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
        }
        "urn:x-cast:".concat("com.google.cast.multizone");
        b = true;
    }
}
