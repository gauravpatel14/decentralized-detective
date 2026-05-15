package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TD2 extends SQLiteOpenHelper {
    public final /* synthetic */ C0513dE2 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TD2(C0513dE2 c0513dE2, Context context) {
        super(context, "google_app_measurement.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.t = c0513dE2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        C0513dE2 c0513dE2 = this.t;
        C0480cX2 c0480cX2 = c0513dE2.e;
        C1391rR2 c1391rR2 = c0513dE2.a;
        c1391rR2.getClass();
        if (c0480cX2.b != 0 && c0480cX2.a.elapsedRealtime() - c0480cX2.b < 3600000) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            C0480cX2 c0480cX22 = c0513dE2.e;
            c0480cX22.b = c0480cX22.a.elapsedRealtime();
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Opening the database failed, dropping and recreating it");
            c1391rR2.getClass();
            if (!c1391rR2.a.getDatabasePath("google_app_measurement.db").delete()) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.f.b("google_app_measurement.db", "Failed to delete corrupted db file");
            }
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                c0480cX22.b = 0L;
                return writableDatabase;
            } catch (SQLiteException e) {
                WO2 wo23 = c1391rR2.i;
                C1391rR2.k(wo23);
                wo23.f.b(e, "Failed to open freshly created database");
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        WO2 wo2 = this.t.a.i;
        C1391rR2.k(wo2);
        AbstractC0824iE2.b(wo2, sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        C0513dE2 c0513dE2 = this.t;
        WO2 wo2 = c0513dE2.a.i;
        C1391rR2.k(wo2);
        AbstractC0824iE2.a(wo2, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", C0513dE2.f);
        WO2 wo22 = c0513dE2.a.i;
        C1391rR2.k(wo22);
        AbstractC0824iE2.a(wo22, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        WO2 wo23 = c0513dE2.a.i;
        C1391rR2.k(wo23);
        AbstractC0824iE2.a(wo23, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", C0513dE2.g);
        WO2 wo24 = c0513dE2.a.i;
        C1391rR2.k(wo24);
        AbstractC0824iE2.a(wo24, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", C0513dE2.h);
        WO2 wo25 = c0513dE2.a.i;
        C1391rR2.k(wo25);
        AbstractC0824iE2.a(wo25, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", C0513dE2.j);
        WO2 wo26 = c0513dE2.a.i;
        C1391rR2.k(wo26);
        AbstractC0824iE2.a(wo26, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        WO2 wo27 = c0513dE2.a.i;
        C1391rR2.k(wo27);
        AbstractC0824iE2.a(wo27, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", C0513dE2.i);
        WO2 wo28 = c0513dE2.a.i;
        C1391rR2.k(wo28);
        AbstractC0824iE2.a(wo28, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", C0513dE2.k);
        WO2 wo29 = c0513dE2.a.i;
        C1391rR2.k(wo29);
        AbstractC0824iE2.a(wo29, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", C0513dE2.l);
        WO2 wo210 = c0513dE2.a.i;
        C1391rR2.k(wo210);
        AbstractC0824iE2.a(wo210, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        WO2 wo211 = c0513dE2.a.i;
        C1391rR2.k(wo211);
        AbstractC0824iE2.a(wo211, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", C0513dE2.m);
        WO2 wo212 = c0513dE2.a.i;
        C1391rR2.k(wo212);
        AbstractC0824iE2.a(wo212, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
        WO2 wo213 = c0513dE2.a.i;
        C1391rR2.k(wo213);
        AbstractC0824iE2.a(wo213, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
        WO2 wo214 = c0513dE2.a.i;
        C1391rR2.k(wo214);
        AbstractC0824iE2.a(wo214, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
