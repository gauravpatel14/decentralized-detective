package defpackage;

import J.N;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class u6 extends AbstractC1239ow {
    @Override // defpackage.AbstractC1239ow
    public final void b(vH1 vh1) {
        AbstractC0080Gb0 abstractC0080Gb0 = this.a;
        abstractC0080Gb0.a();
        HashMap map = new HashMap();
        String[] strArr = (String[]) N._O_JO(0, abstractC0080Gb0.a, this.b);
        for (int i = 0; i < strArr.length; i += 2) {
            map.put(strArr[i], strArr[i + 1]);
        }
        vh1.putString(a(), new JSONObject(map).toString());
    }
}
