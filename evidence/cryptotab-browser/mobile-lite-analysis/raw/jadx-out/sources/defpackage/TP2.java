package defpackage;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TP2 extends US2 {
    public static final Pair w = new Pair("", 0L);
    public SharedPreferences c;
    public MP2 d;
    public final FP2 e;
    public final QP2 f;
    public String g;
    public boolean h;
    public long i;
    public final FP2 j;
    public final C1783yP2 k;
    public final QP2 l;
    public final C1783yP2 m;
    public final FP2 n;
    public boolean o;
    public final C1783yP2 p;
    public final C1783yP2 q;
    public final FP2 r;
    public final QP2 s;
    public final QP2 t;
    public final FP2 u;
    public final BP2 v;

    public TP2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.j = new FP2(this, "session_timeout", 1800000L);
        this.k = new C1783yP2(this, "start_new_session", true);
        this.n = new FP2(this, "last_pause_time", 0L);
        this.l = new QP2(this, "non_personalized_ads");
        this.m = new C1783yP2(this, "allow_remote_dynamite", false);
        this.e = new FP2(this, "first_open_time", 0L);
        Preconditions.checkNotEmpty("app_install_time");
        this.f = new QP2(this, "app_instance_id");
        this.p = new C1783yP2(this, "app_backgrounded", false);
        this.q = new C1783yP2(this, "deep_link_retrieval_complete", false);
        this.r = new FP2(this, "deep_link_retrieval_attempts", 0L);
        this.s = new QP2(this, "firebase_feature_rollouts");
        this.t = new QP2(this, "deferred_attribution_cache");
        this.u = new FP2(this, "deferred_attribution_cache_timestamp", 0L);
        this.v = new BP2(this);
    }

    @Override // defpackage.US2
    public final boolean h() {
        return true;
    }

    public final SharedPreferences k() {
        g();
        i();
        Preconditions.checkNotNull(this.c);
        return this.c;
    }

    public final CD2 l() {
        g();
        return CD2.b(k().getString("consent_settings", "G1"));
    }

    public final void m(boolean z) {
        g();
        WO2 wo2 = this.a.i;
        C1391rR2.k(wo2);
        wo2.n.b(Boolean.valueOf(z), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    public final boolean n(long j) {
        return j - this.j.a() > this.n.a();
    }

    public final boolean o(int i) {
        int i2 = k().getInt("consent_source", 100);
        CD2 cd2 = CD2.b;
        return i <= i2;
    }
}
