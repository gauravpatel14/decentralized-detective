package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: renamed from: rO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1386rO2 extends SQLiteOpenHelper {
    public final /* synthetic */ C1503tO2 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1386rO2(C1503tO2 c1503tO2, Context context) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.t = c1503tO2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            C1503tO2 c1503tO2 = this.t;
            WO2 wo2 = c1503tO2.a.i;
            C1391rR2.k(wo2);
            wo2.f.a("Opening the local database failed, dropping and recreating it");
            c1503tO2.a.getClass();
            if (!c1503tO2.a.a.getDatabasePath("google_app_measurement_local.db").delete()) {
                WO2 wo22 = c1503tO2.a.i;
                C1391rR2.k(wo22);
                wo22.f.b("google_app_measurement_local.db", "Failed to delete corrupted local db file");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                WO2 wo23 = c1503tO2.a.i;
                C1391rR2.k(wo23);
                wo23.f.b(e2, "Failed to open local database. Events will bypass local storage");
                return null;
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
        WO2 wo2 = this.t.a.i;
        C1391rR2.k(wo2);
        AbstractC0824iE2.a(wo2, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
