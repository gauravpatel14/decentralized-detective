package defpackage;

import com.android.volley.ParseError;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class nB0 extends rB0 {
    public nB0(int i, String str, JSONObject jSONObject, nv1 nv1Var, mv1 mv1Var) {
        super(i, str, jSONObject != null ? jSONObject.toString() : null, nv1Var, mv1Var);
    }

    @Override // defpackage.AbstractC1701wu1
    public final ov1 l(C1223oY0 c1223oY0) {
        try {
            return new ov1(new JSONObject(new String(c1223oY0.a, Pp0.b(c1223oY0.b))), Pp0.a(c1223oY0));
        } catch (UnsupportedEncodingException e) {
            return new ov1(new ParseError(e));
        } catch (JSONException e2) {
            return new ov1(new ParseError(e2));
        }
    }
}
