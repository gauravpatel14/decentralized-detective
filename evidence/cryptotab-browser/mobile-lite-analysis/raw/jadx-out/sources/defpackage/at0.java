package defpackage;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.VolleyError;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class at0 implements nv1, mv1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ C0673ft0 b;

    public /* synthetic */ at0(C0673ft0 c0673ft0, String str) {
        this.b = c0673ft0;
        this.a = str;
    }

    @Override // defpackage.nv1
    public void a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        C0673ft0 c0673ft0 = this.b;
        LruCache lruCache = c0673ft0.b.a;
        String str = this.a;
        lruCache.put(str, bitmap);
        ct0 ct0Var = (ct0) c0673ft0.c.remove(str);
        if (ct0Var != null) {
            ct0Var.a = bitmap;
            c0673ft0.d.put(str, ct0Var);
            if (c0673ft0.f == null) {
                bt0 bt0Var = new bt0(c0673ft0);
                c0673ft0.f = bt0Var;
                c0673ft0.e.postDelayed(bt0Var, 100);
            }
        }
    }

    @Override // defpackage.mv1
    public void c(VolleyError volleyError) {
        C0673ft0 c0673ft0 = this.b;
        HashMap map = c0673ft0.c;
        String str = this.a;
        ct0 ct0Var = (ct0) map.remove(str);
        if (ct0Var != null) {
            ct0Var.b = volleyError;
            c0673ft0.d.put(str, ct0Var);
            if (c0673ft0.f == null) {
                bt0 bt0Var = new bt0(c0673ft0);
                c0673ft0.f = bt0Var;
                c0673ft0.e.postDelayed(bt0Var, 100);
            }
        }
    }
}
