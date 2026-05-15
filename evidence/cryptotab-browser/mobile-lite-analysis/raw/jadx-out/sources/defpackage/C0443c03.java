package defpackage;

/* JADX INFO: renamed from: c03, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0443c03 implements InterfaceC0386b03 {
    public static final CT2 a;
    public static final CT2 b;
    public static final CT2 c;

    static {
        IT2 it2 = new IT2(AbstractC1619vT2.a(), false, true);
        it2.c("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        a = it2.c("measurement.audience.refresh_event_count_filters_timestamp", false);
        b = it2.c("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        c = it2.c("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
