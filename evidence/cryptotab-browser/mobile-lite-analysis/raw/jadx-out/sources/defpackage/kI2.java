package defpackage;

import com.google.android.gms.common.util.ArrayUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kI2 {
    public static final List a;
    public static final List b;
    public static final List c;

    static {
        new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
        a = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
        b = Arrays.asList("auto", "app", "am");
        c = Arrays.asList("_r", "_dbg");
        Arrays.asList((String[]) ArrayUtils.concat(AbstractC0645fT2.a, AbstractC0645fT2.b));
        Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }
}
