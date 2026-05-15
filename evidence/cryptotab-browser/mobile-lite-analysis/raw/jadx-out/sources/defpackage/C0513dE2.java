package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzlo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: dE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0513dE2 extends AbstractC0906jX2 {
    public static final String[] f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    public static final String[] i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final TD2 d;
    public final C0480cX2 e;

    public C0513dE2(QX2 qx2) {
        super(qx2);
        this.e = new C0480cX2(this.a.n);
        this.a.getClass();
        this.d = new TD2(this, this.a.a);
    }

    public static final void s(ContentValues contentValues, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    public final zzac A(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        QX2 qx2 = this.b;
        C1391rR2 c1391rR2 = this.a;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        Cursor cursor = null;
        try {
            cursorQuery = y().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    String str3 = string;
                    Object objE = E(cursorQuery, 1);
                    boolean z = cursorQuery.getInt(2) != 0;
                    String string2 = cursorQuery.getString(3);
                    long j2 = cursorQuery.getLong(4);
                    VX2 vx2 = qx2.g;
                    VX2 vx22 = qx2.g;
                    QX2.H(vx2);
                    byte[] blob = cursorQuery.getBlob(5);
                    Parcelable.Creator creator = zzaw.CREATOR;
                    zzaw zzawVar = (zzaw) vx2.p(blob, creator);
                    long j3 = cursorQuery.getLong(6);
                    QX2.H(vx22);
                    zzaw zzawVar2 = (zzaw) vx22.p(cursorQuery.getBlob(7), creator);
                    long j4 = cursorQuery.getLong(8);
                    long j5 = cursorQuery.getLong(9);
                    QX2.H(vx22);
                    zzac zzacVar = new zzac(str, str3, new zzlo(j4, objE, str2, str3), j3, z, string2, zzawVar, j2, zzawVar2, j5, (zzaw) vx22.p(cursorQuery.getBlob(10), creator));
                    if (cursorQuery.moveToNext()) {
                        WO2 wo2 = c1391rR2.i;
                        C1391rR2.k(wo2);
                        wo2.f.c(WO2.n(str), c1391rR2.m.d(str2), "Got multiple records for conditional property, expected one");
                    }
                    cursorQuery.close();
                    return zzacVar;
                } catch (SQLiteException e) {
                    e = e;
                    WO2 wo22 = c1391rR2.i;
                    C1391rR2.k(wo22);
                    wo22.f.d("Error querying conditional property", WO2.n(str), c1391rR2.m.d(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
            th = th;
            cursor = cursorQuery;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public final PD2 B(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        C1391rR2 c1391rR2 = this.a;
        Preconditions.checkNotEmpty(str);
        g();
        h();
        String[] strArr = {str};
        PD2 pd2 = new PD2();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseY = y();
                Cursor cursorQuery = sQLiteDatabaseY.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.i.b(WO2.n(str), "Not updating daily counts, app is not known. appId");
                    cursorQuery.close();
                    return pd2;
                }
                if (cursorQuery.getLong(0) == j2) {
                    pd2.b = cursorQuery.getLong(1);
                    pd2.a = cursorQuery.getLong(2);
                    pd2.c = cursorQuery.getLong(3);
                    pd2.d = cursorQuery.getLong(4);
                    pd2.e = cursorQuery.getLong(5);
                }
                if (z) {
                    pd2.b += j3;
                }
                if (z2) {
                    pd2.a += j3;
                }
                if (z3) {
                    pd2.c += j3;
                }
                if (z4) {
                    pd2.d += j3;
                }
                if (z5) {
                    pd2.e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(pd2.a));
                contentValues.put("daily_events_count", Long.valueOf(pd2.b));
                contentValues.put("daily_conversions_count", Long.valueOf(pd2.c));
                contentValues.put("daily_error_events_count", Long.valueOf(pd2.d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(pd2.e));
                sQLiteDatabaseY.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return pd2;
            } catch (SQLiteException e) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.f.c(WO2.n(str), e, "Error updating daily counts. appId");
                if (0 != 0) {
                    cursor.close();
                }
                return pd2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final KE2 C(String str, String str2) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        C1391rR2 c1391rR2 = this.a;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        Cursor cursor = null;
        try {
            cursorQuery = y().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j2 = cursorQuery.getLong(0);
                    long j3 = cursorQuery.getLong(1);
                    long j4 = cursorQuery.getLong(2);
                    long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                    }
                    KE2 ke2 = new KE2(str, str2, j2, j3, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j4, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursorQuery.moveToNext()) {
                        WO2 wo2 = c1391rR2.i;
                        C1391rR2.k(wo2);
                        wo2.f.b(WO2.n(str), "Got multiple records for event aggregates, expected one. appId");
                    }
                    cursorQuery.close();
                    return ke2;
                } catch (SQLiteException e) {
                    e = e;
                    WO2 wo22 = c1391rR2.i;
                    C1391rR2.k(wo22);
                    wo22.f.d("Error querying events. appId", WO2.n(str), c1391rR2.m.b(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
            th = th;
            cursor = cursorQuery;
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0072: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:115), block:B:24:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.C0362aY2 D(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            rR2 r0 = r11.a
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r11.g()
            r11.h()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.y()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r3 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String[] r6 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r3 = "user_attributes"
            java.lang.String r5 = "app_id=? and name=?"
            r9 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            if (r3 != 0) goto L36
            r2.close()
            return r1
        L36:
            r3 = 0
            long r8 = r2.getLong(r3)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            r3 = 1
            java.lang.Object r10 = r11.E(r2, r3)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            if (r10 != 0) goto L46
            r2.close()
            return r1
        L46:
            r3 = 2
            java.lang.String r6 = r2.getString(r3)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            aY2 r3 = new aY2     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            r4 = r3
            r5 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            if (r4 == 0) goto L6e
            WO2 r4 = r0.i     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            defpackage.C1391rR2.k(r4)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            CO2 r4 = r4.f     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            java.lang.String r5 = "Got multiple records for user property, expected one. appId"
            DO2 r6 = defpackage.WO2.n(r12)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            r4.b(r6, r5)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            goto L6e
        L6a:
            r12 = move-exception
            goto L72
        L6c:
            r3 = move-exception
            goto L79
        L6e:
            r2.close()
            return r3
        L72:
            r1 = r2
            goto L95
        L74:
            r12 = move-exception
            goto L95
        L76:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L79:
            WO2 r4 = r0.i     // Catch: java.lang.Throwable -> L6a
            defpackage.C1391rR2.k(r4)     // Catch: java.lang.Throwable -> L6a
            CO2 r4 = r4.f     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = "Error querying user property. appId"
            DO2 r12 = defpackage.WO2.n(r12)     // Catch: java.lang.Throwable -> L6a
            wO2 r0 = r0.m     // Catch: java.lang.Throwable -> L6a
            java.lang.String r13 = r0.d(r13)     // Catch: java.lang.Throwable -> L6a
            r4.d(r5, r12, r13, r3)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L94
            r2.close()
        L94:
            return r1
        L95:
            if (r1 == 0) goto L9a
            r1.close()
        L9a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.D(java.lang.String, java.lang.String):aY2");
    }

    public final Object E(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        C1391rR2 c1391rR2 = this.a;
        if (type == 0) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type == 4) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.a("Loaded invalid blob type value, ignoring it");
            return null;
        }
        WO2 wo23 = c1391rR2.i;
        C1391rR2.k(wo23);
        wo23.f.b(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String F() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.y()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L26 android.database.sqlite.SQLiteException -> L28
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L1e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r2 = move-exception
            goto L2b
        L1e:
            r0.close()
            return r1
        L22:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L26:
            r0 = move-exception
            goto L3f
        L28:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L2b:
            rR2 r3 = r6.a     // Catch: java.lang.Throwable -> L1a
            WO2 r3 = r3.i     // Catch: java.lang.Throwable -> L1a
            defpackage.C1391rR2.k(r3)     // Catch: java.lang.Throwable -> L1a
            CO2 r3 = r3.f     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r2, r4)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3e
            r0.close()
        L3e:
            return r1
        L3f:
            if (r1 == 0) goto L44
            r1.close()
        L44:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.F():java.lang.String");
    }

    public final List G(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        g();
        h();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return H(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0055, code lost:
    
        r0 = r2.i;
        defpackage.C1391rR2.k(r0);
        r0.f.b(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List H(java.lang.String r30, java.lang.String[] r31) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.H(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List I(java.lang.String r13) {
        /*
            r12 = this;
            rR2 r0 = r12.a
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r12.g()
            r12.h()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r10 = "1000"
            r11 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.y()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r9 = "rowid"
            r0.getClass()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            if (r2 == 0) goto L80
        L3c:
            r2 = 0
            java.lang.String r6 = r11.getString(r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r2 = 1
            java.lang.String r2 = r11.getString(r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            if (r2 != 0) goto L4a
            java.lang.String r2 = ""
        L4a:
            r5 = r2
            r2 = 2
            long r7 = r11.getLong(r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r2 = 3
            java.lang.Object r9 = r12.E(r11, r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            if (r9 != 0) goto L6c
            WO2 r2 = r0.i     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            defpackage.C1391rR2.k(r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            CO2 r2 = r2.f     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r3 = "Read invalid user property value, ignoring it. appId"
            DO2 r4 = defpackage.WO2.n(r13)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r2.b(r4, r3)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            goto L76
        L68:
            r13 = move-exception
            goto L9e
        L6a:
            r1 = move-exception
            goto L84
        L6c:
            aY2 r2 = new aY2     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r3 = r2
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r1.add(r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
        L76:
            boolean r2 = r11.moveToNext()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            if (r2 != 0) goto L3c
            r11.close()
            return r1
        L80:
            r11.close()
            return r1
        L84:
            WO2 r0 = r0.i     // Catch: java.lang.Throwable -> L68
            defpackage.C1391rR2.k(r0)     // Catch: java.lang.Throwable -> L68
            CO2 r0 = r0.f     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = "Error querying user properties. appId"
            DO2 r13 = defpackage.WO2.n(r13)     // Catch: java.lang.Throwable -> L68
            r0.c(r13, r1, r2)     // Catch: java.lang.Throwable -> L68
            java.util.List r13 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L68
            if (r11 == 0) goto L9d
            r11.close()
        L9d:
            return r13
        L9e:
            if (r11 == 0) goto La3
            r11.close()
        La3:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.I(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        defpackage.C1391rR2.k(r6);
        r6.f.b(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List J(java.lang.String r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.J(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void K() {
        h();
        y().beginTransaction();
    }

    public final void L() {
        h();
        y().endTransaction();
    }

    public final void M(List list) {
        g();
        h();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        C1391rR2 c1391rR2 = this.a;
        if (c1391rR2.a.getDatabasePath("google_app_measurement.db").exists()) {
            String strA = BN0.a("(", TextUtils.join(",", list), ")");
            if (t("SELECT COUNT(1) FROM queue WHERE rowid IN " + strA + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.i.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                y().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + strA + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.f.b(e, "Error incrementing retry count. error");
            }
        }
    }

    public final void N() {
        int iDelete;
        g();
        h();
        C1391rR2 c1391rR2 = this.a;
        if (c1391rR2.a.getDatabasePath("google_app_measurement.db").exists()) {
            QX2 qx2 = this.b;
            long jA = qx2.i.h.a();
            long jElapsedRealtime = c1391rR2.n.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) AbstractC0579eO2.x.a(null)).longValue()) {
                qx2.i.h.b(jElapsedRealtime);
                g();
                h();
                if (c1391rR2.a.getDatabasePath("google_app_measurement.db").exists() && (iDelete = y().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(c1391rR2.n.currentTimeMillis()), String.valueOf(((Long) AbstractC0579eO2.C.a(null)).longValue())})) > 0) {
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.n.b(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                }
            }
        }
    }

    public final void k(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        try {
            y().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            C1391rR2 c1391rR2 = this.a;
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.d("Error deleting user property. appId", WO2.n(str), c1391rR2.m.d(str2), e);
        }
    }

    public final void l() {
        h();
        y().setTransactionSuccessful();
    }

    public final void m(C1275pS2 c1275pS2) {
        Preconditions.checkNotNull(c1275pS2);
        g();
        h();
        String strG = c1275pS2.G();
        Preconditions.checkNotNull(strG);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strG);
        contentValues.put("app_instance_id", c1275pS2.H());
        contentValues.put("gmp_app_id", c1275pS2.K());
        C1391rR2 c1391rR2 = c1275pS2.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        contentValues.put("resettable_device_id_hash", c1275pS2.e);
        C0899jR2 c0899jR22 = c1391rR2.j;
        C1391rR2.k(c0899jR22);
        c0899jR22.g();
        contentValues.put("last_bundle_index", Long.valueOf(c1275pS2.g));
        C0899jR2 c0899jR23 = c1391rR2.j;
        C1391rR2.k(c0899jR23);
        c0899jR23.g();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c1275pS2.h));
        C0899jR2 c0899jR24 = c1391rR2.j;
        C1391rR2.k(c0899jR24);
        c0899jR24.g();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c1275pS2.i));
        contentValues.put("app_version", c1275pS2.I());
        C0899jR2 c0899jR25 = c1391rR2.j;
        C1391rR2.k(c0899jR25);
        c0899jR25.g();
        contentValues.put("app_store", c1275pS2.l);
        C0899jR2 c0899jR26 = c1391rR2.j;
        C1391rR2.k(c0899jR26);
        c0899jR26.g();
        contentValues.put("gmp_version", Long.valueOf(c1275pS2.m));
        C0899jR2 c0899jR27 = c1391rR2.j;
        C1391rR2.k(c0899jR27);
        c0899jR27.g();
        contentValues.put("dev_cert_hash", Long.valueOf(c1275pS2.n));
        C0899jR2 c0899jR28 = c1391rR2.j;
        C1391rR2.k(c0899jR28);
        c0899jR28.g();
        contentValues.put("measurement_enabled", Boolean.valueOf(c1275pS2.o));
        C0899jR2 c0899jR29 = c1391rR2.j;
        C1391rR2.k(c0899jR29);
        c0899jR29.g();
        contentValues.put("day", Long.valueOf(c1275pS2.w));
        C0899jR2 c0899jR210 = c1391rR2.j;
        C1391rR2.k(c0899jR210);
        c0899jR210.g();
        contentValues.put("daily_public_events_count", Long.valueOf(c1275pS2.x));
        C1391rR2.k(c0899jR210);
        c0899jR210.g();
        contentValues.put("daily_events_count", Long.valueOf(c1275pS2.y));
        C1391rR2.k(c0899jR210);
        c0899jR210.g();
        contentValues.put("daily_conversions_count", Long.valueOf(c1275pS2.z));
        C0899jR2 c0899jR211 = c1391rR2.j;
        C1391rR2.k(c0899jR211);
        c0899jR211.g();
        contentValues.put("config_fetched_time", Long.valueOf(c1275pS2.E));
        C0899jR2 c0899jR212 = c1391rR2.j;
        C1391rR2.k(c0899jR212);
        c0899jR212.g();
        contentValues.put("failed_config_fetch_time", Long.valueOf(c1275pS2.F));
        contentValues.put("app_version_int", Long.valueOf(c1275pS2.C()));
        contentValues.put("firebase_instance_id", c1275pS2.J());
        C1391rR2.k(c0899jR210);
        c0899jR210.g();
        contentValues.put("daily_error_events_count", Long.valueOf(c1275pS2.A));
        C1391rR2.k(c0899jR210);
        c0899jR210.g();
        contentValues.put("daily_realtime_events_count", Long.valueOf(c1275pS2.B));
        C1391rR2.k(c0899jR210);
        c0899jR210.g();
        contentValues.put("health_monitor_sample", c1275pS2.C);
        C0899jR2 c0899jR213 = c1391rR2.j;
        C1391rR2.k(c0899jR213);
        c0899jR213.g();
        contentValues.put("android_id", Long.valueOf(c1275pS2.p));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(c1275pS2.B()));
        contentValues.put("admob_app_id", c1275pS2.E());
        contentValues.put("dynamite_version", Long.valueOf(c1275pS2.D()));
        C0899jR2 c0899jR214 = c1391rR2.j;
        C1391rR2.k(c0899jR214);
        c0899jR214.g();
        contentValues.put("session_stitching_token", c1275pS2.v);
        C0899jR2 c0899jR215 = c1391rR2.j;
        C1391rR2.k(c0899jR215);
        c0899jR215.g();
        ArrayList arrayList = c1275pS2.u;
        C1391rR2 c1391rR22 = this.a;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                WO2 wo2 = c1391rR22.i;
                C1391rR2.k(wo2);
                wo2.i.b(strG, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        ((SZ2) EZ2.u.t.zza()).getClass();
        C1009lD2 c1009lD2 = c1391rR22.g;
        WO2 wo22 = c1391rR22.i;
        if (c1009lD2.p(null, AbstractC0579eO2.s0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseY = y();
            if (sQLiteDatabaseY.update("apps", contentValues, "app_id = ?", new String[]{strG}) == 0 && sQLiteDatabaseY.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                C1391rR2.k(wo22);
                wo22.f.b(WO2.n(strG), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e) {
            C1391rR2.k(wo22);
            wo22.f.c(WO2.n(strG), e, "Error storing app. appId");
        }
    }

    public final void n(KE2 ke2) {
        C1391rR2 c1391rR2 = this.a;
        Preconditions.checkNotNull(ke2);
        g();
        h();
        ContentValues contentValues = new ContentValues();
        String str = ke2.a;
        contentValues.put("app_id", str);
        contentValues.put("name", ke2.b);
        contentValues.put("lifetime_count", Long.valueOf(ke2.c));
        contentValues.put("current_bundle_count", Long.valueOf(ke2.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(ke2.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(ke2.g));
        contentValues.put("last_bundled_day", ke2.h);
        contentValues.put("last_sampled_complex_event_id", ke2.i);
        contentValues.put("last_sampling_rate", ke2.j);
        contentValues.put("current_session_count", Long.valueOf(ke2.e));
        Boolean bool = ke2.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (y().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.b(WO2.n(str), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.c(WO2.n(str), e, "Error storing event aggregates. appId");
        }
    }

    public final void o(String str, Long l2, long j2, C0471cQ2 c0471cQ2) {
        g();
        h();
        Preconditions.checkNotNull(c0471cQ2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l2);
        byte[] bArrB = c0471cQ2.b();
        C1391rR2 c1391rR2 = this.a;
        WO2 wo2 = c1391rR2.i;
        WO2 wo22 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.n.c(c1391rR2.m.b(str), Integer.valueOf(bArrB.length), "Saving complex main event, appId, data size");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", bArrB);
        try {
            if (y().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                C1391rR2.k(wo22);
                wo22.f.b(WO2.n(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e) {
            C1391rR2.k(wo22);
            wo22.f.c(WO2.n(str), e, "Error storing complex main event. appId");
        }
    }

    public final boolean p(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        g();
        h();
        String str = zzacVar.t;
        Preconditions.checkNotNull(str);
        C0362aY2 c0362aY2D = D(str, zzacVar.v.u);
        C1391rR2 c1391rR2 = this.a;
        if (c0362aY2D == null) {
            long jT = t("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            c1391rR2.getClass();
            if (jT >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.u);
        contentValues.put("name", zzacVar.v.u);
        s(contentValues, Preconditions.checkNotNull(zzacVar.v.f2()));
        contentValues.put("active", Boolean.valueOf(zzacVar.x));
        contentValues.put("trigger_event_name", zzacVar.y);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.A));
        C0653fY2 c0653fY2 = c1391rR2.l;
        WO2 wo2 = c1391rR2.i;
        C1391rR2.i(c0653fY2);
        contentValues.put("timed_out_event", C0653fY2.T(zzacVar.z));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.w));
        C0653fY2 c0653fY22 = c1391rR2.l;
        C1391rR2.i(c0653fY22);
        contentValues.put("triggered_event", C0653fY2.T(zzacVar.B));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.v.v));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.C));
        C1391rR2.i(c0653fY22);
        contentValues.put("expired_event", C0653fY2.T(zzacVar.D));
        try {
            if (y().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            C1391rR2.k(wo2);
            wo2.f.b(WO2.n(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e) {
            C1391rR2.k(wo2);
            wo2.f.c(WO2.n(str), e, "Error storing conditional user property");
            return true;
        }
    }

    public final boolean q(C0362aY2 c0362aY2) {
        Preconditions.checkNotNull(c0362aY2);
        g();
        h();
        String str = c0362aY2.a;
        String str2 = c0362aY2.c;
        C0362aY2 c0362aY2D = D(str, str2);
        C1391rR2 c1391rR2 = this.a;
        String str3 = c0362aY2.b;
        if (c0362aY2D == null) {
            if (C0653fY2.Q(str2)) {
                if (t("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= Math.max(Math.min(c1391rR2.g.k(str, AbstractC0579eO2.F), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jT = t("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, str3});
                c1391rR2.getClass();
                if (jT >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", str3);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(c0362aY2.d));
        s(contentValues, c0362aY2.e);
        try {
            if (y().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.b(WO2.n(str), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.c(WO2.n(str), e, "Error storing user property. appId");
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f3  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(long r21, long r23, defpackage.OX2 r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.r(long, long, OX2):void");
    }

    public final long t(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = y().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                WO2 wo2 = this.a.i;
                C1391rR2.k(wo2);
                wo2.f.c(str, e, "Database error");
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void u(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        g();
        h();
        try {
            y().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            C1391rR2 c1391rR2 = this.a;
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.d("Error deleting conditional property", WO2.n(str), c1391rR2.m.d(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long v(java.lang.String r3, java.lang.String[] r4, long r5) {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r0 = r2.y()
            r1 = 0
            android.database.Cursor r1 = r0.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            if (r4 == 0) goto L1c
            r4 = 0
            long r3 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            r1.close()
            return r3
        L18:
            r3 = move-exception
            goto L2f
        L1a:
            r4 = move-exception
            goto L20
        L1c:
            r1.close()
            return r5
        L20:
            rR2 r5 = r2.a     // Catch: java.lang.Throwable -> L18
            WO2 r5 = r5.i     // Catch: java.lang.Throwable -> L18
            defpackage.C1391rR2.k(r5)     // Catch: java.lang.Throwable -> L18
            CO2 r5 = r5.f     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = "Database error"
            r5.c(r3, r4, r6)     // Catch: java.lang.Throwable -> L18
            throw r4     // Catch: java.lang.Throwable -> L18
        L2f:
            if (r1 == 0) goto L34
            r1.close()
        L34:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.v(java.lang.String, java.lang.String[], long):long");
    }

    public final long w(String str) {
        long jV;
        C1391rR2 c1391rR2 = this.a;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        g();
        h();
        SQLiteDatabase sQLiteDatabaseY = y();
        sQLiteDatabaseY.beginTransaction();
        long j2 = 0;
        try {
            try {
                jV = v("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
            } finally {
                sQLiteDatabaseY.endTransaction();
            }
        } catch (SQLiteException e) {
            e = e;
        }
        if (jV == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("first_open_count", (Integer) 0);
            contentValues.put("previous_install_count", (Integer) 0);
            if (sQLiteDatabaseY.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.c(WO2.n(str), "first_open_count", "Failed to insert column (got -1). appId");
                return -1L;
            }
            jV = 0;
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.d("Error inserting column. appId", WO2.n(str), "first_open_count", e);
            sQLiteDatabaseY.endTransaction();
            return j2;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put("first_open_count", Long.valueOf(1 + jV));
            if (sQLiteDatabaseY.update("app2", contentValues2, "app_id = ?", new String[]{str}) != 0) {
                sQLiteDatabaseY.setTransactionSuccessful();
                return jV;
            }
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.f.c(WO2.n(str), "first_open_count", "Failed to update column (got 0). appId");
            return -1L;
        } catch (SQLiteException e2) {
            e = e2;
            j2 = jV;
        }
    }

    public final long x(String str) {
        Preconditions.checkNotEmpty(str);
        return v("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase y() {
        g();
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.i.b(e, "Error opening database");
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.C1275pS2 z(java.lang.String r35) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0513dE2.z(java.lang.String):pS2");
    }

    @Override // defpackage.AbstractC0906jX2
    public final void j() {
    }
}
