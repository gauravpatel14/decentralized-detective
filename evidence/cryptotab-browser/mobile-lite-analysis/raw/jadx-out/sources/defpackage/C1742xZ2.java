package defpackage;

/* JADX INFO: renamed from: xZ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1742xZ2 implements InterfaceC1685wZ2 {
    public static final AT2 A;
    public static final AT2 B;
    public static final AT2 C;
    public static final AT2 D;
    public static final AT2 E;
    public static final AT2 F;
    public static final AT2 G;
    public static final AT2 H;
    public static final GT2 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final AT2 f39J;
    public static final AT2 a;
    public static final AT2 b;
    public static final AT2 c;
    public static final GT2 d;
    public static final GT2 e;
    public static final AT2 f;
    public static final AT2 g;
    public static final AT2 h;
    public static final AT2 i;
    public static final AT2 j;
    public static final AT2 k;
    public static final AT2 l;
    public static final AT2 m;
    public static final AT2 n;
    public static final AT2 o;
    public static final AT2 p;
    public static final AT2 q;
    public static final AT2 r;
    public static final AT2 s;
    public static final AT2 t;
    public static final AT2 u;
    public static final AT2 v;
    public static final AT2 w;
    public static final AT2 x;
    public static final AT2 y;
    public static final AT2 z;

    static {
        IT2 it2 = new IT2(AbstractC1619vT2.a(), false, true);
        a = it2.a(10000L, "measurement.ad_id_cache_time");
        b = it2.a(100L, "measurement.max_bundles_per_iteration");
        c = it2.a(86400000L, "measurement.config.cache_time");
        it2.b("measurement.log_tag", "FA");
        d = new GT2(it2, "measurement.config.url_authority", "app-measurement.com");
        e = new GT2(it2, "measurement.config.url_scheme", "https");
        f = it2.a(1000L, "measurement.upload.debug_upload_interval");
        g = it2.a(4L, "measurement.lifetimevalue.max_currency_tracked");
        h = it2.a(100000L, "measurement.store.max_stored_events_per_app");
        i = it2.a(50L, "measurement.experiment.max_ids");
        j = it2.a(200L, "measurement.audience.filter_result_max_count");
        k = it2.a(60000L, "measurement.alarm_manager.minimum_interval");
        l = it2.a(500L, "measurement.upload.minimum_delay");
        m = it2.a(86400000L, "measurement.monitoring.sample_period_millis");
        n = it2.a(10000L, "measurement.upload.realtime_upload_interval");
        o = it2.a(604800000L, "measurement.upload.refresh_blacklisted_config_interval");
        it2.a(3600000L, "measurement.config.cache_time.service");
        p = it2.a(5000L, "measurement.service_client.idle_disconnect_millis");
        it2.b("measurement.log_tag.service", "FA-SVC");
        q = it2.a(86400000L, "measurement.upload.stale_data_deletion_interval");
        r = it2.a(604800000L, "measurement.sdk.attribution.cache.ttl");
        s = it2.a(7200000L, "measurement.redaction.app_instance_id.ttl");
        t = it2.a(43200000L, "measurement.upload.backoff_period");
        u = it2.a(15000L, "measurement.upload.initial_upload_delay_time");
        v = it2.a(3600000L, "measurement.upload.interval");
        w = it2.a(65536L, "measurement.upload.max_bundle_size");
        x = it2.a(100L, "measurement.upload.max_bundles");
        y = it2.a(500L, "measurement.upload.max_conversions_per_day");
        z = it2.a(1000L, "measurement.upload.max_error_events_per_day");
        A = it2.a(1000L, "measurement.upload.max_events_per_bundle");
        B = it2.a(100000L, "measurement.upload.max_events_per_day");
        C = it2.a(50000L, "measurement.upload.max_public_events_per_day");
        D = it2.a(2419200000L, "measurement.upload.max_queue_time");
        E = it2.a(10L, "measurement.upload.max_realtime_events_per_day");
        F = it2.a(65536L, "measurement.upload.max_batch_size");
        G = it2.a(6L, "measurement.upload.retry_count");
        H = it2.a(1800000L, "measurement.upload.retry_time");
        I = new GT2(it2, "measurement.upload.url", "https://app-measurement.com/a");
        f39J = it2.a(3600000L, "measurement.upload.window_interval");
    }
}
